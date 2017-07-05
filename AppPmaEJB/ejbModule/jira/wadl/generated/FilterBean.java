
package jira.wadl.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de filterBean complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="filterBean"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="self" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="owner" type="{}userBean" minOccurs="0"/&gt;
 *         &lt;element name="jql" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="viewUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="searchUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="favourite" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="sharePermissions" type="{}filterPermissionBean" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="subscriptions" type="{}filterSubscriptionBeanListWrapper" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "filterBean", propOrder = {
    "self",
    "id",
    "name",
    "description",
    "owner",
    "jql",
    "viewUrl",
    "searchUrl",
    "favourite",
    "sharePermissions",
    "subscriptions"
})
public class FilterBean {

    protected String self;
    protected String id;
    protected String name;
    protected String description;
    protected UserBean owner;
    protected String jql;
    protected String viewUrl;
    protected String searchUrl;
    protected boolean favourite;
    protected List<FilterPermissionBean> sharePermissions;
    protected FilterSubscriptionBeanListWrapper subscriptions;

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
     * Obtém o valor da propriedade owner.
     * 
     * @return
     *     possible object is
     *     {@link UserBean }
     *     
     */
    public UserBean getOwner() {
        return owner;
    }

    /**
     * Define o valor da propriedade owner.
     * 
     * @param value
     *     allowed object is
     *     {@link UserBean }
     *     
     */
    public void setOwner(UserBean value) {
        this.owner = value;
    }

    /**
     * Obtém o valor da propriedade jql.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJql() {
        return jql;
    }

    /**
     * Define o valor da propriedade jql.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJql(String value) {
        this.jql = value;
    }

    /**
     * Obtém o valor da propriedade viewUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getViewUrl() {
        return viewUrl;
    }

    /**
     * Define o valor da propriedade viewUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setViewUrl(String value) {
        this.viewUrl = value;
    }

    /**
     * Obtém o valor da propriedade searchUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchUrl() {
        return searchUrl;
    }

    /**
     * Define o valor da propriedade searchUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchUrl(String value) {
        this.searchUrl = value;
    }

    /**
     * Obtém o valor da propriedade favourite.
     * 
     */
    public boolean isFavourite() {
        return favourite;
    }

    /**
     * Define o valor da propriedade favourite.
     * 
     */
    public void setFavourite(boolean value) {
        this.favourite = value;
    }

    /**
     * Gets the value of the sharePermissions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sharePermissions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSharePermissions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FilterPermissionBean }
     * 
     * 
     */
    public List<FilterPermissionBean> getSharePermissions() {
        if (sharePermissions == null) {
            sharePermissions = new ArrayList<FilterPermissionBean>();
        }
        return this.sharePermissions;
    }

    /**
     * Obtém o valor da propriedade subscriptions.
     * 
     * @return
     *     possible object is
     *     {@link FilterSubscriptionBeanListWrapper }
     *     
     */
    public FilterSubscriptionBeanListWrapper getSubscriptions() {
        return subscriptions;
    }

    /**
     * Define o valor da propriedade subscriptions.
     * 
     * @param value
     *     allowed object is
     *     {@link FilterSubscriptionBeanListWrapper }
     *     
     */
    public void setSubscriptions(FilterSubscriptionBeanListWrapper value) {
        this.subscriptions = value;
    }

}
