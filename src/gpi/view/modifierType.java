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

	/**
	 * Initialise les données Ajoute les données aux combobox
	 */
	@FXML
	private void initialize() {
		listNom = FXCollections.observableArrayList();

		for (Type type : donneetype.getTypeData()) {
			listNom.add(type.getNomString());
		}
		comboboxTypeMod.setItems(listNom);
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
	 * Cette methode permet de savoir si le bouton AJOUTER est clique ou pas
	 * 
	 * @return vrai si le bouton AJOUTER est clique, faux sinon
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Cette procedure permet de fermer la fenetre, lorsque le bouton AJOUTER
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
	 * Cette methode permet de faire apparaitre un Filechooser lorsqu'on clique
	 * sur "choisir l'image"
	 * 
	 * @param event
	 *            un evenement sur le bouton "choisir l'image"
	 */
	@FXML
	private void handleChoose(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open File");
		File file = fileChooser.showOpenDialog(null);

		if (file != null) {
		}

	}

	/**
	 * Cette methode permet de pre remplir les champs lorsqu'un type est
	 * selectionne
	 */
	@FXML
	private void handlechange() {
		Type selected = donneetype.gettype(comboboxTypeMod.getValue());

		typefield.setText(selected.getNom().getValue());
	}

}
