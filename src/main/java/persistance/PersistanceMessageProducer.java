package persistance;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class PersistanceMessageProducer {

	private ConnectionFactory factory = null;
	private Connection connection = null;
	private Session session = null;
	private Destination queueMetier = null;
	private MessageProducer producerMetier = null;

	public void sendMessage(String contentMessage) {
		try {
			factory = new ActiveMQConnectionFactory(
					ActiveMQConnection.DEFAULT_BROKER_URL);
			connection = factory.createConnection();
			connection.start();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			queueMetier = session.createQueue("SAMPLEQUEUE");
			producerMetier = session.createProducer(queueMetier);
			TextMessage message = session.createTextMessage();
			message.setText(contentMessage);
			producerMetier.send(message);
			System.out.println("Sent: " + message.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
