package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Prestataire;
import gpi.metier.Utilisateur;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class ModifierUtilisateur {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private TextField nomfield;
	@FXML
	private TextField prenomfield;
	@FXML
	private TextField telfield;
	@FXML
	private boolean choix1 = false;

	@FXML
	private ComboBox<String> comboboxnom;
	@FXML
	private ComboBox<String> comboboxprenom;

	private Donnee donnee = new Donnee();

	private ObservableList<String> listnom;
	private ObservableList<String> listprenom;

	/**
	 * Initialise les donn�es Ajoute les donn�es aux combobox
	 */
	@FXML
	private void initialize() {
		listnom = FXCollections.observableArrayList();

		for (Utilisateur ut : donnee.getUtilisateurData()) {
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
	 * Cette methode permet de pre remplir le combobox avec les prenoms afin
	 * d'avoir un seul et unique prestataire cibl�
	 */
	@FXML
	private void handlechange1() {
		choix1 = true;
		Utilisateur selected = donnee.getUtilisateur(comboboxnom.getValue());
		listprenom = FXCollections.observableArrayList();

		for (Utilisateur ut : donnee.getUtilisateurData()) {
			if (ut.getNomUtilisateur().getValue()
					.equals(selected.getNomUtilisateur().getValue())) {
				listprenom.add(ut.getPrenomUtilisateur().getValue());
			}
		}
		comboboxprenom.setItems(listprenom);
	}

	/**
	 * Cette methode permet de pre remplir les champs lorsqu'un prestataire est
	 * selectionne avec son pr�nom et son nom
	 */
	@FXML
	private void handlechange2() {
		try {
			if (choix1 = true) {
				String test = comboboxnom.getValue() + " "
						+ comboboxprenom.getValue();
				Utilisateur selected2 = donnee.getUtilisateur2(test);

				nomfield.setText(selected2.getNomUtilisateur().getValue());
				prenomfield.setText(selected2.getPrenomUtilisateur().getValue());
				telfield.setText(selected2.getTelUtilisateur().getValue());
			}
		} catch (NullPointerException e) {

		}
	}
}
