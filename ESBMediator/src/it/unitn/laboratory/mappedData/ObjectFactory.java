//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.03.07 at 08:36:04 AM CET 
//


package it.unitn.laboratory.mappedData;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.unitn.laboratory.mappedData package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DWHSCHEMA_QNAME = new QName("http:/it.unitn.laboratory.MappedEventsSchema", "DWH_SCHEMA");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.unitn.laboratory.mappedData
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DwhSchemaType }
     * 
     */
    public DwhSchemaType createDwhSchemaType() {
        return new DwhSchemaType();
    }

    /**
     * Create an instance of {@link AssistitoType }
     * 
     */
    public AssistitoType createAssistitoType() {
        return new AssistitoType();
    }

    /**
     * Create an instance of {@link OperatoreType }
     * 
     */
    public OperatoreType createOperatoreType() {
        return new OperatoreType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DwhSchemaType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://events.laboratory.unitn.it/", name = "DWH_SCHEMA")
    public JAXBElement<DwhSchemaType> createDWHSCHEMA(DwhSchemaType value) {
        return new JAXBElement<DwhSchemaType>(_DWHSCHEMA_QNAME, DwhSchemaType.class, null, value);
    }

}
