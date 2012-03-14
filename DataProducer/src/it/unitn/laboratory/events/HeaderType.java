
package it.unitn.laboratory.events;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HeaderType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HeaderType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdEvento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Mittente" type="{http://events.laboratory.unitn.it/}MittenteType"/>
 *         &lt;element name="SorgenteAnagrafe" type="{http://events.laboratory.unitn.it/}SorgenteAnagrafeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderType", propOrder = {
    "idEvento",
    "mittente",
    "sorgenteAnagrafe"
})
public class HeaderType {

    @XmlElement(name = "IdEvento", required = true)
    protected String idEvento;
    @XmlElement(name = "Mittente", required = true)
    protected MittenteType mittente;
    @XmlElement(name = "SorgenteAnagrafe", required = true)
    protected SorgenteAnagrafeType sorgenteAnagrafe;

    /**
     * Gets the value of the idEvento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdEvento() {
        return idEvento;
    }

    /**
     * Sets the value of the idEvento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdEvento(String value) {
        this.idEvento = value;
    }

    /**
     * Gets the value of the mittente property.
     * 
     * @return
     *     possible object is
     *     {@link MittenteType }
     *     
     */
    public MittenteType getMittente() {
        return mittente;
    }

    /**
     * Sets the value of the mittente property.
     * 
     * @param value
     *     allowed object is
     *     {@link MittenteType }
     *     
     */
    public void setMittente(MittenteType value) {
        this.mittente = value;
    }

    /**
     * Gets the value of the sorgenteAnagrafe property.
     * 
     * @return
     *     possible object is
     *     {@link SorgenteAnagrafeType }
     *     
     */
    public SorgenteAnagrafeType getSorgenteAnagrafe() {
        return sorgenteAnagrafe;
    }

    /**
     * Sets the value of the sorgenteAnagrafe property.
     * 
     * @param value
     *     allowed object is
     *     {@link SorgenteAnagrafeType }
     *     
     */
    public void setSorgenteAnagrafe(SorgenteAnagrafeType value) {
        this.sorgenteAnagrafe = value;
    }

}
