
package it.unitn.laboratory.events;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PresaInCaricoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PresaInCaricoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PresaCaricoNum">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="InizioPresaInCarico" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PresaInCaricoType", propOrder = {
    "presaCaricoNum",
    "inizioPresaInCarico"
})
public class PresaInCaricoType {

    @XmlElement(name = "PresaCaricoNum")
    protected int presaCaricoNum;
    @XmlElement(name = "InizioPresaInCarico", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar inizioPresaInCarico;

    /**
     * Gets the value of the presaCaricoNum property.
     * 
     */
    public int getPresaCaricoNum() {
        return presaCaricoNum;
    }

    /**
     * Sets the value of the presaCaricoNum property.
     * 
     */
    public void setPresaCaricoNum(int value) {
        this.presaCaricoNum = value;
    }

    /**
     * Gets the value of the inizioPresaInCarico property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getInizioPresaInCarico() {
        return inizioPresaInCarico;
    }

    /**
     * Sets the value of the inizioPresaInCarico property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setInizioPresaInCarico(XMLGregorianCalendar value) {
        this.inizioPresaInCarico = value;
    }

}
