package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Maintenance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class supprimerMaintenance {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private ComboBox<String> comboboxobj;
	@FXML
	private ComboBox<String> comboboxdate;

	private Donnee donnee = new Donnee();

	private ObservableList<String> listobj;
	private ObservableList<String> listdate;

	@FXML
	private void initialize() {
		listobj = FXCollections.observableArrayList();

		for (Maintenance m : donnee.getMaintenanceData()) {
			listobj.add(m.getObjetMaintenance());
		}
		comboboxobj.setItems(listobj);
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Cette methode permet de savoir si le bouton SUPPRIMER est clique ou pas
	 * 
	 * @return vrai si le bouton SUPPRIMER est clique, faux sinon
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Cette procedure permet de fermer la fenetre, lorsque le bouton SUPPRIMER
	 * est clique
	 */
	@FXML
	private void handleOk() {

		okClicked = true;
		dialogStage.close();

	}

	/**
	 * Cette procedure permet de fermer la fenetre, lorsque le bouton ANNULER
	 * est clique
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	@FXML
	private void handlechange() {
		Maintenance selected = donnee.getMaintenance(comboboxobj.getValue());

		listdate = FXCollections.observableArrayList();
		for (Maintenance m : donnee.getMaintenanceData()) {
			if (m.getObjetMaintenance().equals(selected.getObjetMaintenance())) {
				listdate.add(selected.getdateMaintenanceStringProperty().getValue());
			}
		}
		comboboxdate.setItems(listdate);
	}

}
