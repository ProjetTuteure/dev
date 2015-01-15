package utils;

import gpi.exception.BDNonTrouveException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class MaConnexion {
	static private MaConnexion maConnexion;
	
	public static synchronized MaConnexion getInstance(){
		if(maConnexion==null){
			maConnexion=new MaConnexion();
		}
		return maConnexion;
	}
	
	public Connection getConnexion() throws BDNonTrouveException{
		Connection connexion = null;
		Properties p = Propriete.getInstance().getProperties();
		String url = "jdbc:sqlserver://"+p.getProperty("ipBD")+":"+p.getProperty("port")+";databaseName="+p.getProperty("base")+";";
		String mdp = p.getProperty("mdp");
		String user= p.getProperty("user");
		try {
			connexion = DriverManager.getConnection(url,user,mdp);
			if(connexion==null)
			{
				throw new BDNonTrouveException("Connexion impossible");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return connexion;
	}
	
	private MaConnexion(){
	
	}
}
