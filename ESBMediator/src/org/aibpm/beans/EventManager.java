package org.aibpm.beans;

import javax.annotation.Resource;
import javax.jbi.messaging.DeliveryChannel;
import javax.jbi.messaging.ExchangeStatus;
import javax.jbi.messaging.MessageExchange;
import javax.jbi.messaging.MessagingException;
import javax.jbi.messaging.NormalizedMessage;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;

import org.apache.servicemix.bean.Operation;
import org.apache.servicemix.jbi.jaxp.SourceTransformer;

public class EventManager {

	@Resource
	private DeliveryChannel channel;

	@Operation
	public void logContent(MessageExchange exchange) throws MessagingException {

		if (exchange.getStatus() == ExchangeStatus.ACTIVE) {

			// get incoming message in normalized form
			NormalizedMessage inMessage = exchange.getMessage("in");

			// get message content
			Source messageContent = inMessage.getContent();

			try {
				String body = (new SourceTransformer()).toString(messageContent);
				System.out.println("Hey, your message passed from here!1\n"
						+ body);


				exchange.setMessage(inMessage, "out");
				// send the out message through the delivery channel
				channel.send(exchange);
			} catch (Exception e1) {
				System.out.println("Errore Parsing Request:" + e1.getMessage());
				e1.printStackTrace();
			}
		}
	}

	@Operation
	public void logContentNoForward(MessageExchange exchange)
			throws MessagingException {

		if (exchange.getStatus() == ExchangeStatus.ACTIVE) {

			// get incoming message in normalized form
			NormalizedMessage inMessage = exchange.getMessage("in");

			// get message content
			Source messageContent = inMessage.getContent();

			String body;
			try {
				body = (new SourceTransformer()).toString(messageContent);

				System.out.println(body);
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
