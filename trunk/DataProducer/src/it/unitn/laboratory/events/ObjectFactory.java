
package it.unitn.laboratory.events;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the it.unitn.laboratory.events package. 
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

    private final static QName _EventNotificationResponse_QNAME = new QName("http://events.laboratory.unitn.it/", "EventNotificationResponse");
    private final static QName _EventNotificationRequest_QNAME = new QName("http://events.laboratory.unitn.it/", "EventNotificationRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: it.unitn.laboratory.events
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EventType }
     * 
     */
    public EventType createEventType() {
        return new EventType();
    }

    /**
     * Create an instance of {@link AssegnazioneAreaUtenzaType }
     * 
     */
    public AssegnazioneAreaUtenzaType createAssegnazioneAreaUtenzaType() {
        return new AssegnazioneAreaUtenzaType();
    }

    /**
     * Create an instance of {@link OperationType }
     * 
     */
    public OperationType createOperationType() {
        return new OperationType();
    }

    /**
     * Create an instance of {@link PresaInCaricoType }
     * 
     */
    public PresaInCaricoType createPresaInCaricoType() {
        return new PresaInCaricoType();
    }

    /**
     * Create an instance of {@link PatientType }
     * 
     */
    public PatientType createPatientType() {
        return new PatientType();
    }

    /**
     * Create an instance of {@link SorgenteAnagrafeType }
     * 
     */
    public SorgenteAnagrafeType createSorgenteAnagrafeType() {
        return new SorgenteAnagrafeType();
    }

    /**
     * Create an instance of {@link FatturazionePeriodicaType }
     * 
     */
    public FatturazionePeriodicaType createFatturazionePeriodicaType() {
        return new FatturazionePeriodicaType();
    }

    /**
     * Create an instance of {@link InserimentoVariazioneNucleoFattoType }
     * 
     */
    public InserimentoVariazioneNucleoFattoType createInserimentoVariazioneNucleoFattoType() {
        return new InserimentoVariazioneNucleoFattoType();
    }

    /**
     * Create an instance of {@link RicezioneDomandaAmministrativaType }
     * 
     */
    public RicezioneDomandaAmministrativaType createRicezioneDomandaAmministrativaType() {
        return new RicezioneDomandaAmministrativaType();
    }

    /**
     * Create an instance of {@link RevocaAreaUtenzaType }
     * 
     */
    public RevocaAreaUtenzaType createRevocaAreaUtenzaType() {
        return new RevocaAreaUtenzaType();
    }

    /**
     * Create an instance of {@link InserimentoVariazioneAnagraficaType }
     * 
     */
    public InserimentoVariazioneAnagraficaType createInserimentoVariazioneAnagraficaType() {
        return new InserimentoVariazioneAnagraficaType();
    }

    /**
     * Create an instance of {@link MittenteType }
     * 
     */
    public MittenteType createMittenteType() {
        return new MittenteType();
    }

    /**
     * Create an instance of {@link BodyType }
     * 
     */
    public BodyType createBodyType() {
        return new BodyType();
    }

    /**
     * Create an instance of {@link DescriptionType }
     * 
     */
    public DescriptionType createDescriptionType() {
        return new DescriptionType();
    }

    /**
     * Create an instance of {@link ComponenteNucleoType }
     * 
     */
    public ComponenteNucleoType createComponenteNucleoType() {
        return new ComponenteNucleoType();
    }

    /**
     * Create an instance of {@link HeaderType }
     * 
     */
    public HeaderType createHeaderType() {
        return new HeaderType();
    }

    /**
     * Create an instance of {@link SchedaAccessoType }
     * 
     */
    public SchedaAccessoType createSchedaAccessoType() {
        return new SchedaAccessoType();
    }

    /**
     * Create an instance of {@link ChiusuraPresaInCaricoType }
     * 
     */
    public ChiusuraPresaInCaricoType createChiusuraPresaInCaricoType() {
        return new ChiusuraPresaInCaricoType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://events.laboratory.unitn.it/", name = "EventNotificationResponse")
    public JAXBElement<String> createEventNotificationResponse(String value) {
        return new JAXBElement<String>(_EventNotificationResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EventType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://events.laboratory.unitn.it/", name = "EventNotificationRequest")
    public JAXBElement<EventType> createEventNotificationRequest(EventType value) {
        return new JAXBElement<EventType>(_EventNotificationRequest_QNAME, EventType.class, null, value);
    }

}
