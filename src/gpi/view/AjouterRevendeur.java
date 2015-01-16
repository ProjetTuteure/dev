package gpi.view;

import utils.Constante;
import utils.Popup;
import gpi.exception.ConnexionBDException;
import gpi.metier.Revendeur;
import gpi.metier.RevendeurDAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
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
	private TextField tf_mobileRevendeur;
	
	@FXML 
	private TextField tf_faxRevendeur;
	
	@FXML
	private TextField tf_emailRevendeur;
	
	@FXML
	private TextField adresseRevendeur;
	
	RevendeurDAO rdao=new RevendeurDAO();
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
	 * Cette procedure permet de fermer la fenetre et d'ajouter le revendeur dans la BD 
	 * lorsque le bouton AJOUTER est clique
	 */
	@FXML
	private void handleOk() {
		if(controlerSaisies()==true)
		{
			System.out.println("nomRevendeur "+nomRevendeur.getText());
			System.out.println("telRevendeur "+telRevendeur.getText());
			System.out.println("tf_mobileRevendeur "+tf_mobileRevendeur.getText());
			System.out.println("tf_faxRevendeur "+tf_faxRevendeur.getText());
			System.out.println("tf_emailRevendeur "+tf_emailRevendeur.getText());
			System.out.println("adresseRevendeur "+adresseRevendeur.getText());
			Revendeur revendeurAAjouter=new Revendeur(new SimpleIntegerProperty(0),nomRevendeur.getText(),
					telRevendeur.getText(),
					tf_mobileRevendeur.getText(),
					tf_faxRevendeur.getText(),
					tf_emailRevendeur.getText(),
					adresseRevendeur.getText());
			System.out.println(revendeurAAjouter);
			try
			{
				rdao.ajouterRevendeur(revendeurAAjouter);
				new Popup("Revendeur "+revendeurAAjouter.getNomRevendeur().getValue()+" ajout� !");
			}
			catch(ConnexionBDException ce)
			{
				new Popup(ce.getMessage());
			}
			okClicked = true;
			dialogStage.close();
		}
	}

	/**
	 * Controle les saisies
	 * @return vrai si les donn�es saisies sont coh�rentes, faux sinon
	 */
	public boolean controlerSaisies()
	{
		if(nomRevendeur.getText().isEmpty())
		{
			new Popup("Le champ \"Nom du revendeur\" doit �tre saisi");
			return false;
		}
		if(nomRevendeur.getText().length()>Constante.LONGUEUR_NOM_REVENDEUR)
		{
			new Popup("La longueur du nom du revendeur doit �tre inf�rieur � "+Constante.LONGUEUR_NOM_REVENDEUR+" caract�res");
			return false;
		}
		if(telRevendeur.getText().length()>Constante.LONGUEUR_NUM_TELEPHONE)
		{
			new Popup("Le num�ro de t�l�phone saisi doit �tre inf�rieur � "+Constante.LONGUEUR_NUM_TELEPHONE+" caract�res");
			return false;
		}
		if(tf_mobileRevendeur.getText().length()>Constante.LONGUEUR_NUM_TELEPHONE)
		{
			new Popup("Le num�ro de mobile saisi doit �tre inf�rieur � "+Constante.LONGUEUR_NUM_TELEPHONE+" caract�res");
			return false;
		}
		if(tf_faxRevendeur.getText().length()>Constante.LONGUEUR_NUM_TELEPHONE)
		{
			new Popup("Le num�ro de fax saisi doit �tre inf�rieur � "+Constante.LONGUEUR_NUM_TELEPHONE+" caract�res");
			return false;
		}
		if(tf_emailRevendeur.getText().length()>Constante.LONGUEUR_MAIL)
		{
			new Popup("Le mail saisi doit contenir "+Constante.LONGUEUR_MAIL+" caract�res");
			return false;
		}
		if(adresseRevendeur.getText().length()>Constante.LONGUEUR_ADRESSE)
		{
			new Popup("L'adresse ne peut pas d�passer "+Constante.LONGUEUR_ADRESSE+" caract�res");
			return false;
		}
		if(nomRevendeur.getText().length()>Constante.LONGUEUR_NOM_REVENDEUR)
		{
			new Popup("L'adresse ne peut pas d�passer "+Constante.LONGUEUR_NOM_REVENDEUR+" caract�res");
			return false;
		}
		return true;
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