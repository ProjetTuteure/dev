package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Site;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by Kevin
 */

public class modifierSite {
	@FXML
	private TextField NameSiteField;

	@FXML
	private Stage dialogStage;
	// @FXML
	// private Site site;
	@FXML
	private boolean okClicked = false;

	@FXML
	private ComboBox<String> comboboxSiteMod;

	private Donnee donneesite = new Donnee();

	private ObservableList<String> listNom;

	/**
	 * Initialise les données Ajoute les données aux combobox
	 */
	@FXML
	private void initialize() {
		listNom = FXCollections.observableArrayList();

		for (Site site : donneesite.getSiteData()) {
			listNom.add(site.getNomSte());
		}
		comboboxSiteMod.setItems(listNom);
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

	// a voir pour la suite
	// public void setPerson(Site site) {
	// this.site = site;
	//
	// NameSiteField.setText(site.getNomSte());
	//
	// }

	/**
	 * Cette methode permet de savoir si le bouton MODIFIER est clique ou pas
	 * 
	 * @return vrai si le bouton MODIFIER est clique, faux sinon
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Cette procedure permet de fermer la fenetre, lorsque le bouton MODIFIER
	 * est clique
	 */
	@FXML
	private void handleOk() {
		// a voir pour la suite
		// if (isInputValid()) {
		// site.setNomSte(NameSiteField.getText());

		okClicked = true;
		dialogStage.close();
		// }
	}

	/**
	 * Cette procedure permet de fermer la fenetre, lorsque le bouton ANNULER
	 * est clique
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	// a voir pour la suite
	// private boolean isInputValid() {
	// String errorMessage = "";
	//
	// if (NameSiteField.getText() == null
	// || NameSiteField.getText().length() == 0) {
	// errorMessage += "Nom de site invalide\n";
	// }
	//
	// if (errorMessage.length() == 0) {
	// return true;
	// } else {
	// // Show the error message
	// Dialogs.showErrorDialog(dialogStage, errorMessage,
	// "Veuillez corriger le champ", "Champ invalide");
	// return false;
	// }
	// }

	/**
	 * Cette methode permet de faire apparaitre un Filechooser lorsqu'on clique
	 * sur "choisir l'image"
	 * 
	 * @param event
	 *            un evenement sur le bouton "choisir l'image"
	 */
	@FXML
	private void handleChoose(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open File");
		File file = fileChooser.showOpenDialog(null); // you could pass a stage
														// reference here if you
														// wanted.

		if (file != null) {
		}// do something interesting with the file.

	}

	/**
	 * Cette methode permet de pre remplir les champs lorsqu'un site est
	 * selectionne
	 */
	@FXML
	private void handlechange(ActionEvent event) {
		NameSiteField.setText(comboboxSiteMod.getValue());
	}

}
