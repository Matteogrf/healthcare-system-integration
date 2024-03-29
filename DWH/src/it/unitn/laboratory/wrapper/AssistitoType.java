
package it.unitn.laboratory.wrapper;

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
 *         &lt;element name="ID_ANAGRAFE_LOCALE" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="MITTENTE_NOME_ENTE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MITTENTE_URL_ENTE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ANAG_URL_ENTE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ANAG_ID_ANAGRAFE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ID_ASS_SOC" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="HASH_COD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DATA_NASCITA" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="COMUNE_NASCITA_COD" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="COMUNE_NASCITA_DESCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMUNE_RESIDENZA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="COMUNE_RESIDENZA_COD" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="COMUNE_RESIDENZA_DESCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SESSO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CAP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="STATO_CIVILE_COD" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="STATO_CIVILE_DESCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NAZIONALITA_COD" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="NAZIONALITA_DESCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CITTADINANZA_COD" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="CITTADINANZA_DESCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="POLO_COD" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="POLO_DESCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GESTORE_COD" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="GESTORE_DESCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INIZIO_PRESA_CARICO" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DATA_DOMANDA" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
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
    "gestoredescr",
    "iniziopresacarico",
    "datadomanda"
})
public class AssistitoType {

    @XmlElement(name = "ID_ASSISTITO")
    protected Integer idassistito;
    @XmlElement(name = "ID_ANAGRAFE_LOCALE")
    protected Integer idanagrafelocale;
    @XmlElement(name = "MITTENTE_NOME_ENTE")
    protected String mittentenomeente;
    @XmlElement(name = "MITTENTE_URL_ENTE")
    protected String mittenteurlente;
    @XmlElement(name = "ANAG_URL_ENTE")
    protected String anagurlente;
    @XmlElement(name = "ANAG_ID_ANAGRAFE")
    protected String anagidanagrafe;
    @XmlElement(name = "ID_ASS_SOC")
    protected Integer idasssoc;
    @XmlElement(name = "HASH_COD")
    protected String hashcod;
    @XmlElement(name = "DATA_NASCITA")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datanascita;
    @XmlElement(name = "COMUNE_NASCITA_COD")
    protected Integer comunenascitacod;
    @XmlElement(name = "COMUNE_NASCITA_DESCR")
    protected String comunenascitadescr;
    @XmlElement(name = "COMUNE_RESIDENZA")
    protected String comuneresidenza;
    @XmlElement(name = "COMUNE_RESIDENZA_COD")
    protected Integer comuneresidenzacod;
    @XmlElement(name = "COMUNE_RESIDENZA_DESCR")
    protected String comuneresidenzadescr;
    @XmlElement(name = "SESSO")
    protected String sesso;
    @XmlElement(name = "CAP")
    protected String cap;
    @XmlElement(name = "STATO_CIVILE_COD")
    protected Integer statocivilecod;
    @XmlElement(name = "STATO_CIVILE_DESCR")
    protected String statociviledescr;
    @XmlElement(name = "NAZIONALITA_COD")
    protected Integer nazionalitacod;
    @XmlElement(name = "NAZIONALITA_DESCR")
    protected String nazionalitadescr;
    @XmlElement(name = "CITTADINANZA_COD")
    protected Integer cittadinanzacod;
    @XmlElement(name = "CITTADINANZA_DESCR")
    protected String cittadinanzadescr;
    @XmlElement(name = "POLO_COD")
    protected Integer polocod;
    @XmlElement(name = "POLO_DESCR")
    protected String polodescr;
    @XmlElement(name = "GESTORE_COD")
    protected Integer gestorecod;
    @XmlElement(name = "GESTORE_DESCR")
    protected String gestoredescr;
    @XmlElement(name = "INIZIO_PRESA_CARICO")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar iniziopresacarico;
    @XmlElement(name = "DATA_DOMANDA")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datadomanda;

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
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDANAGRAFELOCALE() {
        return idanagrafelocale;
    }

    /**
     * Sets the value of the idanagrafelocale property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDANAGRAFELOCALE(Integer value) {
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
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getANAGIDANAGRAFE() {
        return anagidanagrafe;
    }

    /**
     * Sets the value of the anagidanagrafe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setANAGIDANAGRAFE(String value) {
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
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCOMUNENASCITACOD() {
        return comunenascitacod;
    }

    /**
     * Sets the value of the comunenascitacod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCOMUNENASCITACOD(Integer value) {
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
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCOMUNERESIDENZACOD() {
        return comuneresidenzacod;
    }

    /**
     * Sets the value of the comuneresidenzacod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCOMUNERESIDENZACOD(Integer value) {
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
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSTATOCIVILECOD() {
        return statocivilecod;
    }

    /**
     * Sets the value of the statocivilecod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSTATOCIVILECOD(Integer value) {
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
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNAZIONALITACOD() {
        return nazionalitacod;
    }

    /**
     * Sets the value of the nazionalitacod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNAZIONALITACOD(Integer value) {
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
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCITTADINANZACOD() {
        return cittadinanzacod;
    }

    /**
     * Sets the value of the cittadinanzacod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCITTADINANZACOD(Integer value) {
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
     * Gets the value of the gestorecod property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGESTORECOD() {
        return gestorecod;
    }

    /**
     * Sets the value of the gestorecod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGESTORECOD(Integer value) {
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

    /**
     * Gets the value of the iniziopresacarico property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getINIZIOPRESACARICO() {
        return iniziopresacarico;
    }

    /**
     * Sets the value of the iniziopresacarico property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setINIZIOPRESACARICO(XMLGregorianCalendar value) {
        this.iniziopresacarico = value;
    }

    /**
     * Gets the value of the datadomanda property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDATADOMANDA() {
        return datadomanda;
    }

    /**
     * Sets the value of the datadomanda property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDATADOMANDA(XMLGregorianCalendar value) {
        this.datadomanda = value;
    }

}
