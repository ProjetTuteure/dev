package gpi.view;

import gpi.exception.ConnexionBDException;
import gpi.metier.Fabricant;
import gpi.metier.FabricantDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.Popup;

/**
 * Created by Kevin
 */

public class AjouterFabricant {
	@FXML
	private Stage dialogStage;

	@FXML
	private boolean okClicked = false;

	@FXML
	private TextField nomFabricantField;

	@FXML
	private TextField telFabricantField;

	@FXML
	private TextField adresseFabricantField;

	private FabricantDAO fabricantDAO=new FabricantDAO();
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
			fabricantDAO.ajouterFabricant(new Fabricant(0,nomFabricantField.getText(),adresseFabricantField.getText(),telFabricantField.getText()));
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

}