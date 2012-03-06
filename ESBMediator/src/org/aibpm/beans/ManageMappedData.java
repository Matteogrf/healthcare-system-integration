package org.aibpm.beans;

import it.unitn.laboratory.mappedData.DwhSchemaType;
import it.unitn.laboratory.utils.JAXBUtils;

import java.io.InputStream;

import javax.annotation.Resource;
import javax.jbi.messaging.DeliveryChannel;
import javax.jbi.messaging.ExchangeStatus;
import javax.jbi.messaging.MessageExchange;
import javax.jbi.messaging.NormalizedMessage;
import javax.xml.transform.Source;

import org.apache.servicemix.bean.Operation;
import org.apache.servicemix.jbi.jaxp.SourceTransformer;

public class ManageMappedData {

	@Resource
	private DeliveryChannel channel;

	@Operation
	public void manageInserimentoVariazioneAnagrafica(MessageExchange exchange){
		if (exchange.getStatus() == ExchangeStatus.ACTIVE) {

			// get incoming message in normalized form
			NormalizedMessage inMessage = exchange.getMessage("in");

			// get message content
			Source messageContent = inMessage.getContent();

			try {
				
				
				InputStream globalSchemaEventXML = (new SourceTransformer().toStreamSource(messageContent).getInputStream());
				DwhSchemaType dwh = JAXBUtils.getDWHClassesFromXML(globalSchemaEventXML);
				
				System.out.println(dwh.getDASSISTITO().getCAP());
				

			} catch (Exception e1) {
				System.out.println("Errore Parsing Request:" + e1.getMessage());
				e1.printStackTrace();
			}
		}
	}
}
