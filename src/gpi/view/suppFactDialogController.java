package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Facture;
import gpi.metier.Site;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class suppFactDialogController {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;
	
	@FXML
	private ComboBox<String> comboboxfact;

	private Donnee donneesite = new Donnee();

	private ObservableList<String> listNum;

	@FXML
	private void initialize() {
		listNum = FXCollections.observableArrayList();

		for (Facture fac : donneesite.getFactureData()) {
			listNum.add(fac.getNumFac());
		}
		comboboxfact.setItems(listNum);
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
