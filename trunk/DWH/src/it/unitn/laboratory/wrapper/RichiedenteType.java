
package it.unitn.laboratory.wrapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RichiedenteType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RichiedenteType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RICHIEDENTE_COD" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="RICHIEDENTE_DESCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RichiedenteType", propOrder = {
    "richiedentecod",
    "richiedentedescr"
})
public class RichiedenteType {

    @XmlElement(name = "RICHIEDENTE_COD")
    protected Integer richiedentecod;
    @XmlElement(name = "RICHIEDENTE_DESCR")
    protected String richiedentedescr;

    /**
     * Gets the value of the richiedentecod property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRICHIEDENTECOD() {
        return richiedentecod;
    }

    /**
     * Sets the value of the richiedentecod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRICHIEDENTECOD(Integer value) {
        this.richiedentecod = value;
    }

    /**
     * Gets the value of the richiedentedescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRICHIEDENTEDESCR() {
        return richiedentedescr;
    }

    /**
     * Sets the value of the richiedentedescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRICHIEDENTEDESCR(String value) {
        this.richiedentedescr = value;
    }

}
