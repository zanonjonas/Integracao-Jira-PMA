
package jira.wadl.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de assigneeType.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="assigneeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="PROJECT_DEFAULT"/&gt;
 *     &lt;enumeration value="COMPONENT_LEAD"/&gt;
 *     &lt;enumeration value="PROJECT_LEAD"/&gt;
 *     &lt;enumeration value="UNASSIGNED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "assigneeType")
@XmlEnum
public enum AssigneeType {

    PROJECT_DEFAULT,
    COMPONENT_LEAD,
    PROJECT_LEAD,
    UNASSIGNED;

    public String value() {
        return name();
    }

    public static AssigneeType fromValue(String v) {
        return valueOf(v);
    }

}
