
package it.unitn.laboratory.wrapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ComponenteType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComponenteType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="HASH_COD" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GRADO_PARENTELA_COD" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="GRADO_PARENTELA_DESCR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DATA_NASCITA" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComponenteType", propOrder = {
    "hashcod",
    "gradoparentelacod",
    "gradoparenteladescr",
    "datanascita"
})
public class ComponenteType {

    @XmlElement(name = "HASH_COD")
    protected String hashcod;
    @XmlElement(name = "GRADO_PARENTELA_COD")
    protected Integer gradoparentelacod;
    @XmlElement(name = "GRADO_PARENTELA_DESCR")
    protected String gradoparenteladescr;
    @XmlElement(name = "DATA_NASCITA")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar datanascita;

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
     * Gets the value of the gradoparentelacod property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGRADOPARENTELACOD() {
        return gradoparentelacod;
    }

    /**
     * Sets the value of the gradoparentelacod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGRADOPARENTELACOD(Integer value) {
        this.gradoparentelacod = value;
    }

    /**
     * Gets the value of the gradoparenteladescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGRADOPARENTELADESCR() {
        return gradoparenteladescr;
    }

    /**
     * Sets the value of the gradoparenteladescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGRADOPARENTELADESCR(String value) {
        this.gradoparenteladescr = value;
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

}
