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
		PreparedStatement ps  = conn.getConnection().prepareStatement("SELECT * FROM inserimentovariazioneanagrafica I, Events E, EventDescription ED, Header H,  Patient P, nucleofamiliare N  " +
											  "WHERE I.EventoInviato = 0 AND " +
											  "I.EventoAssociato = E.idEvent AND " +
											  "E.IdPatient = P.idAnagrafeLocale AND " +
											  "E.IdHeader = H.IdHeader AND " +
											  "E.IdEventDescr = ED.IdEvent AND " +
											  "E.IdPatient = N.IdPatient;");
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
		PreparedStatement ps  = conn.getConnection().prepareStatement("SELECT * FROM nucleofamiliare N;");		
		return ps.executeQuery();
	}
}
