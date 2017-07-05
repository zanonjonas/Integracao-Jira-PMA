
package jira.wadl.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de position.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="position"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Earlier"/&gt;
 *     &lt;enumeration value="Later"/&gt;
 *     &lt;enumeration value="First"/&gt;
 *     &lt;enumeration value="Last"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "position")
@XmlEnum
public enum Position {

    @XmlEnumValue("Earlier")
    EARLIER("Earlier"),
    @XmlEnumValue("Later")
    LATER("Later"),
    @XmlEnumValue("First")
    FIRST("First"),
    @XmlEnumValue("Last")
    LAST("Last");
    private final String value;

    Position(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Position fromValue(String v) {
        for (Position c: Position.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
