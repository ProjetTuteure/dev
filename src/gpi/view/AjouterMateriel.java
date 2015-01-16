package gpi.view;

import java.io.File;

import utils.Popup;
import gpi.bd.Donnee;
import gpi.exception.ConnexionBDException;
import gpi.metier.Etat;
import gpi.metier.Fabricant;
import gpi.metier.FabricantDAO;
import gpi.metier.Facture;
import gpi.metier.FactureDAO;
import gpi.metier.Materiel;
import gpi.metier.MaterielDAO;
import gpi.metier.Site;
import gpi.metier.SiteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class AjouterMateriel {

	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;
	@FXML
	private ComboBox<String> comboboxEtatMateriel;
	@FXML
	private ComboBox<String> comboboxFabricantMateriel;
	@FXML
	private ComboBox<String> comboboxFactureMateriel;
	@FXML
	private ComboBox<String> comboboxSiteMateriel;


	private ObservableList<String> listEtatMateriel;
	private ObservableList<String> listSiteMateriel;
	private ObservableList<String> listFabricantMateriel;
	private ObservableList<String> listFactureMateriel;

	/**
	 * Initialise les donn�es Ajoute les donn�es aux combobox
	 */
	@FXML
	private void initialize() {
		listEtatMateriel = FXCollections.observableArrayList();
		listSiteMateriel = FXCollections.observableArrayList();
		listFabricantMateriel = FXCollections.observableArrayList();
		listFactureMateriel = FXCollections.observableArrayList();

		for (Etat etat : Etat.values()) {
			listEtatMateriel.add(etat.name());
		}
		System.out.println(listEtatMateriel);
		comboboxEtatMateriel.setItems(listEtatMateriel);

		FabricantDAO fabricantDAO=new FabricantDAO();
		
		try {
			for (Fabricant fabricant : fabricantDAO.recupererAllFabricant()) {
				listFabricantMateriel.add(fabricant.getNomFabricant().getValue());
			}
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		comboboxFabricantMateriel.setItems(listFabricantMateriel);

		FactureDAO factureDAO=new FactureDAO();
		try {
			for (Facture facture : factureDAO.recupererAllFacture()) {
				listFactureMateriel.add(facture.getNumFacture());
			}
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		comboboxFactureMateriel.setItems(listFactureMateriel);

		SiteDAO siteDAO=new SiteDAO();
		try {
			for (Site site : siteDAO.recupererAllSite()) {
				listFactureMateriel.add(site.getNomSiteString());
			}
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		comboboxSiteMateriel.setItems(listFactureMateriel);

	}

	/**
	 * Cette methode permet de mettre en fenetre active le popup
	 * 
	 * @param dialogStage
	 *            la fenetre active
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Cette methode permet de savoir si le bouton AJOUTER est clique ou pas
	 * 
	 * @return vrai si le bouton AJOUTER est clique, faux sinon
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Cette procedure permet de fermer la fenetre, lorsque le bouton AJOUTER
	 * est clique
	 */
	@FXML
	private void handleOk() {
		MaterielDAO materielDAO=new MaterielDAO();
		//materielDAO.ajouterMateriel(new Materiel(0,, nomMateriel, typeMateriel, etatMateriel, dateExpirationGarantieMateriel, repertoireDriverMateriel, factureMateriel, siteMateriel, fabricantMateriel, modeleMateriel))
		okClicked = true;
		dialogStage.close();

	}

	/**
	 * Cette procedure permet de fermer la fenetre, lorsque le bouton ANNULER
	 * est clique
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * Cette methode permet de pre remplir les champs lorsqu'un Materiel est
	 * selectionne
	 */
	@FXML
	private void handleChoose() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Choisir un dossier");
		File selectedDirectory = directoryChooser.showDialog(null);

		if (selectedDirectory != null) {
		}
	}

}