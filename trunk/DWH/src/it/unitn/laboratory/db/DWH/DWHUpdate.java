package it.unitn.laboratory.db.DWH;

import it.unitn.laboratory.db.StagingArea.ConnectionManagerSA;
import it.unitn.laboratory.wrapper.OperatoreType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;

public class DWHUpdate {
	
	public static void updateOperatore(OperatoreType operatore, int id) throws SQLException, ClassNotFoundException 
	{
		Connection con = ConnectionManagerSA.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO D_OPERATORE " +
						"(ID_OPERATORE, OPERATORE_COD, NOME, COGNOME, POLO_COD, POLO_DESCR, ENTE_GESTORE_COD, ENTE_GESTORE_DESCR ) " +
						"VALUES (?,?,?,?,?,?,?,?)");
		ps.setInt(1, id);
		ps.setInt(2, operatore.getOPERATORECOD());
		ps.setString(3, operatore.getNOME());
		ps.setString(4, operatore.getCOGNOME());
		ps.setInt(5, operatore.getPOLOCOD());
		ps.setString(6, operatore.getPOLODESCR());
		ps.setInt(7, operatore.getENTEGESTORECOD());
		ps.setString(8, operatore.getENTEGESTOREDESCR());
		int res = ps.executeUpdate();
		
		if (res==0) throw new SQLWarning("Inserimanto operatore fallito? check It");
	}

}
