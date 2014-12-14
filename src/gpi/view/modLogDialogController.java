package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Facture;
import gpi.metier.Logiciel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class modLogDialogController {

	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private TextField nomfield;
	@FXML
	private TextField versfield;
	@FXML
	private DatePicker datefield;
	@FXML
	private boolean choix1 = false;

	@FXML
	private ComboBox<String> comboboxlog;
	@FXML
	private ComboBox<String> comboboxvers;
	@FXML
	private ComboBox<String> comboboxfact;

	private Donnee donneesite = new Donnee();

	private ObservableList<String> listlog;
	private ObservableList<String> listvers;
	private ObservableList<String> listfact;

	@FXML
	private void initialize() {
		listlog = FXCollections.observableArrayList();
		listfact = FXCollections.observableArrayList();
		for (Logiciel log : donneesite.getLogicielData()) {
			listlog.add(log.getNomLog().getValue());
		}
		comboboxlog.setItems(listlog);
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

		Logiciel selected = donneesite.getLogiciel(comboboxlog.getValue());

		listvers = FXCollections.observableArrayList();
		for (Logiciel log : donneesite.getLogicielData()) {
			if (log.getNomLog().getValue()
					.equals(selected.getNomLog().getValue())) {
				listvers.add(selected.getVersion().getValue());
			}
		}
		comboboxvers.setItems(listvers);
	}

	@FXML
	private void handlechange2() {
		if (choix1 = true) {
			listvers = FXCollections.observableArrayList();
			String test = comboboxlog.getValue() + " "
					+ comboboxvers.getValue();
			Logiciel selected2 = donneesite.getLogiciel2(test);

			nomfield.setText(selected2.getNomLog().getValue());
			versfield.setText(selected2.getVersion().getValue());
			datefield.setPromptText(selected2.getDateExpiration().getValue());

			for (Facture fac : donneesite.getFactureData()) {
				listfact.add(fac.getNumFac());
			}
			comboboxfact.setItems(listfact);
			comboboxfact.setPromptText(selected2.getFacture().getNumFac());
		}
	}
}
