package gpi.view;

import java.io.File;
import gpi.bd.Donnee;
import gpi.metier.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class modifierMateriel {
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
	private void handlechoose() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Choisir un dossier");
		File selectedDirectory = directoryChooser.showDialog(null);

		if (selectedDirectory != null) {
		}
	}

	@FXML
	private void handlechange() {
		listEtat = FXCollections.observableArrayList();
		listSite = FXCollections.observableArrayList();
		listFact = FXCollections.observableArrayList();
		listFabr = FXCollections.observableArrayList();

		Materiel selected = donneesite.getMateriel(comboboximmo.getValue());

		nomfield.setText(selected.getNom().getValue());
		typefield.setText(selected.getType().getNom().getValue());
		immofield.setText(selected.getNumImmobMat().getValue());
		datefield
				.setPromptText(selected.getDateExpirationGarantieStringProperty().getValue());

		for (Etat etat : Etat.values()) {
			listEtat.add(etat.name());
		}
		comboboxetat.setItems(listEtat);
		comboboxetat.setPromptText(selected.getEtat().name());

		for (Facture fac : donneesite.getFactureData()) {
			listFact.add(fac.getNumFac());
		}
		comboboxfact.setItems(listFact);
		comboboxfact.setPromptText(selected.getFacture().getNumFac());

		for (Fabricant fb : donneesite.getFabricantData()) {
			listFabr.add(fb.getNomFabricant().getValue());
		}
		comboboxfab.setItems(listFabr);
		comboboxfab.setPromptText(selected.getFabricantString());

		for (Site st : donneesite.getSiteData()) {
			listSite.add(st.getNomSte());
		}
		comboboxsite.setItems(listEtat);
		comboboxsite.setPromptText(selected.getSite().getNomSte());

	}

}
