package it.unitn.laboratory.dataproducer.GA;

import it.unitn.laboratory.dataproducer.DB.DataManager;

import java.sql.SQLException;

import javax.xml.datatype.DatatypeConfigurationException;

public class GADataProducer {

	/**
	 * @param args
	 */
	private static DataManager dataM;
	public static void main(String[] args)
	{
		try 
		{
			dataM = new DataManager();
			produceEvents();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			System.out.println("Error: "+e.getMessage());
		}				
	}
	private static void produceEvents() 
	{
		System.out.println("Invio Ricezione Domanda Amministrativa");
		CreateInserimentoRicezioneDomandaAmministrativa();
		
	}
	private static void CreateInserimentoRicezioneDomandaAmministrativa() 
	{
		
		
	}

}
