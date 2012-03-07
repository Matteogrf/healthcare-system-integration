
package it.unitn.laboratory.wrapper;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.unitn.laboratory.wrapper package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.unitn.laboratory.wrapper
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendMappedChangesResponse }
     * 
     */
    public SendMappedChangesResponse createSendMappedChangesResponse() {
        return new SendMappedChangesResponse();
    }

    /**
     * Create an instance of {@link SendMappedChanges }
     * 
     */
    public SendMappedChanges createSendMappedChanges() {
        return new SendMappedChanges();
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
     * Create an instance of {@link EventType }
     * 
     */
    public EventType createEventType() {
        return new EventType();
    }

}
