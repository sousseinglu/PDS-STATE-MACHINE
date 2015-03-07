package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModelConnexionDAO  {

   @SuppressWarnings("unused")
public Connection getConnexion() {
	   Connection cx = null;
	   try {
       System.out.println("Chargement du driver");
	   
	   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
	   System.out.println("Driver chargé");
       // Obtention de la connexion
       String url = "jdbc:mysql://localhost:3306/pds";
       System.out.println("pre Get Connexion");
       
		cx = DriverManager.getConnection(url, "root", "root");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

       System.out.println("Get Connexion");
       return cx;
   }
 
}