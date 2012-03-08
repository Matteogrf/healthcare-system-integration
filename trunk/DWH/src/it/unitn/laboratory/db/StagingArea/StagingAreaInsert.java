package it.unitn.laboratory.db.StagingArea;

import it.unitn.laboratory.wrapper.AssistitoType;
import it.unitn.laboratory.wrapper.OperatoreType;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.GregorianCalendar;

import javax.xml.datatype.XMLGregorianCalendar;

public class StagingAreaInsert 
{

	public static void insertOperatore(OperatoreType operatore, int id) throws SQLException, ClassNotFoundException 
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

	public static void insertAssistito(int id, AssistitoType assistito, OperatoreType operatore) throws ClassNotFoundException, SQLException 
	{		
		Connection con = ConnectionManagerSA.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO D_ASSISTITO " +
				"VALUES (?,?,?,?,?,?,?,MD5('"+assistito.getHASHCOD()+"'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

		ps.setInt(1, id);
		ps.setInt(2, assistito.getIDANAGRAFELOCALE());
		ps.setString(3, assistito.getMITTENTENOMEENTE());
		ps.setString(4, assistito.getMITTENTEURLENTE());
		ps.setString(5, assistito.getANAGURLENTE());
		ps.setString(6, assistito.getANAGIDANAGRAFE());
		ps.setInt(7, assistito.getIDASSSOC());
		ps.setDate(8, convertDate(assistito.getDATANASCITA()));
		ps.setInt(9, assistito.getCOMUNENASCITACOD());
		ps.setString(10, assistito.getCOMUNENASCITADESCR());
		ps.setInt(11, assistito.getCOMUNERESIDENZACOD());
		ps.setString(12, assistito.getCOMUNERESIDENZADESCR());
		ps.setString(13, assistito.getSESSO());
		ps.setString(13, assistito.getCAP());
		ps.setInt(14, assistito.getSTATOCIVILECOD());
		ps.setString(15, assistito.getSTATOCIVILEDESCR());
		ps.setInt(16, assistito.getNAZIONALITACOD());
		ps.setString(17, assistito.getNAZIONALITADESCR());
		ps.setInt(18, assistito.getCITTADINANZACOD());
		ps.setString(19, assistito.getCITTADINANZADESCR());
		ps.setInt(20, assistito.getPOLOCOD());
		ps.setString(21, assistito.getPOLODESCR());
		ps.setInt(22, operatore.getENTEGESTORECOD());
		ps.setString(23, operatore.getENTEGESTOREDESCR());

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
