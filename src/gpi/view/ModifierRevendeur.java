package gpi.view;

import java.util.ArrayList;
import java.util.List;

import utils.Constante;
import utils.Popup;
import gpi.bd.Donnee;
import gpi.exception.ConnexionBDException;
import gpi.metier.Revendeur;
import gpi.metier.RevendeurDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class ModifierRevendeur {
	@FXML
	private Stage dialogStage;

	@FXML
	private boolean okClicked = false;

	@FXML
	private TextField nomfield;
	@FXML
	private TextField telfield;
	@FXML
	private TextField adrfield;

	@FXML
	private ComboBox<String> comboboxrev;

	private ObservableList<String> listrev;
	
	private List<Revendeur> listeRevendeur;
	
	private RevendeurDAO revendeurDAO=new RevendeurDAO();

	/**
	 * Initialise les donn�es Ajoute les donn�es aux combobox
	 */
	@FXML
	private void initialize() {
		listrev = FXCollections.observableArrayList();
		listeRevendeur=new ArrayList<Revendeur>();
		try
		{
			listeRevendeur=revendeurDAO.recupererAllRevendeur();
		}
		catch(ConnexionBDException ce)
		{
			new Popup(ce.getMessage());
			this.dialogStage.close();
		}
		for(Revendeur revendeur : listeRevendeur)
		{
			listrev.add(revendeur.getNomRevendeur().getValue());
		}
		comboboxrev.setItems(listrev);
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
		if(nomfield.getText().equals(""))
		{
			new Popup("Le champ \"Nom du revendeur\" doit �tre rempli");
		}
		else if(telfield.getText().length()>Constante.LONGUEUR_NUM_TELEPHONE)
		{
			new Popup("Le num�ro de t�l�phone saisi doit �tre inf�rieur � "+Constante.LONGUEUR_NUM_TELEPHONE+" caract�res");
		}
		else if(adrfield.getText().length()>Constante.LONGUEUR_ADRESSE)
		{
			new Popup("L'adresse ne peut pas d�passer "+Constante.LONGUEUR_ADRESSE+" caract�res");
		}
		else if(nomfield.getText().length()>Constante.LONGUEUR_NOM_REVENDEUR)
		{
			new Popup("L'adresse ne peut pas d�passer "+Constante.LONGUEUR_NOM_REVENDEUR+" caract�res");
		}
		else
		{
			int indexRevendeurSelectionne=comboboxrev.getSelectionModel().getSelectedIndex();
			Revendeur revendeur = listeRevendeur.get(indexRevendeurSelectionne);
			revendeur.setNomRevendeur(nomfield.getText());
			revendeur.setAdresseRevendeur(adrfield.getText());
			revendeur.setTelRevendeur(telfield.getText());
			try
			{
				revendeurDAO.modifierRevendeur(revendeur);
				new Popup("Revendeur "+revendeur.getNomRevendeur().getValue()+" modifi� !");
			}
			catch(ConnexionBDException ce)
			{
				new Popup(ce.getMessage());
			}
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

	/**
	 * Cette methode permet de pre remplir les champs lorsqu'un revendeur est
	 * selectionne
	 */
	@FXML
	private void handlechange() {
		
		int indexRevendeurSelectionne=comboboxrev.getSelectionModel().getSelectedIndex();
		Revendeur selected = listeRevendeur.get(indexRevendeurSelectionne);
		nomfield.setText(selected.getNomRevendeur().getValue());
		telfield.setText(selected.getTelRevendeur().getValue());
		adrfield.setText(selected.getAdresseRevendeur().getValue());
	}

}