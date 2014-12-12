package gpi.view;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;

import javafx.fxml.FXML;
//import javafx.scene.control.ComboBox;

import javafx.stage.Stage;

public class suppFabrDialogController {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;


	@FXML
	private void initialize() {
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