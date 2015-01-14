package gpi.view;

import java.util.ArrayList;
import java.util.List;

import utils.Popup;
import gpi.bd.Donnee;
import gpi.metier.Revendeur;
import gpi.metier.RevendeurDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class SupprimerRevendeur {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private ComboBox<String> comboboxrev;

	private Donnee donneesite = new Donnee();

	private ObservableList<String> listrev;
	
	private List<Revendeur> listeRevendeur;
	
	private RevendeurDAO revendeurDAO=new RevendeurDAO();

	/**
	 * Initialise les donnï¿½es Ajoute les donnï¿½es aux combobox
	 */
	@FXML
	private void initialize() {
		listrev = FXCollections.observableArrayList();
		listeRevendeur=new ArrayList<Revendeur>();
		listeRevendeur=revendeurDAO.recupererAllRevendeur();
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
	 * Cette methode permet de savoir si le bouton SUPPRIMER est clique ou pas
	 * 
	 * @return vrai si le bouton SUPPRIMER est clique, faux sinon
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Cette procedure permet de fermer la fenetre, lorsque le bouton SUPPRIMER
	 * est clique
	 */
	@FXML
	private void handleOk() {
		if(comboboxrev.getValue()==null)
		{
			new Popup("Veuillez choisir un revendeur");
		}
		else
		{
			Revendeur revendeur=listeRevendeur.get(comboboxrev.getSelectionModel().getSelectedIndex());
			if(revendeurDAO.supprimerRevendeur(revendeur)==true)
			{
				dialogStage.close();
				new Popup("Revendeur supprimé !");
			}
			else
			{
				new Popup("Echec lors de la suppression");
			}
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