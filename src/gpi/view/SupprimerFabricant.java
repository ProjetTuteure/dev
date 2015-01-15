package gpi.view;

import gpi.bd.Donnee;
import gpi.exception.ConnexionBDException;
import gpi.metier.Fabricant;
import gpi.metier.FabricantDAO;
import gpi.metier.Site;
import gpi.metier.SiteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import utils.Popup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin
 */

public class SupprimerFabricant {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;

	@FXML
	private ComboBox<String> comboboxfabr;

	private FabricantDAO fabricantDAO=new FabricantDAO();

	private ObservableList<String> listFabricantObservable;

	private List<Fabricant> listFabricant;

	/**
	 * Initialise les donn�es Ajoute les donn�es aux combobox
	 */
	@FXML
	private void initialize() {
		listFabricantObservable = FXCollections.observableArrayList();
		listFabricant=new ArrayList<Fabricant>();
		try {
			listFabricant=fabricantDAO.recupererAllFabricant();
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		for (Fabricant fabricant : listFabricant) {
			listFabricantObservable.add(fabricant.getNomFabricantString());
		}
		comboboxfabr.setItems(listFabricantObservable);
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
		int selected=comboboxfabr.getSelectionModel().getSelectedIndex();
		int id=listFabricant.get(selected).getIdFabricant().getValue();
		try {
			fabricantDAO.supprimerFabricant(new Fabricant(id, null, null,null));
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