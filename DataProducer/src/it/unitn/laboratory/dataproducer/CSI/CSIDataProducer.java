//----------------------------------------------------------------------------
//	Laboratory Project
//	@author: Groff Matteo, Marchesoni Michele, Meque Abdul
//  @date: 5 / 3 / 2012
//----------------------------------------------------------------------------

package it.unitn.laboratory.dataproducer.CSI;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.unitn.laboratory.dataproducer.DB.ConnectionManager;
import it.unitn.laboratory.dataproducer.DB.DataManager;

public class CSIDataProducer 
{
	private static DataManager dataM;
	public static void main(String[] args)
	{
		try 
		{
			dataM = new DataManager();
			produceEvents();
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			System.out.println("Error: "+e.getMessage());
		}				
	}

	private static void produceEvents() throws SQLException 
	{		
		ResultSet iva = dataM.getInserimentoVariazioneAnagrafica();
		while ( iva.next() )
		{
			CreateInserimentoVariazioneAnagraficaEvent(iva);
		}
			
	}
}

