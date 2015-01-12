package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Facture;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class ajouterLogiciel {
	@FXML
	private Stage dialogStage;

	@FXML
	private boolean okClicked = false;

	@FXML
	private ComboBox<String> comboboxfact;

	private Donnee donneesite = new Donnee();

	private ObservableList<String> listfact;

	@FXML
	private void initialize() {
		listfact = FXCollections.observableArrayList();
		for (Facture fac : donneesite.getFactureData()) {
			listfact.add(fac.getNumFac());
		}
		comboboxfact.setItems(listfact);
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
