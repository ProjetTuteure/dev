package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Facture;
import gpi.metier.Logiciel;
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

public class modifierLogiciel {

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

	private Donnee donneeLog = new Donnee();

	private ObservableList<String> listlog;
	private ObservableList<String> listvers;
	private ObservableList<String> listfact;

	@FXML
	private void initialize() {
		listlog = FXCollections.observableArrayList();
		listfact = FXCollections.observableArrayList();
		for (Logiciel log : donneeLog.getLogicielData()) {
			listlog.add(log.getNomLogiciel().getValue());
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

		Logiciel selected = donneeLog.getLogiciel(comboboxlog.getValue());

		listvers = FXCollections.observableArrayList();
		for (Logiciel log : donneeLog.getLogicielData()) {
			if (log.getNomLogiciel().getValue()
					.equals(selected.getNomLogiciel().getValue())) {
				listvers.add(selected.getVersionLogiciel().getValue());
			}
		}
		comboboxvers.setItems(listvers);
	}

	@FXML
	private void handlechange2() {
		try {
			if (choix1 = true) {
				listvers = FXCollections.observableArrayList();
				String test = comboboxlog.getValue() + " "
						+ comboboxvers.getValue();
				Logiciel selected2 = donneeLog.getLogiciel2(test);

				nomfield.setText(selected2.getNomLogiciel().getValue());
				versfield.setText(selected2.getVersionLogiciel().getValue());
				datefield.setPromptText(selected2.getDateExpirationLogicielStringProperty().getValue());

				for (Facture fac : donneeLog.getFactureData()) {
					listfact.add(fac.getNumFacture());
				}
				comboboxfact.setItems(listfact);
				comboboxfact.setPromptText(selected2.getFacture().getNumFacture());
			}
		} catch (NullPointerException e) {

		}
	}
}
