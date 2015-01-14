package gpi.metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

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
			PreparedStatement prep = connection.prepareStatement("UPDATE FACTURE SET dateFacture=?, montantFacture=? , idRevendeur=? WHERE numFacture=? ;");
			
			prep.setString(1, facture.getDateFacture().toString());
			prep.setFloat(2, facture.getMontantFacture().get());
			prep.setInt(3, facture.getRevendeurFacture().getIdRevendeur().get());
			prep.setString(4, facture.getNumFacture());
			
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
			PreparedStatement prep = connection.prepareStatement("DELETE FROM FACTURE WHERE numFacture=?;");
			
			prep.setString(1, facture.getNumFacture());
			
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
	
	public Site recupererFactureParNum(String numFacture){
		Connection connection=null;
		ResultSet resultat;
		LocalDate date;
		float montantFacture;
		int idRevendeur;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection.prepareStatement("SELECT * FROM FACTURE WHERE numFacture=?;");
			
			prep.setString(1, numFacture);
			
			resultat=prep.executeQuery();
			date=LocalDate.parse(resultat.getString(1));
			//montantFacture=resultat.getFloat(montantFacture);
			
			//return new Site(idSite,nomSite,cheminImageSite);
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
