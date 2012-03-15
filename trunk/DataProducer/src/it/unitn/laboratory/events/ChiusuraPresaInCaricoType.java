
package it.unitn.laboratory.events;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ChiusuraPresaInCaricoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChiusuraPresaInCaricoType">
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
 *         &lt;element name="FinePresaInCarico" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChiusuraPresaInCaricoType", propOrder = {
    "presaCaricoNum",
    "finePresaInCarico"
})
public class ChiusuraPresaInCaricoType {

    @XmlElement(name = "PresaCaricoNum")
    protected int presaCaricoNum;
    @XmlElement(name = "FinePresaInCarico", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar finePresaInCarico;

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
     * Gets the value of the finePresaInCarico property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFinePresaInCarico() {
        return finePresaInCarico;
    }

    /**
     * Sets the value of the finePresaInCarico property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFinePresaInCarico(XMLGregorianCalendar value) {
        this.finePresaInCarico = value;
    }

}
