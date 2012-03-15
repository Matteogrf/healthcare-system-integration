package it.unitn.laboratory.dataproducer.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataManager 
{
	ConnectionManager conn;
	public DataManager() throws ClassNotFoundException, SQLException 
	{
		conn = ConnectionManager.getInstance();
	}
	
	public ResultSet getInserimentoVariazioneAnagrafica() throws SQLException
	{
		PreparedStatement ps  = conn.getConnection().prepareStatement("SELECT * FROM inserimentovariazioneanagrafica I, Events E, EventDescription ED, Header H,  Patient P  " +
											  "WHERE ED.TipoEventoCod = 1 AND " +
											  "ED.IdEvent = E.IdEventDescr AND " +											  
											  "I.EventoAssociato = E.idEvent AND " +
											  "I.EventoInviato = 0 AND " +
											  "E.IdPatient = P.idAnagrafeLocale AND " +
											  "E.IdHeader = H.IdHeader AND " +
											  "E.IdEventDescr = ED.IdEvent; ");
		return ps.executeQuery();
	}
	
	public ResultSet getComponentiNucleoFamiliare(int codiceNucleo) throws ClassNotFoundException, SQLException 
	{
		PreparedStatement ps  = conn.getConnection().prepareStatement("SELECT * FROM nucleofamiliare N, patient P" +
											" WHERE N.CodiceNucleo = ? AND" +
											" N.IdPatient = P.IdAnagrafeLocale; ");
		ps.setInt(1, codiceNucleo);
		return ps.executeQuery();
	}

	public ResultSet getNucleiFamiliari() throws SQLException
	{
		PreparedStatement ps  = conn.getConnection().prepareStatement("SELECT * FROM Events E, EventDescription ED, Header H,  Patient P, nucleofamiliare N  " +
				 "WHERE ED.TipoEventoCod = 2 AND " +
				  "ED.IdEvent = E.IdEventDescr AND " +
				  "E.IdPatient = P.idAnagrafeLocale AND " +
				  "E.IdHeader = H.IdHeader AND " +				  
				  "N.IdPatient = E.IdPatient;");	
		return ps.executeQuery();
	}

	public ResultSet getPreseInCarico() throws SQLException
	{
		PreparedStatement ps  = conn.getConnection().prepareStatement("SELECT * FROM Events E, EventDescription ED, Header H, Patient P, presaincarico PI" +
				  " WHERE ED.TipoEventoCod = 4 AND " +
				  "ED.IdEvent = E.IdEventDescr AND " +
				  "E.IdPatient = P.idAnagrafeLocale AND " +
				  "E.IdHeader = H.IdHeader AND " +
				  "E.idEvent = PI.EventoAssociato;");			  
				 
		return ps.executeQuery();
	}
	
	public ResultSet getChiusuraPreseInCarico() throws SQLException
	{
		PreparedStatement ps  = conn.getConnection().prepareStatement("SELECT * FROM Events E, EventDescription ED, Header H, Patient P, presaincarico PI" +
				  " WHERE ED.TipoEventoCod = 5 AND " +
				  "ED.IdEvent = E.IdEventDescr AND " +
				  "E.IdPatient = P.idAnagrafeLocale AND " +
				  "E.IdHeader = H.IdHeader AND " +
				  "E.idEvent = PI.EventoAssociato;");			  
				 
		return ps.executeQuery();
	}

	public ResultSet getSchedaAccesso() throws SQLException 
	{
		PreparedStatement ps  = conn.getConnection().prepareStatement("SELECT * FROM Events E, EventDescription ED, Header H, Patient P, schedaaccesso S " +
				  "WHERE ED.TipoEventoCod = 3 AND " +
				  "ED.IdEvent = E.IdEventDescr AND " +
				  "E.IdPatient = P.idAnagrafeLocale AND " +
				  "E.IdHeader = H.IdHeader AND " +
				  "E.idEvent = S.NumeroScheda;");			  
				 
		return ps.executeQuery();
	}

	public ResultSet getAssegnazioneAreaUtenza() throws SQLException 
	{		
			PreparedStatement ps  = conn.getConnection().prepareStatement("SELECT * FROM Events E, EventDescription ED, Header H, Patient P, assegnazionedatautenza A " +
					  "WHERE ED.TipoEventoCod = 6 AND " +
					  "ED.IdEvent = E.IdEventDescr AND " +
					  "E.IdPatient = P.idAnagrafeLocale AND " +
					  "E.IdHeader = H.IdHeader AND " +
					  "A.EventoAssociato = E.idEvent;");			  
					 
			return ps.executeQuery();		
	}

	public ResultSet getDomandeAmministrative() throws SQLException 
	{
		PreparedStatement ps  = conn.getConnection().prepareStatement("SELECT * FROM Events E, EventDescription ED, Header H, Patient P, ricezionedomandaamministrativa R " +
				  "WHERE ED.TipoEventoCod = 9 AND " +
				  "ED.IdEvent = E.IdEventDescr AND " +
				  "E.IdPatient = P.idAnagrafeLocale AND " +
				  "E.IdHeader = H.IdHeader AND " +
				  "R.IdRicezione = E.idEvent;");			  
				 
		return ps.executeQuery();		
		
	}


}
