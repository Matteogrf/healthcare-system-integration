package it.unitn.laboratory.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.unitn.laboratory.db.ConnectionManager;
import it.unitn.laboratory.db.QueryManager;
import it.unitn.laboratory.db.DWH.ConnectionManagerDWH;
import it.unitn.laboratory.db.StagingArea.ConnectionManagerSA;
import it.unitn.laboratory.db.StagingArea.StagingAreaException;
import it.unitn.laboratory.db.StagingArea.StagingAreaInsert;
import it.unitn.laboratory.wrapper.AssistitoType;
import it.unitn.laboratory.wrapper.DwhSchemaType;
import it.unitn.laboratory.wrapper.OperatoreType;

public class EventManager 
{
	public static String inserimentoVariazioneAnagrafica(DwhSchemaType dwhSCHEMA) 
	{
		try 
		{
			checkOperatore(dwhSCHEMA.getDOPERATORE());
			AssistitoType assistito = dwhSCHEMA.getDASSISTITO();
			QueryManager qmDHW = new QueryManager(ConnectionManagerDWH.getInstance());
			ResultSet rs = qmDHW.findAssistito( assistito );
			int id;
			if(rs.next()) id = rs.getInt("ID_ASSISTITO"); // Gia presente nel database. modifica
			else id = 0;
			
			// Controllo se è gia presente nella staging area
			QueryManager qmSTA = new QueryManager(ConnectionManagerSA.getInstance());
			rs = qmDHW.findAssistito( assistito );
			if(rs.next()) return "OK"; // Gia nella staging area. per ora non faccio nulla, poi bho
			
			System.out.println("Inserisco l'assistito");
			StagingAreaInsert.insertAssistito(id, assistito, dwhSCHEMA.getDOPERATORE());
		} 
		catch (Exception e) 
		{
			return "ERRORE: "+e.getMessage();
		}
		return "OK";		
	}
	
	private static void checkOperatore(OperatoreType operatore) throws StagingAreaException
	{
		try 
		{			
			QueryManager qm = new QueryManager(ConnectionManagerDWH.getInstance());			
			ResultSet rs = qm.findOperatore(operatore.getOPERATORECOD(), operatore.getPOLOCOD(), operatore.getENTEGESTORECOD());
			if(rs.next()) return; // Operatore gia presente nel database
			
			QueryManager qm2 = new QueryManager(ConnectionManagerSA.getInstance());
		    rs = qm2.findOperatore(operatore.getOPERATORECOD(), operatore.getPOLOCOD(), operatore.getENTEGESTORECOD());
		    if(rs.next()) return; // Operatore gia presente nella staging area
		    
		    // inserire l'operatore nella staging area
		    StagingAreaInsert.insertOperatore(operatore, 0);
		} 
		catch (Exception e ) 
		{
			e.printStackTrace();
			throw new StagingAreaException(e.getMessage());			
		} 
				
	}
}
