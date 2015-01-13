package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Prestataire;
import gpi.metier.Utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class SupprimerUtilisateur {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private ComboBox<String> comboboxnom;
	@FXML
	private ComboBox<String> comboboxprenom;

	private Donnee donneesite = new Donnee();

	private ObservableList<String> listnom;
	private ObservableList<String> listprenom;

	/**
	 * Initialise les donn�es Ajoute les donn�es aux combobox
	 */
	@FXML
	private void initialize() {
		listnom = FXCollections.observableArrayList();

		for (Utilisateur ut : donneesite.getUtilisateurData()) {
			listnom.add(ut.getNomUtilisateur().getValue());
		}
		comboboxnom.setItems(listnom);
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
	 * Cette methode permet de pre remplir le combobox du prenom du prestataire
	 * lorsqu'un nom du prestataire est selectionne
	 */
	@FXML
	private void handlechange() {
		Utilisateur selected = donneesite.getUtilisateur(comboboxnom.getValue());

		listprenom = FXCollections.observableArrayList();
		for (Utilisateur ut : donneesite.getUtilisateurData()) {
			if (ut.getNomUtilisateur().getValue()
					.equals(selected.getNomUtilisateur().getValue())) {
				listprenom.add(selected.getPrenomUtilisateur().getValue());
			}
		}
		comboboxprenom.setItems(listprenom);
	}

}
