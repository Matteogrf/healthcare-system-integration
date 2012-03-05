//----------------------------------------------------------------------------
//	Laboratory Project
//	@author: Groff Matteo, Marchesoni Michele, Meque Abdul
//  @date: 5 / 3 / 2012
//----------------------------------------------------------------------------

package it.unitn.laboratory.dataproducer.CSI;

import java.sql.Date;
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
		event.setDescrizione(extractDescrizione(iva,of));
		event.setEvento(extractEventInserimentoVariazioneAnagrafica(iva,of));
		
		new Events_Service().getEventsSOAP().sendEvent(event);
	}

	private static BodyType extractEventInserimentoVariazioneAnagrafica(ResultSet iva, ObjectFactory of) {
		BodyType body = of.createBodyType();
		InserimentoVariazioneAnagraficaType ivat = of.createInserimentoVariazioneAnagraficaType();
		ivat.setAssSocialeCod( iva.getInt("I.AssSocialeCod") );
		ivat.setAssSocialeCognome(value);
		ivat.setAssSocialeNome(value);
		ivat.setCAP(value);
		ivat.setCittadinanzaCod(value);
		ivat.setCittadinanzaDescr(value);
		ivat.setComuneNascitaDescr(value);
		ivat.setComuneResidenzaDescr(value);
		ivat.setNazionalitacDescr(value);
		ivat.setNazionalitaCod(value);
		ivat.setSesso(value);
		ivat.setStatoCivileCod(value);
		ivat.setStatoCivileDescr(value);
		ivat.setVia(value);
		body.setInserimentoVariazioneAnagrafica(ivat);
		return body;
	}

	private static DescriptionType extractDescrizione(ResultSet iva,
			ObjectFactory of) throws DatatypeConfigurationException, SQLException 
	{
		DescriptionType description = of.createDescriptionType();
		
		description.setIdInterventoPratica( iva.getInt("ED.IdInterventoPratica") );
		description.setProduttoreCod( iva.getInt("ED.ProduttoreCod") );
		description.setProduttoreDescr( iva.getString("ED.ProduttoreDescr"));
		description.setServizioCod( iva.getInt("ED.ServizioCod") );
		description.setServizioDescr( iva.getString("ED.ServizioDescr") );
		description.setTipoEventoCod( iva.getInt("ED.TipoEventoCod") );
		description.setTipoEventoDescr( iva.getString("ED.TipoEventoDescr") );
		description.setUnitaOrganizzativaCod( iva.getInt("ED.Unit�OrganizzativaCod") );
		description.setUnitaOrganizzativaDescr( iva.getString("ED.Unit�OrganizzativaDescr") );
		
		description.setDataOraEvento( DateToXMLGregorianCalendar( iva.getDate("ED.DataOraEvento") ) );
		description.setDataOraRegEvento( DateToXMLGregorianCalendar( iva.getDate("ED.DataOraRegEvento") ) );
		return description;
	}

	private static HeaderType extractHeader(ResultSet iva, ObjectFactory of) throws SQLException {
		HeaderType header = of.createHeaderType();
		header.setIdEvento(iva.getString("H.IdHeader"));
		MittenteType mt = of.createMittenteType();
		mt.setNomeEnte(iva.getString("H.NomeEnte"));
		mt.setUrlEnte(iva.getString("H.UrlEnteMittente"));
		header.setMittente(mt);
		SorgenteAnagrafeType sat = of.createSorgenteAnagrafeType();
		sat.setIdAnagrafe(iva.getString("H.IdAnagrafe"));
		sat.setUrlEnte(iva.getString("H.UrlEnteAnagrafe"));
		header.setSorgenteAnagrafe(sat);
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
	    patient.setDataNascita( DateToXMLGregorianCalendar( iva.getDate("P.DataNascita") ) );
		return patient;
	}

	public static XMLGregorianCalendar DateToXMLGregorianCalendar(Date date) throws DatatypeConfigurationException 
	{
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		return  DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);	
	}
}

