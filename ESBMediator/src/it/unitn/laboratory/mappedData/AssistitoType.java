//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.07 at 08:36:04 AM CET 
//


package it.unitn.laboratory.mappedData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for AssistitoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssistitoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_ASSISTITO" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ID_ANAGRAFE_LOCALE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MITTENTE_NOME_ENTE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MITTENTE_URL_ENTE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ANAG_URL_ENTE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ANAG_ID_ANAGRAFE" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ID_ASS_SOC" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="HASH_COD" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DATA_NASCITA" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="COMUNE_NASCITA_COD" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="COMUNE_NASCITA_DESCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMUNE_RESIDENZA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMUNE_RESIDENZA_COD" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="COMUNE_RESIDENZA_DESCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SESSO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CAP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="STATO_CIVILE_COD" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="STATO_CIVILE_DESCR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NAZIONALITA_COD" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="NAZIONALITA_DESCR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CITTADINANZA_COD" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="CITTADINANZA_DESCR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="POLO_COD" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="POLO_DESCR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="GESTORE_COD" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="GESTORE_DESCR" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssistitoType", propOrder = {
    "idassistito",
    "idanagrafelocale",
    "mittentenomeente",
    "mittenteurlente",
    "anagurlente",
    "anagidanagrafe",
    "idasssoc",
    "hashcod",
    "datanascita",
    "comunenascitacod",
    "comunenascitadescr",
    "comuneresidenza",
    "comuneresidenzacod",
    "comuneresidenzadescr",
    "sesso",
    "cap",
    "statocivilecod",
    "statociviledescr",
    "nazionalitacod",
    "nazionalitadescr",
    "cittadinanzacod",
    "cittadinanzadescr",
    "polocod",
    "polodescr",
    "gestorecod",
    "gestoredescr"
})
public class AssistitoType {

