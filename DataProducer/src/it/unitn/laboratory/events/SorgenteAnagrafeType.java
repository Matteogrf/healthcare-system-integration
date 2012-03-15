
package it.unitn.laboratory.events;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SorgenteAnagrafeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SorgenteAnagrafeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UrlEnte" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IdAnagrafe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SorgenteAnagrafeType", propOrder = {
    "urlEnte",
    "idAnagrafe"
})
public class SorgenteAnagrafeType {

    @XmlElement(name = "UrlEnte", required = true)
    protected String urlEnte;
    @XmlElement(name = "IdAnagrafe", required = true)
    protected String idAnagrafe;

    /**
     * Gets the value of the urlEnte property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlEnte() {
        return urlEnte;
    }

    /**
     * Sets the value of the urlEnte property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlEnte(String value) {
        this.urlEnte = value;
    }

    /**
     * Gets the value of the idAnagrafe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdAnagrafe() {
        return idAnagrafe;
    }

    /**
     * Sets the value of the idAnagrafe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdAnagrafe(String value) {
        this.idAnagrafe = value;
    }

}
