package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Fabricant;
import gpi.metier.Materiel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class modFabrDialogController {

	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;
	@FXML
	private ComboBox<String> comboboxfabr;
	
	private Donnee donneesite = new Donnee();

	private ObservableList<String> listFabr;

	@FXML
	private TextField nomfield;
	@FXML
	private TextField adrfield;
	@FXML
	private TextField telfield;
	

	@FXML
	private void initialize() {
		listFabr = FXCollections.observableArrayList();

		for (Fabricant fab : donneesite.getFabricantData()) {
			listFabr.add(fab.getNomFabString());
		}
		comboboxfabr.setItems(listFabr);
	}
	
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
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
	
	public boolean isOkClicked() {
		return okClicked;
	}
	
	@FXML
	private void handlechange(){
		Fabricant selected = donneesite.getFabricant(comboboxfabr.getValue());
		nomfield.setText(selected.getNomFabString());
		telfield.setText(selected.getTelFab().getValue());
		adrfield.setText(selected.getAdresseFab().getValue());
	}

}
