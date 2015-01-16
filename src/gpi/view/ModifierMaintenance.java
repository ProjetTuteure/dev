package gpi.view;

import java.util.ArrayList;
import java.util.List;

import utils.Constante;
import utils.Popup;
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
	private TextField tf_objetMaintenance;
	@FXML
	private TextField tf_coutMaintenance;
	@FXML
	private DatePicker dp_dateMaintenance;
	@FXML
	private TextArea ta_descriptionMaintenance;
	@FXML
	private boolean choix1 = false;

	@FXML
	private ComboBox<String> cb_objetMaintenance;
	@FXML
	private ComboBox<String> cb_dateMaintenance;

	private ObservableList<String> listeObjet;
	private ObservableList<String> listeDate;
	
	private List<Maintenance> listeMaintenance;
	private MaintenanceDAO maintenanceDAO=new MaintenanceDAO();
	private Maintenance maintenanceAModifier;

	@FXML
	private void initialize() {
		listeMaintenance=new ArrayList<Maintenance>();
		listeObjet=FXCollections.observableArrayList();
		try {
			listeMaintenance=maintenanceDAO.recupererAllMaintenance();
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
			dialogStage.close();
		}
		for(Maintenance maintenance:listeMaintenance)
		{
			listeObjet.add(maintenance.getObjetMaintenance());
		}
		cb_objetMaintenance.setItems(listeObjet);
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
				if(!tf_coutMaintenance.getText().isEmpty()){
					coutMaintenance=Float.parseFloat(tf_coutMaintenance.getText());
				}
				Maintenance maintenance=new Maintenance(maintenanceAModifier.getIdMaintenance().getValue(),
						dp_dateMaintenance.getValue(),
						tf_objetMaintenance.getText(),
						ta_descriptionMaintenance.getText(),
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
		if(dp_dateMaintenance.getValue()==null)
		{
			new Popup("Une date doit être saisie");
			return false;
		}
		if(tf_objetMaintenance.getText().length()>Constante.LONGUEUR_OBJET_MAINTENANCE)
		{
			new Popup("La longueur de l'objet saisi doit être inférieur à "+Constante.LONGUEUR_OBJET_MAINTENANCE+" caractères");
			return false;
		}
		if(ta_descriptionMaintenance.getText().length()>Constante.LONGUEUR_DESCRIPTION_MAINTENANCE)
		{
			new Popup("La longueur de la description saisie doit être inférieur à "+Constante.LONGUEUR_OBJET_MAINTENANCE+" caractères");
			return false;
		}		
		if(!tf_coutMaintenance.getText().isEmpty())
		{
			if(tf_coutMaintenance.getText().contains(","))
			{
				tf_coutMaintenance.setText(tf_coutMaintenance.getText().replace(',','.'));
			}
			try
			{
				if(Float.parseFloat(tf_coutMaintenance.getText())<0)
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
		if(!cb_dateMaintenance.getItems().equals(null))
		{
			cb_dateMaintenance.setItems(null);
		}
		Maintenance maintenanceSelected = listeMaintenance.get(cb_objetMaintenance.getSelectionModel().getSelectedIndex());
		listeDate = FXCollections.observableArrayList();
		for(Maintenance maintenanceParObjet:listeMaintenance)
		{
			if(maintenanceParObjet.getObjetMaintenance().equals(maintenanceSelected.getObjetMaintenance()))
			{
				listeDate.add(maintenanceParObjet.getdateMaintenanceStringProperty().getValue());
			}
		}
		cb_dateMaintenance.setItems(listeDate);
	}

	@FXML
	private void handlechange2() {
		if(cb_dateMaintenance.getItems()==null)
		{
			tf_objetMaintenance.setText("");
			dp_dateMaintenance.setPromptText("");
			ta_descriptionMaintenance.setText("");
			tf_coutMaintenance.setText("");
		}
		else
		{
			for(Maintenance maintenance:listeMaintenance)
			{
				if(maintenance.getdateMaintenanceStringProperty().getValue().equals(cb_dateMaintenance.getSelectionModel().getSelectedItem()))
				{
					maintenanceAModifier=maintenance;
				}
			}
			//Maintenance maintenanceSelected = listeMaintenance.get(cb_objetMaintenance.getSelectionModel().getSelectedIndex());
			tf_objetMaintenance.setText(maintenanceAModifier.getObjetMaintenance());
			dp_dateMaintenance.setValue(maintenanceAModifier.getdateMaintenance());
			ta_descriptionMaintenance.setText(maintenanceAModifier.getDescriptionMaintenance());
			tf_coutMaintenance.setText(maintenanceAModifier.getCoutMaintenanceString());
		}
	}

}