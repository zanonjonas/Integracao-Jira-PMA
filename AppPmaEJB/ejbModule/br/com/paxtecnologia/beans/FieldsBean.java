package br.com.paxtecnologia.beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import jira.wadl.generated.ComponentBean;
import jira.wadl.generated.IssueTypeJsonBean;
import jira.wadl.generated.ProjectBean;
import jira.wadl.generated.UserBean;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fieldsBean")
public class FieldsBean {
	private String summary, created, resolutiondate, updated, customfield_10800, customfield_10801;
	private Double timespent;
	private ResolutionBean resolution;
	private CustomfieldBean customfield_10601;
	private IssueTypeJsonBean issuetype;
	private List<IssueLinksBean> issuelinks = new ArrayList<>();
	private ProjectBean project;
	private UserBean reporter;
	private PriorityBean priority;
	private UserBean creator;
	private StatusBean status;
	private List<ComponentBean> components;
	private CustomfieldBean customfield_11100;
	private AssigneeBean assignee;

	public AssigneeBean getAssignee() {
		return assignee;
	}

	public void setAssignee(AssigneeBean assignee) {
		this.assignee = assignee;
	}

	public List<IssueLinksBean> getIssuelinks() {
		return issuelinks;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public void setIssuelinks(List<IssueLinksBean> issuelinks) {
		this.issuelinks = issuelinks;
	}

	public List<ComponentBean> getComponents() {
		return components;
	}

	public void setComponents(List<ComponentBean> components) {
		this.components = components;
	}

	public StatusBean getStatus() {
		return status;
	}

	public void setStatus(StatusBean status) {
		this.status = status;
	}

	public ResolutionBean getResolution() {
		return resolution;
	}

	public void setResolution(ResolutionBean resolution) {
		this.resolution = resolution;
	}

	public CustomfieldBean getCustomfield_11100() {
		return customfield_11100;
	}

	public void setCustomfield_11100(CustomfieldBean customfield_11100) {
		this.customfield_11100 = customfield_11100;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getResolutiondate() {
		return resolutiondate;
	}

	public void setResolutiondate(String resolutiondate) {
		this.resolutiondate = resolutiondate;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getCustomfield_10800() {
		return customfield_10800;
	}

	public void setCustomfield_10800(String customfield_10800) {
		this.customfield_10800 = customfield_10800;
	}

	public String getCustomfield_10801() {
		return customfield_10801;
	}

	public void setCustomfield_10801(String customfield_10801) {
		this.customfield_10801 = customfield_10801;
	}

	public Double getTimespent() {
		return timespent;
	}

	public void setTimespent(Double timespent) {
		this.timespent = timespent;
	}

	public CustomfieldBean getCustomfield_10601() {
		return customfield_10601;
	}

	public void setCustomfield_10601(CustomfieldBean customfield_10601) {
		this.customfield_10601 = customfield_10601;
	}

	public IssueTypeJsonBean getIssuetype() {
		return issuetype;
	}

	public void setIssuetype(IssueTypeJsonBean issuetype) {
		this.issuetype = issuetype;
	}

	public ProjectBean getProject() {
		return project;
	}

	public void setProject(ProjectBean project) {
		this.project = project;
	}

	public UserBean getReporter() {
		return reporter;
	}

	public void setReporter(UserBean reporter) {
		this.reporter = reporter;
	}

	public PriorityBean getPriority() {
		return priority;
	}

	public void setPriority(PriorityBean priority) {
		this.priority = priority;
	}

	public UserBean getCreator() {
		return creator;
	}

	public void setCreator(UserBean creator) {
		this.creator = creator;
	}
}
