
package it.unitn.laboratory.wrapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NucleoFamiliareType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NucleoFamiliareType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CODICE_NUCLEO" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="COMPONENTE" type="{http://events.laboratory.unitn.it}ComponenteType"/>
 *         &lt;element name="HASH_COD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COGNOME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POLO_COD" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="POLO_DESCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ENTE_GESTORE_COD" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ENTE_GESTORE_DESCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NucleoFamiliareType", propOrder = {
    "codicenucleo",
    "componente",
    "hashcod",
    "cognome",
    "polocod",
    "polodescr",
    "entegestorecod",
    "entegestoredescr"
})
public class NucleoFamiliareType {

    @XmlElement(name = "CODICE_NUCLEO")
    protected int codicenucleo;
    @XmlElement(name = "COMPONENTE", required = true)
    protected ComponenteType componente;
    @XmlElement(name = "HASH_COD")
    protected String hashcod;
    @XmlElement(name = "COGNOME")
    protected String cognome;
    @XmlElement(name = "POLO_COD")
    protected Integer polocod;
    @XmlElement(name = "POLO_DESCR")
    protected String polodescr;
    @XmlElement(name = "ENTE_GESTORE_COD")
    protected Integer entegestorecod;
    @XmlElement(name = "ENTE_GESTORE_DESCR")
    protected String entegestoredescr;

    /**
     * Gets the value of the codicenucleo property.
     * 
     */
    public int getCODICENUCLEO() {
        return codicenucleo;
    }

    /**
     * Sets the value of the codicenucleo property.
     * 
     */
    public void setCODICENUCLEO(int value) {
        this.codicenucleo = value;
    }

    /**
     * Gets the value of the componente property.
     * 
     * @return
     *     possible object is
     *     {@link ComponenteType }
     *     
     */
    public ComponenteType getCOMPONENTE() {
        return componente;
    }

    /**
     * Sets the value of the componente property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComponenteType }
     *     
     */
    public void setCOMPONENTE(ComponenteType value) {
        this.componente = value;
    }

    /**
     * Gets the value of the hashcod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHASHCOD() {
        return hashcod;
    }

    /**
     * Sets the value of the hashcod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHASHCOD(String value) {
        this.hashcod = value;
    }

    /**
     * Gets the value of the cognome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOGNOME() {
        return cognome;
    }

    /**
     * Sets the value of the cognome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOGNOME(String value) {
        this.cognome = value;
    }

    /**
     * Gets the value of the polocod property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPOLOCOD() {
        return polocod;
    }

    /**
     * Sets the value of the polocod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPOLOCOD(Integer value) {
        this.polocod = value;
    }

    /**
     * Gets the value of the polodescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOLODESCR() {
        return polodescr;
    }

    /**
     * Sets the value of the polodescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOLODESCR(String value) {
        this.polodescr = value;
    }

    /**
     * Gets the value of the entegestorecod property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getENTEGESTORECOD() {
        return entegestorecod;
    }

    /**
     * Sets the value of the entegestorecod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setENTEGESTORECOD(Integer value) {
        this.entegestorecod = value;
    }

    /**
     * Gets the value of the entegestoredescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getENTEGESTOREDESCR() {
        return entegestoredescr;
    }

    /**
     * Sets the value of the entegestoredescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setENTEGESTOREDESCR(String value) {
        this.entegestoredescr = value;
    }

}
