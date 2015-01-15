package gpi.bd;

import gpi.metier.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

/**
 * Created by admin on 24/11/14.
 */
public class Donnee {
	private ObservableList<estIntervenu> estIntervenuData = FXCollections
			.observableArrayList();
	private ObservableList<EstMaintenu> estMaintenuData = FXCollections
			.observableArrayList();
	private ObservableList<Etat> etatData = FXCollections.observableArrayList();
	private ObservableList<Fabricant> fabricantData = FXCollections
			.observableArrayList();
	private ObservableList<Facture> factureData = FXCollections
			.observableArrayList();
	private ObservableList<Logiciel> logicielData = FXCollections
			.observableArrayList();
	private ObservableList<Maintenance> maintenanceData = FXCollections
			.observableArrayList();
	private ObservableList<Materiel> materielData = FXCollections
			.observableArrayList();
	private ObservableList<Prestataire> prestataireData = FXCollections
			.observableArrayList();
	private ObservableList<Revendeur> revendeurData = FXCollections
			.observableArrayList();
	private ObservableList<Site> siteData = FXCollections.observableArrayList();
	private ObservableList<Type> typeData = FXCollections.observableArrayList();
	private ObservableList<Utilisateur> utilisateurData = FXCollections
			.observableArrayList();
	private ObservableList<Utilise> utiliseData = FXCollections
			.observableArrayList();
	private ObservableList<Composant> composantData = FXCollections
			.observableArrayList();

	public Donnee() {
		remplirSiteData();
		remplirTypeData();
		remplirRevendeurData();
		remplirFabricantData();
	/*	remplirFactureData();*/
		remplirMaterielData();
		remplirLogicielData();
		remplirUtilisateurData();
		remplirUtiliseData();
		remplirMaintenanceData();
		remplirEstMaintenuData();
		remplirPrestaraireData();
		remplirComposantData();
	}

	public ObservableList<Site> getSiteData() {
		return siteData;
	}

	public ObservableList<Type> getTypeData() {
		return typeData;
	}

	public ObservableList<Revendeur> getRevendeurData() {
		return revendeurData;
	}

	public ObservableList<Prestataire> getPrestataireData() {
		return prestataireData;
	}

	public ObservableList<Facture> getFactureData() {
		return factureData;
	}

	public ObservableList<Fabricant> getFabricantData() {
		return fabricantData;
	}

	public ObservableList<Materiel> getMaterielData() {
		return materielData;
	}

	public ObservableList<Maintenance> getMaintenanceData() {
		return maintenanceData;
	}

	public ObservableList<EstMaintenu> getEstMaintenuData() {
		return estMaintenuData;
	}

	public ObservableList<Utilise> getUtiliseData() {
		return utiliseData;
	}

	public ObservableList<Logiciel> getLogicielData() {
		return logicielData;
	}

	public ObservableList<Composant> getComposantData() {
		return composantData;
	}

	public ObservableList<Utilisateur> getUtilisateurData() {
		return utilisateurData;
	}

	private void remplirFabricantData() {
		fabricantData.add(new Fabricant(1, "DELL",
				"05.55.66.77.88", "2 route perdu 87000"));
		fabricantData.add(new Fabricant(1, "HP",
				"05.55.66.77.88", "2 route perdu 87000"));
	}

	private void remplirPrestaraireData() {
		prestataireData.add(new Prestataire(1,
				"Caillou", "Pierre", "05.55.69.87.23", "Caillou et Co."));
		prestataireData.add(new Prestataire(2,
				"Noel", "Papa", "00.36.65.65.65", "Pole Nord"));
	}

	private void remplirMaterielData() {
		materielData
				.add(new Materiel(new SimpleIntegerProperty(1), "1IMMO",
						"pc-martine", typeData.get(0), Etat.EN_MARCHE,
						LocalDate.parse("2012-11-11"), "/driver/pc-martine",
						null, siteData.get(0), fabricantData
								.get(0), "XXX1"));
		materielData.add(new Materiel(new SimpleIntegerProperty(2), "2IMMO",
				"pc-gertrude", typeData.get(0), Etat.EN_MARCHE, LocalDate
						.parse("2012-11-11"), "/driver/pc-gertrude",
				null, siteData.get(0), fabricantData.get(1),
				"XXX2"));
		materielData.add(new Materiel(new SimpleIntegerProperty(3), "3IMMO",
				"PC1", typeData.get(0), Etat.EN_MARCHE, LocalDate
						.parse("2014-12-31"), "", null, siteData
						.get(0), fabricantData.get(0), "XXX3"));
		materielData.add(new Materiel(new SimpleIntegerProperty(4), "4IMMO",
				"PC2", typeData.get(0), Etat.EN_MARCHE, LocalDate
						.parse("2015-12-31"), "", null, siteData
						.get(1), fabricantData.get(0), "XXX4"));
		materielData.add(new Materiel(new SimpleIntegerProperty(5), "5IMMO",
				"PC3", typeData.get(0), Etat.EN_MARCHE, LocalDate
						.parse("2014-02-05"), "", null, siteData
						.get(2), fabricantData.get(0), "XXX5"));
		materielData.add(new Materiel(new SimpleIntegerProperty(6), "6IMMO",
				"Routeur1", typeData.get(1), Etat.EN_MARCHE, LocalDate
						.parse("2017-02-14"), "", null, siteData
						.get(3), fabricantData.get(0), "XXX6"));
		materielData.add(new Materiel(new SimpleIntegerProperty(7), "7IMMO",
				"Routeur2", typeData.get(1), Etat.EN_PANNE, LocalDate
						.parse("2012-03-14"), "", null, siteData
						.get(3), fabricantData.get(0), "XXX7<"));
	}

