package ClassesRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientRMI {
	
	public void createStateMachine(String idCorrel){
		
		try {
			StateMachineDAODistante stateMachine = (StateMachineDAODistante) Naming.lookup("rmi://127.0.0.1/StateMachine");
			stateMachine.createStateMachine(idCorrel);
			System.out.println("request StateMachine creation sent to persistance via rmi");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
