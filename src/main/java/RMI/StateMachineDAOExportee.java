package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.mysql.jdbc.BalanceStrategy;



public class StateMachineDAOExportee extends UnicastRemoteObject implements StateMachineDAODistante {
	protected StateMachineDAOExportee() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private StateMachineDAO st;
	
	  public void createStateMachine(String idCorrelation) {
		  st.createStateMachine(idCorrelation);
	   }

}
