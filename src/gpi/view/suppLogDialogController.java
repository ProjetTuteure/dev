package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Logiciel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class suppLogDialogController {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private ComboBox<String> comboboxlog;
	@FXML
	private ComboBox<String> comboboxvers;
	@FXML
	private ComboBox<String> comboboxfact;

	private Donnee donneesite = new Donnee();

	private ObservableList<String> listlog;
	private ObservableList<String> listvers;

	@FXML
	private void initialize() {
		listlog = FXCollections.observableArrayList();

		for (Logiciel log : donneesite.getLogicielData()) {
			listlog.add(log.getNomLog().getValue());
		}
		comboboxlog.setItems(listlog);
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
		Logiciel selected = donneesite.getLogiciel(comboboxlog.getValue());

		listvers = FXCollections.observableArrayList();
		for (Logiciel log : donneesite.getLogicielData()) {
			listvers.add(selected.getVersion().getValue());
		}
		comboboxvers.setItems(listvers);
	}

}
