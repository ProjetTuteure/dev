package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Revendeur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class ModifierRevendeur {
	@FXML
	private Stage dialogStage;

	@FXML
	private boolean okClicked = false;

	@FXML
	private TextField nomfield;
	@FXML
	private TextField telfield;
	@FXML
	private TextField adrfield;

	@FXML
	private ComboBox<String> comboboxrev;

	private Donnee donneesite = new Donnee();

	private ObservableList<String> listrev;

	/**
	 * Initialise les donn�es Ajoute les donn�es aux combobox
	 */
	@FXML
	private void initialize() {
		listrev = FXCollections.observableArrayList();

		for (Revendeur rev : donneesite.getRevendeurData()) {
			listrev.add(rev.getNomRevendeur().getValue());
		}
		comboboxrev.setItems(listrev);
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
	 * Cette methode permet de savoir si le bouton MODIFIER est clique ou pas
	 * 
	 * @return vrai si le bouton MODIFIER est clique, faux sinon
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Cette procedure permet de fermer la fenetre, lorsque le bouton MODIFIER
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
	 * Cette methode permet de pre remplir les champs lorsqu'un revendeur est
	 * selectionne
	 */
	@FXML
	private void handlechange() {

		Revendeur selected = donneesite.getRevendeur(comboboxrev.getValue());
		nomfield.setText(selected.getNomRevendeur().getValue());
		telfield.setText(selected.getTelRevendeur().getValue());
		adrfield.setText(selected.getAdresseRevendeur().getValue());
	}

}
