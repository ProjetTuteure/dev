package gpi.metier;

import gpi.exception.ConnexionBDException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import utils.MaConnexion;

public class MaterielDAO {
	private Connection connection;

	/**
	 * Permet d'ajouter un materiel dans la base de donnees
	 * 
	 * @param materiel
	 *            le materiel � ajouter dans la base de donnees
	 */
	public int ajouterMateriel(Materiel materiel) throws ConnexionBDException {
		int nombreLigneAffectee = 0;
		try {
			connection = MaConnexion.getInstance().getConnexion();
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO MATERIEL (numImmobMateriel,nomMateriel,dateExpirationGarantieMateriel,"
							+ "repertoireDrivers,modeleMateriel,etat,idFacture,idFabricant,idSite,idType) "
							+ "VALUES(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, materiel.getNumImmobMateriel().getValue());
			ps.setString(2, materiel.getNomMateriel().getValue());
			ps.setString(3, materiel.getDateExpirationGarantie().toString());
			ps.setString(4, materiel.getRepertoireDriverMateriel().getValue());
			ps.setString(5, materiel.getModeleMateriel());
			ps.setString(6, materiel.getEtatMateriel().toString());
			ps.setString(7, materiel.getFactureMateriel().getNumFacture());
			ps.setInt(8, materiel.getFabricantMateriel().getIdFabricant()
					.getValue());
			ps.setInt(9, materiel.getSiteMateriel().getIdSiteProperty()
					.getValue());
			ps.setString(10, materiel.getTypeMateriel().getNomType().getValue());
			nombreLigneAffectee = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return nombreLigneAffectee;
	}

	/**
	 * Permet de modifier un materiel
	 * 
	 * @param materiel
	 *            le materiel � modifier
	 */
	public void modifierMateriel(Materiel materiel) throws ConnexionBDException {
		Connection connexion = MaConnexion.getInstance().getConnexion();
		try {
			PreparedStatement ps = connexion
					.prepareStatement("UPDATE MATERIEL SET numImmobMateriel=?,nomMateriel=?,dateExpirationGarantieMateriel=?,"
							+ "repertoireDrivers=?,modeleMateriel=?,etat=?,idFacture=?,idFabricant=?,idSite=?,idType=?  "
							+ "WHERE idMateriel=?");
			ps.setString(1, materiel.getNumImmobMateriel().getValue());
			ps.setString(2, materiel.getNomMateriel().getValue());
			ps.setString(3, materiel.getDateExpirationGarantie().toString());
			ps.setString(4, materiel.getRepertoireDriverMateriel().getValue());
			ps.setString(5, materiel.getModeleMateriel());
			ps.setString(6, materiel.getEtatMateriel().toString());
			ps.setString(7, materiel.getFactureMateriel().getNumFacture());
			ps.setInt(8, materiel.getFabricantMateriel().getIdFabricant()
					.getValue());
			ps.setInt(9, materiel.getSiteMateriel().getIdSiteProperty()
					.getValue());
			ps.setString(10, materiel.getTypeMateriel().getNomType().getValue());
			ps.setInt(11, materiel.getIdMateriel().getValue());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Permet de supprimer un materiel
	 * 
	 * @param materiel
	 *            le materiel � supprimer
	 */
	public void supprimerMateriel(Materiel materiel)
			throws ConnexionBDException {
		Connection connexion = MaConnexion.getInstance().getConnexion();
		try {
			PreparedStatement ps = connexion
					.prepareStatement("DELETE FROM MATERIEL WHERE idMateriel=?");
			ps.setInt(1, materiel.getIdMateriel().getValue());
			ps.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				connexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Materiel recupererMaterielParId(int idMateriel)
			throws ConnexionBDException {
		ResultSet resultat;
		Materiel materiel = null;
		try {
			connection = MaConnexion.getInstance().getConnexion();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM MATERIEL WHERE idMateriel=?;");
			preparedStatement.setInt(1, idMateriel);
			resultat = preparedStatement.executeQuery();
			resultat.next();
			TypeDAO typeDAO = new TypeDAO();
			Type typeMateriel = typeDAO.recupererTypeParId(resultat
					.getInt("idType"));
			LocalDate dateExpirationGarantieMateriel = LocalDate.parse(resultat
					.getString("dateExpirationGarantieMateriel"));
			FactureDAO factureDAO = new FactureDAO();
			Facture factureMateriel = factureDAO.recupererFactureParId(resultat
					.getInt("idFacture"));
			SiteDAO siteDAO = new SiteDAO();
			Site siteMateriel = siteDAO.recupererSiteParId(resultat
					.getInt("idSite"));
			FabricantDAO fabricantDAO = new FabricantDAO();
			Fabricant fabricantMateriel = fabricantDAO
					.recupererFabricantParId(resultat.getInt("idFabricant"));
			materiel = new Materiel(resultat.getInt("idMateriel"),
					resultat.getString("numImmobMateriel"),
					resultat.getString("nomMateriel"), typeMateriel,
					Etat.valueOf(resultat.getString("etat")),
					dateExpirationGarantieMateriel,
					resultat.getString("repertoireDrivers"), factureMateriel,
					siteMateriel, fabricantMateriel,
					resultat.getString("modeleMateriel"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return materiel;
	}

	public List<Materiel> recupererAllMateriel() throws ConnexionBDException {
		ResultSet resultat;
		List<Materiel> listMateriel = new ArrayList<Materiel>();
		try {
			connection = MaConnexion.getInstance().getConnexion();
			Statement statement = connection.createStatement();
			resultat = statement.executeQuery("SELECT * FROM MATERIEL");
			while (resultat.next()) {
				TypeDAO typeDAO = new TypeDAO();
				Type typeMateriel = typeDAO.recupererTypeParId(resultat
						.getInt("idType"));
				LocalDate dateExpirationGarantieMateriel = LocalDate
						.parse(resultat
								.getString("dateExpirationGarantieMateriel"));
				FactureDAO factureDAO = new FactureDAO();
				Facture factureMateriel = factureDAO
						.recupererFactureParId(resultat.getInt("idFacture"));
				SiteDAO siteDAO = new SiteDAO();
				Site siteMateriel = siteDAO.recupererSiteParId(resultat
						.getInt("idSite"));
				FabricantDAO fabricantDAO = new FabricantDAO();
				Fabricant fabricantMateriel = fabricantDAO
						.recupererFabricantParId(resultat.getInt("idFabricant"));
				listMateriel.add(new Materiel(resultat.getInt("idMateriel"),
						resultat.getString("numImmobMateriel"), resultat
								.getString("nomMateriel"), typeMateriel, Etat
								.valueOf(resultat.getString("etat")),
						dateExpirationGarantieMateriel, resultat
								.getString("repertoireDrivers"),
						factureMateriel, siteMateriel, fabricantMateriel,
						resultat.getString("modeleMateriel")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listMateriel;
	}

	public List<Materiel> recupererMaterielParSiteEtType(Site site, Type type)
			throws ConnexionBDException {
		List<Materiel> listMateriel = new ArrayList<Materiel>();
		ResultSet resultat;
		Materiel materiel = null;
		try {
			connection = MaConnexion.getInstance().getConnexion();
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT * FROM MATERIEL WHERE idType=? And idSite=?;");
			preparedStatement.setInt(1, type.getIdType());
			preparedStatement.setInt(2, site.getIdSite());
			resultat = preparedStatement.executeQuery();
			TypeDAO typeDAO = new TypeDAO();
			SiteDAO siteDAO = new SiteDAO();
			while (resultat.next()) {
				Type typeMateriel = typeDAO.recupererTypeParId(resultat
						.getInt("idType"));
				LocalDate dateExpirationGarantieMateriel = LocalDate
						.parse(resultat
								.getString("dateExpirationGarantieMateriel"));
				FactureDAO factureDAO = new FactureDAO();
				Facture factureMateriel = factureDAO
						.recupererFactureParId(resultat.getInt("idFacture"));
				Site siteMateriel = siteDAO.recupererSiteParId(resultat
						.getInt("idSite"));
				FabricantDAO fabricantDAO = new FabricantDAO();
				Fabricant fabricantMateriel = fabricantDAO
						.recupererFabricantParId(resultat.getInt("idFabricant"));
				listMateriel.add( new Materiel(resultat.getInt("idMateriel"),
						resultat.getString("numImmobMateriel"),
						resultat.getString("nomMateriel"), typeMateriel,
						Etat.valueOf(resultat.getString("etat")),
						dateExpirationGarantieMateriel,
						resultat.getString("repertoireDrivers"),
						factureMateriel, siteMateriel, fabricantMateriel,
						resultat.getString("modeleMateriel")));
			}
			return listMateriel;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listMateriel;
	}

}