    @XmlElement(name = "ID_ASSISTITO")
    protected Integer idassistito;
    @XmlElement(name = "ID_ANAGRAFE_LOCALE")
    protected int idanagrafelocale;
    @XmlElement(name = "MITTENTE_NOME_ENTE", required = true)
    protected String mittentenomeente;
    @XmlElement(name = "MITTENTE_URL_ENTE", required = true)
    protected String mittenteurlente;
    @XmlElement(name = "ANAG_URL_ENTE", required = true)
    protected String anagurlente;
    @XmlElement(name = "ANAG_ID_ANAGRAFE")
    protected int anagidanagrafe;
    @XmlElement(name = "ID_ASS_SOC")
    protected Integer idasssoc;
    @XmlElement(name = "HASH_COD", required = true)
    protected String hashcod;
    @XmlElement(name = "DATA_NASCITA", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datanascita;
    @XmlElement(name = "COMUNE_NASCITA_COD")
    protected int comunenascitacod;
    @XmlElement(name = "COMUNE_NASCITA_DESCR")
    protected String comunenascitadescr;
    @XmlElement(name = "COMUNE_RESIDENZA")
    protected String comuneresidenza;
    @XmlElement(name = "COMUNE_RESIDENZA_COD")
    protected int comuneresidenzacod;
    @XmlElement(name = "COMUNE_RESIDENZA_DESCR")
    protected String comuneresidenzadescr;
    @XmlElement(name = "SESSO", required = true)
    protected String sesso;
    @XmlElement(name = "CAP", required = true)
    protected String cap;
    @XmlElement(name = "STATO_CIVILE_COD")
    protected int statocivilecod;
    @XmlElement(name = "STATO_CIVILE_DESCR", required = true)
    protected String statociviledescr;
    @XmlElement(name = "NAZIONALITA_COD")
    protected int nazionalitacod;
    @XmlElement(name = "NAZIONALITA_DESCR", required = true)
    protected String nazionalitadescr;
    @XmlElement(name = "CITTADINANZA_COD")
    protected int cittadinanzacod;
    @XmlElement(name = "CITTADINANZA_DESCR", required = true)
    protected String cittadinanzadescr;
    @XmlElement(name = "POLO_COD")
    protected int polocod;
    @XmlElement(name = "POLO_DESCR", required = true)
    protected String polodescr;
    @XmlElement(name = "GESTORE_COD")
    protected int gestorecod;
    @XmlElement(name = "GESTORE_DESCR", required = true)
    protected String gestoredescr;

    /**
     * Gets the value of the idassistito property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDASSISTITO() {
        return idassistito;
    }

    /**
     * Sets the value of the idassistito property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDASSISTITO(Integer value) {
        this.idassistito = value;
    }

    /**
     * Gets the value of the idanagrafelocale property.
     * 
     */
    public int getIDANAGRAFELOCALE() {
        return idanagrafelocale;
    }

    /**
     * Sets the value of the idanagrafelocale property.
     * 
     */
    public void setIDANAGRAFELOCALE(int value) {
        this.idanagrafelocale = value;
    }

    /**
     * Gets the value of the mittentenomeente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMITTENTENOMEENTE() {
        return mittentenomeente;
    }

    /**
     * Sets the value of the mittentenomeente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMITTENTENOMEENTE(String value) {
        this.mittentenomeente = value;
    }

    /**
     * Gets the value of the mittenteurlente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMITTENTEURLENTE() {
        return mittenteurlente;
    }

    /**
     * Sets the value of the mittenteurlente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMITTENTEURLENTE(String value) {
        this.mittenteurlente = value;
    }

    /**
     * Gets the value of the anagurlente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getANAGURLENTE() {
        return anagurlente;
    }

    /**
     * Sets the value of the anagurlente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setANAGURLENTE(String value) {
        this.anagurlente = value;
    }

    /**
     * Gets the value of the anagidanagrafe property.
     * 
     */
    public int getANAGIDANAGRAFE() {
        return anagidanagrafe;
    }

    /**
     * Sets the value of the anagidanagrafe property.
     * 
     */
    public void setANAGIDANAGRAFE(int value) {
        this.anagidanagrafe = value;
    }

    /**
     * Gets the value of the idasssoc property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDASSSOC() {
        return idasssoc;
    }

    /**
     * Sets the value of the idasssoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDASSSOC(Integer value) {
        this.idasssoc = value;
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
     * Gets the value of the datanascita property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDATANASCITA() {
        return datanascita;
    }

    /**
     * Sets the value of the datanascita property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDATANASCITA(XMLGregorianCalendar value) {
        this.datanascita = value;
    }

    /**
     * Gets the value of the comunenascitacod property.
     * 
     */
    public int getCOMUNENASCITACOD() {
        return comunenascitacod;
    }

    /**
     * Sets the value of the comunenascitacod property.
     * 
     */
    public void setCOMUNENASCITACOD(int value) {
        this.comunenascitacod = value;
    }

    /**
     * Gets the value of the comunenascitadescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMUNENASCITADESCR() {
        return comunenascitadescr;
    }

    /**
     * Sets the value of the comunenascitadescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMUNENASCITADESCR(String value) {
        this.comunenascitadescr = value;
    }

    /**
     * Gets the value of the comuneresidenza property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMUNERESIDENZA() {
        return comuneresidenza;
    }

    /**
     * Sets the value of the comuneresidenza property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMUNERESIDENZA(String value) {
        this.comuneresidenza = value;
    }

    /**
     * Gets the value of the comuneresidenzacod property.
     * 
     */
    public int getCOMUNERESIDENZACOD() {
        return comuneresidenzacod;
    }

    /**
     * Sets the value of the comuneresidenzacod property.
     * 
     */
    public void setCOMUNERESIDENZACOD(int value) {
        this.comuneresidenzacod = value;
    }

    /**
     * Gets the value of the comuneresidenzadescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMUNERESIDENZADESCR() {
        return comuneresidenzadescr;
    }

    /**
     * Sets the value of the comuneresidenzadescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCOMUNERESIDENZADESCR(String value) {
        this.comuneresidenzadescr = value;
    }

    /**
     * Gets the value of the sesso property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSESSO() {
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
    public void setSESSO(String value) {
        this.sesso = value;
    }

    /**
     * Gets the value of the cap property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCAP() {
        return cap;
    }

    /**
     * Sets the value of the cap property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCAP(String value) {
        this.cap = value;
    }

    /**
     * Gets the value of the statocivilecod property.
     * 
     */
    public int getSTATOCIVILECOD() {
        return statocivilecod;
    }

    /**
     * Sets the value of the statocivilecod property.
     * 
     */
    public void setSTATOCIVILECOD(int value) {
        this.statocivilecod = value;
    }

    /**
     * Gets the value of the statociviledescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSTATOCIVILEDESCR() {
        return statociviledescr;
    }

    /**
     * Sets the value of the statociviledescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSTATOCIVILEDESCR(String value) {
        this.statociviledescr = value;
    }

    /**
     * Gets the value of the nazionalitacod property.
     * 
     */
    public int getNAZIONALITACOD() {
        return nazionalitacod;
    }

    /**
     * Sets the value of the nazionalitacod property.
     * 
     */
    public void setNAZIONALITACOD(int value) {
        this.nazionalitacod = value;
    }

    /**
     * Gets the value of the nazionalitadescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNAZIONALITADESCR() {
        return nazionalitadescr;
    }

    /**
     * Sets the value of the nazionalitadescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNAZIONALITADESCR(String value) {
        this.nazionalitadescr = value;
    }

    /**
     * Gets the value of the cittadinanzacod property.
     * 
     */
    public int getCITTADINANZACOD() {
        return cittadinanzacod;
    }

    /**
     * Sets the value of the cittadinanzacod property.
     * 
     */
    public void setCITTADINANZACOD(int value) {
        this.cittadinanzacod = value;
    }

    /**
     * Gets the value of the cittadinanzadescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCITTADINANZADESCR() {
        return cittadinanzadescr;
    }

    /**
     * Sets the value of the cittadinanzadescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCITTADINANZADESCR(String value) {
        this.cittadinanzadescr = value;
    }

    /**
     * Gets the value of the polocod property.
     * 
     */
    public int getPOLOCOD() {
        return polocod;
    }

    /**
     * Sets the value of the polocod property.
     * 
     */
    public void setPOLOCOD(int value) {
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
     * Gets the value of the gestorecod property.
     * 
     */
    public int getGESTORECOD() {
        return gestorecod;
    }

    /**
     * Sets the value of the gestorecod property.
     * 
     */
    public void setGESTORECOD(int value) {
        this.gestorecod = value;
    }

    /**
     * Gets the value of the gestoredescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGESTOREDESCR() {
        return gestoredescr;
    }

    /**
     * Sets the value of the gestoredescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGESTOREDESCR(String value) {
        this.gestoredescr = value;
    }

}