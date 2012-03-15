package it.unitn.laboratory.dataproducer.CD;

import it.unitn.laboratory.dataproducer.CommonPerocedures;
import it.unitn.laboratory.dataproducer.DB.DataManager;
import it.unitn.laboratory.events.BodyType;
import it.unitn.laboratory.events.EventType;
import it.unitn.laboratory.events.Events_Service;
import it.unitn.laboratory.events.FatturazionePeriodicaType;
import it.unitn.laboratory.events.ObjectFactory;
import it.unitn.laboratory.events.OperationType;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.datatype.DatatypeConfigurationException;

public class CDDataProducer {

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
		System.out.println("Invio Fatturazione Periodica");
		CreateFatturazionePeriodicaEvents();
	}
	private static void CreateFatturazionePeriodicaEvents() throws SQLException, DatatypeConfigurationException 
	{
		ResultSet rs = dataM.getFatturazioniPeriodiche();
		ObjectFactory of = new ObjectFactory();	
		while(rs.next())
		{			
			EventType event = CommonPerocedures.setCommonPart(rs);
			OperationType operation = of.createOperationType();
			event.setEvento(extractFatturazionePeriodica(rs));
			operation.setOperazioneCod("10");
			operation.setOperazioneDescr("FatturazionePeriodica");
			event.setOperazione(operation);
			String res=new Events_Service().getEventsSOAP().sendEvent(event);
		
			System.out.println("\tRes sendEvent: "+res);
		}		
	}
	private static BodyType extractFatturazionePeriodica(ResultSet rs) throws SQLException, DatatypeConfigurationException 
	{
		ObjectFactory of = new ObjectFactory();
		FatturazionePeriodicaType f = of.createFatturazionePeriodicaType();
		f.setAccessiServizio( rs.getInt("AccessiServizio") );
		f.setCodiceCentro(rs.getInt("CodiceCentro"));
		f.setDataFine( CommonPerocedures.DateToXMLGregorianCalendar(rs.getDate("DataFine")) );
		f.setDataInizio(CommonPerocedures.DateToXMLGregorianCalendar(rs.getDate("DataFine")));
		f.setDenominazioneCentro(rs.getString("DenominazioneCentro"));
		f.setGiornate(rs.getInt("Giornate"));
		f.setGiorniAssenzaGiustificati(rs.getInt("GiorniAssenzaGiustificati"));
		f.setGiorniAssenzaNonGiustificati(rs.getInt("GiorniAssenzaNonGiustificati"));
		f.setImportoFattura(rs.getInt("ImportoFattura"));
		f.setNumeroPasti(rs.getInt("NumeroPasti"));
		f.setNumeroTrasporti(rs.getInt("NumeroTrasporti"));
		f.setOreErogate(rs.getInt("OreErogate"));
		f.setDataFattura(CommonPerocedures.DateToXMLGregorianCalendar(rs.getDate("DataFattura")));
		BodyType b = of.createBodyType();
		b.setFatturazionePeriodica(f);
		return b;
	}

}
