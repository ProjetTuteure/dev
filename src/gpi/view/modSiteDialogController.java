package gpi.view;

import gpi.metier.Site;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialogs;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;

public class modSiteDialogController {
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

	ObservableList<String> list1 = FXCollections.observableArrayList("Agen",
			"Bordeaux", "Chateroux", "Guéret", "Limoges", "Montluçon",
			"Saint Agan", "Saint Junien");

	@FXML
	private void initialize() {
		comboboxSiteMod.setItems(list1);
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

	}

}
