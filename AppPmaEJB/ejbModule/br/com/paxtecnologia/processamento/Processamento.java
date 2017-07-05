package br.com.paxtecnologia.processamento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;

import org.jboss.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.paxtecnologia.beans.RelatorioBean;
import br.com.paxtecnologia.dao.RelatorioDao;
import br.com.paxtecnologia.util.JiraUrl;
import br.com.paxtecnologia.util.Props;
import br.com.paxtecnologia.vo.RelatorioRetornoVO;
import jira.wadl.generated.ProjectBean;

@Stateless
public class Processamento {

	private final Props props = Props.getInstance();
	private final RelatorioDao dao = new RelatorioDao();
	private RelatorioRetornoVO retorno;
	private final Logger log = Logger.getLogger("log");

	public RelatorioRetornoVO iniciaProcessamento(String dataInicio, String dataFim) {
		HttpURLConnection connection = null;
		retorno = new RelatorioRetornoVO();
		retorno.setData_inicio(dataInicio);
		retorno.setData_fim(dataFim);
		JiraUrl jira = new JiraUrl(dataInicio, dataFim);
		try {
			connection = getConnJira(JiraUrl.jiraProjectURL);
			JsonArray json = formataJsonArray(
					new BufferedReader(new InputStreamReader((connection.getInputStream()), "UTF-8")));
			Gson gson = new GsonBuilder().create();
			List<ProjectBean> projetos = Arrays.asList(gson.fromJson(json, ProjectBean[].class));

			for (int i = 1; i < 4; i++) {
				for (ProjectBean projeto : projetos) {
					HttpURLConnection conn = getConnJira(jira.getChamado(i, projeto.getId()));

					JsonObject resposta = formataJson(
							new BufferedReader(new InputStreamReader((conn.getInputStream()), "UTF-8")));
					JsonArray obj = resposta.getAsJsonArray("issues");
					try {
						List<RelatorioBean> chamados = Arrays.asList(gson.fromJson(obj, RelatorioBean[].class));

						for (RelatorioBean chamado : chamados) {
							dao.creteRelatorio(chamado, i);
							retorno.setNumeroDeChamadosProcessados(retorno.getNumeroDeChamadosProcessados() + 1);
						}

					} catch (SQLException e) {
						log.error(" Erro ao gravar no banco \n Erro: " + e.getMessage() + "\nEstado: "
								+ e.getSQLState() + "\nError code: " + e.getErrorCode());
						retorno.setNumeroDeChamadoComErro(retorno.getNumeroDeChamadoComErro() + 1);
						retorno.getErrors().add(" Erro ao gravar no banco \n Erro: " + e.getMessage() + "\nEstado: "
								+ e.getSQLState() + "\nError code: " + e.getErrorCode());
					} catch (Exception e) {
						log.error("Erro no json: " + e.getMessage());
						retorno.setNumeroDeChamadoComErro(retorno.getNumeroDeChamadoComErro() + 1);
						retorno.getErrors().add((" Erro no projeto no método getChamadosAberto: " + projeto.getId()
								+ ", json: " + resposta.toString()));
					}
				}
			}
		} catch (MalformedURLException e) {
			retorno.getErrors().add("Erro ao consultar a página do jira. Erro: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			if (e.getCause().toString().contains("401")) {
				retorno.getErrors().add(
						"Request não autorizado! Usuário ou senha inválidos");
			} else {
				retorno.getErrors().add("Erro: " + e.getMessage());
			}
			e.printStackTrace();
		} catch (Exception e) {
			retorno.getErrors().add("Algum erro imprevisto ocorreu! Erro: " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (connection != null) {
				log.debug("Fechando conecção");
				connection.disconnect();
			}
		}
		return retorno;
	}

	private HttpURLConnection getConnJira(String urlStr) {
		URL url;
		HttpURLConnection connection = null;
		try {
			url = new URL(urlStr);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Authorization", "Basic " + props.getAuth());
			log.debug("Conectando ao Jira...");
		} catch (MalformedURLException | ProtocolException e) {
			retorno.setNumeroDeChamadoComErro(retorno.getNumeroDeChamadoComErro() + 1);
			e.printStackTrace();
		} catch (IOException e) {
			retorno.setNumeroDeChamadoComErro(retorno.getNumeroDeChamadoComErro() + 1);
			e.printStackTrace();
		}
		return connection;
	}

	private JsonObject formataJson(BufferedReader json) {
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			while ((line = json.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String gJson = sb.toString();
		JsonParser parser = new JsonParser();
		JsonObject obj = null;
		try {
			obj = parser.parse(gJson).getAsJsonObject();
		} catch (Exception e) {
			log.error(" Estourou no json: " + gJson);
			retorno.setNumeroDeChamadoComErro(retorno.getNumeroDeChamadoComErro() + 1);
			e.printStackTrace();
		}
		return obj;
	}

	private JsonArray formataJsonArray(BufferedReader json) {
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			while ((line = json.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String gJson = sb.toString();
		JsonParser parser = new JsonParser();
		JsonArray array = null;
		try {
			array = parser.parse(gJson).getAsJsonArray();
		} catch (Exception e) {
			log.error(" Estourou no json: " + gJson);
			retorno.setNumeroDeChamadoComErro(retorno.getNumeroDeChamadoComErro() + 1);
			e.printStackTrace();
		}
		return array;
	}
}
