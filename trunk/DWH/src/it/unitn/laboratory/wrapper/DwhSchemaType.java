
package it.unitn.laboratory.wrapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DwhSchemaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DwhSchemaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EVENT_TYPE" type="{http://events.laboratory.unitn.it}EventType"/>
 *         &lt;element name="D_ASSISTITO" type="{http://events.laboratory.unitn.it}AssistitoType" minOccurs="0"/>
 *         &lt;element name="D_OPERATORE" type="{http://events.laboratory.unitn.it}OperatoreType" minOccurs="0"/>
 *         &lt;element name="D_NUCLEO_FAMILIARE" type="{http://events.laboratory.unitn.it}NucleoFamiliareType" minOccurs="0"/>
 *         &lt;element name="F_CARTELLA" type="{http://events.laboratory.unitn.it}CartellaType" minOccurs="0"/>
 *         &lt;element name="D_RICHIEDENTE" type="{http://events.laboratory.unitn.it}RichiedenteType" minOccurs="0"/>
 *         &lt;element name="D_TIPO_TERZI" type="{http://events.laboratory.unitn.it}TipoTerziType" minOccurs="0"/>
 *         &lt;element name="D_SEGNALANTE" type="{http://events.laboratory.unitn.it}SegnalanteType" minOccurs="0"/>
 *         &lt;element name="D_AREA_UTENZA" type="{http://events.laboratory.unitn.it}AreaUtenzaType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DwhSchemaType", propOrder = {
    "eventtype",
    "dassistito",
    "doperatore",
    "dnucleofamiliare",
    "fcartella",
    "drichiedente",
    "dtipoterzi",
    "dsegnalante",
    "dareautenza"
})
public class DwhSchemaType {

    @XmlElement(name = "EVENT_TYPE", required = true)
    protected EventType eventtype;
    @XmlElement(name = "D_ASSISTITO")
    protected AssistitoType dassistito;
    @XmlElement(name = "D_OPERATORE")
    protected OperatoreType doperatore;
    @XmlElement(name = "D_NUCLEO_FAMILIARE")
    protected NucleoFamiliareType dnucleofamiliare;

    @XmlElement(name = "F_CARTELLA")
    protected CartellaType fcartella;
	@XmlElement(name = "D_RICHIEDENTE")
    protected RichiedenteType drichiedente;
	@XmlElement(name = "D_TIPO_TERZI")
    protected TipoTerziType dtipoterzi;
	@XmlElement(name = "D_SEGNALANTE")
    protected SegnalanteType dsegnalante;

	@XmlElement(name = "D_AREA_UTENZA")
    protected AreaUtenzaType dareautenza;

	/**
     * Gets the value of the eventtype property.
     * 
     * @return
     *     possible object is
     *     {@link EventType }
     *     
     */
    public EventType getEVENTTYPE() {
        return eventtype;
    }

    /**
     * Sets the value of the eventtype property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventType }
     *     
     */
    public void setEVENTTYPE(EventType value) {
        this.eventtype = value;
    }

    /**
     * Gets the value of the dassistito property.
     * 
     * @return
     *     possible object is
     *     {@link AssistitoType }
     *     
     */
    public AssistitoType getDASSISTITO() {
        return dassistito;
    }

    /**
     * Sets the value of the dassistito property.
     * 
     * @param value
     *     allowed object is
     *     {@link AssistitoType }
     *     
     */
    public void setDASSISTITO(AssistitoType value) {
        this.dassistito = value;
    }

    /**
     * Gets the value of the doperatore property.
     * 
     * @return
     *     possible object is
     *     {@link OperatoreType }
     *     
     */
    public OperatoreType getDOPERATORE() {
        return doperatore;
    }

    /**
     * Sets the value of the doperatore property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatoreType }
     *     
     */
    public void setDOPERATORE(OperatoreType value) {
        this.doperatore = value;
    }

    /**
     * Gets the value of the dnucleofamiliare property.
     * 
     * @return
     *     possible object is
     *     {@link NucleoFamiliareType }
     *     
     */
    public NucleoFamiliareType getDNUCLEOFAMILIARE() {
        return dnucleofamiliare;
    }

    /**
     * Sets the value of the dnucleofamiliare property.
     * 
     * @param value
     *     allowed object is
     *     {@link NucleoFamiliareType }
     *     
     */
    public void setDNUCLEOFAMILIARE(NucleoFamiliareType value) {
        this.dnucleofamiliare = value;
    }

	/**
     * Gets the value of the fcartella property.
     * 
     * @return
     *     possible object is
     *     {@link CartellaType }
     *     
     */
    public CartellaType getFCARTELLA() {
        return fcartella;
    }

	/**
     * Sets the value of the fcartella property.
     * 
     * @param value
     *     allowed object is
     *     {@link CartellaType }
     *     
     */
    public void setFCARTELLA(CartellaType value) {
        this.fcartella = value;
    }

	/**
     * Gets the value of the drichiedente property.
     * 
     * @return
     *     possible object is
     *     {@link RichiedenteType }
     *     
     */
    public RichiedenteType getDRICHIEDENTE() {
        return drichiedente;
    }

	/**
     * Sets the value of the drichiedente property.
     * 
     * @param value
     *     allowed object is
     *     {@link RichiedenteType }
     *     
     */
    public void setDRICHIEDENTE(RichiedenteType value) {
        this.drichiedente = value;
    }

	/**
     * Gets the value of the dtipoterzi property.
     * 
     * @return
     *     possible object is
     *     {@link TipoTerziType }
     *     
     */
    public TipoTerziType getDTIPOTERZI() {
        return dtipoterzi;
    }

	/**
     * Sets the value of the dtipoterzi property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTerziType }
     *     
     */
    public void setDTIPOTERZI(TipoTerziType value) {
        this.dtipoterzi = value;
    }

	/**
     * Gets the value of the dsegnalante property.
     * 
     * @return
     *     possible object is
     *     {@link SegnalanteType }
     *     
     */
    public SegnalanteType getDSEGNALANTE() {
        return dsegnalante;
    }

	/**
     * Sets the value of the dsegnalante property.
     * 
     * @param value
     *     allowed object is
     *     {@link SegnalanteType }
     *     
     */
    public void setDSEGNALANTE(SegnalanteType value) {
        this.dsegnalante = value;
    }

	/**
     * Gets the value of the dareautenza property.
     * 
     * @return
     *     possible object is
     *     {@link AreaUtenzaType }
     *     
     */
    public AreaUtenzaType getDAREAUTENZA() {
        return dareautenza;
    }

	/**
     * Sets the value of the dareautenza property.
     * 
     * @param value
     *     allowed object is
     *     {@link AreaUtenzaType }
     *     
     */
    public void setDAREAUTENZA(AreaUtenzaType value) {
        this.dareautenza = value;
    }

}
