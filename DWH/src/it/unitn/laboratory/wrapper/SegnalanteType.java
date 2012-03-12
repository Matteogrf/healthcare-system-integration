
package it.unitn.laboratory.wrapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SegnalanteType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SegnalanteType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SEGNALANTE_COD" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="SEGNALANTE_DESCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SegnalanteType", propOrder = {
    "segnalantecod",
    "segnalantedescr"
})
public class SegnalanteType {

    @XmlElement(name = "SEGNALANTE_COD")
    protected Integer segnalantecod;
    @XmlElement(name = "SEGNALANTE_DESCR")
    protected String segnalantedescr;

    /**
     * Gets the value of the segnalantecod property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSEGNALANTECOD() {
        return segnalantecod;
    }

    /**
     * Sets the value of the segnalantecod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSEGNALANTECOD(Integer value) {
        this.segnalantecod = value;
    }

    /**
     * Gets the value of the segnalantedescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSEGNALANTEDESCR() {
        return segnalantedescr;
    }

    /**
     * Sets the value of the segnalantedescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSEGNALANTEDESCR(String value) {
        this.segnalantedescr = value;
    }

}
