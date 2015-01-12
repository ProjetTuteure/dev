package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Facture;
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

public class modifierFacture {

	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private ComboBox<String> comboboxfact;

	private Donnee donneeFact = new Donnee();

	private ObservableList<String> listfact;

	@FXML
	private TextField numfield;
	@FXML
	private TextField revfield;
	@FXML
	private TextField montantfield;
	@FXML
	private DatePicker datefield;

	@FXML
	private void initialize() {
		listfact = FXCollections.observableArrayList();

		for (Facture fact : donneeFact.getFactureData()) {
			listfact.add(fact.getNumFacture());
		}
		comboboxfact.setItems(listfact);
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
		Facture selected = donneeFact.getFacture(comboboxfact.getValue());
		numfield.setText(selected.getNumFacture());
		montantfield.setText(selected.getMontantFactureString());
		datefield.setPromptText(selected.getDateFacStringProperty().getValue());
		revfield.setText(selected.getRevendeurFacture().getNomRevendeur().getValue());
	}
}
