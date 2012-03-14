package it.unitn.laboratory.log;

import it.unitn.laboratory.utils.XMLUtils;

import javax.annotation.Resource;
import javax.jbi.messaging.DeliveryChannel;
import javax.jbi.messaging.ExchangeStatus;
import javax.jbi.messaging.MessageExchange;
import javax.jbi.messaging.MessagingException;
import javax.jbi.messaging.NormalizedMessage;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;

import org.apache.servicemix.bean.Operation;
import org.apache.servicemix.jbi.jaxp.SourceTransformer;
import org.apache.servicemix.jbi.jaxp.StringSource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EventManager {

	private static final boolean VERBOSE_MODE = false;

	@Resource
	private DeliveryChannel channel;

	@Operation
	public void logEvent(MessageExchange exchange) throws MessagingException {

		if (exchange.getStatus() == ExchangeStatus.ACTIVE) {

			// get incoming message in normalized form
			NormalizedMessage inMessage = exchange.getMessage("in");
			// get message content
			Source messageContent = inMessage.getContent();

			try {
				Node n = ((DOMSource) messageContent).getNode();
				Document doc = (Document) n;
				Node eventDescr = doc.getElementsByTagName("Descrizione").item(0);
				NodeList descrAttrs = eventDescr.getChildNodes();
				Node attr;
				String eventLog = "\nEvent Received -> ";
				for (int i = 0; i < descrAttrs.getLength(); i++) {
					attr = descrAttrs.item(i);
					if (attr.getNodeName().equals("TipoEventoCod"))
						eventLog += "Cod: " + attr.getTextContent();
					if (attr.getNodeName().equals("TipoEventoDescr"))
						eventLog += " Descr: " + attr.getTextContent();
				}

				System.out.println(eventLog);

				if (VERBOSE_MODE) {
					String body = (new SourceTransformer())
							.toString(messageContent);
					System.out.println("Event XML Message on Bus:\n" + body
							+ "\n");
				}

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
	public void logMappedEvent(MessageExchange exchange)
			throws MessagingException {

		if (exchange.getStatus() == ExchangeStatus.ACTIVE) {

			// get incoming message in normalized form
			NormalizedMessage inMessage = exchange.getMessage("in");
			// get message content
			Source messageContent = inMessage.getContent();

			try {
				Document doc = XMLUtils.getDocument(((StringSource) messageContent).getInputStream());
				Node eventDescr = doc.getElementsByTagName("EVENT_TYPE").item(0);
				NodeList descrAttrs = eventDescr.getChildNodes();
				Node attr;
				String eventLog = "Event Mapped -> ";
				for (int i = 0; i < descrAttrs.getLength(); i++) {
					attr = descrAttrs.item(i);
					if (attr.getNodeName().equals("EVENT_COD"))
						eventLog += "Cod: " + attr.getTextContent();
					if (attr.getNodeName().equals("EVENT_DESCR"))
						eventLog += " Descr: " + attr.getTextContent();
				}

				System.out.println(eventLog);

				if (VERBOSE_MODE) {
					String body = (new SourceTransformer()).toString(messageContent);
					System.out.println("Mapped Event XML Message on Bus:\n" + body+ "\n");
				}
				
				exchange.setMessage(inMessage, "out");
				// send the out message through the delivery channel
				channel.send(exchange);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Operation
	public void logDWHResponse(MessageExchange exchange)
			throws MessagingException {

		if (exchange.getStatus() == ExchangeStatus.ACTIVE) {

			// get incoming message in normalized form
			NormalizedMessage inMessage = exchange.getMessage("in");
			// get message content
			Source messageContent = inMessage.getContent();

			try {
				Document doc = XMLUtils.getDocument(((StringSource) messageContent).getInputStream());
				Node eventDescr = doc.getElementsByTagName("tns:EventNotificationResponse").item(0);
				String eventLog = "DWH Response -> "+eventDescr.getTextContent();

				System.out.println(eventLog);

				if (VERBOSE_MODE) {
					String body = (new SourceTransformer()).toString(messageContent);
					System.out.println("Mapped DWH Response on Bus:\n" + body+ "\n");
				}
				
				exchange.setMessage(inMessage, "out");
				// send the out message through the delivery channel
				channel.send(exchange);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
