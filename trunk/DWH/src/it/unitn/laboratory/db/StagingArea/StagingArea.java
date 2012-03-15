package it.unitn.laboratory.db.StagingArea;

import it.unitn.laboratory.db.QueryManager;
import it.unitn.laboratory.db.DWH.DWHInsertSQL;
import it.unitn.laboratory.wrapper.CartellaType;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class StagingArea {

	
	public static void deleteFCartellaInfo(int idAssistito) throws ClassNotFoundException, SQLException 
	{
		Connection con = ConnectionManagerSA.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM F_CARTELLA WHERE ID_ASSISTITO = ?");
		ps.setInt(1, idAssistito);
		ps.executeUpdate();
	}

	public static void getFCartellaInfo(int idAssistito, CartellaType cartella) throws ClassNotFoundException, SQLException, DatatypeConfigurationException 
	{
		Connection con = ConnectionManagerSA.getInstance().getConnection();
		QueryManager qm = new QueryManager(ConnectionManagerSA.getInstance());
		ResultSet rs = qm.findCartella(idAssistito);
		if(rs.next())
		{
			cartella.setPRESACARICO(			rs.getInt("PRESA_CARICO_NUM"));
			cartella.setINIZIOPRESACARICO(		DateToXMLGregorianCalendar(rs.getDate("INIZIO_PRESA_CARICO")));
			cartella.setFINEPRESACARICO(		DateToXMLGregorianCalendar(rs.getDate("FINE_PRESA_CARICO")));
			cartella.setDATADOMANDA(			DateToXMLGregorianCalendar(rs.getDate("DATA_DOMANDA")));
			cartella.setGIORNATESETTIMANALI(	rs.getInt("GIORNATE_SETTIMANALI"));
			cartella.setNUMEROPASTISETTIMANALI(	rs.getInt("NUMERO_PASTI_SETTIMANALI"));
			cartella.setNUMEROTRASPORTISETTIMANALI(rs.getInt("NUMERO_TRASPORTI_SETTIMANALI"));
			cartella.setORESETTIMANALI(			rs.getInt("ORE_SETTIMANALI"));		
		}
	}

	public static XMLGregorianCalendar DateToXMLGregorianCalendar(Date date) throws DatatypeConfigurationException 
	{
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		return  DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);	
	}

	public static void addPresaInCaricoInfo(int idAssistito,
			CartellaType fcartella)  throws ClassNotFoundException, SQLException 
	{
		Connection con = ConnectionManagerSA.getInstance().getConnection();
		QueryManager qm = new QueryManager(ConnectionManagerSA.getInstance());
		ResultSet rs = qm.findCartella(idAssistito);
		if(rs.next())
		{
			// INSERT
			PreparedStatement ps = con.prepareStatement("INSERT INTO F_CARTELLA " +
					"( PRESA_CARICO_NUM, INIZIO_PRESA_CARICO, ID_ASSISTITO  ) " +
					"VALUES (?,?,?)");
			ps.setInt(1, fcartella.getPRESACARICO());
			ps.setDate(2, DWHInsertSQL.convertDate(fcartella.getINIZIOPRESACARICO()));
			ps.setInt(3, idAssistito);
			ps.executeUpdate();
		}
		else qm.updatePresaInCaricoInfo(idAssistito, fcartella);
		
	}



}
