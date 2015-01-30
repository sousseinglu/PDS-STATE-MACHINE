package controller;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Servlet implementation class Publisher
 */
public class Publisher extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Publisher() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void sendMessage(String destination, String msg){
    	try { 
    	 ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
         Connection connection = connectionFactory.createConnection();
         connection.start();

         // JMS messages are sent and received using a Session. We will
         // create here a non-transactional session object. If you want
         // to use transactions you should set the first parameter to 'true'
         Session session = connection.createSession(false,
                 Session.AUTO_ACKNOWLEDGE);
        
         
         Destination queuePersistance = session.createQueue("testpdsPersistance");
         Destination queuePresentation = session.createQueue("testpdsPresentation");

         MessageProducer producerPersistance = session.createProducer(queuePersistance);
         MessageProducer producerPresentation = session.createProducer(queuePresentation);

         // We will send a small text message saying 'Hello'

         TextMessage message = session.createTextMessage();

         message.setText(msg);
         // Here we are sending the message!
         if(destination.equals("persistance")){
        	 producerPersistance.send(message);
         }
         else if(destination.equals("presentation")){
        	 producerPresentation.send(message);
         }
         System.out.println("Sent message '" + message.getText() + "'");

         
			connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
