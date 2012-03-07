package it.unitn.laboratory.dataconsumer.WSServer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace="http://datawarehouse.laboratory.unitn.it")
public class WebServiceServer 
{
	
	public static void main (String[] args)
	{
		WebServiceServer serviceInstance = new WebServiceServer();		
		Endpoint.publish("http://localhost:8080/MyService", serviceInstance);		
	}
	
	@RequestWrapper(className = "it.unitn.laboratory.dataconsumer.WSServer.jaxws.Update", localName = "update", targetNamespace = "http://datawarehouse.laboratory.unitn.it")
	@ResponseWrapper(className = "it.unitn.laboratory.dataconsumer.WSServer.jaxws.UpdateResponse", localName = "updateResponse", targetNamespace = "http://datawarehouse.laboratory.unitn.it")
	@WebMethod
	public String update(@WebParam(name="update_query") String query)
	{
		return "OK";
	}
	
	@RequestWrapper(className = "it.unitn.laboratory.dataconsumer.WSServer.jaxws.Insert", localName = "insert", targetNamespace = "http://datawarehouse.laboratory.unitn.it")
	@ResponseWrapper(className = "it.unitn.laboratory.dataconsumer.WSServer.jaxws.InsertResponse", localName = "insertResponse", targetNamespace = "http://datawarehouse.laboratory.unitn.it")
	@WebMethod
	public String insert(@WebParam(name="insert_query") String query)
	{
		return "OK";
	}
	
	@RequestWrapper(className = "it.unitn.laboratory.dataconsumer.WSServer.jaxws.Query", localName = "query", targetNamespace = "http://datawarehouse.laboratory.unitn.it")
	@ResponseWrapper(className = "it.unitn.laboratory.dataconsumer.WSServer.jaxws.QueryResponse", localName = "queryResponse", targetNamespace = "http://datawarehouse.laboratory.unitn.it")
	@WebMethod
	public String query(@WebParam(name="query") String query)
	{
		return "OK";
	}
}
