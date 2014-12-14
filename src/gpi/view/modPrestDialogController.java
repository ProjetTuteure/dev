package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Prestataire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class modPrestDialogController {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private TextField nomfield;
	@FXML
	private TextField prenomfield;
	@FXML
	private TextField telfield;
	@FXML
	private TextField socfield;
	@FXML
	private boolean choix1 = false;

	@FXML
	private ComboBox<String> comboboxnom;
	@FXML
	private ComboBox<String> comboboxprenom;

	private Donnee donnee = new Donnee();

	private ObservableList<String> listnom;
	private ObservableList<String> listprenom;

	@FXML
	private void initialize() {
		listnom = FXCollections.observableArrayList();

		for (Prestataire pr : donnee.getPrestataireData()) {
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
	private void handlechange1() {
		choix1 = true;
		Prestataire selected = donnee.getPrestaire(comboboxnom.getValue());
		listprenom = FXCollections.observableArrayList();

		for (Prestataire pr : donnee.getPrestataireData()) {
			listprenom.add(selected.getPrenomPrest().getValue());
		}
		comboboxprenom.setItems(listprenom);
	}

	@FXML
	private void handlechange2() {
		if (choix1 = true) {
			String test = comboboxnom.getValue() + " "
					+ comboboxprenom.getValue();
			Prestataire selected2 = donnee.getPrestaire2(test);

			nomfield.setText(selected2.getNomPrest().getValue());
			prenomfield.setText(selected2.getPrenomPrest().getValue());
			telfield.setText(selected2.getTelPrest().getValue());
			socfield.setText(selected2.getSocietee().getValue());
		}
	}

}
