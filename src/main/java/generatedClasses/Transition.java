//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.13 at 09:27:23 PM CET 
//


package generatedClasses;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://www.w3.org/2005/07/scxml}executablecontent" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="event" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="cond" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="target" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "executablecontent"
})
@XmlRootElement(name = "transition")
public class Transition {

    @XmlElements({
        @XmlElement(name = "assign", type = Assign.class),
        @XmlElement(name = "send", type = Send.class),
        @XmlElement(name = "if", type = If.class),
        @XmlElement(name = "log", type = Log.class),
        @XmlElement(name = "script", type = Script.class)
    })
    protected List<Object> executablecontent;
    @XmlAttribute(name = "event")
    protected String event;
    @XmlAttribute(name = "cond")
    protected String cond;
    @XmlAttribute(name = "target")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object target;

    /**
     * Gets the value of the executablecontent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the executablecontent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExecutablecontent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Assign }
     * {@link Send }
     * {@link If }
     * {@link Log }
     * {@link Script }
     * 
     * 
     */
    public List<Object> getExecutablecontent() {
        if (executablecontent == null) {
            executablecontent = new ArrayList<Object>();
        }
        return this.executablecontent;
    }

    /**
     * Gets the value of the event property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEvent() {
        return event;
    }

    /**
     * Sets the value of the event property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEvent(String value) {
        this.event = value;
    }

    /**
     * Gets the value of the cond property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCond() {
        return cond;
    }

    /**
     * Sets the value of the cond property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCond(String value) {
        this.cond = value;
    }

    /**
     * Gets the value of the target property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setTarget(Object value) {
        this.target = value;
    }

}
