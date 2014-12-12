package gpi.view;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class addSiteDialogController {
	@FXML
	private TextField NameSiteField;
	@FXML
	private Stage dialogStage;
	// @FXML
	// private Site site;
	@FXML
	private boolean okClicked = false;

	@FXML
	private void initialize() {

	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	// public void setPerson(Site site) {
	// this.site = site;
	//
	// NameSiteField.setText(site.getNomSte());
	//
	// }

	public boolean isOkClicked() {
		return okClicked;
	}

	@FXML
	private void handleOk() {
		// if (isInputValid()) {
		// site.setNomSte(NameSiteField.getText());

		okClicked = true;
		dialogStage.close();
		// }
	}

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
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open File");
		File file = fileChooser.showOpenDialog(null); // you could pass a stage
														// reference here if you
														// wanted.

		if (file != null) {
		}// do something interesting with the file.

	}

}
