package gpi.metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.MaConnexion;

public class SiteDAO {

	public SiteDAO(){}
	
	//ajouter/modifier/supprimer/recuperer
	
	public int ajouterSite(Site site){
		Connection connection=null;
		int resultat;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection.prepareStatement("INSERT INTO SITE(nomSite,cheminImageSite) VALUES (?,?);");
			
			prep.setString(1, site.getNomSiteString());
			prep.setString(2, site.getCheminImageSiteProperty().toString());
			
			resultat=prep.executeUpdate();
			return resultat;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int modifierSite(Site site){
		Connection connection=null;
		int resultat;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection.prepareStatement("UPDATE SITE SET nomSite=?, cheminImageSite=? WHERE idSite=?;");
			
			prep.setString(1, site.getNomSiteString());
			prep.setString(2, site.getCheminImageSiteProperty().toString());
			prep.setInt(3, site.getIdSite());
			
			resultat=prep.executeUpdate();
			return resultat;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int supprimerSite(Site site){
		Connection connection=null;
		int resultat;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection.prepareStatement("DELETE FROM SITE WHERE idSite=?;");
			
			prep.setInt(1, site.getIdSite());
			
			resultat=prep.executeUpdate();
			return resultat;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public Site recupererSiteParId(int idSite){
		Connection connection=null;
		ResultSet resultat;
		String nomSite,cheminImageSite;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection.prepareStatement("SELECT * FROM SITE WHERE idSite=?;");
			
			prep.setInt(1, idSite);
			
			resultat=prep.executeQuery();
			nomSite=resultat.getString(1);
			cheminImageSite=resultat.getString(2);
			
			return new Site(idSite,nomSite,cheminImageSite);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public ArrayList<Site> recupererAllSite(){
		Connection connection=null;
		List<Site> listSite=new ArrayList<Site>();
		ResultSet resultat;
		String nomSite,cheminImageSite;
		int idSite;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection.prepareStatement("SELECT * FROM SITE;");
			
			
			resultat=prep.executeQuery();
			while(resultat.next()){
				
				idSite=resultat.getInt("idSite");
				nomSite=resultat.getString("nomSite");
				cheminImageSite=resultat.getString("cheminImageSite");
				listSite.add(new Site(idSite,nomSite,cheminImageSite));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
}
