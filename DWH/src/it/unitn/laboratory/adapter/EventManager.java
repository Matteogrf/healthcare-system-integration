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
import it.unitn.laboratory.wrapper.ComponenteType;
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
			rs = qmSTA.findAssistito( assistito );
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
	
	public static String inserimentoVariazioneNucleoFatto(DwhSchemaType dwhSCHEMA) {
		try 
		{
			//Per ogni componente del nucleo controllo se gia presente nella DWH	
			QueryManager qm = new QueryManager(ConnectionManagerDWH.getInstance());
			QueryManager qmSTA = new QueryManager(ConnectionManagerSA.getInstance());
			ResultSet rs;
			int id;
			int idPatient;
			for(ComponenteType ct : dwhSCHEMA.getDNUCLEOFAMILIARE().getCOMPONENTE()){
				
			  rs = qm.findComponenteNucleo(ct, dwhSCHEMA.getDNUCLEOFAMILIARE().getCODICENUCLEO());
			  if(rs.next()){ // gia presente nella DWH
		        id = rs.getInt("ID_NUCLEO");
		        rs= qm.findIdAssistito(ct.getHASHCOD());
		        idPatient = rs.getInt("ID_ASSISTITO");
			  }
			  else {
				id = 0;
			    idPatient = 0;
			    // Controllo se è gia presente nella staging area
				rs = qmSTA.findComponenteNucleo(ct, dwhSCHEMA.getDNUCLEOFAMILIARE().getCODICENUCLEO() );
				if(rs.next()){ // Gia nella staging area.
				  
					  return "OK"; 
				}
			  }
				
		      else {
				rs= qmSTA.findIdAssistito(ct.getHASHCOD());
				if(rs.next())
		            idPatient = rs.getInt("ID_ASSISTITO"); 
				else throw new StagingAreaException("Patient associated to Nucleo:"+dwhSCHEMA.getDNUCLEOFAMILIARE().getCODICENUCLEO()+" not found");
		      }
			  
			  System.out.println("Inserisco una variazione nucleo");
			  StagingAreaInsert.insertNucleoFamiliare(id, ct, dwhSCHEMA.getDNUCLEOFAMILIARE().getCODICENUCLEO(), idPatient);
			}
			
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
