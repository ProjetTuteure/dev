package gpi.metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.MaConnexion;

public class FactureDAO {

	public FactureDAO(){}
	
	public int ajouterFacture(Facture facture){
		Connection connection=null;
		int resultat;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection.prepareStatement("INSERT INTO FACTURE(dateFacture,montantFacture,idRevendeur) VALUES (?,?,?);");
			
			prep.setString(1, facture.getDateFacture().toString());
			prep.setFloat(2, facture.getMontantFacture().get());
			prep.setInt(3, facture.getRevendeurFacture().getIdRevendeur().get());
			
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
	
	public int modifierFacture(Facture facture){
		Connection connection=null;
		int resultat;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection.prepareStatement("UPDATE FACTURE SET dateFacture=?, montantFacture=? , idRevendeur=? WHERE idFacture=? ;");
			
			prep.setString(1, facture.getDateFacture().toString());
			prep.setFloat(2, facture.getMontantFacture().get());
			prep.setInt(3, facture.getRevendeurFacture().getIdRevendeur().get());
			prep.setInt(4, facture.getIdFacture());
			
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
	
	public int supprimerFacture(Facture facture){
		Connection connection=null;
		int resultat;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection.prepareStatement("DELETE FROM FACTURE WHERE idFacture=?;");
			
			prep.setInt(1, facture.getIdFacture());
			
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
	
	public Site recupererFactureParId(int idSite){
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
}
