package ClassesRMI;


import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// Classe du Serveur RMI
public class ServeurRMI {
	
	public static void main(String[] args) {
		try {
			StateMachineDAOExportee statem = new StateMachineDAOExportee();
			// Puis on enregistre le service associé à la base dans le registry, sous le nom "Base",
			// pour que les clients puissent le trouver.
			Registry registry = LocateRegistry.createRegistry(10000);
			registry.rebind("StateMachine", statem);
			if (System.getSecurityManager() == null){
		    System.setSecurityManager(new RMISecurityManager());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}