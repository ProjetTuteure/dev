package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MaConnexion {
	static private MaConnexion mc;
	static private Connection c;
	
	public static synchronized MaConnexion getInstance(){
		if(mc==null){
			mc=new MaConnexion();
		}
		return mc;
	}
	
	public Connection getConnexion(){
		return this.c;
	}
	
	private MaConnexion(){
		
		Properties p = Propriete.getInstance().getProperties();
		String url = "jdbc:sqlserver://"+p.getProperty("ipBD")+":"+p.getProperty("port")+";databaseName="+p.getProperty("base")+";";
		String mdp = p.getProperty("mdp");
		String user= p.getProperty("user");
		try {
			this.c = DriverManager.getConnection(url,user,mdp);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
