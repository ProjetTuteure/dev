package gpi.view;

import java.io.File;

import gpi.bd.Donnee;
import gpi.metier.Etat;
import gpi.metier.Fabricant;
import gpi.metier.Facture;
import gpi.metier.Site;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class AjouterMateriel {

	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;
	@FXML
	private ComboBox<String> comboboxetat;
	@FXML
	private ComboBox<String> comboboxfabr;
	@FXML
	private ComboBox<String> comboboxfact;
	@FXML
	private ComboBox<String> comboboxsite;

	private Donnee donneesite = new Donnee();

	private ObservableList<String> listNom1;
	private ObservableList<String> listNom2;
	private ObservableList<String> listNom3;
	private ObservableList<String> listNom4;

	@FXML
	private void initialize() {
		listNom1 = FXCollections.observableArrayList();
		listNom2 = FXCollections.observableArrayList();
		listNom3 = FXCollections.observableArrayList();
		listNom4 = FXCollections.observableArrayList();

		for (Etat etat : Etat.values()) {
			listNom1.add(etat.name());
		}
		comboboxetat.setItems(listNom1);

		for (Fabricant fab : donneesite.getFabricantData()) {
			listNom2.add(fab.getNomFabString());
		}
		comboboxfabr.setItems(listNom2);

		for (Facture fac : donneesite.getFactureData()) {
			listNom3.add(fac.getNumFac());
		}
		comboboxfact.setItems(listNom3);

		for (Site site : donneesite.getSiteData()) {
			listNom4.add(site.getNomSte());
		}
		comboboxsite.setItems(listNom4);

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
	private void handleChoose() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Choisir un dossier");
		File selectedDirectory = directoryChooser.showDialog(null);

		if (selectedDirectory != null) {
		}
	}

}
