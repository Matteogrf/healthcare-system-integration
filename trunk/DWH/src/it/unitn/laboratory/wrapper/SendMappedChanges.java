
package it.unitn.laboratory.wrapper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DWH_SCHEMA" type="{http://wrapper.laboratory.unitn.it}DwhSchemaType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dwhschema"
})
@XmlRootElement(name = "SendMappedChanges")
public class SendMappedChanges {

    @XmlElement(name = "DWH_SCHEMA", required = true)
    protected DwhSchemaType dwhschema;

    /**
     * Gets the value of the dwhschema property.
     * 
     * @return
     *     possible object is
     *     {@link DwhSchemaType }
     *     
     */
    public DwhSchemaType getDWHSCHEMA() {
        return dwhschema;
    }

    /**
     * Sets the value of the dwhschema property.
     * 
     * @param value
     *     allowed object is
     *     {@link DwhSchemaType }
     *     
     */
    public void setDWHSCHEMA(DwhSchemaType value) {
        this.dwhschema = value;
    }

}
