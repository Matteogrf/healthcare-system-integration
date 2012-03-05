
package it.unitn.laboratory.events;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AssegnazioneAreaUtenzaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssegnazioneAreaUtenzaType">
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
 *         &lt;element name="AreaUtenzaCod">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AreaUtenzaDescr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="255"/>
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
@XmlType(name = "AssegnazioneAreaUtenzaType", propOrder = {
    "presaCaricoNum",
    "areaUtenzaCod",
    "areaUtenzaDescr"
})
public class AssegnazioneAreaUtenzaType {

    @XmlElement(name = "PresaCaricoNum")
    protected int presaCaricoNum;
    @XmlElement(name = "AreaUtenzaCod", required = true)
    protected String areaUtenzaCod;
    @XmlElement(name = "AreaUtenzaDescr", required = true)
    protected String areaUtenzaDescr;

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

    /**
     * Gets the value of the areaUtenzaCod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaUtenzaCod() {
        return areaUtenzaCod;
    }

    /**
     * Sets the value of the areaUtenzaCod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaUtenzaCod(String value) {
        this.areaUtenzaCod = value;
    }

    /**
     * Gets the value of the areaUtenzaDescr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaUtenzaDescr() {
        return areaUtenzaDescr;
    }

    /**
     * Sets the value of the areaUtenzaDescr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaUtenzaDescr(String value) {
        this.areaUtenzaDescr = value;
    }

}
