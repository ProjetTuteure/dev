package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Composant;
import gpi.metier.Facture;
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

public class ModifierComposant {

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
		Composant selected = donnee.getComposant(comboboxnom.getValue());
		listcarac = FXCollections.observableArrayList();

		for (Composant c : donnee.getComposantData()) {
			if (c.getNomComposant().equals(selected.getNomComposant())) {
				listcarac.add(selected.getFabricantComposant().getNomFabricant().getValue());
			}
		}
		comboboxcarac.setItems(listcarac);
	}

	@FXML
	private void handlechange2() {
		try {
			if (choix1 = true) {
				listfabr = FXCollections.observableArrayList();
				String test = comboboxnom.getValue() + " "
						+ comboboxcarac.getValue();
				Composant selected2 = donnee.getComposant2(test);
				nomfield.setText(selected2.getNomComposant());
				caracfield.setText(selected2.getcaracteristiqueComposant());
				
				for (Composant co : donnee.getComposantData()) {
					listfabr.add(co.getFabricantComposant().getNomFabricant().getValue());
				}
				comboboxfabr.setItems(listfabr);
				comboboxfabr.setPromptText(selected2.getFabricantComposant().getNomFabricant().getValue());
				
			}
		} catch (NullPointerException e) {

		}
	}

}
