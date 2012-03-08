
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package it.unitn.laboratory.wrapper;



import it.unitn.laboratory.adapter.EventManager;

import java.util.logging.Logger;
import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 2.5.2
 * 2012-03-07T14:15:56.650+01:00
 * Generated source version: 2.5.2
 * 
 */

@javax.jws.WebService(
                      serviceName = "DwhWS",
                      portName = "DwhWSSOAP",
                      targetNamespace = "http://events.laboratory.unitn.it",
                      wsdlLocation = "WebContent/wsdl/DwhWS.wsdl",
                      endpointInterface = "it.unitn.laboratory.wrapper.DwhWS")
                      
public class DwhWSImpl implements DwhWS {

    private static final Logger LOG = Logger.getLogger(DwhWSImpl.class.getName());

    /* (non-Javadoc)
     * @see it.unitn.laboratory.wrapper.DwhWS#sendMappedChanges(it.unitn.laboratory.wrapper.DwhSchemaType  dwhSCHEMA )*
     */
    public java.lang.String sendMappedChanges(it.unitn.laboratory.wrapper.DwhSchemaType dwhSCHEMA) 
    { 
        
        int type = dwhSCHEMA.getEVENTTYPE().getEVENTCOD();
        LOG.info("Executing operation "+dwhSCHEMA.getEVENTTYPE().getEVENTDESCR());
        switch ( type ) 
        {
			case 1:	 return EventManager.inserimentoVariazioneAnagrafica(dwhSCHEMA);
			default: return "ERROR: unokown type "+type;
		}        
    }
    
    public static void main(String[] args){
    	Endpoint.publish("http://192.168.178.25:9090/DwhWS",new DwhWSImpl());
    }

}
