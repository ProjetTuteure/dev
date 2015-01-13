package Test;

import gpi.bd.BDSqlServer;
import gpi.bd.IBD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class testbd {
	public static final String PASS = "123";

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, SQLException {
		
		String chaine="";
		String fichier ="C:\\Program Files\\Gpi\\Configuration.ini";
		String ipBD="Localhost";
		int port=0;
		String base = "test"; 
		
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				String[] parts = ligne.split(">");
				switch(parts[0]){
					case "Adresse_BD":
						ipBD=parts[1];
						break;
					case "Port" : 
						port=Integer.parseInt(parts[1]);
						break;
					case "Base" :
						base=parts[1];
						break;	
				}
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		IBD bd = new BDSqlServer(ipBD, port, base,
				"test3", "test");
		boolean estconnecter = ((BDSqlServer) bd).connexion();
		List result = bd.query("select", "SELECT * FROM PRESTATAIRE;");
		bd.query("", "Delete from prestataire where idprestataire > 2 ");
		for (Object o : result) {
			System.out.println(o.getClass() + " " + o);
		}

		result = bd.query("Select", "select count(*) from prestataire;");
		for (Object o : result) {
			System.out.println(o.getClass() + " " + o);
		}

		bd.deconnexion();

	}
}