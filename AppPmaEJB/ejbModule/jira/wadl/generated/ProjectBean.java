
package jira.wadl.generated;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "projectBean", propOrder = { "self", "id", "key", "description", "lead", "components", "issueTypes",
		"url", "email", "assigneeType", "versions", "name", "roles", "avatarUrls", "projectKeys", "projectCategory",
		"projectTypeKey" })
public class ProjectBean {

	private String self;
	private String id;
	private String key;
	private String name;
	private List<String> projectKeys;
	private ProjectCategoryBean projectCategory;
	private String projectTypeKey;

	public String getSelf() {
		return self;
	}

	public void setSelf(String value) {
		this.self = value;
	}

	public String getId() {
		return id;
	}

	public void setId(String value) {
		this.id = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String value) {
		this.key = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String value) {
		this.name = value;
	}

	public List<String> getProjectKeys() {
		if (projectKeys == null) {
			projectKeys = new ArrayList<String>();
		}
		return this.projectKeys;
	}

	public ProjectCategoryBean getProjectCategory() {
		return projectCategory;
	}

	public void setProjectCategory(ProjectCategoryBean value) {
		this.projectCategory = value;
	}

	public String getProjectTypeKey() {
		return projectTypeKey;
	}

	public void setProjectTypeKey(String value) {
		this.projectTypeKey = value;
	}
}
