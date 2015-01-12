package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Composant;
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

public class modifierComposant {

	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private TextField nomfield;
	@FXML
	private TextArea caracfield;
	@FXML
	private boolean choix1 = false;

	@FXML
	private ComboBox<String> comboboxnom;
	@FXML
	private ComboBox<String> comboboxcarac;
	@FXML
	private ComboBox<String> comboboxfabr;

	private Donnee donnee = new Donnee();

	private ObservableList<String> listnom;
	private ObservableList<String> listcarac;
	private ObservableList<String> listfabr;

	@FXML
	private void initialize() {
		listnom = FXCollections.observableArrayList();

		for (Composant c : donnee.getComposantData()) {
			listnom.add(c.getNomComposant());
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
		Composant selected = donnee.getMaintenance(comboboxobj.getValue());
		listdate = FXCollections.observableArrayList();

		for (Maintenance m : donnee.getMaintenanceData()) {
			if (m.getObjetMaintenance().equals(selected.getObjetMaintenance())) {
				listdate.add(selected.getdateMaintenanceStringProperty().getValue());
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
				System.out.println(selected2.getObjetMaintenance());
				System.out.println(selected2.getDescriptionMaintenance());
				objfield.setText(selected2.getObjetMaintenance());
				datefield.setPromptText(selected2.getdateMaintenanceStringProperty().getValue());
				descfield.setText(selected2.getDescriptionMaintenance());
				coutfield.setText(selected2.getCoutMaintenanceString());
			}
		} catch (NullPointerException e) {

		}
	}

}
