package it.unitn.laboratory.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.unitn.laboratory.db.ConnectionManager;
import it.unitn.laboratory.db.QueryManager;
import it.unitn.laboratory.db.DWH.ConnectionManagerDWH;
import it.unitn.laboratory.db.DWH.DWHInsertSQL;
import it.unitn.laboratory.db.DWH.DWHUpdateSQL;
import it.unitn.laboratory.db.StagingArea.ConnectionManagerSA;
import it.unitn.laboratory.db.StagingArea.StagingArea;
import it.unitn.laboratory.db.StagingArea.StagingAreaException;
import it.unitn.laboratory.db.StagingArea.StagingAreaInsert;
import it.unitn.laboratory.wrapper.AssistitoType;
import it.unitn.laboratory.wrapper.ComponenteType;
import it.unitn.laboratory.wrapper.DwhSchemaType;
import it.unitn.laboratory.wrapper.OperatoreType;
import it.unitn.laboratory.wrapper.RichiedenteType;
import it.unitn.laboratory.wrapper.SegnalanteType;
import it.unitn.laboratory.wrapper.TipoTerziType;

public class EventManager 
{
	public static String inserimentoVariazioneAnagrafica(DwhSchemaType dwhSCHEMA) 
	{
		try 
		{
			int id;
			Operatore(dwhSCHEMA.getDOPERATORE());
			AssistitoType assistito = dwhSCHEMA.getDASSISTITO();
			
			QueryManager qmDHW = new QueryManager(ConnectionManagerDWH.getInstance());
			ResultSet rs = qmDHW.findAssistito( assistito );
			
			if(rs.next())
			{
				id = rs.getInt("ID_ASSISTITO"); // Gia presente nel database. modifica
				System.out.println("Update assistito");
				DWHUpdateSQL.updateAssistito(assistito, id);
			}
			else //non presente nella DWH (inserimento)
			{
				System.out.println("Inserisco assistito");
				DWHInsertSQL.insertAssistito(assistito);	
			}			
		} 
		catch (Exception e) 
		{
			return "ERRORE: "+e.getMessage();
		}
		return "OK";		
	}
	
	public static String inserimentoVariazioneNucleoFatto(DwhSchemaType dwhSCHEMA) //TODO: Da aggiornare
	{
		try 
		{
			//Per ogni componente del nucleo controllo se gia presente nella DWH	
			QueryManager qm = new QueryManager(ConnectionManagerDWH.getInstance());
			QueryManager qmSTA = new QueryManager(ConnectionManagerSA.getInstance());
			ResultSet rs;
			int id;
			int idPatient;
			for(ComponenteType ct : dwhSCHEMA.getDNUCLEOFAMILIARE().getCOMPONENTE())
			{
				
				  rs = qm.findComponenteNucleo(ct, dwhSCHEMA.getDNUCLEOFAMILIARE().getCODICENUCLEO());  
				  if(rs.next()){ //gia presente nella DWH (update)				  
			        id = rs.getInt("ID_NUCLEO");		        
			        DWHUpdateSQL.updateComponenteNucleo(id, ct, dwhSCHEMA.getDNUCLEOFAMILIARE().getCODICENUCLEO());
			 }
			  else 
			  { //componente non presente nella DWH (insert)
				id = 0;
			    rs = qm.findIdAssistito(ct.getHASHCOD());
			    if(rs.next())
				    { // inserisco la variazione nucleo nella DWH
				    	idPatient = rs.getInt("ID_ASSISTITO");
				    	System.out.println("fuck:"+idPatient);
				    	DWHInsertSQL.insertVariazioneNucleo(ct, idPatient, dwhSCHEMA.getDNUCLEOFAMILIARE().getCODICENUCLEO());
				    }  
					else throw new StagingAreaException("Patient associated to Nucleo:"+dwhSCHEMA.getDNUCLEOFAMILIARE().getCODICENUCLEO()+" not found");
			  }
			
			} 
		}
		catch (Exception e) 
		{
			return "ERRORE: "+e.getMessage();
		}
		return "OK";	
	}
	
