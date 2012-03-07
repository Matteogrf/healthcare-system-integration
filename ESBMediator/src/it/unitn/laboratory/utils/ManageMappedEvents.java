package it.unitn.laboratory.utils;

import it.unitn.laboratory.datawarehouse.Query;
import it.unitn.laboratory.datawarehouse.WebServiceServer_Service;

import it.unitn.laboratory.mappedData.DwhSchemaType;
import it.unitn.laboratory.mappedData.OperatoreType;

public class ManageMappedEvents {
	
	public static void InserimentoVariazioneAnagraficaEvent(DwhSchemaType dwh){
		
		
		checkOperatore(dwh.getDOPERATORE());
		
	}
	
	
	static private int checkOperatore(OperatoreType op){
		
		
		String query = "SELECT D.ID_OPERATORE FROM D_OPERATORE AS D WHERE " +
					   "D.OPERATORE_COD ="+op.getOPERATORECOD()+
					   " AND D.POLO_COD="+op.getPOLOCOD()+
					   " AND D.ENTE_GESTORE_COD="+op.getENTEGESTORECOD()+";";
		
		System.out.println("Query: "+query);
		
		WebServiceServer_Service ws = new WebServiceServer_Service();
		ws.getWebServiceSOAP().query(query);

		return 0;
	}

}
