
package jira.wadl.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de worklogJsonBean complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="worklogJsonBean"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="self" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="author" type="{}userJsonBean" minOccurs="0"/&gt;
 *         &lt;element name="updateAuthor" type="{}userJsonBean" minOccurs="0"/&gt;
 *         &lt;element name="comment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="created" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="updated" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="visibility" type="{}visibilityJsonBean" minOccurs="0"/&gt;
 *         &lt;element name="isVisibilitySet" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="started" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="timeSpent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="timeSpentSeconds" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="issueId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="properties" type="{}entityPropertyBean" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "worklogJsonBean", propOrder = {
    "self",
    "author",
    "updateAuthor",
    "comment",
    "created",
    "updated",
    "visibility",
    "isVisibilitySet",
    "started",
    "timeSpent",
    "timeSpentSeconds",
    "id",
    "issueId",
    "properties"
})
public class WorklogJsonBean {

    protected String self;
    protected UserJsonBean author;
    protected UserJsonBean updateAuthor;
    protected String comment;
    protected String created;
    protected String updated;
    protected VisibilityJsonBean visibility;
    protected boolean isVisibilitySet;
    protected String started;
    protected String timeSpent;
    protected Long timeSpentSeconds;
    protected String id;
    protected String issueId;
    protected List<EntityPropertyBean> properties;

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
     * Obtém o valor da propriedade author.
     * 
     * @return
     *     possible object is
     *     {@link UserJsonBean }
     *     
     */
    public UserJsonBean getAuthor() {
        return author;
    }

    /**
     * Define o valor da propriedade author.
     * 
     * @param value
     *     allowed object is
     *     {@link UserJsonBean }
     *     
     */
    public void setAuthor(UserJsonBean value) {
        this.author = value;
    }

    /**
     * Obtém o valor da propriedade updateAuthor.
     * 
     * @return
     *     possible object is
     *     {@link UserJsonBean }
     *     
     */
    public UserJsonBean getUpdateAuthor() {
        return updateAuthor;
    }

    /**
     * Define o valor da propriedade updateAuthor.
     * 
     * @param value
     *     allowed object is
     *     {@link UserJsonBean }
     *     
     */
    public void setUpdateAuthor(UserJsonBean value) {
        this.updateAuthor = value;
    }

    /**
     * Obtém o valor da propriedade comment.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Define o valor da propriedade comment.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Obtém o valor da propriedade created.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreated() {
        return created;
    }

    /**
     * Define o valor da propriedade created.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreated(String value) {
        this.created = value;
    }

    /**
     * Obtém o valor da propriedade updated.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdated() {
        return updated;
    }

    /**
     * Define o valor da propriedade updated.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdated(String value) {
        this.updated = value;
    }

    /**
     * Obtém o valor da propriedade visibility.
     * 
     * @return
     *     possible object is
     *     {@link VisibilityJsonBean }
     *     
     */
    public VisibilityJsonBean getVisibility() {
        return visibility;
    }

    /**
     * Define o valor da propriedade visibility.
     * 
     * @param value
     *     allowed object is
     *     {@link VisibilityJsonBean }
     *     
     */
    public void setVisibility(VisibilityJsonBean value) {
        this.visibility = value;
    }

    /**
     * Obtém o valor da propriedade isVisibilitySet.
     * 
     */
    public boolean isIsVisibilitySet() {
        return isVisibilitySet;
    }

    /**
     * Define o valor da propriedade isVisibilitySet.
     * 
     */
    public void setIsVisibilitySet(boolean value) {
        this.isVisibilitySet = value;
    }

    /**
     * Obtém o valor da propriedade started.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStarted() {
        return started;
    }

    /**
     * Define o valor da propriedade started.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStarted(String value) {
        this.started = value;
    }

    /**
     * Obtém o valor da propriedade timeSpent.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeSpent() {
        return timeSpent;
    }

    /**
     * Define o valor da propriedade timeSpent.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeSpent(String value) {
        this.timeSpent = value;
    }

    /**
     * Obtém o valor da propriedade timeSpentSeconds.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTimeSpentSeconds() {
        return timeSpentSeconds;
    }

    /**
     * Define o valor da propriedade timeSpentSeconds.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTimeSpentSeconds(Long value) {
        this.timeSpentSeconds = value;
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
     * Obtém o valor da propriedade issueId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssueId() {
        return issueId;
    }

    /**
     * Define o valor da propriedade issueId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssueId(String value) {
        this.issueId = value;
    }

    /**
     * Gets the value of the properties property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the properties property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProperties().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityPropertyBean }
     * 
     * 
     */
    public List<EntityPropertyBean> getProperties() {
        if (properties == null) {
            properties = new ArrayList<EntityPropertyBean>();
        }
        return this.properties;
    }

}
