package gpi.metier;

import java.sql.Connection;
import java.sql.PreparedStatement;

import utils.MaConnexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;

public class UtilisateurDAO {

	public UtilisateurDAO() {
	}

	public int ajouterUtilisateur(Utilisateur ut) {
		Connection connection = null;
		int resultat;
		try {
			connection = MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection
					.prepareStatement("INSERT INTO UTILISATEUR(nomUtilisateur,prenomUtilisateur,telUtilisateur) VALUES (?,?,?);");

			prep.setString(1, ut.getNomUtilisateur().getValue());
			prep.setString(2, ut.getPrenomUtilisateur().getValue());
			prep.setString(3, ut.getTelUtilisateur().getValue());

			resultat = prep.executeUpdate();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int modifierUtilisateur(Utilisateur ut) {
		Connection connection = null;
		int resultat;
		try {
			connection = MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection
					.prepareStatement("UPDATE UTILISATEUR SET nomUtilisateur=?, prenomUtilisateur=?, telUtilisateur=? WHERE idUtilisateur=?;");

			prep.setString(1, ut.getNomUtilisateur().getValue());
			prep.setString(2, ut.getPrenomUtilisateur().getValue());
			prep.setString(3, ut.getTelUtilisateur().getValue());
			prep.setInt(4, ut.getIdUtilisateur().get());

			resultat = prep.executeUpdate();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int supprimerUtilisateur(Utilisateur ut) {
		Connection connection = null;
		int resultat;
		try {
			connection = MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection
					.prepareStatement("DELETE FROM SITE WHERE idUtilisateur=?;");

			prep.setInt(1, ut.getIdUtilisateur().get());

			resultat = prep.executeUpdate();
			return resultat;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public Utilisateur recupererUtilisateurParId(int idUtilisateur) {
		Connection connection = null;
		ResultSet resultat;
		String nomUtilisateur, prenomUtilisateur, telUtilisateur;
		try {
			connection = MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection
					.prepareStatement("SELECT * FROM UTILISATEUR WHERE idUtilisateur=?;");

			prep.setInt(1, idUtilisateur);

			resultat = prep.executeQuery();
			nomUtilisateur = resultat.getString(1);
			prenomUtilisateur = resultat.getString(2);
			telUtilisateur = resultat.getString(3);

			return new Utilisateur(new SimpleIntegerProperty(idUtilisateur),
					nomUtilisateur, prenomUtilisateur, telUtilisateur);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<Utilisateur> recupererUtilisateurParNom(String nomUtilisateur) {
		Connection connection = null;
		List<Utilisateur> list = null; 
		ResultSet resultat;
		String prenomUtilisateur, telUtilisateur;
		int idUtilisateur;
		try {
			connection = MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection
					.prepareStatement("SELECT * FROM UTILISATEUR WHERE nomUtilisateur=?;");

			prep.setString(1,nomUtilisateur);

			resultat = prep.executeQuery();
		/*idUtilisateur = resultat.getInt(1);
			prenomUtilisateur = resultat.getString(2);
			telUtilisateur = resultat.getString(3);*/

			while (resultat.next()){
				list=new ArrayList<Utilisateur>();
				list.add(new Utilisateur(new SimpleIntegerProperty(resultat.getInt("idUtilisateur")),
						resultat.getString("nomUtilisateur"),
						resultat.getString("prenomUtilisateur"),
						resultat.getString("telUtilisateur")));
				//list.add(new Utilisateur(new SimpleIntegerProperty(idUtilisateur), nomUtilisateur, prenomUtilisateur, telUtilisateur));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public ArrayList<Utilisateur> recupererAllUtilisateur() {
		Connection connection = null;
		ArrayList<Utilisateur> listUtilisateur = new ArrayList<Utilisateur>();
		ResultSet resultat;
		String nomUtilisateur, prenomUtilisateur, telUtilisateur;
		int idUtilisateur;
		Utilisateur utilisateur;
		try {
			connection = MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection
					.prepareStatement("SELECT * FROM UTILISATEUR;");

			resultat = prep.executeQuery();
			while (resultat.next()) {

				idUtilisateur = resultat.getInt("idUtilisateur");
				nomUtilisateur = resultat.getString("nomUtilisateur");
				prenomUtilisateur = resultat.getString("prenomUtilisateur");
				telUtilisateur = resultat.getString("telUtilisateur");
				// System.out.println(idSite+" "+nomSite+" "+cheminImageSite);
				utilisateur = new Utilisateur(new SimpleIntegerProperty(
						idUtilisateur), nomUtilisateur, prenomUtilisateur,
						telUtilisateur);
				// System.out.println(site);
				listUtilisateur.add(utilisateur);
			}
			return listUtilisateur;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
