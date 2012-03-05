//----------------------------------------------------------------------------
//	Laboratory Project
//	@author: Groff Matteo, Marchesoni Michele, Meque Abdul
//  @date: 5 / 3 / 2012
//----------------------------------------------------------------------------

package it.unitn.laboratory.dataproducer.CSI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


import it.unitn.laboratory.dataproducer.DB.DataManager;
import it.unitn.laboratory.events.*;


public class CSIDataProducer 
{
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
		ResultSet iva = dataM.getInserimentoVariazioneAnagrafica();
		while ( iva.next() )
		{		
			CreateInserimentoVariazioneAnagraficaEvent(iva);
		}
			
	}

	private static void CreateInserimentoVariazioneAnagraficaEvent(ResultSet iva) throws SQLException, DatatypeConfigurationException 
	{
		ObjectFactory of = new ObjectFactory();			
		EventType event = of.createEventType();	
		
		event.setAssistito(extractPatient(iva, of));
		event.setIntestazione(extractHeader(iva, of));
		new Events_Service().getEventsSOAP().sendEvent(event);
	}

	private static HeaderType extractHeader(ResultSet iva, ObjectFactory of) {
		HeaderType header = of.createHeaderType();
		//header.setIdEvento(iva.getString(""));
		//header.setMittente(iva.getString(""));
		//header.setSorgenteAnagrafe(iva.getString(""));
		return null;
	}

	private static PatientType extractPatient(ResultSet iva, ObjectFactory of) throws SQLException, DatatypeConfigurationException 
	{
		PatientType patient = of.createPatientType();
		patient.setNome( iva.getString("P.Nome") );
		patient.setCognome(iva.getString("P.Cognome"));
		patient.setCodiceFiscale(iva.getString("P.CodiceFiscale"));
		patient.setComuneNascitaCod(iva.getInt("P.ComuneNascitaCod"));
		patient.setComuneResidenzaCod(iva.getInt("P.ComuneResidenzaCod"));		
		patient.setIdAnagrafeLocale(iva.getInt("P.IdAnagrafeLocale"));		
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(iva.getDate("P.DataNascita"));
		XMLGregorianCalendar gc =  DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);		
	    patient.setDataNascita(gc);
		return patient;
	}
}

