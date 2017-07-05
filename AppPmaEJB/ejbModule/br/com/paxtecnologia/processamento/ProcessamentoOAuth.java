package br.com.paxtecnologia.processamento;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;
import javax.naming.NamingException;

import org.jboss.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.paxtecnologia.beans.RelatorioBean;
import br.com.paxtecnologia.dao.RelatorioDao;
import br.com.paxtecnologia.oAuth.JiraOauthSearch;
import br.com.paxtecnologia.util.JiraUrl;
import br.com.paxtecnologia.vo.RelatorioRetornoVO;
import jira.wadl.generated.ProjectBean;

@Stateless
public class ProcessamentoOAuth {

	private RelatorioRetornoVO retorno;
	private final RelatorioDao dao = new RelatorioDao();
	private final Logger log = Logger.getLogger("log");
	private Gson gson = new GsonBuilder().create();

	public RelatorioRetornoVO iniciaProcessamento(String dataInicio, String dataFim) {
		retorno = new RelatorioRetornoVO();
		retorno.setData_inicio(dataInicio);
		retorno.setData_fim(dataFim);
		JiraUrl jira = new JiraUrl(dataInicio, dataFim);

		try {
			List<ProjectBean> projetos = getProjects(dao.getProjectIds());
			dao.deleteDados();

			List<RelatorioBean> chamadosP = new ArrayList<>();
			for (int i = 1; i < 4; i++) {
				for (ProjectBean projeto : projetos) {
					JsonObject resposta = null;
					try {
						// Uma possível forma de melhorar a performance do
						// código é "pedindo" para que os webservices do Jira
						// retorne apenas os campos necessários, na chamada abaixo
						resposta = (JsonObject) formataJson(
								JiraOauthSearch.getJiraRest(jira.getChamado(i, projeto.getId())), 1);
						JsonArray obj = resposta.getAsJsonArray("issues");

						List<RelatorioBean> chamados = Arrays.asList(gson.fromJson(obj, RelatorioBean[].class));

						for (RelatorioBean chamado : chamados) {
							if (!containsId(chamadosP, chamado.getKey())) {
								dao.creteRelatorio(chamado, i);
								chamadosP.add(chamado);
								retorno.setNumeroDeChamadosProcessados(retorno.getNumeroDeChamadosProcessados() + 1);
							}
						}

					} catch (SQLException e) {
						log.error(" Erro ao gravar no banco. Erro: " + e.getMessage() + "\nEstado: " + e.getSQLState()
								+ "\nError code: " + e.getErrorCode());
						retorno.setNumeroDeChamadoComErro(retorno.getNumeroDeChamadoComErro() + 1);
						retorno.getErrors().add(" Erro ao gravar no banco. Erro: " + e.getMessage() + " Estado: "
								+ e.getSQLState() + " Error code: " + e.getErrorCode());
					} catch (IOException e) {
						if (e.getMessage().toString().contains("400")) {
							log.error("Erro no projeto: " + projeto.getId() + "erro: " + e.getMessage());
							retorno.setNumeroDeChamadoComErro(retorno.getNumeroDeChamadoComErro() + 1);
							retorno.getErrors()
									.add("Erro no projeto: " + projeto.getId() + " , erro: " + e.getMessage());
						} else {
							throw new IOException(e);
						}
					} catch (Exception e) {
						log.error("Erro no json: " + e.toString());
						retorno.setNumeroDeChamadoComErro(retorno.getNumeroDeChamadoComErro() + 1);
						retorno.getErrors().add(("Erro no projeto: " + projeto.getId() + ", json: " + resposta));
					}
				}
			}
		} catch (MalformedURLException e) {
			retorno.getErrors().add("Erro ao consultar a página do jira. Erro: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			if (e.getCause().toString().contains("401")) {
				retorno.getErrors().add(
						"Token rejeitado! Para corrigir esse problema faça o processo de requisição do token descrito na página: {ip-atual}/pax");
			} else {
				retorno.getErrors().add("Erro: " + e.getMessage());
			}
			e.printStackTrace();
		} catch (Exception e) {
			retorno.getErrors().add("Algum erro imprevisto ocorreu! Erro: " + e.getMessage());
			e.printStackTrace();
		}
		return retorno;
	}

	private boolean containsId(List<RelatorioBean> list, String key) {
		for (RelatorioBean object : list) {
			if (object.getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}

	private Object formataJson(String json, int tipo) {
		JsonParser parser = new JsonParser();
		if (tipo == 1) {
			JsonObject obj = null;
			obj = parser.parse(json).getAsJsonObject();
			return obj;
		} else {
			JsonArray array = null;
			array = parser.parse(json).getAsJsonArray();
			return array;
		}
	}

	private List<ProjectBean> getProjects(List<String> ids)
			throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, SQLException, NamingException {
		List<ProjectBean> retorno = new ArrayList<>();

		for (String id : ids) {
			JsonObject json = (JsonObject) formataJson(JiraOauthSearch.getJiraRest(JiraUrl.jiraProjectURL + id), 1);
			retorno.add(gson.fromJson(json, ProjectBean.class));
		}
		return retorno;
	}
}
