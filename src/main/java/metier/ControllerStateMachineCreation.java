package metier;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StateMachineCreation
 */
public class ControllerStateMachineCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerStateMachineCreation() {
        super();
        // TODO Auto-generated constructor stub
    }

   
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected synchronized void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("hello");
		// TODO Auto-generated method stub
		//String from  = request.getParameter("from");
		String idCorrel  = request.getParameter("idCorrel");
		
		Map<String, String> messageList = ControllerStoreMessages.getMessages();
		if(!messageList.isEmpty()){
			for(Entry<String, String> entry : messageList.entrySet()) {
			    String cle = entry.getKey();
			    String valeur = entry.getValue();
			    if(idCorrel.equals(cle)){
			    	new ControllerXml().decodeAndSendXML("presentation", valeur, "createStateMachine" , cle);
			    	
			    	//todo call rmi method to create state machine
			    }
			    
			}
		}
	}	
	

}
