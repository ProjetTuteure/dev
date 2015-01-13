package Test;

import gpi.bd.BDSqlServer;
import gpi.bd.IBD;

import java.io.File;
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
		
		
		IBD bd = new BDSqlServer("192.168.137.169", 1433, "ProjetTutore",
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