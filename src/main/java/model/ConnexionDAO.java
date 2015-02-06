package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionDAO  {

   @SuppressWarnings("unused")
public Connection getConnexion() throws Exception {
       // Chargement du driver
       Class.forName("com.mysql.jdbc.Driver");
       // Obtention de la connexion
       String url = "jdbc:mysql://localhost:3306/todolist";
       Connection cx = DriverManager.getConnection(url, "root", "root");
       return cx;
   }

}