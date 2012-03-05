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
											  "WHERE I.EventoInviato = 0 AND " +
											  "I.EventoAssociato = E.idEvent AND " +
											  "E.IdPatient = P.idAnagrafeLocale AND " +
											  "E.IdHeader = H.IdHeader AND " +
											  "E.IdEventDescr = ED.IdEvent;");
		return ps.executeQuery();
	}
}
