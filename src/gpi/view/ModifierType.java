package gpi.view;

import gpi.bd.Donnee;
import gpi.exception.ConnexionBDException;
import gpi.metier.Fabricant;
import gpi.metier.Type;
import gpi.metier.TypeDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utils.*;
import utils.Popup;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin
 */

public class ModifierType {
	private int idType;
	private String cheminImageType;

	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private ComboBox<String> comboboxTypeMod;

	TypeDAO typeDAO=new TypeDAO();

	private ObservableList<String> listNomFabricant;
	private List<Integer> listIdFabricant;

	@FXML
	private TextField typeField;

	/**
	 * Initialise les donn�es Ajoute les donn�es aux combobox
	 */
	@FXML
	private void initialize() {
		listNomFabricant = FXCollections.observableArrayList();
		listIdFabricant=new ArrayList<Integer>();
		try {
			for (Type type : typeDAO.recupererAllType()) {
                listNomFabricant.add(type.getNomTypeString());
				listIdFabricant.add(type.getIdType());
            }
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		comboboxTypeMod.setItems(listNomFabricant);
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
		try {
			typeDAO.modifierType(new Type(this.getIdType(),typeField.getText(),this.getCheminImageType()));
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
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
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Open File");
		fileChooser.showOpenDialog(null); // you could pass a stage
		File file = fileChooser.getSelectedFile();												// reference here if you


		if (file != null) {
			this.setCheminImageType(file.getAbsolutePath());
		}

	}

	/**
	 * Cette methode permet de pre remplir les champs lorsqu'un type est
	 * selectionne
	 */
	@FXML
	private void handlechange() {
		this.setIdType(listIdFabricant.get(comboboxTypeMod.getSelectionModel().getSelectedIndex()));
		Type selected= null;
		try {
			selected = typeDAO.recupererTypeParId(this.getIdType());
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		typeField.setText(selected.getNomTypeString());

	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getCheminImageType() {
		return cheminImageType;
	}

	public void setCheminImageType(String cheminImageType) {
		this.cheminImageType = cheminImageType;
	}

}