
package it.unitn.laboratory.wrapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CartellaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CartellaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NUMERO_SCHEDA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PRESA_CARICO" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="DATA_ACCESSO" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ID_ASSISTITO" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ID_SEGNALANTE" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ID_TIPO_TERZI" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ID_RICHIEDENTE" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ID_OPERATORE" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="INIZIO_PRESA_CARICO" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="FINE_PRESA_CARICO" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="GIORNATE_SETTIMANALI" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="NUMERO_PASTI_SETTIMANALI" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="NUMERO_TRASPORTI_SETTIMANALI" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ORE_SETTIMANALI" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
@XmlType(name = "CartellaType", propOrder = {
    "numeroscheda",
    "presacarico",
    "dataaccesso",
    "idassistito",
    "idsegnalante",
    "idtipoterzi",
    "idrichiedente",
    "idoperatore",
    "iniziopresacarico",
    "finepresacarico",
    "giornatesettimanali",
    "numeropastisettimanali",
    "numerotrasportisettimanali",
    "oresettimanali",
    "datadomanda"
})
public class CartellaType {

    @XmlElement(name = "NUMERO_SCHEDA")
    protected String numeroscheda;
    @XmlElement(name = "PRESA_CARICO")
    protected Integer presacarico;
    @XmlElement(name = "DATA_ACCESSO")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dataaccesso;
    @XmlElement(name = "ID_ASSISTITO")
    protected Integer idassistito;
    @XmlElement(name = "ID_SEGNALANTE")
    protected Integer idsegnalante;
    @XmlElement(name = "ID_TIPO_TERZI")
    protected Integer idtipoterzi;
    @XmlElement(name = "ID_RICHIEDENTE")
    protected Integer idrichiedente;
    @XmlElement(name = "ID_OPERATORE")
    protected Integer idoperatore;
    @XmlElement(name = "INIZIO_PRESA_CARICO")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar iniziopresacarico;
    @XmlElement(name = "FINE_PRESA_CARICO")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar finepresacarico;
    @XmlElement(name = "GIORNATE_SETTIMANALI")
    protected Integer giornatesettimanali;
    @XmlElement(name = "NUMERO_PASTI_SETTIMANALI")
    protected Integer numeropastisettimanali;
    @XmlElement(name = "NUMERO_TRASPORTI_SETTIMANALI")
    protected Integer numerotrasportisettimanali;
    @XmlElement(name = "ORE_SETTIMANALI")
    protected Integer oresettimanali;
    @XmlElement(name = "DATA_DOMANDA")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datadomanda;

    /**
     * Gets the value of the numeroscheda property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNUMEROSCHEDA() {
        return numeroscheda;
    }

    /**
     * Sets the value of the numeroscheda property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNUMEROSCHEDA(String value) {
        this.numeroscheda = value;
    }

    /**
     * Gets the value of the presacarico property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPRESACARICO() {
        return presacarico;
    }

    /**
     * Sets the value of the presacarico property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPRESACARICO(Integer value) {
        this.presacarico = value;
    }

    /**
     * Gets the value of the dataaccesso property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDATAACCESSO() {
        return dataaccesso;
    }

    /**
     * Sets the value of the dataaccesso property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDATAACCESSO(XMLGregorianCalendar value) {
        this.dataaccesso = value;
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
     * Gets the value of the idsegnalante property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDSEGNALANTE() {
        return idsegnalante;
    }

    /**
     * Sets the value of the idsegnalante property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDSEGNALANTE(Integer value) {
        this.idsegnalante = value;
    }

    /**
     * Gets the value of the idtipoterzi property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDTIPOTERZI() {
        return idtipoterzi;
    }

    /**
     * Sets the value of the idtipoterzi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDTIPOTERZI(Integer value) {
        this.idtipoterzi = value;
    }

    /**
     * Gets the value of the idrichiedente property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDRICHIEDENTE() {
        return idrichiedente;
    }

    /**
     * Sets the value of the idrichiedente property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDRICHIEDENTE(Integer value) {
        this.idrichiedente = value;
    }

    /**
     * Gets the value of the idoperatore property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDOPERATORE() {
        return idoperatore;
    }

    /**
     * Sets the value of the idoperatore property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDOPERATORE(Integer value) {
        this.idoperatore = value;
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
     * Gets the value of the finepresacarico property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFINEPRESACARICO() {
        return finepresacarico;
    }

    /**
     * Sets the value of the finepresacarico property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFINEPRESACARICO(XMLGregorianCalendar value) {
        this.finepresacarico = value;
    }

    /**
     * Gets the value of the giornatesettimanali property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGIORNATESETTIMANALI() {
        return giornatesettimanali;
    }

    /**
     * Sets the value of the giornatesettimanali property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGIORNATESETTIMANALI(Integer value) {
        this.giornatesettimanali = value;
    }

    /**
     * Gets the value of the numeropastisettimanali property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNUMEROPASTISETTIMANALI() {
        return numeropastisettimanali;
    }

    /**
     * Sets the value of the numeropastisettimanali property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNUMEROPASTISETTIMANALI(Integer value) {
        this.numeropastisettimanali = value;
    }

    /**
     * Gets the value of the numerotrasportisettimanali property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNUMEROTRASPORTISETTIMANALI() {
        return numerotrasportisettimanali;
    }

    /**
     * Sets the value of the numerotrasportisettimanali property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNUMEROTRASPORTISETTIMANALI(Integer value) {
        this.numerotrasportisettimanali = value;
    }

    /**
     * Gets the value of the oresettimanali property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getORESETTIMANALI() {
        return oresettimanali;
    }

    /**
     * Sets the value of the oresettimanali property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setORESETTIMANALI(Integer value) {
        this.oresettimanali = value;
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
