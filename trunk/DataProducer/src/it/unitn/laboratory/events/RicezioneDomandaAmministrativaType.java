
package it.unitn.laboratory.events;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for RicezioneDomandaAmministrativaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RicezioneDomandaAmministrativaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GiornateSettimanali" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NumeroPastiSettimanali" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NumeroTrasportiSettimanali" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OreSettimanali" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DataDomanda" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RicezioneDomandaAmministrativaType", propOrder = {
    "giornateSettimanali",
    "numeroPastiSettimanali",
    "numeroTrasportiSettimanali",
    "oreSettimanali",
    "dataDomanda"
})
public class RicezioneDomandaAmministrativaType {

    @XmlElement(name = "GiornateSettimanali")
    protected Integer giornateSettimanali;
    @XmlElement(name = "NumeroPastiSettimanali")
    protected Integer numeroPastiSettimanali;
    @XmlElement(name = "NumeroTrasportiSettimanali")
    protected Integer numeroTrasportiSettimanali;
    @XmlElement(name = "OreSettimanali")
    protected Integer oreSettimanali;
    @XmlElement(name = "DataDomanda", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dataDomanda;

    /**
     * Gets the value of the giornateSettimanali property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGiornateSettimanali() {
        return giornateSettimanali;
    }

    /**
     * Sets the value of the giornateSettimanali property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGiornateSettimanali(Integer value) {
        this.giornateSettimanali = value;
    }

    /**
     * Gets the value of the numeroPastiSettimanali property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroPastiSettimanali() {
        return numeroPastiSettimanali;
    }

    /**
     * Sets the value of the numeroPastiSettimanali property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroPastiSettimanali(Integer value) {
        this.numeroPastiSettimanali = value;
    }

    /**
     * Gets the value of the numeroTrasportiSettimanali property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroTrasportiSettimanali() {
        return numeroTrasportiSettimanali;
    }

    /**
     * Sets the value of the numeroTrasportiSettimanali property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroTrasportiSettimanali(Integer value) {
        this.numeroTrasportiSettimanali = value;
    }

    /**
     * Gets the value of the oreSettimanali property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOreSettimanali() {
        return oreSettimanali;
    }

    /**
     * Sets the value of the oreSettimanali property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOreSettimanali(Integer value) {
        this.oreSettimanali = value;
    }

    /**
     * Gets the value of the dataDomanda property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataDomanda() {
        return dataDomanda;
    }

    /**
     * Sets the value of the dataDomanda property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataDomanda(XMLGregorianCalendar value) {
        this.dataDomanda = value;
    }

}
