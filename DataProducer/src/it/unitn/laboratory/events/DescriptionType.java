
package it.unitn.laboratory.events;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DescriptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DescriptionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DataOraRegEvento" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="TipoEventoCod">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TipoEventoDescr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="250"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IdInterventoPratica" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ServizioCod">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="12"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ServizioDescr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="250"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DataOraEvento" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="ProduttoreCod">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ProduttoreDescr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="250"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="UnitaOrganizzativaCod">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="UnitaOrganizzativaDescr">
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
@XmlType(name = "DescriptionType", propOrder = {
    "dataOraRegEvento",
    "tipoEventoCod",
    "tipoEventoDescr",
    "idInterventoPratica",
    "servizioCod",
    "servizioDescr",
    "dataOraEvento",
    "produttoreCod",
    "produttoreDescr",
    "unitaOrganizzativaCod",
    "unitaOrganizzativaDescr"
})
public class DescriptionType {

    @XmlElement(name = "DataOraRegEvento", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataOraRegEvento;
    @XmlElement(name = "TipoEventoCod")
    protected int tipoEventoCod;
    @XmlElement(name = "TipoEventoDescr", required = true)
    protected String tipoEventoDescr;
    @XmlElement(name = "IdInterventoPratica")
    protected Integer idInterventoPratica;
    @XmlElement(name = "ServizioCod")
    protected int servizioCod;
    @XmlElement(name = "ServizioDescr", required = true)
    protected String servizioDescr;
    @XmlElement(name = "DataOraEvento", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataOraEvento;
    @XmlElement(name = "ProduttoreCod")
    protected int produttoreCod;
    @XmlElement(name = "ProduttoreDescr", required = true)
    protected String produttoreDescr;
    @XmlElement(name = "UnitaOrganizzativaCod")
    protected int unitaOrganizzativaCod;
    @XmlElement(name = "UnitaOrganizzativaDescr", required = true)
    protected String unitaOrganizzativaDescr;

    /**
     * Gets the value of the dataOraRegEvento property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataOraRegEvento() {
        return dataOraRegEvento;
    }

    /**
     * Sets the value of the dataOraRegEvento property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataOraRegEvento(XMLGregorianCalendar value) {
        this.dataOraRegEvento = value;
    }

    /**
     * Gets the value of the tipoEventoCod property.
     * 
     */
    public int getTipoEventoCod() {
        return tipoEventoCod;
    }

    /**
     * Sets the value of the tipoEventoCod property.
     * 
     */
    public void setTipoEventoCod(int value) {
        this.tipoEventoCod = value;
    }

    /**
     * Gets the value of the tipoEventoDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoEventoDescr() {
        return tipoEventoDescr;
    }

    /**
     * Sets the value of the tipoEventoDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoEventoDescr(String value) {
        this.tipoEventoDescr = value;
    }

    /**
     * Gets the value of the idInterventoPratica property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdInterventoPratica() {
        return idInterventoPratica;
    }

    /**
     * Sets the value of the idInterventoPratica property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdInterventoPratica(Integer value) {
        this.idInterventoPratica = value;
    }

    /**
     * Gets the value of the servizioCod property.
     * 
     */
    public int getServizioCod() {
        return servizioCod;
    }

    /**
     * Sets the value of the servizioCod property.
     * 
     */
    public void setServizioCod(int value) {
        this.servizioCod = value;
    }

    /**
     * Gets the value of the servizioDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServizioDescr() {
        return servizioDescr;
    }

    /**
     * Sets the value of the servizioDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServizioDescr(String value) {
        this.servizioDescr = value;
    }

    /**
     * Gets the value of the dataOraEvento property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataOraEvento() {
        return dataOraEvento;
    }

    /**
     * Sets the value of the dataOraEvento property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataOraEvento(XMLGregorianCalendar value) {
        this.dataOraEvento = value;
    }

    /**
     * Gets the value of the produttoreCod property.
     * 
     */
    public int getProduttoreCod() {
        return produttoreCod;
    }

    /**
     * Sets the value of the produttoreCod property.
     * 
     */
    public void setProduttoreCod(int value) {
        this.produttoreCod = value;
    }

    /**
     * Gets the value of the produttoreDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProduttoreDescr() {
        return produttoreDescr;
    }

    /**
     * Sets the value of the produttoreDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProduttoreDescr(String value) {
        this.produttoreDescr = value;
    }

    /**
     * Gets the value of the unitaOrganizzativaCod property.
     * 
     */
    public int getUnitaOrganizzativaCod() {
        return unitaOrganizzativaCod;
    }

    /**
     * Sets the value of the unitaOrganizzativaCod property.
     * 
     */
    public void setUnitaOrganizzativaCod(int value) {
        this.unitaOrganizzativaCod = value;
    }

    /**
     * Gets the value of the unitaOrganizzativaDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitaOrganizzativaDescr() {
        return unitaOrganizzativaDescr;
    }

    /**
     * Sets the value of the unitaOrganizzativaDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitaOrganizzativaDescr(String value) {
        this.unitaOrganizzativaDescr = value;
    }

}
