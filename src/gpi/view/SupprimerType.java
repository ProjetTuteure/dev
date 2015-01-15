package gpi.view;

import gpi.bd.Donnee;
import gpi.exception.ConnexionBDException;
import gpi.metier.Type;
import gpi.metier.TypeDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import utils.Popup;

/**
 * Created by Kevin
 */

public class SupprimerType {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;
	@FXML
	private ComboBox<String> comboboxtype;

	private Donnee donneetype = new Donnee();

	private ObservableList<String> listNom;

	TypeDAO typeDAO=new TypeDAO();

	/**
	 * Initialise les donnees Ajoute les donnees aux combobox
	 */
	@FXML
	private void initialize() {
		listNom = FXCollections.observableArrayList();

		try {
			for (Type type : typeDAO.recupererAllType()) {
                listNom.add(type.getNomTypeString());
            }
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		comboboxtype.setItems(listNom);

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
		try {
			typeDAO.supprimerType(new Type(comboboxtype.getValue(),""));
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

}