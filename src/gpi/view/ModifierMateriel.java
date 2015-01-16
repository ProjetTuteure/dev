package gpi.view;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import utils.Popup;
import gpi.bd.Donnee;
import gpi.exception.ConnexionBDException;
import gpi.metier.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class ModifierMateriel {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;
	@FXML
	private TextField nomMaterielField;
	@FXML
	private TextField typeMaterielField;
	@FXML
	private TextField immobMaterielField;
	@FXML
	private DatePicker dateMaterielPicker;
	@FXML
	private ComboBox<String> comboboxEtatMateriel;
	@FXML
	private ComboBox<String> comboboxFabricantMateriel;
	@FXML
	private ComboBox<String> comboboxFactureMateriel;
	@FXML
	private ComboBox<String> comboboxSiteMateriel;
	@FXML
	private ComboBox<String> comboboxImmobMateriel;
	@FXML
	private TextField numeroSerieMaterielField;
	@FXML
	private TextField systemeExploitationMaterielField;
	@FXML
	private TextField modeleMaterielField;

	private MaterielDAO materielDAO=new MaterielDAO();
	
	
	private List<Integer> listIdMateriel;
	private ObservableList<String> listImmobMateriel;
	private ObservableList<String> listEtatMateriel;
	private ObservableList<String> listSiteMateriel;
	private ObservableList<String> listFabricantMateriel;
	private ObservableList<String> listFactureMateriel;

	@FXML
	private void initialize() {
		listImmobMateriel = FXCollections.observableArrayList();
		listIdMateriel = new ArrayList<Integer>();
		MaterielDAO materielDAO=new MaterielDAO();
		
		try {
			for (Materiel materiel : materielDAO.recupererAllMateriel()) {
				//listIdMateriel.add(Integer.parseInt(materiel.getIdMateriel()).getValue().intValue()+"- "+materiel.getNomMateriel().getValue());
				listIdMateriel.add(materiel.getIdMateriel().getValue());
			}
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		comboboxImmobMateriel.setItems(listImmobMateriel);
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	@FXML
	private void handleOk() {
		try {
			materielDAO.modifierMateriel(new Materiel(0, null, null, null, null, null, null, null, null, null, null, null, null));
			//ma.modifierPrestataire(new Prestataire(this.getIdPrestataire(),nomPrestataireField.getText(),prenomPrestataireField.getText(),telPrestataireField.getText(),societePrestataireField.getText()));
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		okClicked = true;
		dialogStage.close();

	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	@FXML
	private void handlechoose() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Choisir un dossier");
		File selectedDirectory = directoryChooser.showDialog(null);

		if (selectedDirectory != null) {
		}
	}

	@FXML
	private void handlechange() {
		listEtatMateriel = FXCollections.observableArrayList();
		listSiteMateriel = FXCollections.observableArrayList();
		listFactureMateriel = FXCollections.observableArrayList();
		listFabricantMateriel = FXCollections.observableArrayList();
		
		MaterielDAO materielDAO=new MaterielDAO();
		Materiel selected=null;
		try {
			selected = materielDAO.recupererMaterielParId(listIdMateriel.get(comboboxImmobMateriel.getSelectionModel().getSelectedIndex()));
		} catch (NumberFormatException e) {
			new Popup("NumberFormatException");
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}

		nomMaterielField.setText(selected.getNomMateriel().getValue());
		typeMaterielField.setText(selected.getTypeMateriel().getNomType().getValue());
		immobMaterielField.setText(selected.getNumImmobMateriel().getValue());
		dateMaterielPicker.setPromptText(selected.getDateExpirationGarantieMaterielStringProperty().getValue());

		for (Etat etat : Etat.values()) {
			listEtatMateriel.add(etat.name());
		}
		comboboxEtatMateriel.setItems(listEtatMateriel);
		comboboxEtatMateriel.setPromptText(selected.getEtatMateriel().name());

		FactureDAO factureDAO=new FactureDAO();
		
		try {
			for (Facture facture : factureDAO.recupererAllFacture()) {
				listFactureMateriel.add(facture.getNumFacture());
			}
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		comboboxFactureMateriel.setItems(listFactureMateriel);
		comboboxFactureMateriel.setPromptText(selected.getFactureMateriel().getNumFacture());

		FabricantDAO fabricantDAO=new FabricantDAO();
				
		try {
			for (Fabricant fabricant : fabricantDAO.recupererAllFabricant()) {
				listFabricantMateriel.add(fabricant.getNomFabricant().getValue());
			}
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		comboboxFabricantMateriel.setItems(listFabricantMateriel);
		comboboxFabricantMateriel.setPromptText(selected.getFabricantMaterielString());

		SiteDAO siteDAO=new SiteDAO();
		
		try {
			for (Site site : siteDAO.recupererAllSite()) {
				listSiteMateriel.add(site.getNomSiteString());
			}
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		comboboxSiteMateriel.setItems(listEtatMateriel);
		comboboxSiteMateriel.setPromptText(selected.getSiteMateriel().getNomSiteString());

	}

}