package it.unitn.laboratory.adapter;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.unitn.laboratory.db.QueryManager;
import it.unitn.laboratory.db.DWH.ConnectionManagerDWH;
import it.unitn.laboratory.db.DWH.DWHInsertSQL;
import it.unitn.laboratory.db.DWH.DWHUpdateSQL;
import it.unitn.laboratory.db.StagingArea.ConnectionManagerSA;
import it.unitn.laboratory.db.StagingArea.StagingArea;
import it.unitn.laboratory.wrapper.AssistitoType;
import it.unitn.laboratory.wrapper.ComponenteType;
import it.unitn.laboratory.wrapper.DwhSchemaType;
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
			AssistitoType assistito = dwhSCHEMA.getDASSISTITO();

			QueryManager qmDWH = new QueryManager(ConnectionManagerDWH.getInstance());
			ResultSet rs = qmDWH.findAssistito(assistito);
			id = 0;
			if (rs.next())
			{
				id = rs.getInt("ID_ASSISTITO"); // Gia presente nel database.
												// modifica
				System.out.println("Update assistito");
				DWHUpdateSQL.updateAssistito(assistito, id);
			} else
			// non presente nella DWH (inserimento)
			{
				System.out.println("Inserisco assistito");
				DWHInsertSQL.insertAssistito(assistito);
				id = qmDWH.findIdAssistito(assistito.getHASHCOD());
			}

			Operatore op = new Operatore(dwhSCHEMA.getDOPERATORE());
			int idOperatore;
			if ((idOperatore = op.getIdOperatore()) == 0)
			{
				idOperatore = op.insert();
			}

			StagingArea.addOperatoreInCartella(id, idOperatore);

		} catch (Exception e)
		{
			return "ERRORE: " + e.getMessage();
		}
		return "OK";
	}

	public static String inserimentoVariazioneNucleoFatto(DwhSchemaType dwhSCHEMA) // TODO:
																					// Da
																					// aggiornare
	{
		try
		{
			// Per ogni componente del nucleo controllo se gia presente nella
			// DWH
			QueryManager qm = new QueryManager(ConnectionManagerDWH.getInstance());
			QueryManager qmSTA = new QueryManager(ConnectionManagerSA.getInstance());
			ResultSet rs;
			int id;
			int idPatient;
			for (ComponenteType ct : dwhSCHEMA.getDNUCLEOFAMILIARE().getCOMPONENTE())
			{

				rs = qm.findComponenteNucleo(ct, dwhSCHEMA.getDNUCLEOFAMILIARE().getCODICENUCLEO());
				if (rs.next())
				{ // gia presente nella DWH (update)
					id = rs.getInt("ID_NUCLEO");
					DWHUpdateSQL.updateComponenteNucleo(id, ct, dwhSCHEMA.getDNUCLEOFAMILIARE().getCODICENUCLEO());
				} else
				{ // componente non presente nella DWH (insert)
					idPatient = qm.findIdAssistito(ct.getHASHCOD());
					if (idPatient == 0)
					{
						DWHInsertSQL.insertAssistito(ct);
						idPatient = qm.findIdAssistito(ct.getHASHCOD());
					}

					DWHInsertSQL.insertVariazioneNucleo(ct, idPatient, dwhSCHEMA.getDNUCLEOFAMILIARE().getCODICENUCLEO());
				}
			}
		} catch (Exception e)
		{
			return "ERRORE: " + e.getMessage();
		}
		return "OK";
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

			// Insert or update richiedente
			int idRichiedete = insertRichiedente(dwhSCHEMA.getDRICHIEDENTE());

			if (dwhSCHEMA.getDRICHIEDENTE().getRICHIEDENTECOD() == 2) // se codice richiedente è terzi
				idTipoTerzi = insertTipoTerzi(dwhSCHEMA.getDTIPOTERZI());
			else
				idTipoTerzi = 0;

			idSegnalante = insertSegnalante(dwhSCHEMA.getDSEGNALANTE());
			idAssistito = qmDWH.findOrCreateAssistito(dwhSCHEMA.getDASSISTITO());
			idOperatore = qmDWH.findIdOperatore(dwhSCHEMA.getDOPERATORE());

			// todo : se la cartella clinica dell'utente esiste gia aggiornarla.
			// E possibile ke ci sia gia qualcosa nella stagin area? bha
			ResultSet cartella = qmDWH.findCartella(idAssistito);
			if (!cartella.next())
			{
				// Prima di inserire una nuova cartella controllo se ce qualche
				// informazione nella staging area
				StagingArea.getFCartellaInfo(idAssistito, dwhSCHEMA.getFCARTELLA());
				DWHInsertSQL.insertFCartella(dwhSCHEMA.getFCARTELLA(), idRichiedete, idTipoTerzi, idSegnalante, idAssistito, idOperatore);
				StagingArea.deleteFCartellaInfo(idAssistito);
			} else
				DWHUpdateSQL.UpdateSchedaAccesso(cartella.getInt("ID_CARTELLa"), dwhSCHEMA.getFCARTELLA(), idRichiedete, idTipoTerzi, idSegnalante, idAssistito, idOperatore);

			return "OK";
		} catch (Exception e)
		{
			e.printStackTrace();
			return "ERRORE: " + idAssistito + e.getMessage();
		}
	}

	private static int insertSegnalante(SegnalanteType dsegnalante) throws ClassNotFoundException, SQLException
	{
		QueryManager qmDWH = new QueryManager(ConnectionManagerDWH.getInstance());
		ResultSet rs;
		rs = qmDWH.findSegnalante(dsegnalante);

		if (rs.next())
			return rs.getInt("ID_SEGNALANTE");

		DWHInsertSQL.insertSegnalante(dsegnalante);
		rs = qmDWH.findSegnalante(dsegnalante);
		rs.next();
		return rs.getInt("ID_SEGNALANTE");
	}

	private static int insertTipoTerzi(TipoTerziType dtipoterzi) throws ClassNotFoundException, SQLException
	{
		QueryManager qmDWH = new QueryManager(ConnectionManagerDWH.getInstance());
		ResultSet rs;
		rs = qmDWH.findTipoTerzi(dtipoterzi);

		if (rs.next())
			return rs.getInt("ID_TIPO_TERZI");

		DWHInsertSQL.insertTipoTerzi(dtipoterzi);
		rs = qmDWH.findTipoTerzi(dtipoterzi);
		rs.next();
		return rs.getInt("ID_TIPO_TERZI");
	}

	private static int insertRichiedente(RichiedenteType drichiedente) throws ClassNotFoundException, SQLException
	{

		QueryManager qmDWH = new QueryManager(ConnectionManagerDWH.getInstance());
		ResultSet rs;
		rs = qmDWH.findRichiedente(drichiedente);

		if (rs.next())
			return rs.getInt("ID_RICHIEDENTE");

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
			if (!cartella.next())
				// Se non ce la scheda accesso butto queste info a marcire nella
				// staging area. non si sa mai ke prima o poi servano
				StagingArea.addPresaInCaricoInfo(idAssistito, dwhSCHEMA.getFCARTELLA());

			else
				qmDWH.updatePresaInCaricoInfo(idAssistito, dwhSCHEMA.getFCARTELLA());

		} catch (Exception e)
		{
			e.printStackTrace();
			return "ERRORE: " + idAssistito + e.getMessage();
		}
		return "OK";
	}

	public static String chiusuraPresaInCarico(DwhSchemaType dwhSCHEMA)
	{
		int idAssistito = 0;
		try
		{
			QueryManager qmDWH = new QueryManager(ConnectionManagerDWH.getInstance());

			idAssistito = qmDWH.findOrCreateAssistito(dwhSCHEMA.getDASSISTITO());

			ResultSet cartella = qmDWH.findCartella(idAssistito);
			if (!cartella.next())
				// Se non ce la scheda accesso butto queste info a marcire nella
				// staging area. non si sa mai ke prima o poi servano
				StagingArea.addChiusuraPresaInCaricoInfo(idAssistito, dwhSCHEMA.getFCARTELLA());

			else
				qmDWH.updateChiusuraPresaInCaricoInfo(idAssistito, dwhSCHEMA.getFCARTELLA());

		} catch (Exception e)
		{
			e.printStackTrace();
			return "ERRORE: " + idAssistito + e.getMessage();
		}
		return "OK";
	}

	public static String assegnazioneAreaUtenza(DwhSchemaType dwhSCHEMA)
	{
		int idAssistito = 0;
		try
		{
			QueryManager qmDWH = new QueryManager(ConnectionManagerDWH.getInstance());

			idAssistito = qmDWH.findOrCreateAssistito(dwhSCHEMA.getDASSISTITO());

			int idArea;
			if ((idArea = qmDWH.checkAreaUtenza(dwhSCHEMA.getDAREAUTENZA().getAREAUTENZACOD(), idAssistito)) == 0)
			{

				DWHInsertSQL.insertAreaUtenza(idAssistito, dwhSCHEMA.getDAREAUTENZA());
			} else
			{

				DWHUpdateSQL.updateInizioAreaUtenza(idArea, dwhSCHEMA.getDAREAUTENZA());
			}

			ResultSet cartella = qmDWH.findCartella(idAssistito);
			if (!cartella.next())
			{
				// Se non ce la scheda accesso butto queste info a marcire nella
				// staging area. non si sa mai ke prima o poi servano

				StagingArea.addAreaUtenzaInfo(idAssistito, dwhSCHEMA.getFCARTELLA().getPRESACARICO());
			}

			else
				qmDWH.updateAreaUtenzaInfo(idAssistito, dwhSCHEMA.getFCARTELLA().getPRESACARICO());

		} catch (Exception e)
		{
			e.printStackTrace();
			return "ERRORE: " + idAssistito + e.getMessage();
		}
		return "OK";
	}

	public static String revocaAreaUtenza(DwhSchemaType dwhSCHEMA)
	{
		int idAssistito = 0;
		try
		{
			QueryManager qmDWH = new QueryManager(ConnectionManagerDWH.getInstance());

			idAssistito = qmDWH.findOrCreateAssistito(dwhSCHEMA.getDASSISTITO());
			int idArea;
			if ((idArea = qmDWH.checkAreaUtenza(dwhSCHEMA.getDAREAUTENZA().getAREAUTENZACOD(), idAssistito)) == 0)
			{
				DWHInsertSQL.insertRevocaAreaUtenza(idAssistito, dwhSCHEMA.getDAREAUTENZA());
			} else
			{
				DWHUpdateSQL.updateRevocaAreaUtenza(idArea, dwhSCHEMA.getDAREAUTENZA());
			}

			ResultSet cartella = qmDWH.findCartella(idAssistito);
			if (!cartella.next())
				// Se non ce la scheda accesso butto queste info a marcire nella
				// staging area. non si sa mai ke prima o poi servano
				StagingArea.addAreaUtenzaInfo(idAssistito, dwhSCHEMA.getFCARTELLA().getPRESACARICO());
			else
				qmDWH.updateAreaUtenzaInfo(idAssistito, dwhSCHEMA.getFCARTELLA().getPRESACARICO());

		} catch (Exception e)
		{
			e.printStackTrace();
			return "ERRORE: " + idAssistito + e.getMessage();
		}
		return "OK";
	}

	public static String ricezioneDomandaAmministrativa(DwhSchemaType dwhSCHEMA)
	{
		int idAssistito = 0;
		try
		{
			QueryManager qmDWH = new QueryManager(ConnectionManagerDWH.getInstance());

			idAssistito = qmDWH.findOrCreateAssistito(dwhSCHEMA.getDASSISTITO());

			ResultSet cartella = qmDWH.findCartella(idAssistito);
			if (!cartella.next())
				// Se non ce la scheda accesso butto queste info a marcire nella
				// staging area. non si sa mai ke prima o poi servano
				StagingArea.addDomandaAmministrativaInfo(idAssistito, dwhSCHEMA.getFCARTELLA());
			else
				qmDWH.updateDomandaAmministrativaInfo(idAssistito, dwhSCHEMA.getFCARTELLA());

		} catch (Exception e)
		{
			e.printStackTrace();
			return "ERRORE: " + idAssistito + e.getMessage();
		}
		return "OK";
	}

	public static String fatturazionePeriodica(DwhSchemaType dwhSCHEMA)
	{
		int idAssistito = 0;
		int idErogatore = 0;
		try
		{
			QueryManager qmDWH = new QueryManager(ConnectionManagerDWH.getInstance());

			idAssistito = qmDWH.findOrCreateAssistito(dwhSCHEMA.getDASSISTITO());

			idErogatore = qmDWH.findOrCreateErogatore(dwhSCHEMA.getDENTEEROGATORE());

			int idFatturazione = qmDWH.findFatturazione(idAssistito, idErogatore);
			if (idFatturazione == 0)
				// Se non ce la fatturazione la creo
				DWHInsertSQL.addFatturazioneInfo(idAssistito, idErogatore, dwhSCHEMA.getFFATTURAZIONE());
			else
				DWHUpdateSQL.updateFatturazioneInfo(idFatturazione, idAssistito, idErogatore, dwhSCHEMA.getFFATTURAZIONE());

		} catch (Exception e)
		{
			e.printStackTrace();
			return "ERRORE: " + idAssistito + e.getMessage();
		}
		return "OK";
	}

}
