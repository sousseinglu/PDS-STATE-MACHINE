import com.mysql.jdbc.BalanceStrategy;

import model;

public class StateMachineDAOExportee extends UnicastRemoteObject implements StateMachineDAODistante {
	private StateMachineDAO st;
	
	  public void createStateMachine(String nomMachine, String user) {
		  st.createStateMachine(String nomMachine, String user);
	   }

}
