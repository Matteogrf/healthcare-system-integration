
package it.unitn.laboratory.wrapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for AreaUtenzaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AreaUtenzaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AREA_UTENZA_COD" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="AREA_UTENZA_DESCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DATA_FINE_VAL" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DATA_INIZIO_VAL" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ID_ASSISITITO" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AreaUtenzaType", propOrder = {
    "areautenzacod",
    "areautenzadescr",
    "datafineval",
    "datainizioval",
    "idassisitito"
})
public class AreaUtenzaType {

    @XmlElement(name = "AREA_UTENZA_COD")
    protected Integer areautenzacod;
    @XmlElement(name = "AREA_UTENZA_DESCR")
    protected String areautenzadescr;
    @XmlElement(name = "DATA_FINE_VAL")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datafineval;
    @XmlElement(name = "DATA_INIZIO_VAL")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datainizioval;
    @XmlElement(name = "ID_ASSISITITO")
    protected Integer idassisitito;

    /**
     * Gets the value of the areautenzacod property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAREAUTENZACOD() {
        return areautenzacod;
    }

    /**
     * Sets the value of the areautenzacod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAREAUTENZACOD(Integer value) {
        this.areautenzacod = value;
    }

    /**
     * Gets the value of the areautenzadescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAREAUTENZADESCR() {
        return areautenzadescr;
    }

    /**
     * Sets the value of the areautenzadescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAREAUTENZADESCR(String value) {
        this.areautenzadescr = value;
    }

    /**
     * Gets the value of the datafineval property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDATAFINEVAL() {
        return datafineval;
    }

    /**
     * Sets the value of the datafineval property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDATAFINEVAL(XMLGregorianCalendar value) {
        this.datafineval = value;
    }

    /**
     * Gets the value of the datainizioval property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDATAINIZIOVAL() {
        return datainizioval;
    }

    /**
     * Sets the value of the datainizioval property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDATAINIZIOVAL(XMLGregorianCalendar value) {
        this.datainizioval = value;
    }

    /**
     * Gets the value of the idassisitito property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIDASSISITITO() {
        return idassisitito;
    }

    /**
     * Sets the value of the idassisitito property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIDASSISITITO(Integer value) {
        this.idassisitito = value;
    }

}
