package interfaces;

import java.rmi.*;

// Cette interface définit le service d'une base de licenciés distante.
// Le service autorise l'utilisation de 3 méthodes, définies par leurs prototypes.
public interface BaseDistante extends Remote {
	public boolean createStateMachine(String nom) throws RemoteException;
}
