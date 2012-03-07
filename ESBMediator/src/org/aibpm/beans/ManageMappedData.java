package org.aibpm.beans;

import it.unitn.laboratory.mappedData.DwhSchemaType;
import it.unitn.laboratory.utils.JAXBUtils;
import it.unitn.laboratory.utils.ManageMappedEvents;

import java.io.InputStream;

import javax.annotation.Resource;
import javax.jbi.messaging.DeliveryChannel;
import javax.jbi.messaging.ExchangeStatus;
import javax.jbi.messaging.MessageExchange;
import javax.jbi.messaging.NormalizedMessage;
import javax.swing.text.GlyphView;
import javax.xml.transform.Source;

import org.apache.servicemix.bean.Operation;
import org.apache.servicemix.jbi.jaxp.SourceTransformer;

public class ManageMappedData {
	
	private static final int OP_BEFORE_UPDATE_DWH = 10;
	private static int op = 0;

	@Resource
	private DeliveryChannel channel;

	@Operation
	public void manageInserimentoVariazioneAnagrafica(MessageExchange exchange){
		if (exchange.getStatus() == ExchangeStatus.ACTIVE) {

			// get incoming message in normalized form
			NormalizedMessage inMessage = exchange.getMessage("in");
			// get message content
			Source messageContent = inMessage.getContent();

			/* Conversione dell'evento mappato per la staging area da XML a Oggetti mediante JAXB */
			DwhSchemaType dwh = JAXBUtils.getDWHClassesFromXML(messageContent);
			
			System.out.println(dwh.getEVENTTYPE().getEVENTCOD());
			int eventType = dwh.getEVENTTYPE().getEVENTCOD();
			
			/* Esegue il routing dell'evento in base al tipo */
			switch (eventType) {
            case 1:  ManageMappedEvents.InserimentoVariazioneAnagraficaEvent(dwh);
                     break;
            default: break;
        }
			
		
    }
			
 }
}


