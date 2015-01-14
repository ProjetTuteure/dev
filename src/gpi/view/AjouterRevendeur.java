package gpi.view;


import utils.Popup;
import gpi.metier.Revendeur;
import gpi.metier.RevendeurDAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class AjouterRevendeur {
	@FXML
	private Stage dialogStage;

	@FXML
	private boolean okClicked = false;

	@FXML
	private TextField nomRevendeur;
	
	@FXML
	private TextField telRevendeur;
	
	@FXML
	private TextField adresseRevendeur;
	
	RevendeurDAO rdao=new RevendeurDAO();
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
	 * Cette procedure permet de fermer la fenetre et d'ajouter le revendeur dans la BD 
	 * lorsque le bouton AJOUTER est clique
	 */
	@FXML
	private void handleOk() {
		Revendeur revendeurAAjouter;
		if(nomRevendeur.getText().equals(""))
		{
			new Popup("Le champ \"Nom du revendeur\" doit être saisi");
		}
		else
		{
			revendeurAAjouter=new Revendeur(null,nomRevendeur.getText(),telRevendeur.getText(),adresseRevendeur.getText());
			rdao.ajouterRevendeur(revendeurAAjouter);
			okClicked = true;
			dialogStage.close();
		}
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