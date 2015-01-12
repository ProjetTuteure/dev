package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Fabricant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class supprimerFabricant {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private ComboBox<String> comboboxfabr;

	private Donnee donneesite = new Donnee();

	private ObservableList<String> listNom;

	@FXML
	private void initialize() {
		listNom = FXCollections.observableArrayList();

		for (Fabricant fb : donneesite.getFabricantData()) {
			listNom.add(fb.getNomFabString());
		}
		comboboxfabr.setItems(listNom);
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
