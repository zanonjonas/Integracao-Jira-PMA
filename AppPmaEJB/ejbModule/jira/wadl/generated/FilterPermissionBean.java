
package jira.wadl.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de filterPermissionBean complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="filterPermissionBean"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element ref="{}project" minOccurs="0"/&gt;
 *         &lt;element name="role" type="{}projectRoleBean" minOccurs="0"/&gt;
 *         &lt;element name="group" type="{}groupJsonBean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "filterPermissionBean", propOrder = {
    "id",
    "type",
    "project",
    "role",
    "group"
})
public class FilterPermissionBean {

    protected Long id;
    protected String type;
    protected ProjectBean project;
    protected ProjectRoleBean role;
    protected GroupJsonBean group;

    /**
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade project.
     * 
     * @return
     *     possible object is
     *     {@link ProjectBean }
     *     
     */
    public ProjectBean getProject() {
        return project;
    }

    /**
     * Define o valor da propriedade project.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectBean }
     *     
     */
    public void setProject(ProjectBean value) {
        this.project = value;
    }

    /**
     * Obtém o valor da propriedade role.
     * 
     * @return
     *     possible object is
     *     {@link ProjectRoleBean }
     *     
     */
    public ProjectRoleBean getRole() {
        return role;
    }

    /**
     * Define o valor da propriedade role.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectRoleBean }
     *     
     */
    public void setRole(ProjectRoleBean value) {
        this.role = value;
    }

    /**
     * Obtém o valor da propriedade group.
     * 
     * @return
     *     possible object is
     *     {@link GroupJsonBean }
     *     
     */
    public GroupJsonBean getGroup() {
        return group;
    }

    /**
     * Define o valor da propriedade group.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupJsonBean }
     *     
     */
    public void setGroup(GroupJsonBean value) {
        this.group = value;
    }

}
