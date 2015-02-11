package persistance;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;

import metier.ControllerStateMachineCreation;

import org.apache.activemq.ActiveMQConnectionFactory;

public class PersistanceMessage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// URL of the JMS server
    private static String url = "tcp://localhost:61616";
	public void init() throws ServletException
    {
		// Getting JMS connection from the server
		try {
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
			Connection connection = connectionFactory.createConnection();

			// need to setClientID value, any string value you wish

			connection.setClientID("1");

			connection.start();

			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);

			Destination queueMetier = session.createQueue("fromMetier");

			MessageConsumer consumerMetier = session.createConsumer(queueMetier);

			MessageListener listnerPresentation = new MessageListener() {
				public void onMessage(Message message) {
					try {
						if (message instanceof TextMessage) {

							TextMessage textMessage = (TextMessage) message;
							System.out.println("Received message"
									+ textMessage.getText() + "'");

							//send message to couche persistance 
							// new controller.Publisher().sendMessage("persistance", textMessage.getText());
							ControllerStateMachineCreation sm = new ControllerStateMachineCreation(); 
							sm.setIdCorrelation(message.getJMSCorrelationID());
							sm.setMessage(textMessage.getText());


						}
					} catch (JMSException e) {
						System.out.println("Caught:" + e);
						e.printStackTrace();
					}
				}
			};

			MessageListener listnerMetier = new MessageListener() {
				public void onMessage(Message message) {
					try {
						if (message instanceof TextMessage) {

							TextMessage textMessage = (TextMessage) message;
							System.out.println("Received message"
									+ textMessage.getText() + "'");
						}
					} catch (JMSException e) {
						System.out.println("Caught:" + e);
						e.printStackTrace();
					}
				}
			};


			consumerMetier.setMessageListener(listnerMetier);
			//connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.toString());
		}
	}
}
