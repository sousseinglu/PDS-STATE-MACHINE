package controller;

import interfaces.BaseDistante;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.*;

//Classe représentant une base de licenciés, présente en interne sur le serveur.
public class Base {
	
	public boolean createStateMachine(String msg) throws RemoteException{
		try {
			BaseDistante bs =(BaseDistante)
			Naming.lookup ("//127.0.0.1/Base");
			bs.createStateMachine(msg);
			
			}
			catch (Exception e){
			System.out.println ("exception: " + e);
			}
		//new Publisher().sendMessage("persistance", msg);
		return false;
	}

}
