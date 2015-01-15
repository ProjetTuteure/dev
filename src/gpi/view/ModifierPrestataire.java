package gpi.view;

import gpi.bd.Donnee;
import gpi.exception.ConnexionBDException;
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
	private boolean choix1 = false;

	@FXML
	private ComboBox<String> comboboxnom;
	@FXML
	private ComboBox<String> comboboxprenom;

	private PrestataireDAO prestataireDAO=new PrestataireDAO();

	private ObservableList<String> listNomPrestataire;
	private ObservableList<String> listPrenomPrestataire;
	private List<Integer> prestataireList;

	/**
	 * Initialise les donn�es Ajoute les donn�es aux combobox
	 */
	@FXML
	private void initialize() {
		listNomPrestataire = FXCollections.observableArrayList();
		prestataireList=new ArrayList<Integer>();

		try {
			for (Prestataire prestataire : prestataireDAO.recupererAllPrestataire()) {
                listNomPrestataire.add(prestataire.getNomPrestataire().getValue());
                prestataireList.add(prestataire.getIdPrestataire().getValue());
            }
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		comboboxnom.setItems(listNomPrestataire);
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
			prestataireDAO.modifierPrestataire(new Prestataire(this.getIdPrestataire(),nomPrestataireField.getText(),prenomPrestataireField.getText(),telPrestataireField.getText(),societePrestataireField.getText()));
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
		choix1 = true;
		int idPrestataire=prestataireList.get(comboboxnom.getSelectionModel().getSelectedIndex());
		Prestataire selected = null;
		try {
			selected = prestataireDAO.recupererPrestataireParId(idPrestataire);
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		listPrenomPrestataire = FXCollections.observableArrayList();
		prestataireList=new ArrayList<Integer>();
		try {
			for (Prestataire prestataire : prestataireDAO.recupererAllPrestataire()) {
                if (prestataire.getNomPrestataire().getValue().equals(selected.getNomPrestataire().getValue())) {
                    listPrenomPrestataire.add(prestataire.getPrenomPrestataire().getValue());
                    prestataireList.add(prestataire.getIdPrestataire().getValue());
                }
            }
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		comboboxprenom.setItems(listPrenomPrestataire);
	}

	/**
	 * Cette methode permet de pre remplir les champs lorsqu'un prestataire est
	 * selectionne avec son pr�nom et son nom
	 */
	@FXML
	private void handlechange2() {
		try {
			if (choix1 = true) {
				int idPrestataire=prestataireList.get(comboboxprenom.getSelectionModel().getSelectedIndex());
				Prestataire selected2 = null;
				try {
					selected2 = prestataireDAO.recupererPrestataireParId(idPrestataire);
				} catch (ConnexionBDException e) {
					new Popup(e.getMessage());
				}
				this.setIdPrestataire(selected2.getIdPrestataire().getValue());
				nomPrestataireField.setText(selected2.getNomPrestataire().getValue());
				prenomPrestataireField.setText(selected2.getPrenomPrestataire().getValue());
				telPrestataireField.setText(selected2.getTelPrestataire().getValue());
				societePrestataireField.setText(selected2.getSocieteePrestataire().getValue());
			}
		} catch (NullPointerException e) {

		}
	}

	public int getIdPrestataire() {
		return idPrestataire;
	}

	public void setIdPrestataire(int idPrestataire) {
		this.idPrestataire = idPrestataire;
	}
}