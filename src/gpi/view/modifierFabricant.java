package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Fabricant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class modifierFabricant {

	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;
	@FXML
	private ComboBox<String> comboboxfabr;

	private Donnee donneeFabr = new Donnee();

	private ObservableList<String> listFabr;

	@FXML
	private TextField nomfield;
	@FXML
	private TextField adrfield;
	@FXML
	private TextField telfield;

	/**
	 * Initialise les données Ajoute les données aux combobox
	 */
	@FXML
	private void initialize() {
		listFabr = FXCollections.observableArrayList();

		for (Fabricant fab : donneeFabr.getFabricantData()) {
			listFabr.add(fab.getNomFab().getValue());
		}
		comboboxfabr.setItems(listFabr);
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
	 * Cette methode permet de savoir si le bouton MODIFIER est clique ou pas
	 * 
	 * @return vrai si le bouton MODIFIER est clique, faux sinon
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Cette methode permet de pre remplir les champs lorsqu'un Fabricant est
	 * selectionne
	 */
	@FXML
	private void handlechange() {
		Fabricant selected = donneeFabr.getFabricant(comboboxfabr.getValue());
		nomfield.setText(selected.getNomFab().getValue());
		telfield.setText(selected.getTelFab().getValue());
		adrfield.setText(selected.getAdresseFab().getValue());
	}

}
