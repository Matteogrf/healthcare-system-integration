package it.unitn.laboratory.db.StagingArea;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import it.unitn.laboratory.db.ConnectionManager;
import it.unitn.laboratory.db.QueryManager;
import it.unitn.laboratory.db.DWH.DWHInsertSQL;
import it.unitn.laboratory.db.DWH.DWHUpdateSQL;
import it.unitn.laboratory.wrapper.AssistitoType;
import it.unitn.laboratory.wrapper.OperatoreType;

public class UpdateDWH {

	public UpdateDWH() {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Update data from StaginArea to DWH
		UpdateDWH up = new UpdateDWH();
		try {
			up.updateAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void updateAll() throws ClassNotFoundException, SQLException, DatatypeConfigurationException {

		ConnectionManager cm = ConnectionManagerSA.getInstance();
		
		this.updateD_Operatore(cm);
		this.updateD_Assistito(cm);

	}

	private void updateD_Operatore(ConnectionManager cm) throws SQLException, ClassNotFoundException {
		
		String table = "D_OPERATORE";
		QueryManager qm = new QueryManager(cm);
		ResultSet rs = qm.findAll(table);
		
		int id;
		OperatoreType o;
		while(rs.next()){
			
			o = new OperatoreType();
			o.setCOGNOME(rs.getString("COGNOME"));
			o.setNOME(rs.getString("NOME"));
			o.setENTEGESTORECOD(rs.getInt("ENTE_GESTORE_COD"));
			o.setENTEGESTOREDESCR(rs.getString("ENTE_GESTORE_DESCR"));
			o.setOPERATORECOD(rs.getInt("OPERATORE_COD"));
			o.setPOLOCOD(rs.getInt("POLO_COD"));
			o.setPOLODESCR(rs.getString("POLO_DESCR"));
			
			id = rs.getInt("ID_OPERATORE");
			
			if(id >0)
				DWHUpdateSQL.updateOperatore(o, id);				
			else
				DWHInsertSQL.insertOperatore(o);
		}
			
	}

	private void updateD_Assistito(ConnectionManager cm) throws SQLException, ClassNotFoundException, DatatypeConfigurationException {
		String table = "D_ASSISTITO";
		QueryManager qm = new QueryManager(cm);
		ResultSet rs = qm.findAll(table);
		
		int id;
		AssistitoType i;
		while(rs.next()){
			
			i = new AssistitoType();
			i.setANAGIDANAGRAFE(rs.getString("ANAG_ID_ANAGRAFE"));
			i.setANAGURLENTE(rs.getString("ANAG_URL_ENTE"));
			i.setCAP(rs.getString("CAP"));
			i.setCITTADINANZACOD(rs.getInt("CITTADINANZA_COD"));
			i.setCITTADINANZADESCR(rs.getString("CITTADINANZA_DESCR"));
			i.setCOMUNENASCITACOD(rs.getInt("COMUNE_NASCITA_COD"));
			i.setCOMUNENASCITADESCR(rs.getString("COMUNE_NASCITA_DESCR"));
			i.setCOMUNERESIDENZACOD(rs.getInt("COMUNE_RESIDENZA_COD"));
			i.setCOMUNERESIDENZADESCR(rs.getString("COMUNE_RESIDENZA_DESCR"));
			i.setDATANASCITA(DateToXMLGregorianCalendar(rs.getDate("DATA_NASCITA")));
			i.setGESTORECOD(rs.getInt("ENTE_GESTORE_COD"));
			i.setGESTOREDESCR(rs.getString("ENTE_GESTORE_DESCR"));
			i.setHASHCOD(rs.getString("HASH_COD"));
			i.setIDANAGRAFELOCALE(rs.getInt("ID_ANAGRAFE_LOCALE"));
			i.setIDASSISTITO(rs.getInt("ID_ASSISTITO"));
			i.setIDASSSOC(rs.getInt("ID_ASS_SOC"));
			i.setMITTENTENOMEENTE(rs.getString("MITTENTE_NOME_ENTE"));
			i.setMITTENTEURLENTE(rs.getString("MITTENTE_URL_ENTE"));
			i.setNAZIONALITACOD(rs.getInt("NAZIONALITA_COD"));
			i.setNAZIONALITADESCR(rs.getString("NAZIONALITA_DESCR"));
			i.setPOLOCOD(rs.getInt("POLO_COD"));
			i.setPOLODESCR(rs.getString("POLO_DESCR"));
			i.setSESSO(rs.getString("SESSO"));
			i.setSTATOCIVILECOD(rs.getInt("STATO_CIVILE_COD"));
			i.setSTATOCIVILEDESCR(rs.getString("STATO_CIVILE_DESCR"));
			
			id = rs.getInt("ID_ASSISTITO");
			
			if(id >0)
				DWHUpdateSQL.updateAssistito(i, id);				
			else
				DWHInsertSQL.insertAssistito(i);
		}
	}
	
	public static XMLGregorianCalendar DateToXMLGregorianCalendar(Date date) throws DatatypeConfigurationException 
	{
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		return  DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);	
	}
	}

