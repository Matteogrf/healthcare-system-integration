
package it.unitn.laboratory.datawarehouse;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "WebServiceServer", targetNamespace = "http://datawarehouse.laboratory.unitn.it")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebServiceServer {


    /**
     * 
     * @param updateQuery
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "update", targetNamespace = "http://datawarehouse.laboratory.unitn.it", className = "it.unitn.laboratory.datawarehouse.Update")
    @ResponseWrapper(localName = "updateResponse", targetNamespace = "http://datawarehouse.laboratory.unitn.it", className = "it.unitn.laboratory.datawarehouse.UpdateResponse")
    public String update(
        @WebParam(name = "update_query", targetNamespace = "")
        String updateQuery);

    /**
     * 
     * @param query
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "query", targetNamespace = "http://datawarehouse.laboratory.unitn.it", className = "it.unitn.laboratory.datawarehouse.Query")
    @ResponseWrapper(localName = "queryResponse", targetNamespace = "http://datawarehouse.laboratory.unitn.it", className = "it.unitn.laboratory.datawarehouse.QueryResponse")
    public String query(
        @WebParam(name = "query", targetNamespace = "")
        String query);

    /**
     * 
     * @param insertQuery
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insert", targetNamespace = "http://datawarehouse.laboratory.unitn.it", className = "it.unitn.laboratory.datawarehouse.Insert")
    @ResponseWrapper(localName = "insertResponse", targetNamespace = "http://datawarehouse.laboratory.unitn.it", className = "it.unitn.laboratory.datawarehouse.InsertResponse")
    public String insert(
        @WebParam(name = "insert_query", targetNamespace = "")
        String insertQuery);

}
