package it.unitn.laboratory.db;

import it.unitn.laboratory.db.DWH.DWHInsertSQL;
import it.unitn.laboratory.wrapper.AssistitoType;
import it.unitn.laboratory.wrapper.CartellaType;
import it.unitn.laboratory.wrapper.ComponenteType;
import it.unitn.laboratory.wrapper.EnteErogatoreType;
import it.unitn.laboratory.wrapper.OperatoreType;
import it.unitn.laboratory.wrapper.RichiedenteType;
import it.unitn.laboratory.wrapper.SegnalanteType;
import it.unitn.laboratory.wrapper.TipoTerziType;

import java.sql.*;

import javax.xml.datatype.XMLGregorianCalendar;

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
		
		return rs;
	}

	
	public ResultSet findAssistito(AssistitoType assistito) throws SQLException 
	{
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM D_ASSISTITO " +
								" WHERE HASH_COD = MD5('"+assistito.getHASHCOD()+"')" +
								" AND ID_ANAGRAFE_LOCALE = ?;");
		ps.setInt(1, assistito.getIDANAGRAFELOCALE());
		return ps.executeQuery();
	}
	

	
	public int findIdAssistito(String hashcod) throws SQLException 
	{
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM D_ASSISTITO " +
								" WHERE HASH_COD = MD5('"+hashcod+"')");
		ResultSet rs = ps.executeQuery();
		if(rs.next()) return rs.getInt("ID_ASSISTITO");
		return 0;
	}
	
	public ResultSet findComponenteNucleo(ComponenteType comp, int nucleo) throws SQLException 
	{
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM D_NUCLEO_FAMILIARE " +
								" WHERE HASH_COD = MD5('"+comp.getHASHCOD()+"')" +
								" AND CODICE_NUCLEO = "+nucleo+";");
		return ps.executeQuery();
	}
	
	public ResultSet findAll(String tableName) throws SQLException 
	{
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM "+tableName+" ;");
		
		return ps.executeQuery();
	}

	public ResultSet findRichiedente(RichiedenteType drichiedente) throws SQLException {
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM D_RICHIEDENTE" +
												    " WHERE RICHIEDENTE_COD="+drichiedente.getRICHIEDENTECOD()+";");
		
		return ps.executeQuery();
	}

	public ResultSet findTipoTerzi(TipoTerziType dtipoterzi) throws SQLException {
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM D_TIPO_TERZI" +
												    " WHERE TIPO_TERZI_COD="+dtipoterzi.getTIPOTERZICOD()+";");
		
		return ps.executeQuery();
	}

	public ResultSet findSegnalante(SegnalanteType dsegnalante) throws SQLException {
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM D_SEGNALANTE" +
												    " WHERE SEGNALANTE_COD="+dsegnalante.getSEGNALANTECOD()+";");
		
		return ps.executeQuery();
	}

	public int findIdAssistito(AssistitoType dassistito) throws SQLException {
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM D_ASSISTITO " +
								" WHERE HASH_COD = MD5('"+dassistito.getHASHCOD()+"')");
		ResultSet rs = ps.executeQuery();

		if(!rs.next())
			return 0;
		return rs.getInt("ID_ASSISTITO");
	}

	public ResultSet findCartella(Integer presacarico) throws SQLException {
				
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM F_CARTELLA" +
												    " WHERE PRESA_CARICO_NUM="+presacarico+";");
		
		return ps.executeQuery();
	}

	public Integer findIdOperatore(OperatoreType doperatore) throws SQLException {
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM D_OPERATORE " +
								" WHERE OPERATORE_COD = ? AND POLO_COD= ?;");
		ps.setInt(1, doperatore.getOPERATORECOD());
		ps.setInt(2, doperatore.getPOLOCOD());
		ResultSet rs = ps.executeQuery();
		if(!rs.next())
			return 0;
		return rs.getInt("ID_OPERATORE");
	}

	public boolean checkCartella(int idAssistito, Date dataaccesso) throws SQLException {
		
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM F_CARTELLA " +
								" WHERE ID_ASSISTITO = ? AND DATA_ACCESSO= ?;");
		ps.setInt(1, idAssistito);
		ps.setDate(2, dataaccesso);
		ResultSet rs = ps.executeQuery();
		
		return rs.next();
	}

	public ResultSet findCartella( int idAssistito) throws SQLException {
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM F_CARTELLA " +
								" WHERE ID_ASSISTITO = ?;");
		ps.setInt(1, idAssistito);			
		return ps.executeQuery();
		
	}

	public int checkAreaUtenza(Integer areautenzacod, Date dataInizioVal, int idAssistito) throws SQLException {
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM D_AREA_UTENZA " +
								" WHERE ID_ASSISTITO = ? AND AREA_UTENZA_COD= ? AND DATA_INIZIO_VAL=?;");
		ps.setInt(1, idAssistito);
		ps.setInt(2, areautenzacod);
		ps.setDate(3, dataInizioVal);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
			return rs.getInt("ID_AREA_UTENZA");
		return 0;
	}

	public int checkAreaUtenza(Integer areautenzacod, int idAssistito) throws SQLException {
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM D_AREA_UTENZA " +
								" WHERE ID_ASSISTITO = ? AND AREA_UTENZA_COD= ?;");
		ps.setInt(1, idAssistito);
		ps.setInt(2, areautenzacod);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
			return rs.getInt("ID_AREA_UTENZA");
		return 0;
	}

	public int findIdOperatoreInCartella(int idAssistito) throws SQLException {
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM F_CARTELLA " +
								" WHERE ID_ASSISTITO = ?;");
		ps.setInt(1, idAssistito);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
			return rs.getInt("ID_OPERATORE"); 
		return 0;
	}

	public int findOrCreateAssistito(AssistitoType dassistito) throws SQLException, ClassNotFoundException 
	{
		int id = findIdAssistito(dassistito);
		if(id==0) DWHInsertSQL.createNewAssistito(dassistito);
		id = findIdAssistito(dassistito);
		if(id==0) throw new SQLException("Non ho trovato l'assistito che ho appena inserito. son semo");
		return id;		
	}
	
	public void updatePresaInCaricoInfo(int idAssistito, CartellaType fcartella) throws SQLException
	{
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE F_CARTELLA " +
				"SET PRESA_CARICO_NUM = ?," +
				"    INIZIO_PRESA_CARICO = ? " +
				"WHERE ID_ASSISTITO = ?; ");
		ps.setInt(1, fcartella.getPRESACARICO());
		ps.setDate(2, DWHInsertSQL.convertDate(fcartella.getINIZIOPRESACARICO()));
		ps.setInt(3, idAssistito);
		ps.executeUpdate();
	}

	public void updateIdOperatoreInCartella(int idAssistito, int idOperatore) throws SQLException
	{
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE F_CARTELLA " +
				"SET ID_OPERATORE = ? " +
				"WHERE ID_ASSISTITO = ?; ");
		ps.setInt(1, idOperatore);
		ps.setInt(2, idAssistito);
		ps.executeUpdate();
		
	}

	public void updateAreaUtenzaInfo(int idAssistito, Integer presacarico) throws SQLException
	{
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE F_CARTELLA " +
				"SET PRESA_CARICO_NUM = ? " +
				"WHERE ID_ASSISTITO = ?; ");
		ps.setInt(1, presacarico);
		ps.setInt(2, idAssistito);
		ps.executeUpdate();
		
	}

	public void updateChiusuraPresaInCaricoInfo(int idAssistito, CartellaType fcartella) throws SQLException
	{
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE F_CARTELLA " +
				"SET PRESA_CARICO_NUM = ?," +
				" FINE_PRESA_CARICO = ? " +
				"WHERE ID_ASSISTITO = ?; ");
		ps.setInt(1, fcartella.getPRESACARICO());
		ps.setDate(2, DWHInsertSQL.convertDate(fcartella.getFINEPRESACARICO()));
		ps.setInt(3, idAssistito);
		ps.executeUpdate();
		
	}

	public void updateDomandaAmministrativaInfo(int idAssistito, CartellaType fcartella) throws SQLException
	{
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE F_CARTELLA " +
				"SET DATA_DOMANDA = ?," +
				" GIORNATE_SETTIMANALI = ?, " +
				" NUMERO_PASTI_SETTIMANALI = ?, " +
				" NUMERO_TRASPORTI_SETTIMANALI = ?, " +
				" ORE_SETTIMANALI = ? " +
				"WHERE ID_ASSISTITO = ?; ");
		ps.setDate(1, DWHInsertSQL.convertDate(fcartella.getDATADOMANDA()));
		ps.setInt(2, fcartella.getGIORNATESETTIMANALI());
		ps.setInt(3, fcartella.getNUMEROPASTISETTIMANALI());
		ps.setInt(4, fcartella.getNUMEROTRASPORTISETTIMANALI());
		ps.setInt(5, fcartella.getORESETTIMANALI());
		ps.setInt(6, idAssistito);
		ps.executeUpdate();
		
	}

	public int findOrCreateErogatore(EnteErogatoreType denteerogatore) throws SQLException, ClassNotFoundException
	{
		int id = findIdErogatore(denteerogatore.getENTEEROGATORECOD());
		if(id==0) DWHInsertSQL.createNewErogatore(denteerogatore);
		id = findIdErogatore(denteerogatore.getENTEEROGATORECOD());
		if(id==0) throw new SQLException("Non ho trovato l'erogatore che ho appena inserito. son semo");
		return id;		
	}

	private int findIdErogatore(Integer enteerogatorecod) throws SQLException
	{
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM D_ENTE_EROGATORE " +
								" WHERE ENTE_EROGATORE_COD = ?;");
		ps.setInt(1, enteerogatorecod);
		ResultSet rs = ps.executeQuery();
		if(!rs.next())
			return 0;
		return rs.getInt("ID_ENTE_EROGATORE");
	}

	public int findFatturazione(int idAssistito, int idErogatore) throws SQLException
	{
		Connection con = cm.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM F_FATTURAZIONE " +
								" WHERE ID_ASSISTITO= ?" +
								" AND ID_ENTE_EROGATORE = ?;");
		ps.setInt(1, idAssistito);
		ps.setInt(2, idErogatore);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) return rs.getInt("ID_FATTURAZIONE");
		return 0;
	}

	
}
