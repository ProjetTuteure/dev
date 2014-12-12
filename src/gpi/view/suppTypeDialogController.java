package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Type;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class suppTypeDialogController {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;
	@FXML
	private ComboBox<String> comboboxTypeSupp;

	private Donnee donneetype = new Donnee();

	private ObservableList<String> listNom ;

	@FXML
	private void initialize() {
		listNom = FXCollections.observableArrayList();
				
		for (Type type : donneetype.getTypeData()) {
			listNom.add(type.getNomString());
		}
			comboboxTypeSupp.setItems(listNom);
		
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

}
