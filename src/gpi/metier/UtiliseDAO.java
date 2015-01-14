package gpi.metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.MaConnexion;

public class UtiliseDAO {
	
	public UtiliseDAO() {
	}
	
	public int ajouterUtilise(Utilise utilise){
		Connection connexion = MaConnexion.getInstance().getConnexion();
		int resultat;
		try {
			connexion = MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connexion
					.prepareStatement("INSERT INTO SITE (idUtilisateur, idMateriel)  VALUES (?,?);");

			prep.setInt(1, utilise.getUtilisateurUtilise().getIdUtilisateur().getValue());
			prep.setInt(2, utilise.getMaterielUtilise().getIdMateriel().getValue());
			resultat = prep.executeUpdate();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int supprimerUtlise(Utilise utilise){
		Connection connexion = MaConnexion.getInstance().getConnexion();
		int resultat;
		try {
			connexion = MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connexion
					.prepareStatement("DELETE FROM UTILISE WHERE idUtilisateur=? And idMateriel=?;");
			prep.setInt(1, utilise.getUtilisateurUtilise().getIdUtilisateur().getValue());
			prep.setInt(2, utilise.getMaterielUtilise().getIdMateriel().getValue());
			resultat = prep.executeUpdate();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public List<Utilise> recuperMaterielUtilise(int idutilisateur){
		List<Utilise> listUtilise= new ArrayList<Utilise>();
		
		return listUtilise;
	}
	
	
}