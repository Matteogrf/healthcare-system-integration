package it.unitn.laboratory.db.StagingArea;

import it.unitn.laboratory.db.QueryManager;
import it.unitn.laboratory.db.DWH.ConnectionManagerDWH;
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

public class StagingArea
{

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
		if (rs.next())
		{
			cartella.setPRESACARICO(rs.getInt("PRESA_CARICO_NUM"));
			cartella.setINIZIOPRESACARICO(DateToXMLGregorianCalendar(rs.getDate("INIZIO_PRESA_CARICO")));
			cartella.setFINEPRESACARICO(DateToXMLGregorianCalendar(rs.getDate("FINE_PRESA_CARICO")));
			cartella.setDATADOMANDA(DateToXMLGregorianCalendar(rs.getDate("DATA_DOMANDA")));
			cartella.setGIORNATESETTIMANALI(rs.getInt("GIORNATE_SETTIMANALI"));
			cartella.setNUMEROPASTISETTIMANALI(rs.getInt("NUMERO_PASTI_SETTIMANALI"));
			cartella.setNUMEROTRASPORTISETTIMANALI(rs.getInt("NUMERO_TRASPORTI_SETTIMANALI"));
			cartella.setORESETTIMANALI(rs.getInt("ORE_SETTIMANALI"));
		}
	}

	public static XMLGregorianCalendar DateToXMLGregorianCalendar(Date date) throws DatatypeConfigurationException
	{
		if (date == null) return null;
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
	}

	public static void addPresaInCaricoInfo(int idAssistito, CartellaType fcartella) throws ClassNotFoundException, SQLException
	{
		Connection con = ConnectionManagerSA.getInstance().getConnection();
		QueryManager qm = new QueryManager(ConnectionManagerSA.getInstance());
		ResultSet rs = qm.findCartella(idAssistito);
		if (!rs.next())
		{
			// INSERT
			PreparedStatement ps = con.prepareStatement("INSERT INTO F_CARTELLA " + "( PRESA_CARICO_NUM, INIZIO_PRESA_CARICO, ID_ASSISTITO  ) " + "VALUES (?,?,?)");
			ps.setInt(1, fcartella.getPRESACARICO());
			ps.setDate(2, DWHInsertSQL.convertDate(fcartella.getINIZIOPRESACARICO()));
			ps.setInt(3, idAssistito);
			ps.executeUpdate();
		} else
			qm.updatePresaInCaricoInfo(idAssistito, fcartella);

	}

	public static void addOperatoreInCartella(int idAssistito, int idOperatore) throws ClassNotFoundException, SQLException
	{

		Connection conSA = ConnectionManagerSA.getInstance().getConnection();

		QueryManager qmSA = new QueryManager(ConnectionManagerSA.getInstance());
		QueryManager qmDWH = new QueryManager(ConnectionManagerDWH.getInstance());

		ResultSet rs = qmDWH.findCartella(idAssistito);

		if (rs.next())
			qmDWH.updateIdOperatoreInCartella(idAssistito, idOperatore);
		else
		{
			rs = qmSA.findCartella(idAssistito);

			if (rs.next())
				qmSA.updateIdOperatoreInCartella(idAssistito, idOperatore);
			else
			{
				// INSERT
				PreparedStatement ps = conSA.prepareStatement("INSERT INTO F_CARTELLA " + "( ID_ASSISTITO, ID_OPERATORE  ) " + "VALUES (?,?)");
				ps.setInt(1, idAssistito);
				ps.setInt(2, idOperatore);
				ps.executeUpdate();
			}
		}
	}

	public static void addAreaUtenzaInfo(int idAssistito, int presacarico) throws ClassNotFoundException, SQLException
	{
		Connection con = ConnectionManagerSA.getInstance().getConnection();
		QueryManager qm = new QueryManager(ConnectionManagerSA.getInstance());
		ResultSet rs = qm.findCartella(idAssistito);
		if (!rs.next())
		{
			// INSERT
			PreparedStatement ps = con.prepareStatement("INSERT INTO F_CARTELLA " + "( PRESA_CARICO_NUM, ID_ASSISTITO  ) " + "VALUES (?,?)");
			ps.setInt(1, presacarico);
			ps.setInt(2, idAssistito);
			ps.executeUpdate();
		} else
			qm.updateAreaUtenzaInfo(idAssistito, presacarico);

	}

	public static void addChiusuraPresaInCaricoInfo(int idAssistito, CartellaType fcartella) throws ClassNotFoundException, SQLException
	{
		Connection con = ConnectionManagerSA.getInstance().getConnection();
		QueryManager qm = new QueryManager(ConnectionManagerSA.getInstance());
		ResultSet rs = qm.findCartella(idAssistito);
		if (!rs.next())
		{
			// INSERT
			PreparedStatement ps = con.prepareStatement("INSERT INTO F_CARTELLA " + "( PRESA_CARICO_NUM, FINE_PRESA_CARICO, ID_ASSISTITO  ) " + "VALUES (?,?,?)");
			ps.setInt(1, fcartella.getPRESACARICO());
			ps.setDate(2, DWHInsertSQL.convertDate(fcartella.getFINEPRESACARICO()));
			ps.setInt(3, idAssistito);
			ps.executeUpdate();
		} else
			qm.updateChiusuraPresaInCaricoInfo(idAssistito, fcartella);
		
	}

	public static void addDomandaAmministrativaInfo(int idAssistito, CartellaType fcartella) throws ClassNotFoundException, SQLException
	{
		Connection con = ConnectionManagerSA.getInstance().getConnection();
		QueryManager qm = new QueryManager(ConnectionManagerSA.getInstance());
		ResultSet rs = qm.findCartella(idAssistito);
		if (!rs.next())
		{
			// INSERT
			PreparedStatement ps = con.prepareStatement("INSERT INTO F_CARTELLA " + "( DATA_DOMANDA, ID_ASSISTITO, GIORNATE_SETTIMANALI, NUMERO_PASTI_SETTIMANALI" +
														", NUMERO_TRASPORTI_SETTIMANALI, ORE_SETTIMANALI) " + "VALUES (?.?,?,?,?,?)");
	    	ps.setDate(1, DWHInsertSQL.convertDate(fcartella.getDATADOMANDA()));
			ps.setInt(2, idAssistito);
			ps.setInt(3, fcartella.getGIORNATESETTIMANALI());
			ps.setInt(4, fcartella.getNUMEROPASTISETTIMANALI());
			ps.setInt(5, fcartella.getNUMEROTRASPORTISETTIMANALI());
			ps.setInt(6, fcartella.getORESETTIMANALI());
			
			ps.executeUpdate();
		} 
		else
	   	    qm.updateDomandaAmministrativaInfo(idAssistito, fcartella);

		
	}

}
