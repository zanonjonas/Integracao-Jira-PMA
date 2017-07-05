package br.com.paxtecnologia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;

import org.jboss.logging.Logger;

import br.com.paxtecnologia.beans.IssueLinksBean;
import br.com.paxtecnologia.beans.RelatorioBean;
import jira.wadl.generated.ComponentBean;

public class RelatorioDao {

	private Datasource conn;
	private final Logger log = Logger.getLogger("log");

	public void deleteDados() throws SQLException, NamingException {
		PreparedStatement pstmt = null;
		conn = new Datasource();
		try {
			String sql = "DELETE FROM pma_dados";
			pstmt = conn.getPreparedStatement(sql);
			conn.executaQuery(pstmt);
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SQLException(e);
				}
			}
		}
	}

	public List<String> getProjectIds() throws SQLException, NamingException {
		List<String> retorno = new ArrayList<>();
		PreparedStatement pstmt = null;
		conn = new Datasource();
		try {
			String sql = "SELECT projeto_ws_id FROM fp_projetos";
			pstmt = conn.getPreparedStatement(sql);
			ResultSet result = conn.executaQuery(pstmt);

			while (result.next()) {
				retorno.add(result.getString("projeto_ws_id"));
			}

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return retorno;
	}

	public void creteRelatorio(RelatorioBean relatorio, int tipo) throws SQLException, NamingException {
		PreparedStatement pstmt = null;
		conn = new Datasource();
		try {
			String sql = "INSERT INTO pma_dados(DATA_INSERCAO, CHAMADO, TITULO, DATA_CRIACAO, STATUS, "
					+ "TIPO_CHAMADO, SOLICITANTE, SEGUNDOS, PROJETO, HOST, RESPONSAVEL, "
					+ "PRIORIDADE, CRIADOR, RESOLUCAO, DATA_FECHAMENTO, DATA_ATUALIZACAO, TIPO_RELACAO, "
					+ "RELACAO, RELACIONADAS, DATA_INICIO_PARADA, DATA_FIM_PARADA, TIPO_PARADA)"
					+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			SimpleDateFormat formatoAlien = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); // Mentira_é_TimeZone_:P

			pstmt = conn.getPreparedStatement(sql);
			pstmt.setString(1, sdf.format(new Date()));

			if (relatorio.getKey() != null) {
				pstmt.setString(2, relatorio.getKey());
			} else {
				log.error(" ERROR - A atividade " + relatorio.getKey() + " se pode pegar a key");
				pstmt.setString(2, "");
			}

			if (relatorio.getFields().getSummary() != null) {
				pstmt.setString(3, relatorio.getFields().getSummary());
			} else {
				log.error(" ERROR - A atividade " + relatorio.getKey() + " se pode pegar o titulo");
				pstmt.setString(3, "");
			}

			if (relatorio.getFields().getCreated() != null) {
				pstmt.setString(4, sdf.format(formatoAlien.parse(relatorio.getFields().getCreated())));
			} else {
				log.error(" ERROR - A atividade " + relatorio.getKey() + " se pode pegar o created");
				pstmt.setString(4, "");
			}

			if (relatorio.getFields().getStatus() != null && relatorio.getFields().getStatus().getName() != null) {
				pstmt.setString(5, relatorio.getFields().getStatus().getName());
			} else {
				log.error(" ERROR - A atividade " + relatorio.getKey() + " se pode pegar o status");
				pstmt.setString(5, "");
			}

			if (relatorio.getFields().getIssuetype() != null
					&& relatorio.getFields().getIssuetype().getName() != null) {
				pstmt.setString(6, relatorio.getFields().getIssuetype().getName());
			} else {
				log.error(" ERROR - A atividade " + relatorio.getKey() + " se pode pegar o type");
				pstmt.setString(6, "");
			}

			if (relatorio.getFields().getCustomfield_10601() != null
					&& relatorio.getFields().getCustomfield_10601().getValue() != null) {
				pstmt.setString(7, relatorio.getFields().getCustomfield_10601().getValue());
			} else {
				log.error(" ERROR - A atividade " + relatorio.getKey() + " nao tem solicitante");
				pstmt.setString(7, "");
			}

			if (relatorio.getFields().getTimespent() != null) {
				pstmt.setDouble(8, relatorio.getFields().getTimespent());
			} else {
				if (tipo == 1 || tipo == 3) {
					log.error(" Warning - A atividade " + relatorio.getKey()
							+ " nao tem horas lançadas, mas ainda esta em aberto. Bora trabalhar?");
				} else {
					log.error(" ERROR - A atividade " + relatorio.getKey() + " nao tem horas lançadas!!! Come on!");
				}
				pstmt.setString(8, "");
			}

			if (relatorio.getFields().getProject() != null && relatorio.getFields().getProject().getName() != null) {
				pstmt.setString(9, relatorio.getFields().getProject().getName());
			} else {
				log.error(" ERROR - A atividade " + relatorio.getKey() + " se pode pegar o projeto");
				pstmt.setString(9, "");
			}

			StringBuilder component = null;
			try {
				component = new StringBuilder();
				for (ComponentBean componente : relatorio.getFields().getComponents()) {
					component.append(componente.getName() + ", ");
				}
				component.delete(component.length() - 2, component.length() - 1); // Removendo a última vírgula
			} catch (Exception e) {
			}

			if (component != null) {
				pstmt.setString(10, component.toString());
			} else {
				log.error(" ERROR - A atividade " + relatorio.getKey() + " nao contem components(host) vinculadas");
				pstmt.setString(10, "");
			}

			if (relatorio.getFields().getAssignee() != null && relatorio.getFields().getAssignee().getName() != null) {
				pstmt.setString(11, relatorio.getFields().getAssignee().getDisplayName());
			} else {
				log.error(" ERROR - A atividade " + relatorio.getKey() + " se pode pegar o assignee");
				pstmt.setString(11, "");
			}

			if (relatorio.getFields().getPriority() != null && relatorio.getFields().getPriority().getName() != null) {
				pstmt.setString(12, relatorio.getFields().getPriority().getName());
			} else {
				log.error(" ERROR - A atividade " + relatorio.getKey() + " se pode pegar o priority");
				pstmt.setString(12, "");
			}

			if (relatorio.getFields().getReporter() != null && relatorio.getFields().getReporter().getDisplayName() != null) {
				pstmt.setString(13, relatorio.getFields().getReporter().getDisplayName());
			} else {
				log.error(" ERROR - A atividade " + relatorio.getKey() + " se pode pegar o reporter");
				pstmt.setString(13, "");
			}

			if (relatorio.getFields().getResolution() != null
					&& relatorio.getFields().getResolution().getName() != null) {
				pstmt.setString(14, relatorio.getFields().getResolution().getName());
			} else {
				if (tipo == 1 || tipo == 3) {
					log.error(
							" Warning - A atividade " + relatorio.getKey() + " ainda esta em aberto. Bora trabalhar?");
				} else {
					log.error(" ERROR - A atividade " + relatorio.getKey() + " nao foi possivel pegar o resolution!");
				}
				pstmt.setString(14, "");
			}

			if (relatorio.getFields().getResolutiondate() != null) {
				pstmt.setString(15, sdf.format(formatoAlien.parse(relatorio.getFields().getResolutiondate())));
			} else {
				log.error(" ERROR - A atividade " + relatorio.getKey() + " nao foi possivel pegar o resolutionDate!");
				pstmt.setString(15, "");
			}

			if (relatorio.getFields().getUpdated() != null) {
				pstmt.setString(16, sdf.format(formatoAlien.parse(relatorio.getFields().getUpdated())));
			} else {
				log.error(" Warning - A atividade " + relatorio.getKey() + " nao foi atualizada! Trabalhem!");
				pstmt.setString(16, "");
			}

			// TODO: Campos não utilizados na tabela
			if (relatorio.getFields().getIssuelinks() != null && relatorio.getFields().getIssuelinks().size() > 0) {
				pstmt.setString(17, relatorio.getFields().getIssuelinks().get(0).getType().getName());
			} else {
				log.error(" Warning - A atividade " + relatorio.getKey() + " nao tem links com outras task");
				pstmt.setString(17, "");
			}

			if (relatorio.getFields().getIssuelinks() != null && relatorio.getFields().getIssuelinks().size() > 0) {
				pstmt.setString(18, relatorio.getFields().getIssuelinks().get(0).getType().getOutward());
			} else {
				log.error(" Warning - A atividade " + relatorio.getKey() + " nao tem Outwardlinks com outras task");
				pstmt.setString(18, "");
			}

			StringBuilder issuelinks = null;
			try {
				issuelinks = new StringBuilder();
				for (IssueLinksBean links : relatorio.getFields().getIssuelinks()) {
					issuelinks.append(links.getOutwardIssue().getKey() + ", ");
				}
				component.delete(component.length() - 2, component.length() - 1); // Removendo a última vírgula
			} catch (Exception e) {
			}

			if (issuelinks != null) {
				pstmt.setString(19, issuelinks.toString());
			} else {
				log.error(" Warning - A atividade " + relatorio.getKey() + " nao tem Outwardlinks com outras task");
				pstmt.setString(19, "");
			}

			if (relatorio.getFields().getCustomfield_10800() != null) {
				pstmt.setString(20, sdf.format(formatoAlien.parse(relatorio.getFields().getCustomfield_10800())));
			} else {
				if (tipo == 1 || tipo == 3) {
					log.error(
							" Warning - A atividade " + relatorio.getKey() + " ainda esta em aberto. Bora trabalhar?");
				} else {
					log.error(" ERROR - A atividade " + relatorio.getKey()
							+ " nao foi possivel pegar Data/Hora de Inicio da Parada!");
				}
				pstmt.setString(20, "");
			}

			if (relatorio.getFields().getCustomfield_10801() != null) {
				pstmt.setString(21, sdf.format(formatoAlien.parse(relatorio.getFields().getCustomfield_10801())));
			} else {
				if (tipo == 1 || tipo == 3) {
					log.error(
							" Warning - A atividade " + relatorio.getKey() + " ainda esta em aberto. Bora trabalhar?");
				} else {
					log.error(" ERROR - A atividade " + relatorio.getKey()
							+ " nao foi possivel pegar Data/Hora de Fim da Parada!");
				}
				pstmt.setString(21, "");
			}

			if (relatorio.getFields().getCustomfield_11100() != null) {
				pstmt.setString(22, relatorio.getFields().getCustomfield_11100().getValue());
			} else {
				if (tipo == 1 || tipo == 3) {
					log.error(
							" Warning - A atividade " + relatorio.getKey() + " ainda esta em aberto. Bora trabalhar?");
				} else {
					log.error(" ERROR - A atividade " + relatorio.getKey() + " nao foi possivel pegar Tipo de parada!");
				}
				pstmt.setString(22, "");
			}

			conn.executaUpdate(pstmt);

		} catch (SQLException e) {
			throw new SQLException(e);
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					throw new SQLException(e);
				}
			}
		}
	}
}
