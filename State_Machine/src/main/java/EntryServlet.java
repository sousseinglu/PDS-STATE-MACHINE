

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import model.Producer;

/**
 * Servlet implementation class EntryServlet
 */
@WebServlet("/EntryServlet")
public class EntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
	        Connection connection = connectionFactory.createConnection();
	        connection.start();

	        // JMS messages are sent and received using a Session. We will
	        // create here a non-transactional session object. If you want
	        // to use transactions you should set the first parameter to 'true'
	        Session session = connection.createSession(false,
	                Session.AUTO_ACKNOWLEDGE);

	        Destination queue = session.createQueue("fromPresentation");

	        MessageProducer producer = session.createProducer(queue);

	        // We will send a small text message saying 'Hello'

	        TextMessage message = session.createTextMessage();

	        message.setText(request.getParameter("xml"));
	        // Here we are sending the message!
	        producer.send(message);
	        System.out.println("Sent message '" + message.getText() + "'");

	        
				connection.close();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		response.setContentType( "text/html" );
		PrintWriter out = response.getWriter();
		out.println( "<HTML>" );
		out.println( "<HEAD>");
		out.println( "<TITLE>Page generee par une servlet</TITLE>" );
		out.println( "</HEAD>" );
		out.println( "<BODY>" );
		out.println( "<H1>Message sent to Couche Metier</H1>" );
		out.println( "</BODY>" );
		out.println( "</HTML>" );
		out.close();
	}
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
