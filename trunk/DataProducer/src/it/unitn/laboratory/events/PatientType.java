
package it.unitn.laboratory.events;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for PatientType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PatientType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Nome">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Cognome">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="100"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DataNascita" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="CodiceFiscale" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="16"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ComuneNascitaCod">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ComuneResidenzaCod">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="7"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="IdAnagrafeLocale">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;totalDigits value="7"/>
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
@XmlType(name = "PatientType", propOrder = {
    "nome",
    "cognome",
    "dataNascita",
    "codiceFiscale",
    "comuneNascitaCod",
    "comuneResidenzaCod",
    "idAnagrafeLocale"
})
public class PatientType {

    @XmlElement(name = "Nome", required = true)
    protected String nome;
    @XmlElement(name = "Cognome", required = true)
    protected String cognome;
    @XmlElement(name = "DataNascita", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dataNascita;
    @XmlElement(name = "CodiceFiscale")
    protected String codiceFiscale;
    @XmlElement(name = "ComuneNascitaCod")
    protected int comuneNascitaCod;
    @XmlElement(name = "ComuneResidenzaCod")
    protected int comuneResidenzaCod;
    @XmlElement(name = "IdAnagrafeLocale")
    protected int idAnagrafeLocale;

    /**
     * Gets the value of the nome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the value of the nome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Gets the value of the cognome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCognome() {
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
    public void setCognome(String value) {
        this.cognome = value;
    }

    /**
     * Gets the value of the dataNascita property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataNascita() {
        return dataNascita;
    }

    /**
     * Sets the value of the dataNascita property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataNascita(XMLGregorianCalendar value) {
        this.dataNascita = value;
    }

    /**
     * Gets the value of the codiceFiscale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     * Sets the value of the codiceFiscale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodiceFiscale(String value) {
        this.codiceFiscale = value;
    }

    /**
     * Gets the value of the comuneNascitaCod property.
     * 
     */
    public int getComuneNascitaCod() {
        return comuneNascitaCod;
    }

    /**
     * Sets the value of the comuneNascitaCod property.
     * 
     */
    public void setComuneNascitaCod(int value) {
        this.comuneNascitaCod = value;
    }

    /**
     * Gets the value of the comuneResidenzaCod property.
     * 
     */
    public int getComuneResidenzaCod() {
        return comuneResidenzaCod;
    }

    /**
     * Sets the value of the comuneResidenzaCod property.
     * 
     */
    public void setComuneResidenzaCod(int value) {
        this.comuneResidenzaCod = value;
    }

    /**
     * Gets the value of the idAnagrafeLocale property.
     * 
     */
    public int getIdAnagrafeLocale() {
        return idAnagrafeLocale;
    }

    /**
     * Sets the value of the idAnagrafeLocale property.
     * 
     */
    public void setIdAnagrafeLocale(int value) {
        this.idAnagrafeLocale = value;
    }

}
