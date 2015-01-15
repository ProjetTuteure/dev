package gpi.view;

import gpi.metier.Facture;
import gpi.metier.FactureDAO;
import gpi.metier.RevendeurDAO;
import gpi.metier.Site;
import gpi.metier.SiteDAO;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class AjouterFacture {
	@FXML
	private Stage dialogStage;
	@FXML
	private TextField NumFacture;
	@FXML
	private DatePicker DateFacture;
	@FXML
	private TextField MontantFacture;
	@FXML
	private ComboBox<String> NumRevendeur;
	@FXML
	private boolean okClicked = false;

	/**
	 * Initialise les données
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
		FactureDAO factureDAO = new FactureDAO();
		RevendeurDAO revendeurDAO = new RevendeurDAO();
		// if (isInputValid()) {
		
		factureDAO.ajouterFacture(new Facture(NumFacture.getText(),DateFacture.getValue(),Float.parseFloat(MontantFacture.getText()),revendeurDAO.recupererRevendeurParId(Integer.parseInt(NumRevendeur.getValue()))));
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