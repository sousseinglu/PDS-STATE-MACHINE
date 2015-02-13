package persistance;

import java.util.HashMap;
import java.util.Hashtable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;

import metier.ControllerStateMachineCreation;

import org.apache.activemq.ActiveMQConnectionFactory;

public class PersistanceMessageConsumer {
	/**
	 * 
	 */
	Context ctx;
	private static final long serialVersionUID = 1L;

	// URL of the JMS server
	private static String url = "tcp://localhost:61616";
	@SuppressWarnings("unchecked")
	public void init() throws NamingException
	{
		// Getting JMS connection from the server
		try {		
			@SuppressWarnings("rawtypes")
			Hashtable env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY, 
			    "com.sun.jndi.fscontext.RefFSContextFactory");	
			ctx = new InitialContext(env);
			
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
			Connection connection = connectionFactory.createConnection();

			// need to setClientID value, any string value you wish

			connection.setClientID("2");

			connection.start();

			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);

			Destination queueMetier = session.createQueue("testpdsPersistance");

			MessageConsumer consumerMetier = session.createConsumer(queueMetier);

			MessageListener listnerMetier = new MessageListener() {
				public void onMessage(Message message) {
					try {
						if (message instanceof TextMessage) {
							TextMessage textMessage = (TextMessage) message;
							ctx.bind(message.getJMSCorrelationID(), textMessage);
							System.out.println("Couche persistance dit: Received message from metier");
						}
					} catch (JMSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NamingException e) {
						// TODO Auto-generated catch block
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
