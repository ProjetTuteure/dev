package gpi.view;

import java.io.File;

import gpi.bd.Donnee;
import gpi.metier.Etat;
import gpi.metier.Fabricant;
import gpi.metier.Facture;
import gpi.metier.Site;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class AjouterMateriel {

	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;
	@FXML
	private ComboBox<String> comboboxetat;
	@FXML
	private ComboBox<String> comboboxfabr;
	@FXML
	private ComboBox<String> comboboxfact;
	@FXML
	private ComboBox<String> comboboxsite;

	private Donnee donneeMat = new Donnee();

	private ObservableList<String> listNom1;
	private ObservableList<String> listNom2;
	private ObservableList<String> listNom3;
	private ObservableList<String> listNom4;

	/**
	 * Initialise les donn�es Ajoute les donn�es aux combobox
	 */
	@FXML
	private void initialize() {
		listNom1 = FXCollections.observableArrayList();
		listNom2 = FXCollections.observableArrayList();
		listNom3 = FXCollections.observableArrayList();
		listNom4 = FXCollections.observableArrayList();

		for (Etat etat : Etat.values()) {
			listNom1.add(etat.name());
		}
		comboboxetat.setItems(listNom1);

		for (Fabricant fab : donneeMat.getFabricantData()) {
			listNom2.add(fab.getNomFabricant().getValue());
		}
		comboboxfabr.setItems(listNom2);

		for (Facture fac : donneeMat.getFactureData()) {
			listNom3.add(fac.getNumFacture());
		}
		comboboxfact.setItems(listNom3);

		for (Site site : donneeMat.getSiteData()) {
			listNom4.add(site.getNomSite());
		}
		comboboxsite.setItems(listNom4);

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
