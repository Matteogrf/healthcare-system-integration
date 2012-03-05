package org.aibpm.beans;

import javax.annotation.Resource;
import javax.jbi.messaging.DeliveryChannel;
import javax.jbi.messaging.ExchangeStatus;
import javax.jbi.messaging.MessageExchange;
import javax.jbi.messaging.MessagingException;
import javax.jbi.messaging.NormalizedMessage;
import javax.xml.transform.Source;

import org.apache.servicemix.bean.Operation;
import org.apache.servicemix.jbi.jaxp.SourceTransformer;

public class EventManager {
	
	@Resource
	private DeliveryChannel channel;

	@Operation
	public void logContent(MessageExchange exchange)
			throws MessagingException {

		if (exchange.getStatus() == ExchangeStatus.ACTIVE) {

			// get incoming message in normalized form
			NormalizedMessage inMessage = exchange.getMessage("in");

			// get message content
			Source messageContent = inMessage.getContent();


			try {
				/*DocumentBuilderFactory factory = DocumentBuilderFactory
						.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.parse(new InputSource(messageContent
						.getSystemId()));
				NodeList nodeLst = doc.getElementsByTagName("query");
				System.out.println(nodeLst.item(0).getTextContent());*/

				// Here you can do something with the message payload
				String body = (new SourceTransformer()).toString(messageContent);
				System.out.println("Hey, your message passed from here!1\n"+body);

				//String payload = Utils.biuldSoapRequest(nodeLst.item(0).getTextContent());
				//String payload = Utils.biuldSoapRequest("gatto");
				// create a new normalized message that will be the response
				// part of the exchange
				//NormalizedMessage outMessage = exchange.createMessage();
				// copy incoming message body in outgoing message
				//Source outMessageContent = new StreamSource(new StringReader(
				//		payload));
				//outMessage.setContent(outMessageContent);
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
