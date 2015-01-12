package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Revendeur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class modifierRevendeur {
	@FXML
	private Stage dialogStage;

	@FXML
	private boolean okClicked = false;

	@FXML
	private TextField nomfield;
	@FXML
	private TextField telfield;
	@FXML
	private TextField adrfield;

	@FXML
	private ComboBox<String> comboboxrev;

	private Donnee donneesite = new Donnee();

	private ObservableList<String> listrev;

	@FXML
	private void initialize() {
		listrev = FXCollections.observableArrayList();

		for (Revendeur rev : donneesite.getRevendeurData()) {
			listrev.add(rev.getNomRev().getValue());
		}
		comboboxrev.setItems(listrev);
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
	private void handlechange() {

		Revendeur selected = donneesite.getRevendeur(comboboxrev.getValue());
		nomfield.setText(selected.getNomRev().getValue());
		telfield.setText(selected.getTelRev().getValue());
		adrfield.setText(selected.getAdresse().getValue());
	}

}
