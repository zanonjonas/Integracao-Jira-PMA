package br.com.paxtecnologia.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "issueLinksBean")
public class IssueLinksBean {
	private String id;
	private String self;
	private IssueLinksBean.IssueTypeBean type;
	private IssueLinksBean.OutwardIssueBean outwardIssue;

	public IssueLinksBean.OutwardIssueBean getOutwardIssue() {
		return outwardIssue;
	}

	public void setOutwardIssue(IssueLinksBean.OutwardIssueBean outwardIssue) {
		this.outwardIssue = outwardIssue;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public IssueLinksBean.IssueTypeBean getType() {
		return type;
	}

	public void setType(IssueLinksBean.IssueTypeBean type) {
		this.type = type;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "issueTypeBean")
	public class IssueTypeBean {
		private String id;
		private String name;
		private String inward;
		private String outward;
		private String self;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getInward() {
			return inward;
		}

		public void setInward(String inward) {
			this.inward = inward;
		}

		public String getOutward() {
			return outward;
		}

		public void setOutward(String outward) {
			this.outward = outward;
		}

		public String getSelf() {
			return self;
		}

		public void setSelf(String self) {
			this.self = self;
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "outwardIssueBean")
	public class OutwardIssueBean {
		private String id;
		private String key;
		private String self;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getSelf() {
			return self;
		}

		public void setSelf(String self) {
			this.self = self;
		}

	}
}
