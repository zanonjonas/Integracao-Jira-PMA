
package jira.wadl.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de pagedListWrapper complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="pagedListWrapper"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="items" type="{http://www.w3.org/2001/XMLSchema}anyType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="size" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="max-results" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="start-index" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *       &lt;attribute name="end-index" use="required" type="{http://www.w3.org/2001/XMLSchema}int" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pagedListWrapper", propOrder = {
    "items"
})
@XmlSeeAlso({
    FilterSubscriptionBeanListWrapper.class
})
public abstract class PagedListWrapper {

    protected List<Object> items;
    @XmlAttribute(name = "size", required = true)
    protected int size;
    @XmlAttribute(name = "max-results", required = true)
    protected int maxResults;
    @XmlAttribute(name = "start-index", required = true)
    protected int startIndex;
    @XmlAttribute(name = "end-index", required = true)
    protected int endIndex;

    /**
     * Gets the value of the items property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the items property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItems().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getItems() {
        if (items == null) {
            items = new ArrayList<Object>();
        }
        return this.items;
    }

    /**
     * Obtém o valor da propriedade size.
     * 
     */
    public int getSize() {
        return size;
    }

    /**
     * Define o valor da propriedade size.
     * 
     */
    public void setSize(int value) {
        this.size = value;
    }

    /**
     * Obtém o valor da propriedade maxResults.
     * 
     */
    public int getMaxResults() {
        return maxResults;
    }

    /**
     * Define o valor da propriedade maxResults.
     * 
     */
    public void setMaxResults(int value) {
        this.maxResults = value;
    }

    /**
     * Obtém o valor da propriedade startIndex.
     * 
     */
    public int getStartIndex() {
        return startIndex;
    }

    /**
     * Define o valor da propriedade startIndex.
     * 
     */
    public void setStartIndex(int value) {
        this.startIndex = value;
    }

    /**
     * Obtém o valor da propriedade endIndex.
     * 
     */
    public int getEndIndex() {
        return endIndex;
    }

    /**
     * Define o valor da propriedade endIndex.
     * 
     */
    public void setEndIndex(int value) {
        this.endIndex = value;
    }

}
