
package jira.wadl.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de searchRequestBean complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="searchRequestBean"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="jql" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="startAt" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="maxResults" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="fields" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="validateQuery" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="expand" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="properties" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="fieldsByKeys" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchRequestBean", propOrder = {
    "jql",
    "startAt",
    "maxResults",
    "fields",
    "validateQuery",
    "expand",
    "properties",
    "fieldsByKeys"
})
public class SearchRequestBean {

    protected String jql;
    protected Integer startAt;
    protected Integer maxResults;
    @XmlElement(nillable = true)
    protected List<String> fields;
    protected String validateQuery;
    @XmlElement(nillable = true)
    protected List<String> expand;
    @XmlElement(nillable = true)
    protected List<String> properties;
    protected boolean fieldsByKeys;

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
     * Obtém o valor da propriedade startAt.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStartAt() {
        return startAt;
    }

    /**
     * Define o valor da propriedade startAt.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStartAt(Integer value) {
        this.startAt = value;
    }

    /**
     * Obtém o valor da propriedade maxResults.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxResults() {
        return maxResults;
    }

    /**
     * Define o valor da propriedade maxResults.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxResults(Integer value) {
        this.maxResults = value;
    }

    /**
     * Gets the value of the fields property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fields property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFields().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFields() {
        if (fields == null) {
            fields = new ArrayList<String>();
        }
        return this.fields;
    }

    /**
     * Obtém o valor da propriedade validateQuery.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidateQuery() {
        return validateQuery;
    }

    /**
     * Define o valor da propriedade validateQuery.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidateQuery(String value) {
        this.validateQuery = value;
    }

    /**
     * Gets the value of the expand property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the expand property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExpand().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getExpand() {
        if (expand == null) {
            expand = new ArrayList<String>();
        }
        return this.expand;
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
     * {@link String }
     * 
     * 
     */
    public List<String> getProperties() {
        if (properties == null) {
            properties = new ArrayList<String>();
        }
        return this.properties;
    }

    /**
     * Obtém o valor da propriedade fieldsByKeys.
     * 
     */
    public boolean isFieldsByKeys() {
        return fieldsByKeys;
    }

    /**
     * Define o valor da propriedade fieldsByKeys.
     * 
     */
    public void setFieldsByKeys(boolean value) {
        this.fieldsByKeys = value;
    }

}
