package it.unitn.laboratory.wrapper;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.5.2
 * 2012-03-07T14:15:56.709+01:00
 * Generated source version: 2.5.2
 * 
 */
@WebService(targetNamespace = "http://events.laboratory.unitn.it", name = "DwhWS")
@XmlSeeAlso({ObjectFactory.class})
public interface DwhWS {

    @WebResult(name = "out", targetNamespace = "")
    @RequestWrapper(localName = "SendMappedChanges", targetNamespace = "http://events.laboratory.unitn.it", className = "it.unitn.laboratory.wrapper.SendMappedChanges")
    @WebMethod(operationName = "SendMappedChanges", action = "http://events.laboratory.unitn.it/NewOperation")
    @ResponseWrapper(localName = "SendMappedChangesResponse", targetNamespace = "http://events.laboratory.unitn.it", className = "it.unitn.laboratory.wrapper.SendMappedChangesResponse")
    public java.lang.String sendMappedChanges(
        @WebParam(name = "DWH_SCHEMA", targetNamespace = "")
        it.unitn.laboratory.wrapper.DwhSchemaType dwhSCHEMA
    );
}
