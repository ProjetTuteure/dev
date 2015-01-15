package gpi.metier;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import utils.MaConnexion;
import utils.Popup;

public class FactureDAO {

	public FactureDAO(){}
	
	public int ajouterFacture(Facture facture){
		Connection connection=null;
		int resultat;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection.prepareStatement("INSERT INTO FACTURE(numFacture,dateFacture,montantFacture,idRevendeur) VALUES (?,?,?,?);");
			prep.setString(1, facture.getNumFacture());
			prep.setString(2, facture.getDateFacture().toString());
			prep.setFloat(3, facture.getMontantFacture().get());
			prep.setInt(4, facture.getRevendeurFacture().getIdRevendeur().get());
			
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
	
	public Facture recupererFactureParNum(String numFacture){
		Connection connection=null;
		ResultSet resultat;
		LocalDate dateFacture;
		float montantFacture;
		int idRevendeur;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			RevendeurDAO revendeurDAO=new RevendeurDAO();
			PreparedStatement prep = connection.prepareStatement("SELECT * FROM FACTURE WHERE numFacture=?;");
			
			prep.setString(1, numFacture);
			
			resultat=prep.executeQuery();
			dateFacture=LocalDate.parse(resultat.getString("dateFacture"));
			montantFacture=resultat.getFloat("montantFacture");
			idRevendeur=resultat.getInt("idRevendeur");
			
			return new Facture(numFacture,dateFacture,montantFacture,revendeurDAO.recupererRevendeurParId(idRevendeur));
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
	
	
	public List<Facture> recupererAllFacture(){
		Connection connection=null;
		RevendeurDAO revendeurDAO=new RevendeurDAO();
		List<Facture> listFacture=new ArrayList<Facture>();
		ResultSet resultat;
		String numFacture;
		LocalDate dateFacture;
		float montantFacture;
		int idRevendeur;
		Facture facture;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection.prepareStatement("SELECT * FROM FACTURE;");
			
			
			resultat=prep.executeQuery();
			while(resultat.next()){
				numFacture=resultat.getString("numFacture");
				dateFacture=LocalDate.parse(resultat.getString("dateFacture"));
				montantFacture=resultat.getFloat("montantFacture");
				idRevendeur=resultat.getInt("idRevendeur");
				facture=new Facture(numFacture,dateFacture,montantFacture,revendeurDAO.recupererRevendeurParId(idRevendeur));
				listFacture.add(facture);
			}
			return listFacture;
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
