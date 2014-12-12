package gpi.view;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import javafx.stage.Stage;

/**
 * Created by Kevin 
 */

public class addFactDialogController {
	@FXML
	private TextField NameSiteField;
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
