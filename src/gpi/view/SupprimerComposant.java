package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Composant;
import gpi.metier.Maintenance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class SupprimerComposant {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private ComboBox<String> comboboxnom;
	@FXML
	private ComboBox<String> comboboxcarac;

	private Donnee donnee = new Donnee();

	private ObservableList<String> listnom;
	private ObservableList<String> listcarac;

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
		Composant selected = donnee.getComposant(comboboxnom.getValue());

		listcarac = FXCollections.observableArrayList();
		for (Composant c : donnee.getComposantData()) {
			if (c.getNomComposant().equals(selected.getNomComposant())) {
				listcarac.add(selected.getcaracteristiqueComposant());
			}
		}
		comboboxcarac.setItems(listcarac);
	}

}