	private static void Operatore(OperatoreType operatore) throws StagingAreaException
	{
		try 
		{			
			QueryManager qm = new QueryManager(ConnectionManagerDWH.getInstance());			
			ResultSet rs = qm.findOperatore(operatore.getOPERATORECOD(), operatore.getPOLOCOD(), operatore.getENTEGESTORECOD());
			if(rs.next()) return; // Operatore gia presente nel database
		    
		    // inserire l'operatore nella DWH
		    DWHInsertSQL.insertOperatore(operatore);
		} 
		catch (Exception e ) 
		{
			e.printStackTrace();
			throw new StagingAreaException(e.getMessage());			
		} 
				
	}

	
	public static String inserimentoSchedaAccesso(DwhSchemaType dwhSCHEMA) 
	{
		int idAssistito = 0;
		Integer idTipoTerzi;
		int idSegnalante;
		int idOperatore;
		try
		{			
			QueryManager qmDWH = new QueryManager(ConnectionManagerDWH.getInstance());
			
			//Insert or update richiedente
			int idRichiedete = insertRichiedente(dwhSCHEMA.getDRICHIEDENTE());
			
			if(dwhSCHEMA.getDRICHIEDENTE().getRICHIEDENTECOD() == 2) //se codice richiedente è terzi
			    	idTipoTerzi = insertTipoTerzi(dwhSCHEMA.getDTIPOTERZI());
			else    idTipoTerzi = 0;
								
			idSegnalante = insertSegnalante(dwhSCHEMA.getDSEGNALANTE());
			idAssistito = qmDWH.findOrCreateAssistito(dwhSCHEMA.getDASSISTITO());
			idOperatore = qmDWH.findIdOperatore(dwhSCHEMA.getDOPERATORE());		
			
			// todo : se la cartella clinica dell'utente esiste gia aggiornarla. E possibile ke ci sia gia qualcosa nella stagin area? bha	
			ResultSet cartella = qmDWH.findCartella(idAssistito);
			if(!cartella.next()) 
			{
				// Prima di inserire una nuova cartella controllo se ce qualche informazione nella staging area
				StagingArea.getFCartellaInfo(idAssistito, dwhSCHEMA.getFCARTELLA());				
				DWHInsertSQL.insertFCartella(dwhSCHEMA.getFCARTELLA(), idRichiedete, idTipoTerzi, idSegnalante, idAssistito, idOperatore);
				StagingArea.deleteFCartellaInfo(idAssistito);
			}
			else DWHUpdateSQL.UpdateSchedaAccesso( cartella.getInt("ID_CARTELLa"), dwhSCHEMA.getFCARTELLA(),idRichiedete, idTipoTerzi, idSegnalante, idAssistito, idOperatore);
		
			return "OK";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "ERRORE: "+ idAssistito + e.getMessage();
		}
	}


	private static int insertSegnalante(SegnalanteType dsegnalante) throws ClassNotFoundException, SQLException {
		QueryManager qmDWH = new QueryManager(ConnectionManagerDWH.getInstance());
		ResultSet rs;
		rs = qmDWH.findSegnalante(dsegnalante);
		
		if(rs.next()) return rs.getInt("ID_SEGNALANTE");
		
		DWHInsertSQL.insertSegnalante(dsegnalante);
		rs = qmDWH.findSegnalante(dsegnalante);
		rs.next();
		return rs.getInt("ID_SEGNALANTE");
	}

	private static int insertTipoTerzi(TipoTerziType dtipoterzi) throws ClassNotFoundException, SQLException {
		QueryManager qmDWH = new QueryManager(ConnectionManagerDWH.getInstance());
		ResultSet rs;
		rs = qmDWH.findTipoTerzi(dtipoterzi);
		
		if(rs.next()) return rs.getInt("ID_TIPO_TERZI");
		
		DWHInsertSQL.insertTipoTerzi(dtipoterzi);
		rs = qmDWH.findTipoTerzi(dtipoterzi);
		rs.next();
		return rs.getInt("ID_TIPO_TERZI");
	}

