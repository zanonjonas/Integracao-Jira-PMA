
package jira.wadl.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de scope.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="scope"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="GLOBAL"/&gt;
 *     &lt;enumeration value="AUTHENTICATED"/&gt;
 *     &lt;enumeration value="PRIVATE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "scope")
@XmlEnum
public enum Scope {

    GLOBAL,
    AUTHENTICATED,
    PRIVATE;

    public String value() {
        return name();
    }

    public static Scope fromValue(String v) {
        return valueOf(v);
    }

}
