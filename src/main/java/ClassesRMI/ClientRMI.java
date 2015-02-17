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
			Registry registry = LocateRegistry.getRegistry("localhost",10000);
			if (System.getSecurityManager() == null) {
		        System.setSecurityManager(new SecurityManager());
		    }
			StateMachineDAODistante stateMachine = (StateMachineDAODistante) registry.lookup("StateMachine");
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