	/*private void remplirFactureData() {
		factureData.add(new Facture("1", LocalDate.parse("2011-11-11"),
				(float) 123.50, revendeurData.get(0)));
		factureData.add(new Facture("2", LocalDate.parse("2012-12-12"),
				(float) 99, revendeurData.get(1)));
	}*/

	private void remplirRevendeurData() {
		revendeurData.add(new Revendeur(new SimpleIntegerProperty(1), "Darty",
				"05.55.21.36.54", "4 rue n'importe ou"));
		revendeurData.add(new Revendeur(new SimpleIntegerProperty(2), "Fnac",
				"05.55.68.57.41", "5 rue je sais pas ou "));
	}

	private void remplirTypeData() {
		typeData.add(new Type("PC", "sources/images/pc.jpg"));
		typeData.add(new Type("Routeur", "sources/images/routeur.png"));
		typeData.add(new Type("Switch", "sources/images/switch.jpg"));
		typeData.add(new Type("Clef 3G", "sources/images/cle3G.PNG"));
	}

	private void remplirSiteData() {
		siteData.add(new Site(1, "Agen", "sources/images/logo-ville-agen0.png"));
		siteData.add(new Site(2, "Bordeaux", "sources/images/bordeaux.jpg"));
		siteData.add(new Site(3, "Chateauroux",
				"sources/images/chateauroux.jpg"));
		siteData.add(new Site(4, "Gueret", "sources/images/Gueret.jpg"));
		siteData.add(new Site(5, "Limoges", "sources/images/limoges.jpg"));
		siteData.add(new Site(6, "Montlucon", "sources/images/montlucon.jpg"));
		siteData.add(new Site(7, "Saint-Agnant",
				"sources/images/saintAgnan.png"));
		siteData.add(new Site(8, "Saint-Junien",
				"sources/images/saintJunien.jpg"));

	}

	private void remplirLogicielData() {
		this.logicielData.add(new Logiciel(new SimpleIntegerProperty(1),
				"Microsoft Office 2012", "1.0", LocalDate.parse("2014-10-01"),
				null));
	}

	private void remplirUtilisateurData() {
		this.utilisateurData.add(new Utilisateur(new SimpleIntegerProperty(1),
				"Bon", "Jean", "05.52.12.35.41"));
		this.utilisateurData.add(new Utilisateur(new SimpleIntegerProperty(2),
				"Leroy", "Arthur", "05.56.84.51.52"));
		this.utilisateurData.add(new Utilisateur(new SimpleIntegerProperty(3),
				"Fury", "Johanna", "05.56.51.98.19"));
		this.utilisateurData.add(new Utilisateur(new SimpleIntegerProperty(4),
				"Garves", "Eddy", "05.87.49.84.12"));
	}

	private void remplirUtiliseData() {
		this.utiliseData.add(new Utilise(utilisateurData.get(0), materielData
				.get(0)));
		this.utiliseData.add(new Utilise(utilisateurData.get(1), materielData
				.get(0)));
		this.utiliseData.add(new Utilise(utilisateurData.get(1), materielData
				.get(1)));
		this.utiliseData.add(new Utilise(utilisateurData.get(2), materielData
				.get(2)));
		this.utiliseData.add(new Utilise(utilisateurData.get(3), materielData
				.get(4)));
		this.utiliseData.add(new Utilise(utilisateurData.get(3), materielData
				.get(3)));
	}

	private void remplirMaintenanceData() {
		this.maintenanceData.add(new Maintenance(new SimpleIntegerProperty(1),
				LocalDate.parse("2014-10-01"), "erreur",
				"une erreur inconnue est survenue", 10));
		this.maintenanceData.add(new Maintenance(new SimpleIntegerProperty(2),
				LocalDate.parse("2012-02-27"), "orage", "tout a grille", 5000));
		this.maintenanceData.add(new Maintenance(new SimpleIntegerProperty(3),
				LocalDate.parse("2014-04-10"), "neige",
				"il a neige dans la salle des serveurs", 999));
		this.maintenanceData
				.add(new Maintenance(
						new SimpleIntegerProperty(4),
						LocalDate.parse("2011-11-11"),
						"utilisateur",
						"j'ai besoin d'une grosse description pour voir ce que ca donne alors je cherche des trucs a ecrire mais comme je trouve pas grand chose je continue a dire n'importe quoi voila la je pense que ca suffira",
						1));
	}

