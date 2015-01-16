package gpi.view;


import gpi.exception.ConnexionBDException;
import gpi.metier.Type;
import gpi.metier.TypeDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.*;
import utils.Popup;

import javax.swing.*;
import java.io.File;

/**
 * Created by Kevin
 */

public class AjouterType {
	private String cheminImageType;

	@FXML
	private Stage dialogStage;

	@FXML
	private TextField nomTypeField;

	@FXML
	private boolean okClicked = false;

	TypeDAO typeDAO=new TypeDAO();

	/**
	 * Initialise les donn�es
	 */
	@FXML
	private void initialize() {

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
		try {
			typeDAO.ajouterType(new Type(0,nomTypeField.getText(),this.getCheminImageType()));
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

	@FXML
	private void handleChoose(ActionEvent event) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Open File");
		fileChooser.showOpenDialog(null);
		File file = fileChooser.getSelectedFile();


		if (file != null) {
			this.setCheminImageType(file.getAbsolutePath());
		}

	}


	public String getCheminImageType() {
		return cheminImageType;
	}

	public void setCheminImageType(String cheminImageType) {
		this.cheminImageType = cheminImageType;
	}
}