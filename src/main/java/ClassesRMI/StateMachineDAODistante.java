package ClassesRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface StateMachineDAODistante extends Remote{
	 public void createStateMachine(String idCorrelation)  throws RemoteException;
}
