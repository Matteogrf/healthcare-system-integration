package it.unitn.laboratory.db.StagingArea;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import it.unitn.laboratory.db.ConnectionManager;
import it.unitn.laboratory.db.QueryManager;
import it.unitn.laboratory.db.DWH.DWHInsert;
import it.unitn.laboratory.db.DWH.DWHUpdate;
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

	private void updateAll() throws ClassNotFoundException, SQLException {

		ConnectionManager cm = ConnectionManagerSA.getInstance();

		this.updateD_Operatore(cm);

	}

	private void updateD_Operatore(ConnectionManager cm) throws SQLException {
		
		String table = "D_Operatore";
		QueryManager qm = new QueryManager(cm);
		ResultSet rs = qm.findAll(table);
		
		int id;
		OperatoreType o;
		while(rs.next()){
			
			o = new OperatoreType();
			o.setCOGNOME(rs.getString("COGNOME"));
			o.setNOME(rs.getString("NOME");
			o.setENTEGESTORECOD(rs.getInt("ENTE_GESTORE_COD"));
			o.setENTEGESTOREDESCR(rs.getString("ENTE_GESTORE_DESCR"));
			o.setOPERATORECOD(rs.getInt("OPERATORE_COD"));
			o.setPOLOCOD(rs.getInt("POLO_COD"));
			o.setPOLODESCR(rs.getString("POLO_DESCR"));
			
			id = rs.getInt("ID_OPERATORE");
			
			if(id >0)
				DWHInsert.insertOperatore(o);
			else
			    DWHUpdate.updateOperatore(o, id);
		}
			
		}

	}

}
