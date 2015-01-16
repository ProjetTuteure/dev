package gpi.view;

import java.util.ArrayList;
import java.util.List;

import utils.Constante;
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
	private Maintenance maintenanceAModifier;

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
		float coutMaintenance=0;
		try {
			if(controlerSaisies()==true)
			{
				if(!coutfield.getText().isEmpty()){
					coutMaintenance=Float.parseFloat(coutfield.getText());
				}
				Maintenance maintenance=new Maintenance(maintenanceAModifier.getIdMaintenance().getValue(),
						datefield.getValue(),
						objfield.getText(),
						descfield.getText(),
						coutMaintenance);
						maintenanceDAO.modifierMaintenance(maintenance);
				new Popup("Maintenance du "+maintenanceAModifier.getdateMaintenanceStringProperty().getValue()+ " modifiée !");
				okClicked = true;
				dialogStage.close();
			}
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
	}

	/**
	 * Permet de controler la saisie de l'utilisateur
	 * @return vrai si toutes les saisies sont cohérentes, faux sinon
	 */
	public boolean controlerSaisies()
	{
		if(datefield.getValue()==null)
		{
			new Popup("Une date doit être saisie");
			return false;
		}
		if(objfield.getText().length()>Constante.LONGUEUR_OBJET_MAINTENANCE)
		{
			new Popup("La longueur de l'objet saisi doit être inférieur à "+Constante.LONGUEUR_OBJET_MAINTENANCE+" caractères");
			return false;
		}
		if(descfield.getText().length()>Constante.LONGUEUR_DESCRIPTION_MAINTENANCE)
		{
			new Popup("La longueur de la description saisie doit être inférieur à "+Constante.LONGUEUR_OBJET_MAINTENANCE+" caractères");
			return false;
		}		
		if(!coutfield.getText().isEmpty())
		{
			if(coutfield.getText().contains(","))
			{
				coutfield.setText(coutfield.getText().replace(',','.'));
			}
			try
			{
				if(Float.parseFloat(coutfield.getText())<0)
				{
					new Popup("La valeur du coût de la maintenance ne doit pas être négative");
					return false;
				}
			}
			catch(NumberFormatException nfe)
			{
				new Popup("La valeur du coût saisie doit être un nombre");
				return false;
			}
		}
		return true;
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
			for(Maintenance maintenance:listeMaintenance)
			{
				if(maintenance.getdateMaintenanceStringProperty().getValue().equals(comboboxdate.getSelectionModel().getSelectedItem()))
				{
					maintenanceAModifier=maintenance;
				}
			}
			//Maintenance maintenanceSelected = listeMaintenance.get(comboboxobj.getSelectionModel().getSelectedIndex());
			objfield.setText(maintenanceAModifier.getObjetMaintenance());
			datefield.setValue(maintenanceAModifier.getdateMaintenance());
			descfield.setText(maintenanceAModifier.getDescriptionMaintenance());
			coutfield.setText(maintenanceAModifier.getCoutMaintenanceString());
		}
	}

}