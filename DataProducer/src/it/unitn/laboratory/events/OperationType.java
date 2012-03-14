
package it.unitn.laboratory.events;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * specifica se è una pubblicazione di un nuovo
 * 						evento o la cancellazione di uno già pubblicato.
 * 					
 * 
 * <p>Java class for OperationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OperationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OperazioneCod" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OperazioneDescr" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperationType", propOrder = {
    "operazioneCod",
    "operazioneDescr"
})
public class OperationType {

    @XmlElement(name = "OperazioneCod")
    protected String operazioneCod;
    @XmlElement(name = "OperazioneDescr")
    protected String operazioneDescr;

    /**
     * Gets the value of the operazioneCod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperazioneCod() {
        return operazioneCod;
    }

    /**
     * Sets the value of the operazioneCod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperazioneCod(String value) {
        this.operazioneCod = value;
    }

    /**
     * Gets the value of the operazioneDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperazioneDescr() {
        return operazioneDescr;
    }

    /**
     * Sets the value of the operazioneDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperazioneDescr(String value) {
        this.operazioneDescr = value;
    }

}
