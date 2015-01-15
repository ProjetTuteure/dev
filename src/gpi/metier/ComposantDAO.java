package gpi.metier;

import gpi.exception.ConnexionBDException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import utils.MaConnexion;

public class ComposantDAO {

	public ComposantDAO() {
	}

	public int ajouterComposant(Composant composant) throws ConnexionBDException{
		Connection connexion = MaConnexion.getInstance().getConnexion();
		int resultat;
		try {
			connexion = MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connexion
					.prepareStatement("INSERT INTO SITE (nomComposant, caracteristiqueComposant, idFabricant)  VALUES (?,?,?);");

			prep.setString(1, composant.getNomComposant());
			prep.setString(2, composant.getcaracteristiqueComposant());
			prep.setInt(3, composant.getFabricantComposant().getIdFabricant()
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

	public int suprimerComposant(Composant composant) throws ConnexionBDException{
		
		Connection connexion = MaConnexion.getInstance().getConnexion();
		int resultat;
		try {
			connexion = MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connexion
					.prepareStatement("DELETE FROM COMPOSANT WHERE idComposant = ?;");

			prep.setInt(1, composant.getIdComposant());
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

	public int modifierComposant(Composant composant) throws ConnexionBDException{
		Connection connexion = MaConnexion.getInstance().getConnexion();
		int resultat;
		try {
			connexion = MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connexion
					.prepareStatement("UPDATE COMPOSANT SET nomComposant=?, caracteristiqueComposant=?, idFabricant=? WHERE idComposant=?");

			prep.setString(1, composant.getNomComposant());
			prep.setString(2, composant.getcaracteristiqueComposant());
			prep.setInt(3, composant.getFabricantComposant().getIdFabricant()
					.getValue());
			prep.setInt(4, composant.getIdComposant());
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

	public Composant recupererComposantParId(int idComposant) throws ConnexionBDException{
		FabricantDAO fabricantDAO = new FabricantDAO();
		Connection connexion = MaConnexion.getInstance().getConnexion();
		ResultSet resultat;
		ResultSetMetaData resultMeta;
		try {
			PreparedStatement prep = connexion
					.prepareStatement("SELECT * from COMPOSANT WHERE idcomposant=?");

			prep.setInt(1, idComposant);
			resultat = prep.executeQuery();
			resultMeta = resultat.getMetaData();
			String nomComposant = resultat.getString(2);
			String caracteristiqueComposant = resultat.getString(3);
			int idFabricant = resultat.getInt(4);
			return new Composant(new SimpleIntegerProperty(idComposant),
					nomComposant, caracteristiqueComposant,
					fabricantDAO.recupererFabricantParId(idFabricant));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List recupererAllComposant() throws ConnexionBDException{
		List<Composant> listComposant = new ArrayList<Composant>();
		FabricantDAO fabricantDAO = new FabricantDAO();
		Connection connexion = MaConnexion.getInstance().getConnexion();
		ResultSet resultat;
		ResultSetMetaData resultMeta;
		try {
			PreparedStatement prep = connexion
					.prepareStatement("SELECT * from COMPOSANT");
			resultat = prep.executeQuery();
			resultMeta = resultat.getMetaData();
			while (resultat.next()) {
				int idComposant = resultat.getInt(1);
				String nomComposant = resultat.getString(2);
				String caracteristiqueComposant = resultat.getString(3);
				int idFabricant = resultat.getInt(4);
				listComposant.add(new Composant(new SimpleIntegerProperty(
						idComposant), nomComposant, caracteristiqueComposant,
						fabricantDAO.recupererFabricantParId(idFabricant)));
			}
			return listComposant;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listComposant;
	}
}
