package gpi.metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utils.MaConnexion;

public class PrestataireDAO {
	
	public int ajouterPrestataire(Prestataire prestataire){
		Connection connection=null;
		int resultat;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection.prepareStatement("INSERT INTO PRESTATAIRE(nomPrestataire,prenomPrestataire, telPrestataire, societePrestataire) VALUES (?,?,?,?);");
			
			prep.setString(1, prestataire.getNomPrestataire().getValue());
			prep.setString(2, prestataire.getPrenomPrestataire().getValue());
			prep.setString(3, prestataire.getTelPrestataire().getValue());
			prep.setString(4, prestataire.getSocieteePrestataire().getValue());
			
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
			PreparedStatement prep = connection.prepareStatement("UPDATE SITE SET nomPrestataire=?, cheminImageSite=?,  WHERE idSite=?;");
			
			prep.setString(1, site.getNomSiteString());
			prep.setString(2, site.getCheminImageSite());
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
		ArrayList<Site> listSite=new ArrayList<Site>();
		ResultSet resultat;
		String nomSite,cheminImageSite;
		int idSite;
		Site site;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection.prepareStatement("SELECT * FROM SITE;");
			
			
			resultat=prep.executeQuery();
			while(resultat.next()){
				
				idSite=resultat.getInt("idSite");
				nomSite=resultat.getString("nomSite");
				cheminImageSite=resultat.getString("cheminImageSite");
				//System.out.println(idSite+" "+nomSite+" "+cheminImageSite);
				site=new Site(idSite,nomSite,cheminImageSite);
				//System.out.println(site);
				listSite.add(site);
			}
			return listSite;
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
