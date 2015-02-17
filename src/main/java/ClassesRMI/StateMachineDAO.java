package ClassesRMI;

import generatedClasses.Scxml;

import java.sql.*;
import java.util.Hashtable;

import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistance.ModelConnexionDAO;
import persistance.PersistanceHandlerMessage;

public class StateMachineDAO {
	
	   @SuppressWarnings("unchecked")
	public void createStateMachine(String idCorrelation) {
		   
			@SuppressWarnings("rawtypes")
			Hashtable env = new Hashtable();
			env.put(Context.INITIAL_CONTEXT_FACTORY, 
			    "com.sun.jndi.fscontext.RefFSContextFactory");	
			Context ctx;
			try {
				ctx = new InitialContext(env);
				PersistanceHandlerMessage phm = new PersistanceHandlerMessage((TextMessage)ctx.lookup(idCorrelation));
				Scxml scxml = phm.getScxml();
			} catch (NamingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		   Connection cx = null;
	       PreparedStatement st = null;
	       ResultSet rs = null;
	       
	       try {
	    	   ModelConnexionDAO cd = new ModelConnexionDAO();
	           cx = cd.getConnexion();
	           String requete = "insert into machine_a_etat(nomMachine_a_etat, utilisateur) values (?,?)";
	           Statement statement = cx.createStatement();
	           st = cx.prepareStatement(requete);
	           //st.setString(1, nomMachine);
	           //st.setString(2, user);
	           st.executeUpdate();
	           System.out.println("ajout OK !");
	       } catch (Exception e) {
	           throw new RuntimeException(e);
	       } finally {
	           try { if (rs != null) rs.close(); } catch (SQLException sqle) {}
	           try { if (st != null) st.close(); } catch (SQLException sqle) {}
	           try { if (cx != null) cx.close(); } catch (SQLException sqle) {}
	       }
	       
	   }
	   
	   public static void main(String[] args) {
		 // StateMachineDAO smd = new StateMachineDAO();
		 //  smd.createStateMachine("test", "fred");
	   }
}
