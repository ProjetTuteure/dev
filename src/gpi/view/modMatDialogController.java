package gpi.view;



import gpi.bd.Donnee;
import gpi.metier.*;
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

public class modMatDialogController {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;
	@FXML
	private TextField nomfield;
	@FXML
	private TextField typefield;
	@FXML
	private TextField immofield;
	@FXML
	private DatePicker datefield;
	@FXML
	private ComboBox<String> comboboxetat;
	@FXML
	private ComboBox<String> comboboxfab;
	@FXML
	private ComboBox<String> comboboxfact;
	@FXML
	private ComboBox<String> comboboxsite;
	@FXML
	private ComboBox<String> comboboximmo;
	
	private Donnee donneesite = new Donnee();

	private ObservableList<String> listimmo;
	private ObservableList<String> listEtat;
	private ObservableList<String> listSite;
	private ObservableList<String> listFabr;
	private ObservableList<String> listFact;
	

	@FXML
	private void initialize() {
		listimmo = FXCollections.observableArrayList();

		for (Materiel materiel : donneesite.getMaterielData()) {
			listimmo.add(materiel.getNumImmobMat().getValue());
		}
		comboboximmo.setItems(listimmo);
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
		listEtat = FXCollections.observableArrayList();
		listSite = FXCollections.observableArrayList();
		listFact = FXCollections.observableArrayList();
		listFabr = FXCollections.observableArrayList();
		
		//Doit r�cuperer le nom du mat�riel selectionn� avec l'immo du menu d�roulant d'en haut 
				//pour le mettre en valeur par d�faut
		nomfield.setText();
		//Doit r�cuperer le type du mat�riel selectionn� avec l'immo du menu d�roulant d'en haut 
				//pour le mettre en valeur par d�faut
		typefield.setText();
		
		
		immofield.setText();
		
		for (Etat etat : Etat.values()) {
			listEtat.add(etat.name());
		}
		comboboxetat.setItems(listEtat);
		//Doit r�cuperer l'�tat du mat�riel selectionn� avec l'immo du menu d�roulant d'en haut 
		//pour le mettre en valeur par d�faut
		comboboxetat.setPromptText();
		
	
		
		for (Facture fac : donneesite.getFactureData()) {
			listFact.add(fac.getNumFac());
		}
		comboboxfact.setItems(listEtat);
		//Doit r�cuperer la facture du mat�riel selectionn� avec l'immo du menu d�roulant d'en haut 
		//pour le mettre en valeur par d�faut
		comboboxfact.setPromptText();
		
		
		
		for (Fabricant fb : donneesite.getFabricantData()) {
			listFabr.add(fb.getNomFabString());
		}
		comboboxfab.setItems(listEtat);
		//Doit r�cuperer le fabricant du mat�riel selectionn� avec l'immo du menu d�roulant d'en haut 
		//pour le mettre en valeur par d�faut
		comboboxfab.setPromptText();
		
		
		
		for (Site st : donneesite.getSiteData()) {
			listSite.add(st.getNomSte());
		}
		comboboxsite.setItems(listEtat);
		//Doit r�cuperer le site du mat�riel selectionn� avec l'immo du menu d�roulant d'en haut 
		//pour le mettre en valeur par d�faut
		comboboxsite.setPromptText();
		
		
		
	}

}
