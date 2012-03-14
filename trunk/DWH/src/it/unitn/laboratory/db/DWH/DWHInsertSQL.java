package it.unitn.laboratory.db.DWH;

import it.unitn.laboratory.db.QueryManager;
import it.unitn.laboratory.db.StagingArea.ConnectionManagerSA;
import it.unitn.laboratory.wrapper.AreaUtenzaType;
import it.unitn.laboratory.wrapper.AssistitoType;
import it.unitn.laboratory.wrapper.CartellaType;
import it.unitn.laboratory.wrapper.ComponenteType;
import it.unitn.laboratory.wrapper.OperatoreType;
import it.unitn.laboratory.wrapper.RichiedenteType;
import it.unitn.laboratory.wrapper.SegnalanteType;
import it.unitn.laboratory.wrapper.TipoTerziType;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.GregorianCalendar;

import javax.xml.datatype.XMLGregorianCalendar;

import com.sun.corba.se.spi.ior.iiop.GIOPVersion;

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
	
	public static void insertVariazioneNucleo(ComponenteType comp, int idPatient, int componenteCod) throws SQLException, ClassNotFoundException 
	{
		Connection con = ConnectionManagerDWH.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO D_NUCLEO_FAMILIARE " +
						"(CODICE_NUCLEO, HASH_COD, GRADO_PARENTELA_COD, GRADO_PARENTELA_DESCR, DATA_NASCITA, ID_ASSISTITO) " +
						"VALUES (?,MD5('"+comp.getHASHCOD()+"'),?,?,?,?)");
		ps.setInt(1, componenteCod);
		ps.setInt(2, comp.getGRADOPARENTELACOD());
		ps.setString(3, comp.getGRADOPARENTELADESCR());
		ps.setDate(4, convertDate(comp.getDATANASCITA()));
		ps.setInt(5, idPatient);
		int res = ps.executeUpdate();
		
		if (res==0) throw new SQLWarning("Inserimanto nucleo familare fallito? check It");
	}

	public static void insertAssistito(AssistitoType assistito) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionManagerDWH.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO D_ASSISTITO " +
				"(ID_ANAGRAFE_LOCALE, MITTENTE_NOME_ENTE, MITTENTE_URL_ENTE, ANAG_URL_ENTE, ANAG_ID_ANAGRAFE, ID_ASS_SOC, HASH_COD" +
				", DATA_NASCITA, COMUNE_NASCITA_COD, COMUNE_NASCITA_DESCR, COMUNE_RESIDENZA_COD, COMUNE_RESIDENZA_DESCR, SESSO, CAP, STATO_CIVILE_COD" +
				", STATO_CIVILE_DESCR, NAZIONALITA_COD, NAZIONALITA_DESCR, CITTADINANZA_COD, CITTADINANZA_DESCR, POLO_COD, POLO_DESCR, ENTE_GESTORE_COD, ENTE_GESTORE_DESCR)" +
				"VALUES (?,?,?,?,?,?,MD5('"+assistito.getHASHCOD()+"'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

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

		int res = ps.executeUpdate();	

		if (res==0) throw new SQLWarning("Inserimanto operatore fallito? check It");
	}

	public static void insertRichiedente(RichiedenteType drichiedente) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionManagerDWH.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO D_RICHIEDENTE " +
						"(RICHIEDENTE_COD, RICHIEDENTE_DESCR) " +
						"VALUES (?,?)");
		ps.setInt(1, drichiedente.getRICHIEDENTECOD());
		ps.setString(2, drichiedente.getRICHIEDENTEDESCR());
		int res = ps.executeUpdate();
		
		if (res==0) throw new SQLWarning("Inserimanto richiedente fallito? check It");
		
	}

	public static void insertTipoTerzi(TipoTerziType dtipoterzi) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionManagerDWH.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO D_TIPO_TERZI " +
						"(TIPO_TERZI_COD, TIPO_TERZI_DESCR, NOME_TERZI) " +
						"VALUES (?,?,?)");
		ps.setInt(1, dtipoterzi.getTIPOTERZICOD());
		ps.setString(2, dtipoterzi.getTIPOTERZIDERCR());
		ps.setString(3, dtipoterzi.getNOMETERZI());
		int res = ps.executeUpdate();
		
		if (res==0) throw new SQLWarning("Inserimanto nucleo familare fallito? check It");
		return;
		
	}

	public static void insertSegnalante(SegnalanteType dsegnalante) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionManagerDWH.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO D_SEGNALANTE " +
						"(SEGNALANTE_COD, SEGNALANTE_DESCR) " +
						"VALUES (?,?)");
		ps.setInt(1, dsegnalante.getSEGNALANTECOD());
		ps.setString(2, dsegnalante.getSEGNALANTEDESCR());
		
		int res = ps.executeUpdate();
		
		if (res==0) throw new SQLWarning("Inserimanto nucleo familare fallito? check It");
		return;
		
	}

	public static void insertFCartella(CartellaType fcartella,
			int idRichiedete, Integer idTipoTerzi, int idSegnalante,
			int idAssistito, int idOperatore) throws SQLException, ClassNotFoundException {
		
		QueryManager qmDWH = new QueryManager(ConnectionManagerDWH.getInstance());
		
		if (qmDWH.checkCartella(idAssistito, convertDate(fcartella.getDATAACCESSO())))
			return;
		
		Connection con = ConnectionManagerDWH.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO F_CARTELLA " +
						"(NUMERO_SCHEDA, PRESA_CARICO_NUM, DATA_ACCESSO, ID_ASSISTITO, ID_SEGNALANTE" +
						", ID_TIPO_TERZI, ID_RICHIEDENTE, ID_OPERATORE, INIZIO_PRESA_CARICO, FINE_PRESA_CARICO, " +
						"GIORNATE_SETTIMANALI, NUMERO_PASTI_SETTIMANALI, NUMERO_TRASPORTI_SETTIMANALI, ORE_SETTIMANALI, DATA_DOMANDA ) " +
						"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
		
		int res = ps.executeUpdate();
		
		if (res==0) throw new SQLWarning("Inserimanto nucleo familare fallito? check It");
		return;
		
	}
	
	public static void insertAreaUtenza(int idAssistito,
			AreaUtenzaType dareautenza) throws ClassNotFoundException, SQLException {
		
		Connection con = ConnectionManagerDWH.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO D_AREA_UTENZA" +
						"(AREA_UTENZA_COD, AREA_UTENZA_DESCR, DATA_INIZIO_VAL, ID_ASSISTITO) " +
						"VALUES (?,?,?,?)");
		ps.setInt(1, dareautenza.getAREAUTENZACOD());
		ps.setString(2, dareautenza.getAREAUTENZADESCR());
		ps.setDate(3, convertDate(dareautenza.getDATAINIZIOVAL()));
		ps.setInt(4, idAssistito);
		
		int res = ps.executeUpdate();
		
		if (res==0) throw new SQLWarning("Inserimento area utenza? check It");
		return;
		
	}
	
	public static void insertRevocaAreaUtenza(int idAssistito,
			AreaUtenzaType dareautenza) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionManagerDWH.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO D_AREA_UTENZA" +
						"(AREA_UTENZA_COD, AREA_UTENZA_DESCR, DATA_FINE_VAL, ID_ASSISTITO) " +
						"VALUES (?,?,?,?)");
		ps.setInt(1, dareautenza.getAREAUTENZACOD());
		ps.setString(2, dareautenza.getAREAUTENZADESCR());
		ps.setDate(3, convertDate(dareautenza.getDATAFINEVAL()));
		ps.setInt(4, idAssistito);
		
		int res = ps.executeUpdate();
		
		if (res==0) throw new SQLWarning("Inserimento revoca area utenza? check It");
		return;
	}
	
	public static Date convertDate(XMLGregorianCalendar data) 
	{
		if(data==null) return null;
		GregorianCalendar c = data.toGregorianCalendar();
		java.util.Date d = c.getTime();
		java.sql.Date sqlDate = new java.sql.Date(d.getTime());
		return sqlDate;
	}




}
