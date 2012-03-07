
package it.unitn.laboratory.events;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "Events", targetNamespace = "http://events.laboratory.unitn.it/", wsdlLocation = "file:/C:/Users/Matteo/workspace/ESBMediator/cxf-bc/Events.wsdl")
public class Events_Service
    extends Service
{

    private final static URL EVENTS_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(it.unitn.laboratory.events.Events_Service.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = it.unitn.laboratory.events.Events_Service.class.getResource(".");
            url = new URL(baseUrl, "file:/C:/Users/Matteo/workspace/ESBMediator/cxf-bc/Events.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/C:/Users/Matteo/workspace/ESBMediator/cxf-bc/Events.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        EVENTS_WSDL_LOCATION = url;
    }

    public Events_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Events_Service() {
        super(EVENTS_WSDL_LOCATION, new QName("http://events.laboratory.unitn.it/", "Events"));
    }

    /**
     * 
     * @return
     *     returns Events
     */
    @WebEndpoint(name = "EventsSOAP")
    public Events getEventsSOAP() {
        return super.getPort(new QName("http://events.laboratory.unitn.it/", "EventsSOAP"), Events.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Events
     */
    @WebEndpoint(name = "EventsSOAP")
    public Events getEventsSOAP(WebServiceFeature... features) {
        return super.getPort(new QName("http://events.laboratory.unitn.it/", "EventsSOAP"), Events.class, features);
    }

}