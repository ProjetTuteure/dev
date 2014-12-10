package gpi.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TextField;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class modTypeDialogController {
	@FXML
	private TextField NameSiteField;

	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private ComboBox<String> comboboxSiteMod;

	ObservableList<String> list1 = FXCollections.observableArrayList("Agen",
			"Bordeaux", "Chateroux", "Gu�ret", "Limoges", "Montlu�on",
			"Saint Agan", "Saint Junien");

	@FXML
	private void initialize() {
		comboboxSiteMod.setItems(list1);
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

	@FXML
	private void handleChoose(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open File");
		File file = fileChooser.showOpenDialog(null);

		if (file != null) {
		}

	}

}
