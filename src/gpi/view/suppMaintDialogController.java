package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Maintenance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class suppMaintDialogController {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

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
	private void handlechange() {
		Maintenance selected = donnee.getMaintenance(comboboxobj.getValue());

		listdate = FXCollections.observableArrayList();
		for (Maintenance m : donnee.getMaintenanceData()) {
			if (m.getObjet().equals(selected.getObjet())) {
				listdate.add(selected.getDateMaint());
			}
		}
		comboboxdate.setItems(listdate);
	}

}
