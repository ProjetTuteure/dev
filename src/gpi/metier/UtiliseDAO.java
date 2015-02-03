package gpi.metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import gpi.exception.ConnexionBDException;
import utils.MaConnexion;
import utils.Popup;
import utils.UtilisateursDetailsMachine;

public class UtiliseDAO {

	public UtiliseDAO() {
	}

	public int ajouterUtilise(Utilise utilise) throws ConnexionBDException {
		Connection connexion = MaConnexion.getInstance().getConnexion();
		int resultat;
		try {
			connexion = MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connexion
					.prepareStatement("INSERT INTO UTILISE (dateUtilise, idUtilisateur, idMateriel)  VALUES (?,?,?);");

			prep.setString(1,utilise.getDateUtiliseStringProperty().getValue());
			prep.setInt(2, utilise.getUtilisateurUtilise().getIdUtilisateur().getValue());
			prep.setInt(3, utilise.getMaterielUtilise().getIdMateriel()	.getValue());
			resultat = prep.executeUpdate();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connexion != null){
					connexion.close();
				}
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
			prep.setInt(1, utilise.getUtilisateurUtilise().getIdUtilisateur().getValue());
			prep.setInt(2, utilise.getMaterielUtilise().getIdMateriel().getValue());
			resultat = prep.executeUpdate();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connexion != null){
					connexion.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public List<Utilise> recuperMaterielUtiliseAll() throws ConnexionBDException {
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
		}finally{
			try {
				if (connexion != null){
					connexion.close();
				}
			} catch (SQLException e) {
				new Popup(e.getMessage());
			}
		}
		return listUtilise;
	}
	
	public String recupererNomDernierUtilisateurMachine(Integer idMateriel){
		
		Connection connexion;
		ResultSet resultat;
		int idUtilisateur;
		Utilisateur utilisateur;
		UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
		String nomUtilisateur="";
		try {
			connexion =  MaConnexion.getInstance().getConnexion();
			PreparedStatement statement = connexion.prepareStatement("SELECT idUtilisateur FROM UTILISE WHERE idMateriel=? AND dateUtilise>=ALL(SELECT dateUtilise FROM UTILISE WHERE idMateriel=?) ");
			statement.setInt(1, idMateriel.intValue());
			statement.setInt(2, idMateriel.intValue());
			resultat=statement.executeQuery();
			if(resultat.next()){
				idUtilisateur=resultat.getInt(1);
				utilisateur=utilisateurDAO.recupererUtilisateurParId(idUtilisateur);
				nomUtilisateur=utilisateur.getNomUtilisateur().getValue()+" "+utilisateur.getPrenomUtilisateur().getValue();
			}else{
				nomUtilisateur="Aucun utilisateur";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		return nomUtilisateur;	
	}
	
	public List<UtilisateursDetailsMachine> recupererUtilisateursParMachine(int idMateriel) throws ConnexionBDException {
		Connection connexion = MaConnexion.getInstance().getConnexion();
		List<UtilisateursDetailsMachine> listeUtilisateur = new ArrayList<>();
		try {
			PreparedStatement ps = connexion.prepareStatement("SELECT * FROM UTILISE WHERE idMateriel=? ORDER BY dateUtilise asc");
			ps.setInt(1, idMateriel);
			ResultSet rs = ps.executeQuery();
			UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
			Utilisateur utilisateur;
			String dateDebut,dateFin;
			rs.next();
			utilisateur=utilisateurDAO.recupererUtilisateurParId(rs.getInt("idUtilisateur"));
			dateDebut=rs.getString("dateUtilise");
			while (rs.next()) {
				dateFin=rs.getString("dateUtilise");
				listeUtilisateur.add(new UtilisateursDetailsMachine(utilisateur.getNomUtilisateur().getValue(),utilisateur.getPrenomUtilisateur().getValue(),utilisateur.getTelUtilisateur().getValue(),dateDebut,dateFin));
				utilisateur=utilisateurDAO.recupererUtilisateurParId(rs.getInt("idUtilisateur"));
				dateDebut=rs.getString("dateUtilise");
			}
			dateFin="";
			listeUtilisateur.add(new UtilisateursDetailsMachine(utilisateur.getNomUtilisateur().getValue(),utilisateur.getPrenomUtilisateur().getValue(),utilisateur.getTelUtilisateur().getValue(),dateDebut,dateFin));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connexion != null){
					connexion.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return listeUtilisateur;
	}

}
