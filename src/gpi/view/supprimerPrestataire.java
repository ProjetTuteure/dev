package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Prestataire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class supprimerPrestataire {
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

		for (Prestataire pr : donneesite.getPrestataireData()) {
			listnom.add(pr.getNomPrestataire().getValue());
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
	 * Cette methode permet de pre remplir le combobox du prenom du prestataire
	 * lorsqu'un nom du prestataire est selectionne
	 */
	@FXML
	private void handlechange() {
		Prestataire selected = donneesite.getPrestaire(comboboxnom.getValue());

		listprenom = FXCollections.observableArrayList();
		for (Prestataire pr : donneesite.getPrestataireData()) {
			if (pr.getNomPrestataire().getValue()
					.equals(selected.getNomPrestataire().getValue())) {
				listprenom.add(selected.getPrenomPrestataire().getValue());
			}
		}
		comboboxprenom.setItems(listprenom);
	}

}
