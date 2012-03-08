package it.unitn.laboratory.db;

import it.unitn.laboratory.wrapper.AssistitoType;
import it.unitn.laboratory.wrapper.OperatoreType;

import java.sql.*;

public class QueryManager 
{
	private ConnectionManager cm;
	public QueryManager( ConnectionManager cm ) 
	{
		this.cm = cm;
	}
	
	public ResultSet findOperatore(int operatoreCod, int poloCod, int enteGestoreCod) throws SQLException
	{
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM D_OPERATORE AS D " +
							 "WHERE D.OPERATORE_COD = ? AND " +
							 "D.POLO_COD = ? AND " +
							 "D.ENTE_GESTORE_COD = ?;");
		ps.setInt(1, operatoreCod);
		ps.setInt(2, poloCod);
		ps.setInt(3, enteGestoreCod);
		ResultSet rs = ps.executeQuery();
		
		return rs;
	}

	
	public ResultSet findAssistito(AssistitoType assistito) throws SQLException 
	{
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM D_ASSISTITO " +
								" WHERE HASH_COD = MD5('"+assistito.getHASHCOD()+"')" +
								" AND ID_ANAGRAFE_LOCALE = ?;");
		ps.setInt(1, assistito.getIDANAGRAFELOCALE());
		return ps.executeQuery();
	}
	
	public ResultSet findAll(String tableName) throws SQLException 
	{
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM "+tableName+" ;");
		
		return ps.executeQuery();
	}
}
