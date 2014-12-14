package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Prestataire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class suppPrestDialogController {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private ComboBox<String> comboboxnom;
	@FXML
	private ComboBox<String> comboboxprenom;

	private Donnee donneesite = new Donnee();

	private ObservableList<String> listnom;
	private ObservableList<String> listprenom;

	@FXML
	private void initialize() {
		listnom = FXCollections.observableArrayList();

		for (Prestataire pr : donneesite.getPrestataireData()) {
			listnom.add(pr.getNomPrest().getValue());
		}
		comboboxnom.setItems(listnom);
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
		Prestataire selected = donneesite.getPrestaire(comboboxnom.getValue());

		listprenom = FXCollections.observableArrayList();
		for (Prestataire pr : donneesite.getPrestataireData()) {
			if (pr.getNomPrest().getValue()
					.equals(selected.getNomPrest().getValue())) {
				listprenom.add(selected.getPrenomPrest().getValue());
			}
		}
		comboboxprenom.setItems(listprenom);
	}

}
