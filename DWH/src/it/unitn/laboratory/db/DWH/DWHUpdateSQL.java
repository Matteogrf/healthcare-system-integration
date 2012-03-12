package it.unitn.laboratory.db.DWH;

import it.unitn.laboratory.db.StagingArea.ConnectionManagerSA;
import it.unitn.laboratory.wrapper.AssistitoType;
import it.unitn.laboratory.wrapper.OperatoreType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;

public class DWHUpdateSQL {
	
	public static void updateOperatore(OperatoreType operatore, int id) throws SQLException, ClassNotFoundException 
	{
		Connection con = ConnectionManagerDWH.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE D_OPERATORE SET" +
													" OPERATORE_COD = ?," +
													" NOME = ?," +
													" COGNOME = ?," +
													" POLO_COD = ?," +
													" POLO_DESCR = ?," +
													" ENTE_GESTORE_COD = ?," +
													" ENTE_GESTORE_DESCR = ? " +
													" WHERE ID_OPERATORE = ?;");
		ps.setInt(8, id);
		ps.setInt(1, operatore.getOPERATORECOD());
		ps.setString(2, operatore.getNOME());
		ps.setString(3, operatore.getCOGNOME());
		ps.setInt(4, operatore.getPOLOCOD());
		ps.setString(5, operatore.getPOLODESCR());
		ps.setInt(6, operatore.getENTEGESTORECOD());
		ps.setString(7, operatore.getENTEGESTOREDESCR());
		int res = ps.executeUpdate();
		
		if (res==0) throw new SQLWarning("Inserimanto operatore fallito? check It");
	}

	public static void updateAssistito(AssistitoType i, int id) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionManagerDWH.getInstance().getConnection();
		
		PreparedStatement ps = con.prepareStatement("UPDATE D_ASSISTITO SET" +
				" ID_ANAGRAFE_LOCALE = ?," +
				" MITTENTE_NOME_ENTE = ?," +
				" MITTENTE_URL_ENTE = ?," +
				" ANAGRAFE_URL_ENTE = ?," +
				" ANAG_ID_ANAGRAFE = ?," +
				" ID_ASS_SOC = ?," +
				" HASH_COD = ?," +
				" DATA_NASCITA =?," +
				" COMUNE_NASCITA_COD= ?," +
				" COMUNE_NASCITA_DESCR= ?," +
				" COMUNE_RESIDENZA_COD= ?," +
				" COMUNE_RESIDENZA_DESCR= ?," +
				" SESSO= ?," +
				" CAP= ?," +
				" STATO_CIVILE_COD= ?," +
				" STATO_CIVILE_DESCR= ?," +
				" NAZIONALITA_COD= ?," +
				" NAZIONALITA_DESCR= ?," +
				" CITTADINANZA_COD= ?," +
				" CITTADINANZA_DESCR= ?," +
				" POLO_COD, POLO_DESCR= ?," +
				" ENTE_GESTORE_COD= ?," +
				" ENTE_GESTORE_DESCR=?" );
		
		int res = ps.executeUpdate();		
		if (res==0) throw new SQLWarning("Inserimanto operatore fallito? check It");
	}

}
