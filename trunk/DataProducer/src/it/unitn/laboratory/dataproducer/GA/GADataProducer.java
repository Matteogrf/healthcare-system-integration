package it.unitn.laboratory.dataproducer.GA;

import it.unitn.laboratory.dataproducer.CommonPerocedures;
import it.unitn.laboratory.dataproducer.DB.DataManager;
import it.unitn.laboratory.events.BodyType;
import it.unitn.laboratory.events.EventType;
import it.unitn.laboratory.events.Events_Service;
import it.unitn.laboratory.events.ObjectFactory;
import it.unitn.laboratory.events.OperationType;
import it.unitn.laboratory.events.RicezioneDomandaAmministrativaType;

import java.sql.ResultSet;
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
		catch (ClassNotFoundException | SQLException | DatatypeConfigurationException e) 
		{
			System.out.println("Error: "+e.getMessage());
		}				
	}
	private static void produceEvents() throws SQLException, DatatypeConfigurationException 
	{
		System.out.println("Invio Ricezione Domanda Amministrativa");
		CreateInserimentoRicezioneDomandaAmministrativa();
		
	}
	private static void CreateInserimentoRicezioneDomandaAmministrativa() throws SQLException, DatatypeConfigurationException 
	{
		ResultSet pic = dataM.getDomandeAmministrative();
		ObjectFactory of = new ObjectFactory();	
		while(pic.next())
		{			
			EventType event = CommonPerocedures.setCommonPart(pic);
			OperationType operation = of.createOperationType();
			event.setEvento(extractRicezioneDomandaAmministrativa(pic));
			operation.setOperazioneCod("9");
			operation.setOperazioneDescr("RicezioneDomandaAmministrativa");
			event.setOperazione(operation);
			String res=new Events_Service().getEventsSOAP().sendEvent(event);
		
			System.out.println("\tRes sendEvent: "+res);
		}		
		
	}
	private static BodyType extractRicezioneDomandaAmministrativa(ResultSet pic) throws SQLException 
	{
		ObjectFactory of = new ObjectFactory();
		RicezioneDomandaAmministrativaType r = of.createRicezioneDomandaAmministrativaType();
		r.setGiornateSettimanali( pic.getInt("R.GiornateSettimanali") );
		r.setNumeroPastiSettimanali( pic.getInt("R.NumeroPastiSettimanali") );
		r.setNumeroTrasportiSettimanali( pic.getInt("R.NumeroTrasportiSettimanali") );
		r.setOreSettimanali( pic.getInt("R.OreSettimanali") );
		BodyType b = of.createBodyType();
		b.setRicezioneDomandaAmministrativa(r);
		return b;
	}

}
