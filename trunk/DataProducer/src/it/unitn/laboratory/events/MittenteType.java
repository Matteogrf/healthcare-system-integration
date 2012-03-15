
package it.unitn.laboratory.events;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MittenteType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MittenteType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NomeEnte" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="UrlEnte" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MittenteType", propOrder = {
    "nomeEnte",
    "urlEnte"
})
public class MittenteType {

    @XmlElement(name = "NomeEnte", required = true)
    protected String nomeEnte;
    @XmlElement(name = "UrlEnte", required = true)
    protected String urlEnte;

    /**
     * Gets the value of the nomeEnte property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeEnte() {
        return nomeEnte;
    }

    /**
     * Sets the value of the nomeEnte property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeEnte(String value) {
        this.nomeEnte = value;
    }

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

}
