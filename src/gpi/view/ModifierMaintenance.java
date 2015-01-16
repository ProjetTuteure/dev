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
	private List<Maintenance> listeMaintenanceParObjet;
	private MaintenanceDAO maintenanceDAO=new MaintenanceDAO();

	@FXML
	private void initialize() {
		listeMaintenance=new ArrayList<Maintenance>();
		listobj=FXCollections.observableArrayList();
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
		if(!comboboxdate.getItems().equals(null))
		{
			comboboxdate.setItems(null);
		}
		Maintenance maintenanceSelected = listeMaintenance.get(comboboxobj.getSelectionModel().getSelectedIndex());
		listdate = FXCollections.observableArrayList();
		System.out.println(comboboxobj.getSelectionModel().getSelectedIndex());
		for(Maintenance maintenanceParObjet:listeMaintenance)
		{
			if(maintenanceParObjet.getObjetMaintenance().equals(maintenanceSelected.getObjetMaintenance()))
			{
				listdate.add(maintenanceParObjet.getdateMaintenanceStringProperty().getValue());
			}
		}
		comboboxdate.setItems(listdate);
	}

	@FXML
	private void handlechange2() {
		if(comboboxdate.getItems()==null)
		{
			objfield.setText("");
			datefield.setPromptText("");
			descfield.setText("");
			coutfield.setText("");
		}
		else
		{
			Maintenance maintenanceParDate=null;
			for(Maintenance maintenance:listeMaintenance)
			{
				if(maintenance.getdateMaintenanceStringProperty().getValue().equals(comboboxdate.getSelectionModel().getSelectedItem()))
				{
					maintenanceParDate=maintenance;
				}
			}
			//Maintenance maintenanceSelected = listeMaintenance.get(comboboxobj.getSelectionModel().getSelectedIndex());
			objfield.setText(maintenanceParDate.getObjetMaintenance());
			datefield.setPromptText(maintenanceParDate.getdateMaintenanceStringProperty().getValue());
			descfield.setText(maintenanceParDate.getDescriptionMaintenance());
			coutfield.setText(maintenanceParDate.getCoutMaintenanceString());
		}
	}

}