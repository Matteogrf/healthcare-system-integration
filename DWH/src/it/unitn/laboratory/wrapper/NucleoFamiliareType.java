
package it.unitn.laboratory.wrapper;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NucleoFamiliareType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NucleoFamiliareType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CODICE_NUCLEO" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="COMPONENTE" type="{http://wrapper.laboratory.unitn.it}ComponenteType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NucleoFamiliareType", propOrder = {
    "codicenucleo",
    "componente"
})
public class NucleoFamiliareType {

    @XmlElement(name = "CODICE_NUCLEO")
    protected int codicenucleo;
    @XmlElement(name = "COMPONENTE", required = true)
    protected List<ComponenteType> componente;

    /**
     * Gets the value of the codicenucleo property.
     * 
     */
    public int getCODICENUCLEO() {
        return codicenucleo;
    }

    /**
     * Sets the value of the codicenucleo property.
     * 
     */
    public void setCODICENUCLEO(int value) {
        this.codicenucleo = value;
    }

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
     *    getCOMPONENTE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComponenteType }
     * 
     * 
     */
    public List<ComponenteType> getCOMPONENTE() {
        if (componente == null) {
            componente = new ArrayList<ComponenteType>();
        }
        return this.componente;
    }

}
