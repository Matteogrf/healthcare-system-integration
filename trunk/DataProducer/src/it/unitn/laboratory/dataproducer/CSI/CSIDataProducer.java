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


import it.unitn.laboratory.dataproducer.CommonPerocedures;
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
		//CreateInserimentoVariazioneAnagrafica();
		System.out.println("\nInvio Nucleo Familiare");
		//CreateInserimentoNucleoFamiliare();
		System.out.println("\nInvio Assegnazione Area Utenza");
		//CreateAssegnazioneAreaUtenza();
		System.out.println("\nInvio Revoca Area Utenza");
		//CreateRevocaAreaUtenza();
		System.out.println("\nInvio Scheda accesso");
		CreateSchedaAccesso();
		System.out.println("\nInvio Presa in carico");
		//CreatePresaInCarico();
		System.out.println("\nInvio Chiura presa in carico");
		CreateChiusuraPresaInCarico();
	}
	

	private static void CreateRevocaAreaUtenza() throws SQLException, DatatypeConfigurationException 
	{
		ResultSet pic = dataM.getAssegnazioneAreaUtenza();
		ObjectFactory of = new ObjectFactory();	
		while(pic.next())
		{
			EventType event = CommonPerocedures.setCommonPart(pic);
			event.setEvento(extractRevocaAreaUtenza(pic,of));
			OperationType operation = of.createOperationType();
			operation.setOperazioneCod("7");
			operation.setOperazioneDescr("RevocaAreaUtenza");
			event.getDescrizione().setTipoEventoCod(7);
			event.getDescrizione().setTipoEventoDescr("RevocaAreaUtenza");
			event.setOperazione(operation);
			String res=new Events_Service().getEventsSOAP().sendEvent(event);
		
			System.out.println("\tRes sendEvent: "+res);
		}		
	}

	private static BodyType extractRevocaAreaUtenza(ResultSet pic,
			ObjectFactory of) throws SQLException, DatatypeConfigurationException 
	{
		RevocaAreaUtenzaType r = of.createRevocaAreaUtenzaType();
		
		r.setAreaUtenzaCod( pic.getString("AreaUtenzaCod") );
		r.setAreaUtenzaDescr( pic.getString("AreaUtenzaString") );
		r.setPresaCaricoNum( pic.getInt("PresaInCaricoNum") );
		r.setDataFineValidita(CommonPerocedures.DateToXMLGregorianCalendar(pic.getDate("DataInizioValidita")));
		BodyType b = of.createBodyType();
		b.setRevocaAreaUtenza(r);
		return b;
	}

	private static void CreateChiusuraPresaInCarico() throws SQLException, DatatypeConfigurationException 
	{
		ResultSet rs = dataM.getChiusuraPreseInCarico();
		ObjectFactory of = new ObjectFactory();	
		while(rs.next())
		{					
			EventType event = CommonPerocedures.setCommonPart(rs);
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

		ChiusuraPresaInCaricoType pic = of.createChiusuraPresaInCaricoType();

		pic.setPresaCaricoNum(rs.getInt("PI.PresaInCaricoNum"));

		pic.setFinePresaInCarico(CommonPerocedures.DateToXMLGregorianCalendar(rs.getDate("PI.ChiusuraData")));

		BodyType b = of.createBodyType();
		b.setChiusuraPresaInCarico(pic);
		return b;
	}

	private static void CreateSchedaAccesso() throws SQLException, DatatypeConfigurationException 
	{
		ResultSet rs = dataM.getSchedaAccesso();
		ObjectFactory of = new ObjectFactory();	
		while(rs.next())
		{					
			EventType event = CommonPerocedures.setCommonPart(rs);
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
		sac.setDataAccesso(CommonPerocedures.DateToXMLGregorianCalendar(rs.getDate("S.DataAccesso")));
		
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
			EventType event = CommonPerocedures.setCommonPart(rs);
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
		pic.setInizioPresaInCarico(CommonPerocedures.DateToXMLGregorianCalendar(rs.getDate("PI.PresaInCaricoData")));
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
			EventType event = CommonPerocedures.setCommonPart(pic);
			event.setEvento(extractAssegnazioneAreaUtenza(pic,of));
			OperationType operation = of.createOperationType();
			operation.setOperazioneCod("6");
			operation.setOperazioneDescr("AssegnazioneAreaUtenza");
			event.setOperazione(operation);
			String res=new Events_Service().getEventsSOAP().sendEvent(event);
		
			System.out.println("\tRes sendEvent: "+res);
		}
	}

	private static BodyType extractAssegnazioneAreaUtenza(ResultSet pic, ObjectFactory of) throws SQLException, DatatypeConfigurationException 
	{
		AssegnazioneAreaUtenzaType a = of.createAssegnazioneAreaUtenzaType();
		
		a.setAreaUtenzaCod( pic.getString("AreaUtenzaCod") );
		a.setAreaUtenzaDescr( pic.getString("AreaUtenzaString") );
		a.setPresaCaricoNum( pic.getInt("PresaInCaricoNum") );
		a.setDataInizioValidita(CommonPerocedures.DateToXMLGregorianCalendar(pic.getDate("DataInizioValidita")));
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
			
			EventType event = CommonPerocedures.setCommonPart(ev);
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
			c.setDataNascita( CommonPerocedures.DateToXMLGregorianCalendar(rs.getDate("P.DataNascita"))  );
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
		ObjectFactory of = new ObjectFactory();	
		while(iva.next())
		{
			EventType event = CommonPerocedures.setCommonPart(iva);
			event.setEvento(extractEventInserimentoVariazioneAnagrafica(iva,of));
			OperationType operation = of.createOperationType();
			operation.setOperazioneCod("1");
			operation.setOperazioneDescr("Inserimento");
		
			String res=new Events_Service().getEventsSOAP().sendEvent(event);
			System.out.println("\tRes sendEvent: "+res);
		}			
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


}

