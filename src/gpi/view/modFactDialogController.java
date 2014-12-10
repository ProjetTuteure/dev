package gpi.view;

//import gpi.bd.Donnee;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.fxml.FXML;
//import javafx.scene.control.ComboBox;

import javafx.stage.Stage;

public class modFactDialogController {

	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	//
	// @FXML
	// private ComboBox<String> comboboxSiteSupp;
	//
	// Donnee list1 = new Donnee();

	@FXML
	private void initialize() {
		// comboboxSiteSupp.setItems(list1.getFactureData());
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	@FXML
	private void handleOk() {

		okClicked = true;
		dialogStage.close();

	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

}
