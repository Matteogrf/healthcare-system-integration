
package it.unitn.laboratory.wrapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoTerziType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoTerziType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TIPO_TERZI_COD" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="TIPO_TERZI_DERCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NOME_TERZI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoTerziType", propOrder = {
    "tipoterzicod",
    "tipoterzidercr",
    "nometerzi"
})
public class TipoTerziType {

    @XmlElement(name = "TIPO_TERZI_COD")
    protected Integer tipoterzicod;
    @XmlElement(name = "TIPO_TERZI_DERCR")
    protected String tipoterzidercr;
    @XmlElement(name = "NOME_TERZI")
    protected String nometerzi;

    /**
     * Gets the value of the tipoterzicod property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTIPOTERZICOD() {
        return tipoterzicod;
    }

    /**
     * Sets the value of the tipoterzicod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTIPOTERZICOD(Integer value) {
        this.tipoterzicod = value;
    }

    /**
     * Gets the value of the tipoterzidercr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTIPOTERZIDERCR() {
        return tipoterzidercr;
    }

    /**
     * Sets the value of the tipoterzidercr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTIPOTERZIDERCR(String value) {
        this.tipoterzidercr = value;
    }

    /**
     * Gets the value of the nometerzi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNOMETERZI() {
        return nometerzi;
    }

    /**
     * Sets the value of the nometerzi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNOMETERZI(String value) {
        this.nometerzi = value;
    }

}
