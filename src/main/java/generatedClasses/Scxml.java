//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.12 at 10:41:11 AM CET 
//


package generatedClasses;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element ref="{http://www.w3.org/2005/07/scxml}datamodel" minOccurs="0"/>
 *         &lt;element ref="{http://www.w3.org/2005/07/scxml}state" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" fixed="1.0" />
 *       &lt;attribute name="initialstate" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "datamodel",
    "state"
})
@XmlRootElement(name = "scxml")
public class Scxml {

    protected Datamodel datamodel;
    @XmlElement(required = true)
    protected List<State> state;
    @XmlAttribute(name = "version")
    protected String version;
    @XmlAttribute(name = "initialstate", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object initialstate;

    /**
     * Gets the value of the datamodel property.
     * 
     * @return
     *     possible object is
     *     {@link Datamodel }
     *     
     */
    public Datamodel getDatamodel() {
        return datamodel;
    }

    /**
     * Sets the value of the datamodel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Datamodel }
     *     
     */
    public void setDatamodel(Datamodel value) {
        this.datamodel = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the state property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link State }
     * 
     * 
     */
    public List<State> getState() {
        if (state == null) {
            state = new ArrayList<State>();
        }
        return this.state;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "1.0";
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the initialstate property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getInitialstate() {
        return initialstate;
    }

    /**
     * Sets the value of the initialstate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setInitialstate(Object value) {
        this.initialstate = value;
    }

}
