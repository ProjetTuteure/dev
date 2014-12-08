package gpi.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import javafx.stage.Stage;

public class suppSiteDialogController {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;
	@FXML
	private ComboBox<String> comboboxSiteSupp;

	ObservableList<String> list1 = FXCollections.observableArrayList("Agen",
			"Bordeaux", "Chateroux", "Guéret", "Limoges", "Montluçon",
			"Saint Agan", "Saint Junien");

	@FXML
	private void initialize() {
		comboboxSiteSupp.setItems(list1);
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
