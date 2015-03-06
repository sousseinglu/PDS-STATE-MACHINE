package ClassesRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.mysql.jdbc.BalanceStrategy;



public class StateMachineDAOExportee extends UnicastRemoteObject implements StateMachineDAODistante {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6154247838326244397L;
	private StateMachineDAO st;
	public StateMachineDAOExportee() throws RemoteException {
		this.st = new StateMachineDAO();
	}

	
	
	  public void createStateMachine(String idCorrelation) {
		  st.createStateMachine(idCorrelation);
	   }

}
