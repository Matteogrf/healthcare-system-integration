package it.unitn.laboratory.db.DWH;

import it.unitn.laboratory.db.StagingArea.ConnectionManagerSA;
import it.unitn.laboratory.wrapper.AreaUtenzaType;
import it.unitn.laboratory.wrapper.AssistitoType;
import it.unitn.laboratory.wrapper.CartellaType;
import it.unitn.laboratory.wrapper.ComponenteType;
import it.unitn.laboratory.wrapper.FatturazioneType;
import it.unitn.laboratory.wrapper.NucleoFamiliareType;
import it.unitn.laboratory.wrapper.OperatoreType;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.GregorianCalendar;

import javax.xml.datatype.XMLGregorianCalendar;

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
		
		if (res==0) throw new SQLWarning("Update operatore fallito? check It");
	}

	public static void updateAssistito(AssistitoType assistito, int id) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionManagerDWH.getInstance().getConnection();
		
		PreparedStatement ps = con.prepareStatement("UPDATE D_ASSISTITO SET" +
				" ID_ANAGRAFE_LOCALE = ?," +
				" MITTENTE_NOME_ENTE = ?," +
				" MITTENTE_URL_ENTE = ?," +
				" ANAG_URL_ENTE = ?," +
				" ANAG_ID_ANAGRAFE = ?," +
				" ID_ASS_SOC = ?," +
				" HASH_COD = MD5('"+assistito.getHASHCOD()+"')," +
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
				" POLO_COD = ?," +
				" POLO_DESCR= ?," +
				" ENTE_GESTORE_COD= ?," +
				" ENTE_GESTORE_DESCR=?" +
				" WHERE ID_ASSISTITO =?;" );
		
		
		ps.setInt(1, assistito.getIDANAGRAFELOCALE());
		ps.setString(2, assistito.getMITTENTENOMEENTE());
		ps.setString(3, assistito.getMITTENTEURLENTE());
		ps.setString(4, assistito.getANAGURLENTE());
		ps.setString(5, assistito.getANAGIDANAGRAFE());
		ps.setInt(6, assistito.getIDASSSOC());
		ps.setDate(7, convertDate(assistito.getDATANASCITA()));
		ps.setInt(8, assistito.getCOMUNENASCITACOD());
		ps.setString(9, assistito.getCOMUNENASCITADESCR());
		ps.setInt(10, assistito.getCOMUNERESIDENZACOD());
		ps.setString(11, assistito.getCOMUNERESIDENZADESCR());
		ps.setString(12, assistito.getSESSO());
		ps.setString(13, assistito.getCAP());
		ps.setInt(14, assistito.getSTATOCIVILECOD());
		ps.setString(15, assistito.getSTATOCIVILEDESCR());
		ps.setInt(16, assistito.getNAZIONALITACOD());
		ps.setString(17, assistito.getNAZIONALITADESCR());
		ps.setInt(18, assistito.getCITTADINANZACOD());
		ps.setString(19, assistito.getCITTADINANZADESCR());
		ps.setInt(20, assistito.getPOLOCOD());
		ps.setString(21, assistito.getPOLODESCR());
		ps.setInt(22, assistito.getGESTORECOD());
		ps.setString(23, assistito.getGESTOREDESCR());
		ps.setInt(24, id);
		
		int res = ps.executeUpdate();		
		if (res==0) throw new SQLWarning("Inserimanto operatore fallito? check It");
	}

	public static void updateComponenteNucleo(int id, ComponenteType nuc, int codNuc) throws SQLException, ClassNotFoundException 
	{
		Connection con = ConnectionManagerDWH.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE D_NUCLEO_FAMILIARE SET" +
													" CODICE_NUCLEO = ?," +
													" HASH_COD = MD5('"+nuc.getHASHCOD()+"'),"+
													" GRADO_PARENTELA_COD = ?," +
													" GRADO_PARENTELA_DESCR = ?," +
													" DATA_NASCITA = ?" +
													" WHERE ID_NUCLEO = ?;");
		ps.setInt(1, codNuc);
		ps.setInt(2, nuc.getGRADOPARENTELACOD());
		ps.setString(3, nuc.getGRADOPARENTELADESCR());
		ps.setDate(4, convertDate(nuc.getDATANASCITA()));
		ps.setInt(5, id);
		int res = ps.executeUpdate();
		
		if (res==0) throw new SQLWarning("Update variazione nucleo fallito? check It");
	}
	
	private static Date convertDate(XMLGregorianCalendar data) 
	{
		GregorianCalendar c = data.toGregorianCalendar();
		java.util.Date d = c.getTime();
		java.sql.Date sqlDate = new java.sql.Date(d.getTime());
		return sqlDate;
	}

	public static void updateFCartella(int id, CartellaType fcartella,
			int idRichiedete, Integer idTipoTerzi, int idSegnalante,
			int idAssistito, int idOperatore) throws ClassNotFoundException, SQLException {
		
		Connection con = ConnectionManagerDWH.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE F_CARTELLA SET" +
						" NUMERO_SCHEDA= ?," +
						" PRESA_CARICO_NUM= ?," +
						" DATA_ACCESSO= ?," +
						" ID_ASSISTITO= ?," +
						" ID_SEGNALANTE= ?," +
						" ID_TIPO_TERZI= ?," +
						" ID_RICHIEDENTE= ?," +
						" ID_OPERATORE= ?," +
						" INIZIO_PRESA_CARICO= ?," +
						" FINE_PRESA_CARICO= ?," +
						" GIORNATE_SETTIMANALI= ?," +
						" NUMERO_PASTI_SETTIMANALI= ?," +
						" NUMERO_TRASPORTI_SETTIMANALI= ?," +
						" ORE_SETTIMANALI= ?," +
						" DATA_DOMANDA= ? " +
						" WHERE ID_CARTELLA= ?;");
		ps.setString(1, fcartella.getNUMEROSCHEDA());
		ps.setInt(2, fcartella.getPRESACARICO());
		ps.setDate(3, convertDate(fcartella.getDATAACCESSO()));
		ps.setInt(4, idAssistito);
		ps.setInt(5, idSegnalante);
		ps.setInt(6, idTipoTerzi);
		ps.setInt(7, idRichiedete);
		ps.setInt(8, idOperatore);
		ps.setDate(9,convertDate(fcartella.getINIZIOPRESACARICO()));
		ps.setDate(10, convertDate(fcartella.getFINEPRESACARICO()));
		ps.setInt(11, fcartella.getGIORNATESETTIMANALI());
		ps.setInt(12, fcartella.getNUMEROPASTISETTIMANALI());
		ps.setInt(13, fcartella.getNUMEROTRASPORTISETTIMANALI());
		ps.setInt(14, fcartella.getORESETTIMANALI());
		ps.setDate(15, convertDate(fcartella.getDATADOMANDA()));
		ps.setInt(16, id);
		
		int res = ps.executeUpdate();
		
		if (res==0) throw new SQLWarning("Update f_cartella fallito? check It");
		return;
		
	}
	
	public static void updateFCartella(int id, CartellaType fcartella) throws ClassNotFoundException, SQLException {
		
		Connection con = ConnectionManagerDWH.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE F_CARTELLA SET" +
						" INIZIO_PRESA_CARICO= ?," +
						" PRESA_CARICO_NUM= ?" +
						" WHERE ID_CARTELLA= ?;");
		ps.setDate(1, convertDate(fcartella.getINIZIOPRESACARICO()));
		ps.setInt(2, fcartella.getPRESACARICO());
		ps.setInt(3, id);
		
		int res = ps.executeUpdate();
		
		if (res==0) throw new SQLWarning("Update f_cartella fallito? check It");
		return;
    }

	public static void updateRevocaAreaUtenza(int idAreaUtenza, AreaUtenzaType dareautenza) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionManagerDWH.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE D_AREA_UTENZA SET" +
						" DATA_FINE_VAL= ?" +
						" WHERE ID_AREA_UTENZA= ?;");
		ps.setDate(1, convertDate(dareautenza.getDATAFINEVAL()));
		ps.setInt(2, idAreaUtenza);
		
		int res = ps.executeUpdate();
		
		if (res==0) throw new SQLWarning("Update d_area_utenza fallito? check It");
		return;
	}
	
	public static void updateInizioAreaUtenza(int idAreaUtenza, AreaUtenzaType dareautenza) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionManagerDWH.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE D_AREA_UTENZA SET" +
						" DATA_INIZIO_VAL= ?" +
						" WHERE ID_AREA_UTENZA= ?;");
		ps.setDate(1, convertDate(dareautenza.getDATAINIZIOVAL()));
		ps.setInt(2, idAreaUtenza);
		
		int res = ps.executeUpdate();
		
		if (res==0) throw new SQLWarning("Update d_area_utenza fallito? check It");
		return;
	}

	public static void UpdateSchedaAccesso(int idc, CartellaType fcartella,
			int idRichiedete, Integer idTipoTerzi, int idSegnalante,
			int idAssistito, int idOperatore) throws ClassNotFoundException, SQLException
	{
		Connection con = ConnectionManagerDWH.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE F_CARTELLA SET" +
						" NUMERO_SCHEDA= ?," +						
						" DATA_ACCESSO= ?," +
						" ID_ASSISTITO= ?," +
						" ID_SEGNALANTE= ?," +
						" ID_TIPO_TERZI= ?," +
						" ID_RICHIEDENTE= ?," +
						" ID_OPERATORE= ?" +						
						" WHERE ID_CARTELLA= ?;");
		ps.setString(1, fcartella.getNUMEROSCHEDA());
		ps.setDate(2, convertDate(fcartella.getDATAACCESSO()));
		ps.setInt(3, idAssistito);
		ps.setInt(4, idSegnalante);
		ps.setInt(5, idTipoTerzi);
		ps.setInt(6, idRichiedete);
		ps.setInt(7, idOperatore);
		ps.setInt(8, idc);
		int res = ps.executeUpdate();		
		if (res==0) throw new SQLWarning("Update d_area_utenza fallito? check It");
		return;
	}

	public static void updateFatturazioneInfo(int idFatturazione, int idAssistito, int idErogatore, FatturazioneType ffatturazione) throws ClassNotFoundException, SQLException
	{
		Connection con = ConnectionManagerDWH.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE F_FATTURAZIONE SET " +
						" ID_ASSISTITO = ?," +
						" ID_ENTE_EROGATORE = ?," +
						" DATA_INIZIO = ?," +
						" DATA_FINE = ?," +
						" IMPORTO_FATTURA = ?," +
						" GIORNATE = ?," +
						" ACCESSI_SERVIZIO = ?," +
						" NUMERO_PASTI = ?," +
						" NUMERO_TRASPORTI = ?," +
						" GIORNI_ASSENZA_GIUSTIFICATI = ?," +
						" GIORNI_ASSENZA_NON_GIUSTIFICATI = ?," +
						" ORE_EROGATE = ?," +
						" DATA_FATTURA = ?" +
						" WHERE ID_FATTURA = ? " +
						"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		ps.setInt(1, idAssistito);
		ps.setInt(2, idErogatore);
		ps.setDate(3, convertDate(ffatturazione.getDATAINIZIO()));
		ps.setDate(4, convertDate(ffatturazione.getDATAFINE()));
		ps.setInt(5, ffatturazione.getIMPORTOFATTURA());
		ps.setInt(6, ffatturazione.getGIORNATE());
		ps.setInt(7, ffatturazione.getACCESSOSERVIZIO());
		ps.setInt(8, ffatturazione.getNUMEROPASTI());
		ps.setInt(9, ffatturazione.getNUMEROTRASPORTI());
		ps.setInt(10, ffatturazione.getGIORNIASSENZAGIUSTIFICATI());
		ps.setInt(11, ffatturazione.getGIORNIASSENZANONGIUSTIFICATI());
		ps.setInt(12, ffatturazione.getOREEROGATE());
		ps.setDate(13, convertDate(ffatturazione.getDATAFATTURA()));	
		ps.setInt(14, idFatturazione);	
		int res = ps.executeUpdate();
		
		if (res==0) throw new SQLWarning("Inserimanto operatore fallito? check It");
		
	}

}
