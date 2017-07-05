
package jira.wadl.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de visibilityType.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="visibilityType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="group"/&gt;
 *     &lt;enumeration value="role"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "visibilityType")
@XmlEnum
public enum VisibilityType {

    @XmlEnumValue("group")
    GROUP("group"),
    @XmlEnumValue("role")
    ROLE("role");
    private final String value;

    VisibilityType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VisibilityType fromValue(String v) {
        for (VisibilityType c: VisibilityType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
