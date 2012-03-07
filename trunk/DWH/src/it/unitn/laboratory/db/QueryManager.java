package it.unitn.laboratory.db;

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
		ps.close();
		return rs;
	}

	public void insertOperatore(OperatoreType operatore) throws SQLException 
	{
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO D_OPERATORE " +
						"( OPERATORE_COD, NOME, COGNOME, POLO_COD, POLO_DESCR, ENTE_GESTORE_COD, ENTE_GESTORE_DESCR ) " +
						"VALUES (?,?,?,?,?,?,?)");
		ps.setInt(1, operatore.getOPERATORECOD());
		ps.setString(2, operatore.getNOME());
		ps.setString(3, operatore.getCOGNOME());
		ps.setInt(4, operatore.getPOLOCOD());
		ps.setString(5, operatore.getPOLODESCR());
		ps.setInt(6, operatore.getENTEGESTORECOD());
		ps.setString(7, operatore.getENTEGESTOREDESCR());
		int res = ps.executeUpdate();
		ps.close();
		if (res==0) throw new SQLWarning("Inserimanto operatore fallito? check It");
	}
}
