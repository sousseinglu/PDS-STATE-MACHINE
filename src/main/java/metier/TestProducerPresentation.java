package metier;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * Servlet implementation class TestProducerPresentation
 */
public class TestProducerPresentation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String url = "tcp://localhost:61616";    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestProducerPresentation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String messageFromClient = request.getParameter("message");
		try { 
	    	 ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
	         Connection connection = connectionFactory.createConnection();
	         connection.start();

	       
	         Session session = connection.createSession(false,
	                 Session.AUTO_ACKNOWLEDGE);
	        
	         
	         Destination queueMetier = session.createQueue("fromPresentation");
	        

	         MessageProducer producerMetier = session.createProducer(queueMetier);
	     

	         TextMessage message = session.createTextMessage();
	         
	         message.setJMSCorrelationID("1");
	         message.setText(messageFromClient);
	         
	         // Checks the destination and sends message
	        
	         producerMetier.send(message);
	         System.out.println("Couche Presentation dit: Sent message to metier");
	   
			 connection.close();
				
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
