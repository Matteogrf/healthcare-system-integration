
package it.unitn.laboratory.events;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InserimentoVariazioneNucleoFattoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InserimentoVariazioneNucleoFattoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Componente" type="{http://events.laboratory.unitn.it/}ComponenteNucleoType" maxOccurs="unbounded"/>
 *         &lt;element name="CodiceNucleo" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InserimentoVariazioneNucleoFattoType", propOrder = {
    "componente",
    "codiceNucleo"
})
public class InserimentoVariazioneNucleoFattoType {

    @XmlElement(name = "Componente", required = true)
    protected List<ComponenteNucleoType> componente;
    @XmlElement(name = "CodiceNucleo", required = true)
    protected BigInteger codiceNucleo;

    /**
     * Gets the value of the componente property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the componente property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComponente().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComponenteNucleoType }
     * 
     * 
     */
    public List<ComponenteNucleoType> getComponente() {
        if (componente == null) {
            componente = new ArrayList<ComponenteNucleoType>();
        }
        return this.componente;
    }

    /**
     * Gets the value of the codiceNucleo property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCodiceNucleo() {
        return codiceNucleo;
    }

    /**
     * Sets the value of the codiceNucleo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCodiceNucleo(BigInteger value) {
        this.codiceNucleo = value;
    }

}
