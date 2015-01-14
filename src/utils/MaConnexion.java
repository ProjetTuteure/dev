package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MaConnexion {
	static private MaConnexion maConnexion;
	static private Connection connexion;
	
	public static synchronized MaConnexion getInstance(){
		if(maConnexion==null){
			maConnexion=new MaConnexion();
		}
		return maConnexion;
	}
	
	public Connection getConnexion(){
		return this.connexion;
	}
	
	private MaConnexion(){
		
		Properties p = Propriete.getInstance().getProperties();
		String url = "jdbc:sqlserver://"+p.getProperty("ipBD")+":"+p.getProperty("port")+";databaseName="+p.getProperty("base")+";";
		String mdp = p.getProperty("mdp");
		String user= p.getProperty("user");
		try {
			this.connexion = DriverManager.getConnection(url,user,mdp);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
