package it.unitn.laboratory.db.DWH;

import it.unitn.laboratory.db.StagingArea.ConnectionManagerSA;
import it.unitn.laboratory.wrapper.AssistitoType;
import it.unitn.laboratory.wrapper.OperatoreType;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.GregorianCalendar;

import javax.xml.datatype.XMLGregorianCalendar;

public class DWHInsertSQL {

	public static void insertOperatore(OperatoreType operatore) throws SQLException, ClassNotFoundException 
	{
		Connection con = ConnectionManagerDWH.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO D_OPERATORE " +
						"(OPERATORE_COD, NOME, COGNOME, POLO_COD, POLO_DESCR, ENTE_GESTORE_COD, ENTE_GESTORE_DESCR ) " +
						"VALUES (?,?,?,?,?,?,?)");
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

	public static void insertAssistito(AssistitoType assistito) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionManagerDWH.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO D_ASSISTITO " +
				"(ID_ANAGRAFE_LOCALE, MITTENTE_NOME_ENTE, MITTENTE_URL_ENTE, ANAG_URL_ENTE, ANAG_ID_ANAGRAFE, ID_ASS_SOC, HASH_COD" +
				", DATA_NASCITA, COMUNE_NASCITA_COD, COMUNE_NASCITA_DESCR, COMUNE_RESIDENZA_COD, COMUNE_RESIDENZA_DESCR, SESSO, CAP, STATO_CIVILE_COD" +
				", STATO_CIVILE_DESCR, NAZIONALITA_COD, NAZIONALITA_DESCR, CITTADINANZA_COD, CITTADINANZA_DESCR, POLO_COD, POLO_DESCR, ENTE_GESTORE_COD, ENTE_GESTORE_DESCR)" +
				"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

		ps.setInt(1, assistito.getIDANAGRAFELOCALE());
		ps.setString(2, assistito.getMITTENTENOMEENTE());
		ps.setString(3, assistito.getMITTENTEURLENTE());
		ps.setString(4, assistito.getANAGURLENTE());
		ps.setString(5, assistito.getANAGIDANAGRAFE());
		ps.setInt(6, assistito.getIDASSSOC());
		ps.setString(7, assistito.getHASHCOD());
		ps.setDate(8, convertDate(assistito.getDATANASCITA()));
		ps.setInt(9, assistito.getCOMUNENASCITACOD());
		ps.setString(10, assistito.getCOMUNENASCITADESCR());
		ps.setInt(11, assistito.getCOMUNERESIDENZACOD());
		ps.setString(12, assistito.getCOMUNERESIDENZADESCR());
		ps.setString(13, assistito.getSESSO());
		ps.setString(14, assistito.getCAP());
		ps.setInt(15, assistito.getSTATOCIVILECOD());
		ps.setString(16, assistito.getSTATOCIVILEDESCR());
		ps.setInt(17, assistito.getNAZIONALITACOD());
		ps.setString(18, assistito.getNAZIONALITADESCR());
		ps.setInt(19, assistito.getCITTADINANZACOD());
		ps.setString(20, assistito.getCITTADINANZADESCR());
		ps.setInt(21, assistito.getPOLOCOD());
		ps.setString(22, assistito.getPOLODESCR());
		ps.setInt(23, assistito.getGESTORECOD());
		ps.setString(24, assistito.getGESTOREDESCR());

		int res = ps.executeUpdate();	

		if (res==0) throw new SQLWarning("Inserimanto operatore fallito? check It");
	}
	
	private static Date convertDate(XMLGregorianCalendar data) 
	{
		GregorianCalendar c = data.toGregorianCalendar();
		java.util.Date d = c.getTime();
		java.sql.Date sqlDate = new java.sql.Date(d.getTime());
		return sqlDate;
	}
}
