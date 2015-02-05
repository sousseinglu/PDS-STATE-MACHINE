package model;

import java.sql.*;

public class StateMachineDAO {
	
	   public void createStateMachine(String nomMachine, String user) {
		   Connection cx = null;
	       PreparedStatement st = null;
	       ResultSet rs = null;
	       try {
	    	   ConnexionDAO cd = new ConnexionDAO();
	           cx = cd.getConnexion();
	           st = cx.prepareStatement("insert into machine_a_etat(nomMachine_a_etat, utilisateur) values (?,?)");
	           st.setString(1, nomMachine);
	           st.setString(2, user);
	           rs = st.executeQuery();
	       } catch (Exception e) {
	           throw new RuntimeException(e);
	       } finally {
	           try { if (rs != null) rs.close(); } catch (SQLException sqle) {}
	           try { if (st != null) st.close(); } catch (SQLException sqle) {}
	           try { if (cx != null) cx.close(); } catch (SQLException sqle) {}
	       }
	       
	   }

}
