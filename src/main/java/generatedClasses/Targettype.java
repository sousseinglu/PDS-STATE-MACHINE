//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.13 at 09:27:23 PM CET 
//


package generatedClasses;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for targettype.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="targettype">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="scxml"/>
 *     &lt;enumeration value="webservice"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "targettype")
@XmlEnum
public enum Targettype {

    @XmlEnumValue("scxml")
    SCXML("scxml"),
    @XmlEnumValue("webservice")
    WEBSERVICE("webservice");
    private final String value;

    Targettype(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Targettype fromValue(String v) {
        for (Targettype c: Targettype.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
