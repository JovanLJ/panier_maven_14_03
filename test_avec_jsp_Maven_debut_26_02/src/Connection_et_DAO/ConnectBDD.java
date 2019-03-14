package Connection_et_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectBDD est la classe qui a pour role de cherger le driver, etablir la connexion � la BDD, mettre � disposition 
 * la connexion au d�veloppeur, et fermer la connexion
 * 
 * @author nico
 */
public class ConnectBDD {
	
	/**
	 * attribut connect de la classe Connexion qu'on va utiliser pour la connexion et l'identification entre la couche m�tier et la BDD
	 */
	private Connection connect;
	   	  
		
	/**
	 * Getter pour utiliser l'objet ailleurs car attribut d�fint comme private
	 * @return connect
	 */
	private Connection getConnection() {
		 // configuration du driver selon le SGBD
		 String driver="oracle.jdbc.driver.OracleDriver";
		 
		 // configuration de la connexion (toujours de type protocole: sous-protocole: nom)
	     String url = "jdbc:oracle:thin:@10.114.132.120:1521/xe";
	     String user  = "panier2019";
	     String psswd = "panier2019";
		try {
	    	 // chargement du pilote qui construit un pont entre couche m�tier et la BDD
	    	 Class.forName(driver);
	    	 System.out.println("ConnectBDD: Driver ok ");
	    	 
	    	 // instruction pour donner l'autorisation d'acc�s � la BDD
	         this.connect = DriverManager.getConnection(url, user, psswd);
	         System.out.println("ConnectBDD:Connexion ok");
	         
	     } catch (ClassNotFoundException e) {	// declenchee en cas d'echec de chargement du driver
	    	 e.printStackTrace();
	    	 
	     } catch (SQLException e) {		// declenchee en cas d'echec de la connexion
	         e.printStackTrace();
	     } 
		
		return this.connect;
	}
	
	public Connection getConnect() {
		// singleton
		if (this.connect==null) {
			this.connect=getConnection();
	
		} return connect;
	}
	
	
	/**
	 * methode pour fermer la connexion
	 */
	public void closeConnexion() {
		
		try {
		connect.close();
		
		} catch (SQLException e){
			e.printStackTrace();
			
		}
	}	 

}
