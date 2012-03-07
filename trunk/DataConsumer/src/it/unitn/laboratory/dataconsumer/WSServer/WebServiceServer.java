package it.unitn.laboratory.dataconsumer.WSServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLXML;

import it.unitn.laboratory.dataconsumer.DB.ConnectionManager;

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
		Endpoint.publish("http://localhost:8080/DataConsumer", serviceInstance);		
	}
	
	@RequestWrapper(className = "it.unitn.laboratory.dataconsumer.WSServer.jaxws.Update", localName = "update", targetNamespace = "http://datawarehouse.laboratory.unitn.it")
	@ResponseWrapper(className = "it.unitn.laboratory.dataconsumer.WSServer.jaxws.UpdateResponse", localName = "updateResponse", targetNamespace = "http://datawarehouse.laboratory.unitn.it")
	@WebMethod
	public String update(@WebParam(name="update_query") String query)
	{
		try 
		{
			Connection conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(query);
			int res = st.executeUpdate();
			st.close();
			return "OK";
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "ERROR: "+e.getMessage();
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "ERROR: "+e.getMessage();
		}
	}
	
	@RequestWrapper(className = "it.unitn.laboratory.dataconsumer.WSServer.jaxws.Insert", localName = "insert", targetNamespace = "http://datawarehouse.laboratory.unitn.it")
	@ResponseWrapper(className = "it.unitn.laboratory.dataconsumer.WSServer.jaxws.InsertResponse", localName = "insertResponse", targetNamespace = "http://datawarehouse.laboratory.unitn.it")
	@WebMethod
	public String insert(@WebParam(name="insert_query") String query)
	{
		try 
		{
			Connection conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(query);
			int res = st.executeUpdate();
			st.close();
			return "OK";
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "ERROR: "+e.getMessage();
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "ERROR: "+e.getMessage();
		}	
	}
	
	@RequestWrapper(className = "it.unitn.laboratory.dataconsumer.WSServer.jaxws.Query", localName = "query", targetNamespace = "http://datawarehouse.laboratory.unitn.it")
	@ResponseWrapper(className = "it.unitn.laboratory.dataconsumer.WSServer.jaxws.QueryResponse", localName = "queryResponse", targetNamespace = "http://datawarehouse.laboratory.unitn.it")
	@WebMethod
	public String query(@WebParam(name="query") String query)
	{
		try 
		{
			String res="";
			Connection conn = ConnectionManager.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeQuery();
			while (rs.next())
			{	
				int i = 0;
				while(true)
				{
					i++;
					try
					{
						SQLXML xml = rs.getSQLXML(i);
						res = res.concat(xml.getString()+"\n");
					}
					catch(SQLException s)
					{
						System.out.println(s.getMessage());
						break;
					}
				}	
			}
			st.close();
			return "OK";
		} 
		catch (ClassNotFoundException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "ERROR: "+e.getMessage();
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "ERROR: "+e.getMessage();
		}
	}
}
