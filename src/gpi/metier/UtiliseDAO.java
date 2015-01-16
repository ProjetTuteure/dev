package gpi.metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import gpi.exception.ConnexionBDException;
import utils.MaConnexion;

public class UtiliseDAO {

	public UtiliseDAO() {
	}

	public int ajouterUtilise(Utilise utilise) throws ConnexionBDException {
		Connection connexion = MaConnexion.getInstance().getConnexion();
		int resultat;
		try {
			connexion = MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connexion
					.prepareStatement("INSERT INTO UTILISE (dateUtilise idUtilisateur, idMateriel)  VALUES (?,?,?);");

			prep.setString(1,utilise.getDateUtiliseStringProperty().getValue());
			prep.setInt(2, utilise.getUtilisateurUtilise().getIdUtilisateur()
					.getValue());
			prep.setInt(2, utilise.getMaterielUtilise().getIdMateriel()
					.getValue());
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

	public int supprimerUtlise(Utilise utilise) throws ConnexionBDException {
		Connection connexion = MaConnexion.getInstance().getConnexion();
		int resultat;
		try {
			connexion = MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connexion
					.prepareStatement("DELETE FROM UTILISE WHERE idUtilisateur=? And idMateriel=?;");
			prep.setInt(1, utilise.getUtilisateurUtilise().getIdUtilisateur()
					.getValue());
			prep.setInt(2, utilise.getMaterielUtilise().getIdMateriel()
					.getValue());
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

	public List<Utilise> recuperMaterielAll() throws ConnexionBDException {
		List<Utilise> listUtilise = new ArrayList<Utilise>();
		UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
		Connection connexion = MaConnexion.getInstance().getConnexion();
		MaterielDAO materielDAO = new MaterielDAO();
		ResultSet resultat;
		LocalDate date;
		Utilisateur utilisateur;
		Materiel materiel;
		try {
			Statement statement = connexion.createStatement();
            resultat=statement.executeQuery("SELECT * FROM UTILISE");
            while(resultat.next()){
            	date = LocalDate.parse(resultat.getString("dateUtilise"));
            	utilisateur = utilisateurDAO.recupererUtilisateurParId(resultat.getInt("idUtilisateur"));
				materiel = materielDAO.recupererMaterielParId(resultat.getInt("idMateriel"));
                listUtilise.add(new Utilise(date,utilisateur,materiel));
            }
		} catch (SQLException e) {
		}
		return listUtilise;
	}

}