
package jira.wadl.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de versionBean complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="versionBean"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="self" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="archived" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="released" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="overdue" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="userStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="userReleaseDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="project" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="projectId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="moveUnfixedIssuesTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="operations" type="{}simpleLinkBean" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="remotelinks" type="{}remoteEntityLinkJsonBean" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="releaseDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="expand" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "versionBean", propOrder = {
    "self",
    "id",
    "description",
    "name",
    "archived",
    "released",
    "overdue",
    "userStartDate",
    "userReleaseDate",
    "project",
    "projectId",
    "moveUnfixedIssuesTo",
    "operations",
    "remotelinks",
    "releaseDate",
    "startDate"
})
public class VersionBean {

    protected String self;
    protected String id;
    protected String description;
    protected String name;
    protected Boolean archived;
    protected Boolean released;
    protected Boolean overdue;
    protected String userStartDate;
    protected String userReleaseDate;
    protected String project;
    protected Long projectId;
    protected String moveUnfixedIssuesTo;
    protected List<SimpleLinkBean> operations;
    protected List<RemoteEntityLinkJsonBean> remotelinks;
    protected String releaseDate;
    protected String startDate;
    @XmlAttribute(name = "expand")
    protected String expand;

    /**
     * Obtém o valor da propriedade self.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSelf() {
        return self;
    }

    /**
     * Define o valor da propriedade self.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSelf(String value) {
        this.self = value;
    }

    /**
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade description.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define o valor da propriedade description.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtém o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtém o valor da propriedade archived.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isArchived() {
        return archived;
    }

    /**
     * Define o valor da propriedade archived.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setArchived(Boolean value) {
        this.archived = value;
    }

    /**
     * Obtém o valor da propriedade released.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReleased() {
        return released;
    }

    /**
     * Define o valor da propriedade released.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReleased(Boolean value) {
        this.released = value;
    }

    /**
     * Obtém o valor da propriedade overdue.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOverdue() {
        return overdue;
    }

    /**
     * Define o valor da propriedade overdue.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOverdue(Boolean value) {
        this.overdue = value;
    }

    /**
     * Obtém o valor da propriedade userStartDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserStartDate() {
        return userStartDate;
    }

    /**
     * Define o valor da propriedade userStartDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserStartDate(String value) {
        this.userStartDate = value;
    }

    /**
     * Obtém o valor da propriedade userReleaseDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserReleaseDate() {
        return userReleaseDate;
    }

    /**
     * Define o valor da propriedade userReleaseDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserReleaseDate(String value) {
        this.userReleaseDate = value;
    }

    /**
     * Obtém o valor da propriedade project.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProject() {
        return project;
    }

    /**
     * Define o valor da propriedade project.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProject(String value) {
        this.project = value;
    }

    /**
     * Obtém o valor da propriedade projectId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * Define o valor da propriedade projectId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setProjectId(Long value) {
        this.projectId = value;
    }

    /**
     * Obtém o valor da propriedade moveUnfixedIssuesTo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMoveUnfixedIssuesTo() {
        return moveUnfixedIssuesTo;
    }

    /**
     * Define o valor da propriedade moveUnfixedIssuesTo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMoveUnfixedIssuesTo(String value) {
        this.moveUnfixedIssuesTo = value;
    }

    /**
     * Gets the value of the operations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the operations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOperations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimpleLinkBean }
     * 
     * 
     */
    public List<SimpleLinkBean> getOperations() {
        if (operations == null) {
            operations = new ArrayList<SimpleLinkBean>();
        }
        return this.operations;
    }

    /**
     * Gets the value of the remotelinks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the remotelinks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRemotelinks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RemoteEntityLinkJsonBean }
     * 
     * 
     */
    public List<RemoteEntityLinkJsonBean> getRemotelinks() {
        if (remotelinks == null) {
            remotelinks = new ArrayList<RemoteEntityLinkJsonBean>();
        }
        return this.remotelinks;
    }

    /**
     * Obtém o valor da propriedade releaseDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * Define o valor da propriedade releaseDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReleaseDate(String value) {
        this.releaseDate = value;
    }

    /**
     * Obtém o valor da propriedade startDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Define o valor da propriedade startDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Obtém o valor da propriedade expand.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpand() {
        return expand;
    }

    /**
     * Define o valor da propriedade expand.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpand(String value) {
        this.expand = value;
    }

}
