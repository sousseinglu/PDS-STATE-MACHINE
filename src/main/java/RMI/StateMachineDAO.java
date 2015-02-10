package RMI;

import java.sql.*;

import metier.ModelConnexionDAO;

public class StateMachineDAO {
	
	   public void createStateMachine(String nomMachine, String user) {
		   Connection cx = null;
	       PreparedStatement st = null;
	       ResultSet rs = null;
	       try {
	    	   ModelConnexionDAO cd = new ModelConnexionDAO();
	           cx = cd.getConnexion();
	           String requete = "insert into machine_a_etat(nomMachine_a_etat, utilisateur) values (?,?)";
	           Statement statement = cx.createStatement();
	           st = cx.prepareStatement(requete);
	           st.setString(1, nomMachine);
	           st.setString(2, user);
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
		   StateMachineDAO smd = new StateMachineDAO();
		   smd.createStateMachine("test", "fred");
	   }
}
