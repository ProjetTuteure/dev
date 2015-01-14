package gpi.metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.MaConnexion;

public class ComposantDAO {

	public ComposantDAO(){}
	
//	public int ajouterComposant(Composant composant){
//		Connection connexion = MaConnexion.getInstance().getConnexion();
//		Connection connection;
//		int resultat;
//		try{
//			connection=MaConnexion.getInstance().getConnexion();
//			PreparedStatement prep = connection.prepareStatement("INSERT INTO SITE VALUES (?,?,?);");
//			
//			prep.setInt(1, site.getIdSite());
//			prep.setString(2, site.getNomSiteString());
//			prep.setString(3, site.getCheminImageSiteProperty().toString());
//			
//			resultat=prep.executeUpdate();
//			return resultat;
//		}catch(SQLException e){
//			e.printStackTrace();
//		}finally{
//			connection.close();
//		}
//		
//		
//		return 1;
//	}
}
