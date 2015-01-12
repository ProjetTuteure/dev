package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Maintenance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class ModifierMaintenance {

	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private TextField objfield;
	@FXML
	private TextField coutfield;
	@FXML
	private DatePicker datefield;
	@FXML
	private TextArea descfield;
	@FXML
	private boolean choix1 = false;

	@FXML
	private ComboBox<String> comboboxobj;
	@FXML
	private ComboBox<String> comboboxdate;

	private Donnee donnee = new Donnee();

	private ObservableList<String> listobj;
	private ObservableList<String> listdate;

	@FXML
	private void initialize() {
		listobj = FXCollections.observableArrayList();

		for (Maintenance m : donnee.getMaintenanceData()) {
			listobj.add(m.getObjet());
		}
		comboboxobj.setItems(listobj);
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
		Maintenance selected = donnee.getMaintenance(comboboxobj.getValue());
		listdate = FXCollections.observableArrayList();

		for (Maintenance m : donnee.getMaintenanceData()) {
			if (m.getObjet().equals(selected.getObjet())) {
				listdate.add(selected.getDateMaint());
			}
		}
		comboboxdate.setItems(listdate);
	}

	@FXML
	private void handlechange2() {
		try {
			if (choix1 = true) {

				String test = comboboxobj.getValue() + " "
						+ comboboxdate.getValue();
				Maintenance selected2 = donnee.getMaintenance2(test);

				objfield.setText(selected2.getObjet());
				datefield.setPromptText(selected2.getDateMaint());
				descfield.setText(selected2.getDescription());
				coutfield.setText(selected2.getCoutString());
			}
		} catch (NullPointerException e) {

		}
	}

}
