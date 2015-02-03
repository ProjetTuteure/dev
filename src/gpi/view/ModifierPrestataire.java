package gpi.view;

import gpi.bd.Donnee;
import gpi.exception.ConnexionBDException;
import gpi.metier.Composant;
import gpi.metier.Prestataire;
import gpi.metier.PrestataireDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.Popup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin
 */

public class ModifierPrestataire {
	private int idPrestataire;

	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private TextField nomPrestataireField;

	@FXML
	private TextField prenomPrestataireField;

	@FXML
	private TextField telPrestataireField;

	@FXML
	private TextField societePrestataireField;

	@FXML
	private TextField mobilePrestataireField;

	@FXML
	private TextField faxPrestataireField;

	@FXML
	private TextField emailPrestataireField;

	@FXML
	private boolean choix1 = false;

	@FXML
	private ComboBox<String> comboboxnom;
	@FXML
	private ComboBox<String> comboboxprenom;

	private PrestataireDAO prestataireDAO = new PrestataireDAO();

	private ObservableList<String> listNom;
	private ObservableList<String> listPrenom;

	private List<Prestataire> listeNom;
	private List<Prestataire> listePrenom;

	/**
	 * Initialise les donn�es Ajoute les donn�es aux combobox
	 */
	@FXML
	private void initialize() {
		listNom = FXCollections.observableArrayList();
		listeNom = new ArrayList<Prestataire>();

		try {
			listeNom = prestataireDAO.recupererAllPrestataire();
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		for (Prestataire prestataire : listeNom) {
			listNom.add(prestataire.getNomPrestataire().get());
		}
		comboboxnom.setItems(listNom);
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
		try {
			prestataireDAO.modifierPrestataire(new Prestataire(this
					.getIdPrestataire(), nomPrestataireField.getText(),
					prenomPrestataireField.getText(), telPrestataireField
							.getText(), societePrestataireField.getText(),
					null, null, null));
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

	/**
	 * Cette methode permet de pre remplir le combobox avec les prenoms afin
	 * d'avoir un seul et unique prestataire cibl�
	 */
	@FXML
	private void handlechange1() {
		listPrenom = FXCollections.observableArrayList();
		listePrenom = new ArrayList<Prestataire>();

		int indexPrestataireSelectionne = comboboxnom.getSelectionModel()
				.getSelectedIndex();

		try {
			listePrenom = prestataireDAO.recupererPrestataireParNom((listNom
					.get(comboboxnom.getSelectionModel().getSelectedIndex())));
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		Prestataire selected = listeNom.get(indexPrestataireSelectionne);
		for (Prestataire pr : listePrenom) {
			if (pr.getNomPrestataire().getValue().equals(selected.getNomPrestataire().getValue())) {
				
				listPrenom.add(pr.getPrenomPrestataire().get());
			}
		}
		comboboxprenom.setItems(listPrenom);
		
	}

	/**
	 * Cette methode permet de pre remplir les champs lorsqu'un prestataire est
	 * selectionne avec son pr�nom et son nom
	 */
	@FXML
	private void handlechange2() {
		try {
			int indexPrestataireSelectionne = comboboxprenom
					.getSelectionModel().getSelectedIndex();
			Prestataire selected2 = listePrenom
					.get(indexPrestataireSelectionne);

			nomPrestataireField.setText(selected2.getNomPrestataire().get());
			prenomPrestataireField.setText(selected2.getPrenomPrestataire()
					.get());
			telPrestataireField.setText(selected2.getTelPrestataire().get());
			mobilePrestataireField.setText(selected2.getMobilePrestataire()
					.get());
			faxPrestataireField.setText(selected2.getFaxPrestataire().get());
			emailPrestataireField
					.setText(selected2.getEmailPrestataire().get());
			societePrestataireField.setText(selected2.getSocieteePrestataire()
					.get());

		} catch (NullPointerException e) {
			// tripotasse
		}
	}

	public int getIdPrestataire() {
		return idPrestataire;
	}

	public void setIdPrestataire(int idPrestataire) {
		this.idPrestataire = idPrestataire;
	}
}