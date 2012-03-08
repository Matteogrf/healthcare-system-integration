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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;

import org.apache.servicemix.bean.Operation;
import org.apache.servicemix.jbi.jaxp.SourceTransformer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ManageMappedData {
	

	@Resource
	private DeliveryChannel channel;

	@Operation
	public void manageDWHResponse(MessageExchange exchange){
		if (exchange.getStatus() == ExchangeStatus.ACTIVE) {

			if (exchange.getStatus() == ExchangeStatus.ACTIVE) {

				// get incoming message in normalized form
				NormalizedMessage inMessage = exchange.getMessage("in");

				// get message content
				Source messageContent = inMessage.getContent();

				try {
					String body = (new SourceTransformer()).toString(messageContent);
					System.out.println("DWH Response:"+body);
					
					

					exchange.setMessage(inMessage, "out");
					// send the out message through the delivery channel
					channel.send(exchange);
				} catch (Exception e1) {
					System.out.println("Errore Parsing Request:" + e1.getMessage());
					e1.printStackTrace();
				}
			}

        }
    }			
 }


