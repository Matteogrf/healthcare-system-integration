
package it.unitn.laboratory.events;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PresaInCaricoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PresaInCaricoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PresaCaricoNum">
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
@XmlType(name = "PresaInCaricoType", propOrder = {
    "presaCaricoNum"
})
public class PresaInCaricoType {

    @XmlElement(name = "PresaCaricoNum")
    protected int presaCaricoNum;

    /**
     * Gets the value of the presaCaricoNum property.
     * 
     */
    public int getPresaCaricoNum() {
        return presaCaricoNum;
    }

    /**
     * Sets the value of the presaCaricoNum property.
     * 
     */
    public void setPresaCaricoNum(int value) {
        this.presaCaricoNum = value;
    }

}
