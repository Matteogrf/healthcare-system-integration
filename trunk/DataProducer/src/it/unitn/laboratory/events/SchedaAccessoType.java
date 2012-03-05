
package it.unitn.laboratory.events;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SchedaAccessoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SchedaAccessoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NumeroScheda">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="38"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TipoServizioRichiestoCod" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="9"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TipoServizioRichiestoDescr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="250"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TipoRichiedenteCod">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="9"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TipoRichiedenteDescr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TipoTerziCod" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TipoTerziDescr" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="120"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NomeTerzi" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="60"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TipoSegnalanteCod" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TipoSegnalanteDescr" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
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
@XmlType(name = "SchedaAccessoType", propOrder = {
    "numeroScheda",
    "tipoServizioRichiestoCod",
    "tipoServizioRichiestoDescr",
    "tipoRichiedenteCod",
    "tipoRichiedenteDescr",
    "tipoTerziCod",
    "tipoTerziDescr",
    "nomeTerzi",
    "tipoSegnalanteCod",
    "tipoSegnalanteDescr"
})
public class SchedaAccessoType {

    @XmlElement(name = "NumeroScheda", required = true)
    protected String numeroScheda;
    @XmlElement(name = "TipoServizioRichiestoCod")
    protected String tipoServizioRichiestoCod;
    @XmlElement(name = "TipoServizioRichiestoDescr", required = true)
    protected String tipoServizioRichiestoDescr;
    @XmlElement(name = "TipoRichiedenteCod", required = true)
    protected String tipoRichiedenteCod;
    @XmlElement(name = "TipoRichiedenteDescr", required = true)
    protected String tipoRichiedenteDescr;
    @XmlElement(name = "TipoTerziCod")
    protected Integer tipoTerziCod;
    @XmlElement(name = "TipoTerziDescr")
    protected String tipoTerziDescr;
    @XmlElement(name = "NomeTerzi")
    protected String nomeTerzi;
    @XmlElement(name = "TipoSegnalanteCod")
    protected Integer tipoSegnalanteCod;
    @XmlElement(name = "TipoSegnalanteDescr")
    protected String tipoSegnalanteDescr;

    /**
     * Gets the value of the numeroScheda property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroScheda() {
        return numeroScheda;
    }

    /**
     * Sets the value of the numeroScheda property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroScheda(String value) {
        this.numeroScheda = value;
    }

    /**
     * Gets the value of the tipoServizioRichiestoCod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoServizioRichiestoCod() {
        return tipoServizioRichiestoCod;
    }

    /**
     * Sets the value of the tipoServizioRichiestoCod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoServizioRichiestoCod(String value) {
        this.tipoServizioRichiestoCod = value;
    }

    /**
     * Gets the value of the tipoServizioRichiestoDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoServizioRichiestoDescr() {
        return tipoServizioRichiestoDescr;
    }

    /**
     * Sets the value of the tipoServizioRichiestoDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoServizioRichiestoDescr(String value) {
        this.tipoServizioRichiestoDescr = value;
    }

    /**
     * Gets the value of the tipoRichiedenteCod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoRichiedenteCod() {
        return tipoRichiedenteCod;
    }

    /**
     * Sets the value of the tipoRichiedenteCod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoRichiedenteCod(String value) {
        this.tipoRichiedenteCod = value;
    }

    /**
     * Gets the value of the tipoRichiedenteDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoRichiedenteDescr() {
        return tipoRichiedenteDescr;
    }

    /**
     * Sets the value of the tipoRichiedenteDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoRichiedenteDescr(String value) {
        this.tipoRichiedenteDescr = value;
    }

    /**
     * Gets the value of the tipoTerziCod property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTipoTerziCod() {
        return tipoTerziCod;
    }

    /**
     * Sets the value of the tipoTerziCod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTipoTerziCod(Integer value) {
        this.tipoTerziCod = value;
    }

    /**
     * Gets the value of the tipoTerziDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoTerziDescr() {
        return tipoTerziDescr;
    }

    /**
     * Sets the value of the tipoTerziDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoTerziDescr(String value) {
        this.tipoTerziDescr = value;
    }

    /**
     * Gets the value of the nomeTerzi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeTerzi() {
        return nomeTerzi;
    }

    /**
     * Sets the value of the nomeTerzi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeTerzi(String value) {
        this.nomeTerzi = value;
    }

    /**
     * Gets the value of the tipoSegnalanteCod property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTipoSegnalanteCod() {
        return tipoSegnalanteCod;
    }

    /**
     * Sets the value of the tipoSegnalanteCod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTipoSegnalanteCod(Integer value) {
        this.tipoSegnalanteCod = value;
    }

    /**
     * Gets the value of the tipoSegnalanteDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoSegnalanteDescr() {
        return tipoSegnalanteDescr;
    }

    /**
     * Sets the value of the tipoSegnalanteDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoSegnalanteDescr(String value) {
        this.tipoSegnalanteDescr = value;
    }

}