	private static int insertRichiedente(RichiedenteType drichiedente) throws ClassNotFoundException, SQLException {
		
		QueryManager qmDWH = new QueryManager(ConnectionManagerDWH.getInstance());
		ResultSet rs;
		rs = qmDWH.findRichiedente(drichiedente);
		
		if(rs.next()) return rs.getInt("ID_RICHIEDENTE");
		
		DWHInsertSQL.insertRichiedente(drichiedente);
		rs = qmDWH.findRichiedente(drichiedente);
		rs.next();
		return rs.getInt("ID_RICHIEDENTE");
	}

	public static String presaInCarico(DwhSchemaType dwhSCHEMA) 
	{
		int idAssistito = 0;
		try
		{		
			QueryManager qmDWH = new QueryManager(ConnectionManagerDWH.getInstance());
			
			idAssistito = qmDWH.findOrCreateAssistito(dwhSCHEMA.getDASSISTITO());
						
			ResultSet cartella = qmDWH.findCartella(idAssistito);
			if(!cartella.next())
				// Se non ce la scheda accesso butto queste info a marcire nella staging area. non si sa mai ke prima o poi servano
				StagingArea.addPresaInCaricoInfo( idAssistito, dwhSCHEMA.getFCARTELLA() );
			
			else qmDWH.updatePresaInCaricoInfo(idAssistito, dwhSCHEMA.getFCARTELLA() );
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return "ERRORE: "+ idAssistito + e.getMessage();
		}
		return "OK";
	}

	public static String assegnazioneAreaUtenza(DwhSchemaType dwhSCHEMA) {
		int idAssistito = 0;
		try
		{		
			QueryManager qmDWH = new QueryManager(ConnectionManagerDWH.getInstance());
			
			idAssistito = qmDWH.findIdAssistito(dwhSCHEMA.getDASSISTITO());
			
			if(idAssistito == 0) throw new StagingAreaException("Assistito not found in DWH");
			
			if(qmDWH.checkAreaUtenza(dwhSCHEMA.getDAREAUTENZA().getAREAUTENZACOD(),
					                 DWHInsertSQL.convertDate(dwhSCHEMA.getDAREAUTENZA().getDATAINIZIOVAL()),
					                 idAssistito) == 0){
				DWHInsertSQL.insertAreaUtenza(idAssistito, dwhSCHEMA.getDAREAUTENZA());
			}	
			else return "OK, area utenza gia presente.";		
		}
		catch (Exception e) {
			e.printStackTrace();
			return "ERRORE: "+ idAssistito + e.getMessage();
		}
		return "OK";
	}

	public static String revocaAreaUtenza(DwhSchemaType dwhSCHEMA) {
		int idAssistito = 0;
		int idAreaUtenza = 0;
		try
		{		
			QueryManager qmDWH = new QueryManager(ConnectionManagerDWH.getInstance());
			
			idAssistito = qmDWH.findIdAssistito(dwhSCHEMA.getDASSISTITO());
			
			if(idAssistito == 0) throw new StagingAreaException("Assistito not found in DWH");
			
			idAreaUtenza = qmDWH.checkAreaUtenza(dwhSCHEMA.getDAREAUTENZA().getAREAUTENZACOD(), idAssistito);
			
			if(idAreaUtenza == 0)
				throw new StagingAreaException("Area Utenza not found in DWH");				
			else
				DWHUpdateSQL.updateAreaUtenza(idAreaUtenza, dwhSCHEMA.getDAREAUTENZA());
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return "ERRORE: "+ idAssistito + e.getMessage();
		}
		return "OK";
	}


}
