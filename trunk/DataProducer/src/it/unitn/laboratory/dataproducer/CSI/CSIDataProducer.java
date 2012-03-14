//----------------------------------------------------------------------------
//	Laboratory Project
//	@author: Groff Matteo, Marchesoni Michele, Meque Abdul
//  @date: 5 / 3 / 2012
//----------------------------------------------------------------------------

package it.unitn.laboratory.dataproducer.CSI;

import java.util.List;
import java.math.BigInteger;
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

	private static void produceEvents() throws SQLException, DatatypeConfigurationException, ClassNotFoundException 
	{	
		System.out.println("Invio Variazione Anagrafica");
		CreateInserimentoVariazioneAnagrafica();
		System.out.println("\nInvio Nucleo Familiare");
		CreateInserimentoNucleoFamiliare();
		System.out.println("\nInvio Assegnazione Area Utenza");
		CreateAssegnazioneAreaUtenza();
		System.out.println("\nInvio Scheda accesso");
		CreateSchedaAccesso();
		System.out.println("\nInvio Presa in carico");
		CreatePresaInCarico();
		System.out.println("\nInvio Chiura presa in carico");
		CreateChiusuraPresaInCarico();

		
	}
	



	private static void CreateChiusuraPresaInCarico() throws SQLException, DatatypeConfigurationException 
	{
		ResultSet rs = dataM.getChiusuraPreseInCarico();
		ObjectFactory of = new ObjectFactory();	
		while(rs.next())
		{					
			EventType event = of.createEventType();	
		
			event.setAssistito(extractPatient(rs, of));
			event.setIntestazione(extractHeader(rs, of));
			event.setDescrizione(extractDescrizione(rs,of));
			event.setEvento(extractChiusuraPresaInCarico(rs,of));
			OperationType operation = of.createOperationType();
			operation.setOperazioneCod("5");
			operation.setOperazioneDescr("ChiusuraPresaInCarico");
			event.setOperazione(operation);
		
			String res=new Events_Service().getEventsSOAP().sendEvent(event);
			System.out.println("\tRes sendEvent: "+res);
		}
		
	}

	private static BodyType extractChiusuraPresaInCarico(ResultSet rs,
			ObjectFactory of) throws SQLException, DatatypeConfigurationException 
	{
		PresaInCaricoType pic = of.createPresaInCaricoType();
		pic.setPresaCaricoNum(rs.getInt("PI.PresaInCaricoNum"));
		pic.setInizioPresaInCarico(DateToXMLGregorianCalendar(rs.getDate("PI.ChiusuraData")));
		BodyType b = of.createBodyType();
		b.setPresaInCarico(pic);
		return b;
	}

	private static void CreateSchedaAccesso() throws SQLException, DatatypeConfigurationException 
	{
		ResultSet rs = dataM.getSchedaAccesso();
		ObjectFactory of = new ObjectFactory();	
		while(rs.next())
		{					
			EventType event = of.createEventType();	
		
			event.setAssistito(extractPatient(rs, of));
			event.setIntestazione(extractHeader(rs, of));
			event.setDescrizione(extractDescrizione(rs,of));
			event.setEvento(extractSchedaAccesso(rs,of));
			OperationType operation = of.createOperationType();
			operation.setOperazioneCod("3");
			operation.setOperazioneDescr("SchedaAccesso");
			event.setOperazione(operation);
		
			String res=new Events_Service().getEventsSOAP().sendEvent(event);
			System.out.println("\tRes sendEvent: "+res);
		}
		
	}

	private static BodyType extractSchedaAccesso(ResultSet rs, ObjectFactory of) throws SQLException, DatatypeConfigurationException 
	{
		SchedaAccessoType sac = of.createSchedaAccessoType();
		
		sac.setNomeTerzi( rs.getString("S.NomeTerzi") );
		sac.setNumeroScheda( rs.getString("S.NumeroScheda") );
		sac.setTipoRichiedenteCod(rs.getString("S.TipoRichiedenteCod"));
		sac.setTipoRichiedenteDescr(rs.getString("S.TipoRichiedenteDescr"));
		sac.setTipoSegnalanteCod(rs.getInt("S.TipoSegnalanteCod"));
		sac.setTipoSegnalanteDescr(rs.getString("S.TipoSegnalanteDescr"));
		sac.setTipoServizioRichiestoCod(rs.getString("S.TipoServizioRichiestoCod"));
		sac.setTipoServizioRichiestoDescr(rs.getString("S.TipoServizioRichiestoDescr"));
		sac.setTipoTerziCod(rs.getInt("S.TipoTerziCod"));
		sac.setTipoTerziDescr(rs.getString("S.TipoTerziDescr"));
		sac.setDataAccesso(DateToXMLGregorianCalendar(rs.getDate("S.DataAccesso")));
		
		BodyType b = of.createBodyType();
		b.setSchedaAccesso(sac);
		return b;
	}

	private static void CreatePresaInCarico() throws SQLException, DatatypeConfigurationException 
	{
		ResultSet rs = dataM.getPreseInCarico();
		ObjectFactory of = new ObjectFactory();	
		while(rs.next())
		{					
			EventType event = of.createEventType();	
		
			event.setAssistito(extractPatient(rs, of));
			event.setIntestazione(extractHeader(rs, of));
			event.setDescrizione(extractDescrizione(rs,of));
			event.setEvento(extractPresaInCarico(rs,of));
			OperationType operation = of.createOperationType();
			operation.setOperazioneCod("4");
			operation.setOperazioneDescr("PresaInCarico");
			event.setOperazione(operation);
		
			String res=new Events_Service().getEventsSOAP().sendEvent(event);
			System.out.println("\tRes sendEvent:"+res);
		}
	}

	private static BodyType extractPresaInCarico(ResultSet rs, ObjectFactory of) throws SQLException, DatatypeConfigurationException {
		PresaInCaricoType pic = of.createPresaInCaricoType();
		pic.setPresaCaricoNum(rs.getInt("PI.PresaInCaricoNum"));
		pic.setInizioPresaInCarico(DateToXMLGregorianCalendar(rs.getDate("PI.PresaInCaricoData")));
		BodyType b = of.createBodyType();
		b.setPresaInCarico(pic);
		return b;
	}

	private static void CreateAssegnazioneAreaUtenza() throws SQLException, DatatypeConfigurationException 
	{
		ResultSet pic = dataM.getAssegnazioneAreaUtenza();
		ObjectFactory of = new ObjectFactory();	
		while(pic.next())
		{
			EventType event = of.createEventType();			
			event.setAssistito(extractPatient(pic, of));
			event.setIntestazione(extractHeader(pic, of));
			event.setDescrizione(extractDescrizione(pic,of));
			event.setEvento(extractAssegnazioneAreaUtenza(pic,of));
			OperationType operation = of.createOperationType();
			operation.setOperazioneCod("6");
			operation.setOperazioneDescr("AssegnazioneAreaUtenza");
			event.setOperazione(operation);
			String res=new Events_Service().getEventsSOAP().sendEvent(event);
		
			System.out.println("\tRes sendEvent: "+res);
		}
	}

	private static BodyType extractAssegnazioneAreaUtenza(ResultSet pic, ObjectFactory of) throws SQLException 
	{
		AssegnazioneAreaUtenzaType a = of.createAssegnazioneAreaUtenzaType();
		
		a.setAreaUtenzaCod( pic.getString("AreaUtenzaCod") );
		a.setAreaUtenzaDescr( pic.getString("AreaUtenzaString") );
		a.setPresaCaricoNum( pic.getInt("PresaInCaricoNum") );
		
		BodyType b = of.createBodyType();
		b.setAssegnazioneAreaUtenza(a);
		return b;
	}

	private static void CreateInserimentoNucleoFamiliare() throws SQLException, DatatypeConfigurationException, ClassNotFoundException 
	{
		ResultSet ev = dataM.getNucleiFamiliari();
		ObjectFactory of = new ObjectFactory();	
		while(ev.next())
		{
			
			EventType event = of.createEventType();			
			event.setAssistito(extractPatient(ev, of));
			event.setIntestazione(extractHeader(ev, of));
			event.setDescrizione(extractDescrizione(ev,of));
			event.setEvento(extractInserimentoNucleaoFamiliare(ev,of));
		
			OperationType operation = of.createOperationType();
			operation.setOperazioneCod("2");
			operation.setOperazioneDescr("InserimentoVariazioneNucleoFatto");
			event.setOperazione(operation);
			String res=new Events_Service().getEventsSOAP().sendEvent(event);
		
			System.out.println("\tRes sendEvent: "+res);
		}
	}

	private static BodyType extractInserimentoNucleaoFamiliare(ResultSet ev,ObjectFactory of) throws SQLException, ClassNotFoundException, DatatypeConfigurationException 
	{
		InserimentoVariazioneNucleoFattoType ins = of.createInserimentoVariazioneNucleoFattoType();
		ins.setCodiceNucleo( BigInteger.valueOf(ev.getInt("N.CodiceNucleo")));
		List<ComponenteNucleoType> l =  ins.getComponente();
		
		ResultSet rs = dataM.getComponentiNucleoFamiliare(ev.getInt("N.CodiceNucleo"));		
		while (rs.next())
		{
			ComponenteNucleoType c = of.createComponenteNucleoType();
			c.setNome( rs.getString("P.Nome") );
			c.setCognome(rs.getString("P.Cognome"));
			c.setCodiceFiscale(rs.getString("P.CodiceFiscale"));
			c.setDataNascita( DateToXMLGregorianCalendar(rs.getDate("P.DataNascita"))  );
			c.setGradoParentelaCod( rs.getInt("N.GradoParentelaCod") );
			c.setGradoParentelaDescr( rs.getString("N.GradoParentelaDescr") );
			l.add(c);
		}
				
		BodyType body = of.createBodyType();
		body.setInserimentoVariazioneNucleoFatto(ins);
		return body;
	}

	private static void CreateInserimentoVariazioneAnagrafica() throws SQLException, DatatypeConfigurationException 
	{
		ResultSet iva = dataM.getInserimentoVariazioneAnagrafica();
		while(iva.next())
		{
			ObjectFactory of = new ObjectFactory();			
			EventType event = of.createEventType();	
		
			event.setAssistito(extractPatient(iva, of));
			event.setIntestazione(extractHeader(iva, of));
			event.setDescrizione(extractDescrizione(iva,of));
			event.setEvento(extractEventInserimentoVariazioneAnagrafica(iva,of));
			event.setOperazione(extractOperation(of));
		
			String res=new Events_Service().getEventsSOAP().sendEvent(event);
			System.out.println("\tRes sendEvent: "+res);
		}			
	}

	private static OperationType extractOperation(ObjectFactory of) 
	{
		OperationType operation = of.createOperationType();
		operation.setOperazioneCod("1");
		operation.setOperazioneDescr("Inserimento");
		return operation;
	}

	private static BodyType extractEventInserimentoVariazioneAnagrafica(ResultSet iva, ObjectFactory of) throws SQLException {
		BodyType body = of.createBodyType();
		InserimentoVariazioneAnagraficaType ivat = of.createInserimentoVariazioneAnagraficaType();
		ivat.setAssSocialeCod( iva.getInt("I.AssSocialeCod") );
		ivat.setAssSocialeCognome( iva.getString("I.AssSocialeCognome") );
		ivat.setAssSocialeNome(iva.getString("I.AssSocialeNome"));
		ivat.setCAP( iva.getInt("I.CAP") );
		ivat.setCittadinanzaCod( iva.getInt("I.CittadinanzaCod") );
		ivat.setCittadinanzaDescr( iva.getString("I.CittadinanzaDescr") );
		ivat.setComuneNascitaDescr( iva.getString("I.ComuneNascitaDescr") );
		ivat.setComuneResidenzaDescr( iva.getString("I.ComuneDiResidenzaDescr") );
		ivat.setNazionalitacDescr( iva.getString("I.NazionalitaDescr") );
		ivat.setNazionalitaCod( iva.getInt("I.NazionalitaCod") );
		ivat.setSesso( iva.getString("I.Sesso") );
		ivat.setStatoCivileCod( iva.getInt("I.StatoCivileCod") );
		ivat.setStatoCivileDescr(iva.getString("I.StatoCivileDescr"));
		ivat.setVia(iva.getString("I.Via"));
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
		description.setUnitaOrganizzativaCod( iva.getInt("ED.UnitaOrganizzativaCod") );
		description.setUnitaOrganizzativaDescr( iva.getString("ED.UnitaOrganizzativaDescr") );
		
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
		return header;
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