	private void remplirEstMaintenuData() {
		this.estMaintenuData.add(new EstMaintenu(materielData.get(0),
				maintenanceData.get(0)));
		this.estMaintenuData.add(new EstMaintenu(materielData.get(0),
				maintenanceData.get(1)));
		this.estMaintenuData.add(new EstMaintenu(materielData.get(1),
				maintenanceData.get(3)));
		this.estMaintenuData.add(new EstMaintenu(materielData.get(2),
				maintenanceData.get(2)));
		this.estMaintenuData.add(new EstMaintenu(materielData.get(3),
				maintenanceData.get(2)));
		this.estMaintenuData.add(new EstMaintenu(materielData.get(3),
				maintenanceData.get(0)));
	}

	private void remplirComposantData() {
		this.composantData.add(new Composant(new SimpleIntegerProperty(1),
				"trucNull", "pas vraiment bien", fabricantData.get(0)));
		this.composantData.add(new Composant(new SimpleIntegerProperty(2),
				"machinNull", "pas super top", fabricantData.get(1)));
	}

	public Type getTypeByNom(String nom) {
		for (Type type : typeData) {
			if (nom.equals(type.getNomType().getValue())) {
				return type;
			}
		}
		return null;
	}

	public Fabricant getFabricant(String value) {
		for (Fabricant fab : fabricantData) {
			if (value == fab.getNomFabricantString()) {
				return fab;
			}
		}
		return null;
	}

	public Revendeur getRevendeur(String value) {
		for (Revendeur rev : revendeurData) {
			if (value == rev.getNomRevendeur().getValue()) {
				return rev;
			}
		}
		return null;
	}

	public Maintenance getMaintenance(String value) {
		for (Maintenance m : maintenanceData) {
			if (value == m.getObjetMaintenance()) {
				return m;
			}
		}
		return null;
	}

	public Composant getComposant(String value) {
		for (Composant c : composantData) {
			if (value == c.getNomComposant()) {
				return c;
			}
		}
		return null;
	}

	public Maintenance getMaintenance2(String value) {
		for (Maintenance m : maintenanceData) {
			if (value.equals(m.getObjetMaintenance() + " "
					+ m.getdateMaintenanceStringProperty().getValue())) {
				return m;
			}
		}
		return null;
	}

	public Composant getComposant2(String value) {
		for (Composant c : composantData) {
			if (value.equals(c.getNomComposant() + " "
					+ c.getFabricantComposant().getNomFabricantString())) {
				return c;
			}
		}
		return null;
	}

	public Prestataire getPrestaire(String value) {
		for (Prestataire pr : prestataireData) {
			if (value == pr.getNomPrestataire().getValue()) {
				return pr;
			}
		}
		return null;
	}

	public Utilisateur getUtilisateur(String value) {
		for (Utilisateur ut : utilisateurData) {
			if (value == ut.getNomUtilisateur().getValue()) {
				return ut;
			}
		}
		return null;
	}

	public Prestataire getPrestaire2(String value) {
		for (Prestataire pr : prestataireData) {
			if (value.equals(pr.getNomPrestataire().getValue() + " "
					+ pr.getPrenomPrestataire().getValue())) {
				return pr;
			}
		}
		return null;
	}
	
	public Utilisateur getUtilisateur2(String value) {
		for (Utilisateur ut : utilisateurData) {
			if (value.equals(ut.getNomUtilisateur().getValue() + " "
					+ ut.getPrenomUtilisateur().getValue())) {
				return ut;
			}
		}
		return null;
	}

	public Materiel getMateriel(String value) {
		for (Materiel mat : materielData) {
			if (value == mat.getNumImmobMateriel().getValue()) {
				return mat;
			}
		}
		return null;
	}

	public Site getSite(int index) {
		for (Site site : this.siteData) {
			if (index == site.getIdSite()) {
				return site;
			}
		}
		return null;
	}

	public Type gettype(String value) {
		for (Type type : this.typeData) {
			if (value == type.getNomTypeString()) {
				return type;
			}
		}
		return null;
	}

	public Facture getFacture(String value) {
		for (Facture fact : this.factureData) {
			if (value == fact.getNumFacture()) {
				return fact;
			}
		}
		return null;
	}

	public Logiciel getLogiciel(String value) {
		for (Logiciel log : logicielData) {
			if (value == log.getNomLogiciel().getValue()) {
				return log;
			}
		}
		return null;
	}

	public Logiciel getLogiciel2(String value) {
		for (Logiciel log : logicielData) {
			if (value.equals(log.getNomLogiciel().getValue() + " "
					+ log.getVersionLogiciel().getValue())) {
				return log;
			}
		}
		return null;
	}

	/**
	 * Retourne une liste de materiel en fonction du site et du type de
	 * materiel.
	 * 
	 * @param site
	 * @param type
	 * @return
	 */
	public ObservableList<Materiel> rechercher(Site site, Type type) {
		ObservableList<Materiel> resultat = FXCollections.observableArrayList();
		for (Materiel mat : materielData) {
			if (site.getIdSite() == mat.getSiteMateriel().getIdSite()
					&& type.getNomType()
							.getValue()
							.equals(mat.getTypeMateriel().getNomType()
									.getValue())) {
				resultat.add(mat);
			}
		}
		return resultat;
	}
}
