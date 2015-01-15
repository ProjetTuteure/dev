package gpi.view;

import gpi.bd.Donnee;
import gpi.exception.ConnexionBDException;
import gpi.metier.Fabricant;
import gpi.metier.FabricantDAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.Popup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kevin
 */

public class ModifierFabricant {
	private int idFabriquant;

	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;
	@FXML
	private ComboBox<String> comboboxfabr;

	private ObservableList<String> listNomFabricant;
	private List<Integer> listIdFabricant;

	private FabricantDAO fabricantDAO=new FabricantDAO();

	@FXML
	private TextField nomFabricantField;
	@FXML
	private TextField adresseFabricantField;
	@FXML
	private TextField telFabricantField;

	/**
	 * Initialise les donnees Ajoute les donnees aux combobox
	 */
	@FXML
	private void initialize() {
		listNomFabricant = FXCollections.observableArrayList();
		listIdFabricant = new ArrayList<Integer>();
		try {
			for (Fabricant fabricant : fabricantDAO.recupererAllFabricant()) {
                listNomFabricant.add(fabricant.getNomFabricant().getValue());
                listIdFabricant.add(fabricant.getIdFabricant().getValue());
            }
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		comboboxfabr.setItems(listNomFabricant);
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
		try {
			fabricantDAO.modifierFabricant(new Fabricant(this.getIdFabriquant(),nomFabricantField.getText(),adresseFabricantField.getText(),telFabricantField.getText()));
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
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
		this.setIdFabriquant(listIdFabricant.get(comboboxfabr.getSelectionModel().getSelectedIndex()));
		Fabricant selected= null;
		try {
			selected = fabricantDAO.recupererFabricantParId(this.getIdFabriquant());
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		nomFabricantField.setText(selected.getNomFabricant().getValue());
		telFabricantField.setText(selected.getTelFabricant().getValue());
		adresseFabricantField.setText(selected.getAdresseFabricant().getValue());
	}

	public int getIdFabriquant() {
		return idFabriquant;
	}

	public void setIdFabriquant(int idFabriquant) {
		this.idFabriquant = idFabriquant;
	}

}