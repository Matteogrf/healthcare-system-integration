
package it.unitn.laboratory.events;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for FatturazionePeriodicaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FatturazionePeriodicaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CodiceCentro">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DenominazioneCentro">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="240"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DataInizio" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="DataFine" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="ImportoFattura">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Giornate" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AccessiServizio" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NumeroPasti" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NumeroTrasporti" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="GiorniAssenzaGiustificati" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="GiorniAssenzaNonGiustificati" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OreErogate" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DataFattura" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FatturazionePeriodicaType", propOrder = {
    "codiceCentro",
    "denominazioneCentro",
    "dataInizio",
    "dataFine",
    "importoFattura",
    "giornate",
    "accessiServizio",
    "numeroPasti",
    "numeroTrasporti",
    "giorniAssenzaGiustificati",
    "giorniAssenzaNonGiustificati",
    "oreErogate",
    "dataFattura"
})
public class FatturazionePeriodicaType {

    @XmlElement(name = "CodiceCentro")
    protected int codiceCentro;
    @XmlElement(name = "DenominazioneCentro", required = true)
    protected String denominazioneCentro;
    @XmlElement(name = "DataInizio", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dataInizio;
    @XmlElement(name = "DataFine", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dataFine;
    @XmlElement(name = "ImportoFattura")
    protected int importoFattura;
    @XmlElement(name = "Giornate")
    protected Integer giornate;
    @XmlElement(name = "AccessiServizio")
    protected Integer accessiServizio;
    @XmlElement(name = "NumeroPasti")
    protected Integer numeroPasti;
    @XmlElement(name = "NumeroTrasporti")
    protected Integer numeroTrasporti;
    @XmlElement(name = "GiorniAssenzaGiustificati")
    protected Integer giorniAssenzaGiustificati;
    @XmlElement(name = "GiorniAssenzaNonGiustificati")
    protected Integer giorniAssenzaNonGiustificati;
    @XmlElement(name = "OreErogate")
    protected Integer oreErogate;
    @XmlElement(name = "DataFattura", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dataFattura;

    /**
     * Gets the value of the codiceCentro property.
     * 
     */
    public int getCodiceCentro() {
        return codiceCentro;
    }

    /**
     * Sets the value of the codiceCentro property.
     * 
     */
    public void setCodiceCentro(int value) {
        this.codiceCentro = value;
    }

    /**
     * Gets the value of the denominazioneCentro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDenominazioneCentro() {
        return denominazioneCentro;
    }

    /**
     * Sets the value of the denominazioneCentro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDenominazioneCentro(String value) {
        this.denominazioneCentro = value;
    }

    /**
     * Gets the value of the dataInizio property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataInizio() {
        return dataInizio;
    }

    /**
     * Sets the value of the dataInizio property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataInizio(XMLGregorianCalendar value) {
        this.dataInizio = value;
    }

    /**
     * Gets the value of the dataFine property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataFine() {
        return dataFine;
    }

    /**
     * Sets the value of the dataFine property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataFine(XMLGregorianCalendar value) {
        this.dataFine = value;
    }

    /**
     * Gets the value of the importoFattura property.
     * 
     */
    public int getImportoFattura() {
        return importoFattura;
    }

    /**
     * Sets the value of the importoFattura property.
     * 
     */
    public void setImportoFattura(int value) {
        this.importoFattura = value;
    }

    /**
     * Gets the value of the giornate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGiornate() {
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
    public void setGiornate(Integer value) {
        this.giornate = value;
    }

    /**
     * Gets the value of the accessiServizio property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAccessiServizio() {
        return accessiServizio;
    }

    /**
     * Sets the value of the accessiServizio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAccessiServizio(Integer value) {
        this.accessiServizio = value;
    }

    /**
     * Gets the value of the numeroPasti property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroPasti() {
        return numeroPasti;
    }

    /**
     * Sets the value of the numeroPasti property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroPasti(Integer value) {
        this.numeroPasti = value;
    }

    /**
     * Gets the value of the numeroTrasporti property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroTrasporti() {
        return numeroTrasporti;
    }

    /**
     * Sets the value of the numeroTrasporti property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroTrasporti(Integer value) {
        this.numeroTrasporti = value;
    }

    /**
     * Gets the value of the giorniAssenzaGiustificati property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGiorniAssenzaGiustificati() {
        return giorniAssenzaGiustificati;
    }

    /**
     * Sets the value of the giorniAssenzaGiustificati property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGiorniAssenzaGiustificati(Integer value) {
        this.giorniAssenzaGiustificati = value;
    }

    /**
     * Gets the value of the giorniAssenzaNonGiustificati property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGiorniAssenzaNonGiustificati() {
        return giorniAssenzaNonGiustificati;
    }

    /**
     * Sets the value of the giorniAssenzaNonGiustificati property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGiorniAssenzaNonGiustificati(Integer value) {
        this.giorniAssenzaNonGiustificati = value;
    }

    /**
     * Gets the value of the oreErogate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOreErogate() {
        return oreErogate;
    }

    /**
     * Sets the value of the oreErogate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOreErogate(Integer value) {
        this.oreErogate = value;
    }

    /**
     * Gets the value of the dataFattura property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataFattura() {
        return dataFattura;
    }

    /**
     * Sets the value of the dataFattura property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataFattura(XMLGregorianCalendar value) {
        this.dataFattura = value;
    }

}
