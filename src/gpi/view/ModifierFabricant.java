package gpi.view;

import gpi.bd.Donnee;
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

	private ObservableList<String> listFabricant;
	List<Fabricant> list;

	private FabricantDAO fabricantDAO=new FabricantDAO();

	@FXML
	private TextField nomField;
	@FXML
	private TextField adresseField;
	@FXML
	private TextField telField;

	/**
	 * Initialise les donnees Ajoute les donnees aux combobox
	 */
	@FXML
	private void initialize() {
		listFabricant = FXCollections.observableArrayList();
		list=fabricantDAO.recupererAllFabricant();
		for (Fabricant fabricant : list) {
			listFabricant.add(fabricant.getNomFabricant().getValue());
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
		fabricantDAO.modifierFabricant(new Fabricant(this.getIdFabriquant(),nomField.getText(),adresseField.getText(),telField.getText()));
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
		this.setIdFabriquant(list.get(comboboxfabr.getSelectionModel().getSelectedIndex()).getIdFabricant().getValue());
		Fabricant selected=fabricantDAO.recupererFabricantParId(this.getIdFabriquant());
		nomField.setText(selected.getNomFabricant().getValue());
		telField.setText(selected.getTelFabricant().getValue());
		adresseField.setText(selected.getAdresseFabricant().getValue());
	}

	public int getIdFabriquant() {
		return idFabriquant;
	}

	public void setIdFabriquant(int idFabriquant) {
		this.idFabriquant = idFabriquant;
	}

}