
package it.unitn.laboratory.events;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EventType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EventType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Intestazione" type="{http://events.laboratory.unitn.it/}HeaderType"/>
 *         &lt;element name="Assistito" type="{http://events.laboratory.unitn.it/}PatientType"/>
 *         &lt;element name="Descrizione" type="{http://events.laboratory.unitn.it/}DescriptionType"/>
 *         &lt;element name="Operazione" type="{http://events.laboratory.unitn.it/}OperationType"/>
 *         &lt;element name="Evento" type="{http://events.laboratory.unitn.it/}BodyType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventType", propOrder = {
    "intestazione",
    "assistito",
    "descrizione",
    "operazione",
    "evento"
})
public class EventType {

    @XmlElement(name = "Intestazione", required = true)
    protected HeaderType intestazione;
    @XmlElement(name = "Assistito", required = true)
    protected PatientType assistito;
    @XmlElement(name = "Descrizione", required = true)
    protected DescriptionType descrizione;
    @XmlElement(name = "Operazione", required = true)
    protected OperationType operazione;
    @XmlElement(name = "Evento", required = true)
    protected BodyType evento;

    /**
     * Gets the value of the intestazione property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderType }
     *     
     */
    public HeaderType getIntestazione() {
        return intestazione;
    }

    /**
     * Sets the value of the intestazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderType }
     *     
     */
    public void setIntestazione(HeaderType value) {
        this.intestazione = value;
    }

    /**
     * Gets the value of the assistito property.
     * 
     * @return
     *     possible object is
     *     {@link PatientType }
     *     
     */
    public PatientType getAssistito() {
        return assistito;
    }

    /**
     * Sets the value of the assistito property.
     * 
     * @param value
     *     allowed object is
     *     {@link PatientType }
     *     
     */
    public void setAssistito(PatientType value) {
        this.assistito = value;
    }

    /**
     * Gets the value of the descrizione property.
     * 
     * @return
     *     possible object is
     *     {@link DescriptionType }
     *     
     */
    public DescriptionType getDescrizione() {
        return descrizione;
    }

    /**
     * Sets the value of the descrizione property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptionType }
     *     
     */
    public void setDescrizione(DescriptionType value) {
        this.descrizione = value;
    }

    /**
     * Gets the value of the operazione property.
     * 
     * @return
     *     possible object is
     *     {@link OperationType }
     *     
     */
    public OperationType getOperazione() {
        return operazione;
    }

    /**
     * Sets the value of the operazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationType }
     *     
     */
    public void setOperazione(OperationType value) {
        this.operazione = value;
    }

    /**
     * Gets the value of the evento property.
     * 
     * @return
     *     possible object is
     *     {@link BodyType }
     *     
     */
    public BodyType getEvento() {
        return evento;
    }

    /**
     * Sets the value of the evento property.
     * 
     * @param value
     *     allowed object is
     *     {@link BodyType }
     *     
     */
    public void setEvento(BodyType value) {
        this.evento = value;
    }

}
