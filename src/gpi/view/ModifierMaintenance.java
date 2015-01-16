package gpi.view;

import java.util.ArrayList;
import java.util.List;

import utils.Popup;
import gpi.bd.Donnee;
import gpi.exception.ConnexionBDException;
import gpi.metier.Maintenance;
import gpi.metier.MaintenanceDAO;
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
	
	private List<Maintenance> listeMaintenance;
	private MaintenanceDAO maintenanceDAO=new MaintenanceDAO();

	@FXML
	private void initialize() {
		listeMaintenance=new ArrayList<Maintenance>();
		try {
			listeMaintenance=maintenanceDAO.recupererAllMaintenance();
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
			dialogStage.close();
		}
		for(Maintenance maintenance:listeMaintenance)
		{
			listobj.add(maintenance.getObjetMaintenance());
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