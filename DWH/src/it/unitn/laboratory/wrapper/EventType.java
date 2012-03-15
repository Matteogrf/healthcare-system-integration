
package it.unitn.laboratory.wrapper;

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
 *         &lt;element name="EVENT_COD" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="EVENT_DESCR" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "eventcod",
    "eventdescr"
})
public class EventType {

    @XmlElement(name = "EVENT_COD")
    protected int eventcod;
    @XmlElement(name = "EVENT_DESCR", required = true)
    protected String eventdescr;

    /**
     * Gets the value of the eventcod property.
     * 
     */
    public int getEVENTCOD() {
        return eventcod;
    }

    /**
     * Sets the value of the eventcod property.
     * 
     */
    public void setEVENTCOD(int value) {
        this.eventcod = value;
    }

    /**
     * Gets the value of the eventdescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEVENTDESCR() {
        return eventdescr;
    }

    /**
     * Sets the value of the eventdescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEVENTDESCR(String value) {
        this.eventdescr = value;
    }

}
