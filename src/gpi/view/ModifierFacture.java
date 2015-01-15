package gpi.view;

import java.util.ArrayList;
import java.util.List;

import utils.Popup;
import gpi.bd.Donnee;
import gpi.exception.ConnexionBDException;
import gpi.metier.Facture;
import gpi.metier.FactureDAO;
import gpi.metier.Revendeur;
import gpi.metier.RevendeurDAO;
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

public class ModifierFacture {

	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private ComboBox<String> ComboboxFacture;

	private Donnee donneeFact = new Donnee();

	private ObservableList<String> listFacture;

	@FXML
	private TextField NumFacture;
	@FXML
	private DatePicker DateFacture;
	@FXML
	private TextField MontantFacture;
	@FXML
	private ComboBox<String> NumRevendeur;
	List<Facture> listObjetsFacture;
	private ObservableList<String> listRevendeurObservable;
	List<Integer> listRevendeurId;

	@FXML
	private void initialize() {
		listFacture = FXCollections.observableArrayList();
		listObjetsFacture=new ArrayList<Facture>();
		FactureDAO factureDAO = new FactureDAO();
		try{
			listObjetsFacture=factureDAO.recupererAllFacture();
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		for (Facture facture : listObjetsFacture) {
			listFacture.add(facture.getNumFacture());
		}
		
		ComboboxFacture.setItems(listFacture);
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
		RevendeurDAO revendeurDAO=new RevendeurDAO();
		int index = ComboboxFacture.getSelectionModel().getSelectedIndex();
		NumFacture.setText(listObjetsFacture.get(index).getNumFacture());
		DateFacture.setValue(listObjetsFacture.get(index).getDateFacture());
		MontantFacture.setText(listObjetsFacture.get(index).getMontantFactureString());
		String nomRevendeur=listObjetsFacture.get(index).getRevendeurFacture().getNomRevendeur().getValue();
		listRevendeurId=new ArrayList<Integer>();
		listRevendeurObservable = FXCollections.observableArrayList();
		try {
			for (Revendeur revendeur : revendeurDAO.recupererAllRevendeur()){
				listRevendeurObservable.add(revendeur.getNomRevendeur().getValue());
				listRevendeurId.add(revendeur.getIdRevendeur().getValue());
			}
		} catch (ConnexionBDException e) {
			// TODO Auto-generated catch block
			new Popup(e.getMessage());
		}
		NumRevendeur.setItems(listRevendeurObservable);
		NumRevendeur.setPromptText(nomRevendeur);
	}
}