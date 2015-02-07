package RMI;


import java.rmi.*;

// Classe du Serveur RMI
public class ServeurRMI {
	
	public static void main(String[] args) {
		try {
			StateMachineDAOExportee statem = new StateMachineDAOExportee();
			// Puis on enregistre le service associé à la base dans le registry, sous le nom "Base",
			// pour que les clients puissent le trouver.
			Naming.rebind("StateMachine", statem);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}