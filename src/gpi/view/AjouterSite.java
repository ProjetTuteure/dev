package gpi.view;

import gpi.metier.Site;
import gpi.metier.SiteDAO;

import java.io.File;

import javax.swing.JFileChooser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class AjouterSite {
	String nomSite,cheminImageSite;
	@FXML
	private TextField NameSiteField;
	@FXML
	private Stage dialogStage;
	// @FXML
	// private Site site;
	@FXML
	private boolean okClicked = false;

	/**
	 * Initialise les données
	 */
	@FXML
	private void initialize() {

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

	// public void setPerson(Site site) {
	// this.site = site;
	//
	// NameSiteField.setText(site.getNomSte());
	//
	// }

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
		SiteDAO siteDAO = new SiteDAO();
		// if (isInputValid()) {
		setNomSite(NameSiteField.getText());
		siteDAO.ajouterSite(new Site(0,getNomSite(),getCheminImageSite()));
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

	@FXML
	private void handleChoose(ActionEvent event) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Open File");
		fileChooser.showOpenDialog(null); // you could pass a stage
		File file = fileChooser.getSelectedFile();												// reference here if you


		if (file != null) {
			setCheminImageSite(file.getAbsolutePath());
		}// do something interesting with the file.

	}

	public String getNomSite() {
		return nomSite;
	}

	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}

	public String getCheminImageSite() {
		return cheminImageSite;
	}

	public void setCheminImageSite(String cheminImageSite) {
		this.cheminImageSite = cheminImageSite;
	}


}