package ClassesRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientRMI {
	
	public void createStateMachine(String idCorrel){
		
		try {
			Registry registry = LocateRegistry.getRegistry(10000);
			StateMachineDAODistante stateMachine = (StateMachineDAODistante) registry.lookup("StateMachine");
			if (System.getSecurityManager() == null){
		    System.setSecurityManager(new RMISecurityManager());
			}
			//StateMachineDAODistante stateMachine = (StateMachineDAODistante) Naming.lookup("");
			stateMachine.createStateMachine(idCorrel);
			System.out.println("request StateMachine creation sent to persistance via rmi");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
