package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface StateMachineDAODistante extends Remote{
	 public void createStateMachine(String nomMachine, String user)  throws RemoteException;
}
