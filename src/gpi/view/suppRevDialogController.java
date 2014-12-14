package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Revendeur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class suppRevDialogController {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private ComboBox<String> comboboxrev;

	private Donnee donneesite = new Donnee();

	private ObservableList<String> listNom;

	@FXML
	private void initialize() {
		listNom = FXCollections.observableArrayList();

		for (Revendeur rv : donneesite.getRevendeurData()) {
			listNom.add(rv.getNomRev().getValue());
		}
		comboboxrev.setItems(listNom);
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
