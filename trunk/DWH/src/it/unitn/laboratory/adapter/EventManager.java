package it.unitn.laboratory.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.unitn.laboratory.db.ConnectionManager;
import it.unitn.laboratory.db.QueryManager;
import it.unitn.laboratory.db.DWH.ConnectionManagerWDH;
import it.unitn.laboratory.db.StagingArea.ConnectionManagerSA;
import it.unitn.laboratory.db.StagingArea.StagingAreaException;
import it.unitn.laboratory.wrapper.DwhSchemaType;
import it.unitn.laboratory.wrapper.OperatoreType;

public class EventManager 
{
	public static String inserimentoVariazioneAnagrafica(DwhSchemaType dwhSCHEMA) 
	{
		try 
		{
			checkOperatore(dwhSCHEMA.getDOPERATORE());
		} 
		catch (StagingAreaException e) 
		{
			return "ERRORE: "+e.getMessage();
		}
		return "OK";		
	}
	
	private static void checkOperatore(OperatoreType operatore) throws StagingAreaException
	{
		try 
		{
			QueryManager qm = new QueryManager(ConnectionManagerWDH.getInstance());
			ResultSet rs = qm.findOperatore(operatore.getOPERATORECOD(), operatore.getPOLOCOD(), operatore.getENTEGESTORECOD());
			if(rs.next()) return; // Operatore gia presente nel database
			
			QueryManager qm2 = new QueryManager(ConnectionManagerSA.getInstance());
		    rs = qm2.findOperatore(operatore.getOPERATORECOD(), operatore.getPOLOCOD(), operatore.getENTEGESTORECOD());
		    if(rs.next()) return; // Operatore gia presente nella staging area
		    
		    // inserire l'operatore nella staging area
		    qm.insertOperatore(operatore);
		} 
		catch (Exception e ) 
		{
			e.printStackTrace();
			throw new StagingAreaException(e.getMessage());			
		} 
				
	}
}
