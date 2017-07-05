package br.com.paxtecnologia.util;

public class JiraUrl {

	private static final String jiraSearchURL = "https://paxtecnologia.atlassian.net/rest/api/2/search?";
	public static final String jiraProjectURL = "https://paxtecnologia.atlassian.net/rest/api/2/project/";
	private static final String maxResults = "maxResults=999";
	private String project, startDate, endDate;
	
	public JiraUrl(String startDate, String endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getChamado(int chamado, String project) {
		switch(chamado) {
		case 1:
			return getChamadosCriados(project);
		case 2:
			return getChamadosResolvidos(project);
		case 3:
			return getChamadosAberto(project);
		default:
			return null;
		}
		
	}

	private String getChamadosCriados(String project) {
		return jiraSearchURL + "jql=project+%3D+" + project + "+AND+created+%3E%3D+" + startDate
				+ "+AND+created+%3C%3D+" + endDate + "&&" + maxResults;
	}

	private String getChamadosResolvidos(String project) {
		return jiraSearchURL + "jql=project+%3D+" + project
				+ "+AND+status+in+%28Resolved%2C+Closed%2C+\"Resolved+With+Stopping\"%29+AND+resolved+%3E%3D+"
				+ startDate + "+AND+resolved+%3C%3D+" + endDate + "&&" + maxResults;
	}

	private String getChamadosAberto(String project) {
		return jiraSearchURL + "jql=project+%3D+" + project
				+ "+AND+status+in+%28Open%2C+\"In+Progress\"%2C+Reopened%2C+\"Waiting+for+Approval\"%2C+\"Released+to+be+Implemented\"%2C+\"Released+to+be+Validated\"%2C+Rollback%2C+\"In+Validation\"%2C+\"Waiting+for+Customer\"%29+AND+updated+<%3D+"
				+ endDate + "&&" + maxResults;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}
}