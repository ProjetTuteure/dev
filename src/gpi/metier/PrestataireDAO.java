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
	
	public int modifierPrestaire(Prestataire prestataire){
		Connection connection=null;
		int resultat;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection.prepareStatement("UPDATE PRESTATAIRE SET nomPrestataire=?, prenomPrestaire=?, telPrestataire=?, societePrestataire=?  WHERE idPrestataire=?;");
			
			prep.setString(1, prestataire.getNomPrestataire().getValue());
			prep.setString(2, prestataire.getPrenomPrestataire().getValue());
			prep.setString(3, prestataire.getTelPrestataire().getValue());
			prep.setString(4, prestataire.getSocieteePrestataire().getValue());
			prep.setInt(5, prestataire.getIdPrestataire().getValue());
			
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
	
	public int supprimerSite(Prestataire prestataire){
		Connection connection=null;
		int resultat;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection.prepareStatement("DELETE FROM PRESTATAIRE WHERE idPrestataire=?;");
			
			prep.setInt(1, prestataire.getIdPrestataire().getValue());
			
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
<<<<<<< HEAD
=======
	
>>>>>>> origin/master
}
	
