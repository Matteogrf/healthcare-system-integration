package it.unitn.laboratory.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.unitn.laboratory.db.QueryManager;
import it.unitn.laboratory.db.DWH.ConnectionManagerDWH;
import it.unitn.laboratory.db.DWH.DWHInsertSQL;
import it.unitn.laboratory.wrapper.OperatoreType;

public class Operatore {

	OperatoreType operatore;

	public Operatore(OperatoreType op) {
		operatore = op;
	}

	public int getIdOperatore() throws ClassNotFoundException, SQLException {
		
		QueryManager qmDWH = new QueryManager(ConnectionManagerDWH.getInstance());
		ResultSet rs = qmDWH.findOperatore(operatore.getOPERATORECOD(), operatore.getPOLOCOD(), operatore.getENTEGESTORECOD());
		
		if(rs.next()) return rs.getInt("ID_OPERATORE"); // Operatore gia presente nel database
		else return 0;
	}

	public int insert() throws SQLException, ClassNotFoundException {
		DWHInsertSQL.insertOperatore(operatore);
		return getIdOperatore();
	}
	
	

}
