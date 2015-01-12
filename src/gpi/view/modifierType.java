package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Type;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by Kevin
 */

public class modifierType {

	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private ComboBox<String> comboboxTypeMod;

	private Donnee donneetype = new Donnee();

	private ObservableList<String> listNom;

	@FXML
	private TextField typefield;

	@FXML
	private void initialize() {
		listNom = FXCollections.observableArrayList();

		for (Type type : donneetype.getTypeData()) {
			listNom.add(type.getNomString());
		}
		comboboxTypeMod.setItems(listNom);
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
	private void handleChoose(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open File");
		File file = fileChooser.showOpenDialog(null);

		if (file != null) {
		}

	}

	@FXML
	private void handlechange() {
		Type selected = donneetype.gettype(comboboxTypeMod.getValue());

		typefield.setText(selected.getNom().getValue());
	}

}
