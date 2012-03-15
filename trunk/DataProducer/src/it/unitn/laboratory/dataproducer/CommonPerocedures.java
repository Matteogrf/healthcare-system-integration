package it.unitn.laboratory.dataproducer;

import it.unitn.laboratory.events.DescriptionType;
import it.unitn.laboratory.events.EventType;
import it.unitn.laboratory.events.HeaderType;
import it.unitn.laboratory.events.MittenteType;
import it.unitn.laboratory.events.ObjectFactory;
import it.unitn.laboratory.events.PatientType;
import it.unitn.laboratory.events.SorgenteAnagrafeType;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class CommonPerocedures 
{
	
	public static EventType setCommonPart(ResultSet rs) throws SQLException, DatatypeConfigurationException
	{
		ObjectFactory of = new ObjectFactory();	
		EventType event = of.createEventType();			
		event.setAssistito(extractPatient(rs, of));
		event.setIntestazione(extractHeader(rs, of));
		event.setDescrizione(extractDescrizione(rs,of));
		return event;
	}
	
	public static DescriptionType extractDescrizione(ResultSet iva,
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
		description.setUnitaOrganizzativaCod( iva.getInt("ED.UnitaOrganizzativaCod") );
		description.setUnitaOrganizzativaDescr( iva.getString("ED.UnitaOrganizzativaDescr") );
		
		description.setDataOraEvento( DateToXMLGregorianCalendar( iva.getDate("ED.DataOraEvento") ) );
		description.setDataOraRegEvento( DateToXMLGregorianCalendar( iva.getDate("ED.DataOraRegEvento") ) );
		return description;
	}

	public static HeaderType extractHeader(ResultSet iva, ObjectFactory of) throws SQLException {
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
		return header;
	}

	public static PatientType extractPatient(ResultSet iva, ObjectFactory of) throws SQLException, DatatypeConfigurationException 
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
