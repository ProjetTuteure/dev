package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Fabricant;
import gpi.metier.FabricantDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kevin
 */

public class ModifierFabricant {

	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;
	@FXML
	private ComboBox<String> comboboxfabr;

	private Donnee donneeFabr = new Donnee();

	private ObservableList<String> listFabricant;

	private List<Integer> integerList;

	private FabricantDAO fabricantDAO=new FabricantDAO();

	@FXML
	private TextField nomfield;
	@FXML
	private TextField adrfield;
	@FXML
	private TextField telfield;

	/**
	 * Initialise les donnees Ajoute les donnees aux combobox
	 */
	@FXML
	private void initialize() {
		listFabricant = FXCollections.observableArrayList();
		for (Fabricant fabricant : fabricantDAO.recupererAllFabricant()) {
			listFabricant.add(fabricant.getNomFabricant().getValue());
			integerList.add(fabricant.getIdFabricant().getValue());
		}
		comboboxfabr.setItems(listFabricant);
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
		Fabricant selected=fabricantDAO.recupererFabricantParId(integerList.get(listFabricant.indexOf(comboboxfabr.getValue())));
		nomfield.setText(selected.getNomFabricant().getValue());
		telfield.setText(selected.getTelFabricant().getValue());
		adrfield.setText(selected.getAdresseFabricant().getValue());
	}

}