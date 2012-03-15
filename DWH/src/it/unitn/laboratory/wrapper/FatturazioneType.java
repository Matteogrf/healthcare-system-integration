
package it.unitn.laboratory.wrapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for FatturazioneType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FatturazioneType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ID_FATTURAZIONE" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ID_ASSISTITO" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ID_ENTE_EROGATORE" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DATA_INIZIO" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DATA_FINE" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="IMPORTO_FATTURA" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="GIORNATE" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ACCESSO_SERVIZIO" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="NUMERO_PASTI" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="NUMERO_TRASPORTI" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="GIORNI_ASSENZA_GIUSTIFICATI" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="GIORNI_ASSENZA_NON_GIUSTIFICATI" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ORE_EROGATE" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DATA_FATTURA" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FatturazioneType", propOrder = {
    "idfatturazione",
    "idassistito",
    "identeerogatore",
    "datainizio",
    "datafine",
    "importofattura",
    "giornate",
    "accessoservizio",
    "numeropasti",
    "numerotrasporti",
    "giorniassenzagiustificati",
    "giorniassenzanongiustificati",
    "oreerogate",
    "datafattura"
})
public class FatturazioneType {

    @XmlElement(name = "ID_FATTURAZIONE")
    protected Integer idfatturazione;
    @XmlElement(name = "ID_ASSISTITO")
    protected Integer idassistito;
    @XmlElement(name = "ID_ENTE_EROGATORE")
    protected Integer identeerogatore;
    @XmlElement(name = "DATA_INIZIO")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datainizio;
    @XmlElement(name = "DATA_FINE")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datafine;
    @XmlElement(name = "IMPORTO_FATTURA")
    protected Integer importofattura;
    @XmlElement(name = "GIORNATE")
    protected Integer giornate;
    @XmlElement(name = "ACCESSO_SERVIZIO")
    protected Integer accessoservizio;
    @XmlElement(name = "NUMERO_PASTI")
    protected Integer numeropasti;
    @XmlElement(name = "NUMERO_TRASPORTI")
    protected Integer numerotrasporti;
    @XmlElement(name = "GIORNI_ASSENZA_GIUSTIFICATI")
    protected Integer giorniassenzagiustificati;
    @XmlElement(name = "GIORNI_ASSENZA_NON_GIUSTIFICATI")
    protected Integer giorniassenzanongiustificati;
    @XmlElement(name = "ORE_EROGATE")
    protected Integer oreerogate;
    @XmlElement(name = "DATA_FATTURA")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datafattura;

    /**
     * Gets the value of the idfatturazione property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDFATTURAZIONE() {
        return idfatturazione;
    }

    /**
     * Sets the value of the idfatturazione property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDFATTURAZIONE(Integer value) {
        this.idfatturazione = value;
    }

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
     * Gets the value of the identeerogatore property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDENTEEROGATORE() {
        return identeerogatore;
    }

    /**
     * Sets the value of the identeerogatore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDENTEEROGATORE(Integer value) {
        this.identeerogatore = value;
    }

    /**
     * Gets the value of the datainizio property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDATAINIZIO() {
        return datainizio;
    }

    /**
     * Sets the value of the datainizio property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDATAINIZIO(XMLGregorianCalendar value) {
        this.datainizio = value;
    }

    /**
     * Gets the value of the datafine property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDATAFINE() {
        return datafine;
    }

    /**
     * Sets the value of the datafine property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDATAFINE(XMLGregorianCalendar value) {
        this.datafine = value;
    }

    /**
     * Gets the value of the importofattura property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIMPORTOFATTURA() {
        return importofattura;
    }

    /**
     * Sets the value of the importofattura property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIMPORTOFATTURA(Integer value) {
        this.importofattura = value;
    }

    /**
     * Gets the value of the giornate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGIORNATE() {
        return giornate;
    }

    /**
     * Sets the value of the giornate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGIORNATE(Integer value) {
        this.giornate = value;
    }

    /**
     * Gets the value of the accessoservizio property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getACCESSOSERVIZIO() {
        return accessoservizio;
    }

    /**
     * Sets the value of the accessoservizio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setACCESSOSERVIZIO(Integer value) {
        this.accessoservizio = value;
    }

    /**
     * Gets the value of the numeropasti property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNUMEROPASTI() {
        return numeropasti;
    }

    /**
     * Sets the value of the numeropasti property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNUMEROPASTI(Integer value) {
        this.numeropasti = value;
    }

    /**
     * Gets the value of the numerotrasporti property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNUMEROTRASPORTI() {
        return numerotrasporti;
    }

    /**
     * Sets the value of the numerotrasporti property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNUMEROTRASPORTI(Integer value) {
        this.numerotrasporti = value;
    }

    /**
     * Gets the value of the giorniassenzagiustificati property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGIORNIASSENZAGIUSTIFICATI() {
        return giorniassenzagiustificati;
    }

    /**
     * Sets the value of the giorniassenzagiustificati property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGIORNIASSENZAGIUSTIFICATI(Integer value) {
        this.giorniassenzagiustificati = value;
    }

    /**
     * Gets the value of the giorniassenzanongiustificati property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGIORNIASSENZANONGIUSTIFICATI() {
        return giorniassenzanongiustificati;
    }

    /**
     * Sets the value of the giorniassenzanongiustificati property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGIORNIASSENZANONGIUSTIFICATI(Integer value) {
        this.giorniassenzanongiustificati = value;
    }

    /**
     * Gets the value of the oreerogate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOREEROGATE() {
        return oreerogate;
    }

    /**
     * Sets the value of the oreerogate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOREEROGATE(Integer value) {
        this.oreerogate = value;
    }

    /**
     * Gets the value of the datafattura property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDATAFATTURA() {
        return datafattura;
    }

    /**
     * Sets the value of the datafattura property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDATAFATTURA(XMLGregorianCalendar value) {
        this.datafattura = value;
    }

}
