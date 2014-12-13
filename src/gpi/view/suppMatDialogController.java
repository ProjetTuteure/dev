package gpi.view;



import gpi.bd.Donnee;
import gpi.metier.Materiel;
import gpi.metier.Site;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class suppMatDialogController {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;
	@FXML
	private ComboBox<String> comboboxmat;

	private Donnee donneesite = new Donnee();

	private ObservableList<String> listmat;

	@FXML
	private void initialize() {
		listmat = FXCollections.observableArrayList();

		for (Materiel mat : donneesite.getMaterielData()) {
			listmat.add(mat.getNumImmobMat().getValue());
		}
		comboboxmat.setItems(listmat);
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
