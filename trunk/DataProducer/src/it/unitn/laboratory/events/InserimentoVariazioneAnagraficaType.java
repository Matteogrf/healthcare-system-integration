
package it.unitn.laboratory.events;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InserimentoVariazioneAnagraficaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InserimentoVariazioneAnagraficaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ComuneNascitaDescr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Sesso">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="StatoCivileCod">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="StatoCivileDescr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NazionalitaCod">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NazionalitacDescr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ComuneResidenzaDescr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Via">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CAP">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CittadinanzaCod">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CittadinanzaDescr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="25"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AssSocialeCod" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AssSocialeCognome" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AssSocialeNome" minOccurs="0">
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
@XmlType(name = "InserimentoVariazioneAnagraficaType", propOrder = {
    "comuneNascitaDescr",
    "sesso",
    "statoCivileCod",
    "statoCivileDescr",
    "nazionalitaCod",
    "nazionalitacDescr",
    "comuneResidenzaDescr",
    "via",
    "cap",
    "cittadinanzaCod",
    "cittadinanzaDescr",
    "assSocialeCod",
    "assSocialeCognome",
    "assSocialeNome"
})
public class InserimentoVariazioneAnagraficaType {

    @XmlElement(name = "ComuneNascitaDescr", required = true)
    protected String comuneNascitaDescr;
    @XmlElement(name = "Sesso", required = true)
    protected String sesso;
    @XmlElement(name = "StatoCivileCod")
    protected int statoCivileCod;
    @XmlElement(name = "StatoCivileDescr", required = true)
    protected String statoCivileDescr;
    @XmlElement(name = "NazionalitaCod")
    protected int nazionalitaCod;
    @XmlElement(name = "NazionalitacDescr", required = true)
    protected String nazionalitacDescr;
    @XmlElement(name = "ComuneResidenzaDescr", required = true)
    protected String comuneResidenzaDescr;
    @XmlElement(name = "Via", required = true)
    protected String via;
    @XmlElement(name = "CAP")
    protected int cap;
    @XmlElement(name = "CittadinanzaCod")
    protected int cittadinanzaCod;
    @XmlElement(name = "CittadinanzaDescr", required = true)
    protected String cittadinanzaDescr;
    @XmlElement(name = "AssSocialeCod")
    protected Integer assSocialeCod;
    @XmlElement(name = "AssSocialeCognome")
    protected String assSocialeCognome;
    @XmlElement(name = "AssSocialeNome")
    protected String assSocialeNome;

    /**
     * Gets the value of the comuneNascitaDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComuneNascitaDescr() {
        return comuneNascitaDescr;
    }

    /**
     * Sets the value of the comuneNascitaDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComuneNascitaDescr(String value) {
        this.comuneNascitaDescr = value;
    }

    /**
     * Gets the value of the sesso property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSesso() {
        return sesso;
    }

    /**
     * Sets the value of the sesso property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSesso(String value) {
        this.sesso = value;
    }

    /**
     * Gets the value of the statoCivileCod property.
     * 
     */
    public int getStatoCivileCod() {
        return statoCivileCod;
    }

    /**
     * Sets the value of the statoCivileCod property.
     * 
     */
    public void setStatoCivileCod(int value) {
        this.statoCivileCod = value;
    }

    /**
     * Gets the value of the statoCivileDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatoCivileDescr() {
        return statoCivileDescr;
    }

    /**
     * Sets the value of the statoCivileDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatoCivileDescr(String value) {
        this.statoCivileDescr = value;
    }

    /**
     * Gets the value of the nazionalitaCod property.
     * 
     */
    public int getNazionalitaCod() {
        return nazionalitaCod;
    }

    /**
     * Sets the value of the nazionalitaCod property.
     * 
     */
    public void setNazionalitaCod(int value) {
        this.nazionalitaCod = value;
    }

    /**
     * Gets the value of the nazionalitacDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazionalitacDescr() {
        return nazionalitacDescr;
    }

    /**
     * Sets the value of the nazionalitacDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazionalitacDescr(String value) {
        this.nazionalitacDescr = value;
    }

    /**
     * Gets the value of the comuneResidenzaDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComuneResidenzaDescr() {
        return comuneResidenzaDescr;
    }

    /**
     * Sets the value of the comuneResidenzaDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComuneResidenzaDescr(String value) {
        this.comuneResidenzaDescr = value;
    }

    /**
     * Gets the value of the via property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVia() {
        return via;
    }

    /**
     * Sets the value of the via property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVia(String value) {
        this.via = value;
    }

    /**
     * Gets the value of the cap property.
     * 
     */
    public int getCAP() {
        return cap;
    }

    /**
     * Sets the value of the cap property.
     * 
     */
    public void setCAP(int value) {
        this.cap = value;
    }

    /**
     * Gets the value of the cittadinanzaCod property.
     * 
     */
    public int getCittadinanzaCod() {
        return cittadinanzaCod;
    }

    /**
     * Sets the value of the cittadinanzaCod property.
     * 
     */
    public void setCittadinanzaCod(int value) {
        this.cittadinanzaCod = value;
    }

    /**
     * Gets the value of the cittadinanzaDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCittadinanzaDescr() {
        return cittadinanzaDescr;
    }

    /**
     * Sets the value of the cittadinanzaDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCittadinanzaDescr(String value) {
        this.cittadinanzaDescr = value;
    }

    /**
     * Gets the value of the assSocialeCod property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAssSocialeCod() {
        return assSocialeCod;
    }

    /**
     * Sets the value of the assSocialeCod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAssSocialeCod(Integer value) {
        this.assSocialeCod = value;
    }

    /**
     * Gets the value of the assSocialeCognome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssSocialeCognome() {
        return assSocialeCognome;
    }

    /**
     * Sets the value of the assSocialeCognome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssSocialeCognome(String value) {
        this.assSocialeCognome = value;
    }

    /**
     * Gets the value of the assSocialeNome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssSocialeNome() {
        return assSocialeNome;
    }

    /**
     * Sets the value of the assSocialeNome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssSocialeNome(String value) {
        this.assSocialeNome = value;
    }

}
