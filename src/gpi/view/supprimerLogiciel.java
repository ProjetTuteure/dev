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

public class supprimerLogiciel {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private ComboBox<String> comboboxlog;
	@FXML
	private ComboBox<String> comboboxvers;

	private Donnee donneesite = new Donnee();

	private ObservableList<String> listlog;
	private ObservableList<String> listvers;

	/**
	 * Initialise les données Ajoute les données aux combobox
	 */
	@FXML
	private void initialize() {
		listlog = FXCollections.observableArrayList();

		for (Logiciel log : donneesite.getLogicielData()) {
			listlog.add(log.getNomLog().getValue());
		}
		comboboxlog.setItems(listlog);
	}

	/**
	 * Cette methode permet de mettre en fenetre active le popup
	 * 
	 * @param dialogStage
	 *            la fenetre active
	 */
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

	/**
	 * Cette methode permet de pre remplir le combobox de la version de logiciel
	 * lorsqu'un nom du logiciel est selectionne
	 */
	@FXML
	private void handlechange() {
		Logiciel selected = donneesite.getLogiciel(comboboxlog.getValue());

		listvers = FXCollections.observableArrayList();
		for (Logiciel log : donneesite.getLogicielData()) {
			if (log.getNomLog().getValue()
					.equals(selected.getNomLog().getValue())) {
				listvers.add(selected.getVersion().getValue());
			}
		}
		comboboxvers.setItems(listvers);
	}

}
