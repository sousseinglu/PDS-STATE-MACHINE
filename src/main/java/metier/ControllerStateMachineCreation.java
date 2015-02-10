package metier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
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
    private String idCorrel = null;
    private String message = null;
    private Map<String, String> messageList = new HashMap<String,String>();	
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerStateMachineCreation() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void setIdCorrelation(String idCorrel){
    	this.idCorrel = idCorrel;
    }
    public void setMessage(String message){
    	this.message = message;
    	new ControllerXml().validateAndDecod("presentation" , message);
    }
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected synchronized void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String from  = request.getParameter("from");
		
		String from = "presentation";
		
		
		messageList.put(idCorrel, message);
		if(!messageList.isEmpty()){
			for(Entry<String, String> entry : messageList.entrySet()) {
			    String cle = entry.getKey();
			    String valeur = entry.getValue();
			    if(idCorrel.equals(cle)){
			    	//new ControllerXml().validateAndDecod(from , valeur);
			    	
			    	//todo call rmi method to create state machine
			    }
			    
			}
		}
		
		
	}

}
