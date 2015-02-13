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
import javax.xml.bind.annotation.XmlRootElement;
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
 *       &lt;choice>
 *         &lt;group ref="{http://www.w3.org/2005/07/scxml}executablecontent"/>
 *       &lt;/choice>
 *       &lt;attribute name="cond" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "assign",
    "send",
    "_if",
    "log",
    "script"
})
@XmlRootElement(name = "elseif")
public class Elseif {

    protected List<Assign> assign;
    protected List<Send> send;
    @XmlElement(name = "if")
    protected List<If> _if;
    protected List<Log> log;
    protected List<Script> script;
    @XmlAttribute(name = "cond", required = true)
    protected String cond;

    /**
     * Gets the value of the assign property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assign property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssign().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Assign }
     * 
     * 
     */
    public List<Assign> getAssign() {
        if (assign == null) {
            assign = new ArrayList<Assign>();
        }
        return this.assign;
    }

    /**
     * Gets the value of the send property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the send property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSend().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Send }
     * 
     * 
     */
    public List<Send> getSend() {
        if (send == null) {
            send = new ArrayList<Send>();
        }
        return this.send;
    }

    /**
     * Gets the value of the if property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the if property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link If }
     * 
     * 
     */
    public List<If> getIf() {
        if (_if == null) {
            _if = new ArrayList<If>();
        }
        return this._if;
    }

    /**
     * Gets the value of the log property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the log property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLog().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Log }
     * 
     * 
     */
    public List<Log> getLog() {
        if (log == null) {
            log = new ArrayList<Log>();
        }
        return this.log;
    }

    /**
     * Gets the value of the script property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the script property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScript().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Script }
     * 
     * 
     */
    public List<Script> getScript() {
        if (script == null) {
            script = new ArrayList<Script>();
        }
        return this.script;
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

}
