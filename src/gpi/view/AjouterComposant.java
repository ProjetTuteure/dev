package gpi.view;

import gpi.bd.Donnee;
import gpi.metier.Composant;
import gpi.metier.ComposantDAO;
import gpi.metier.Fabricant;
import gpi.metier.FabricantDAO;
import gpi.metier.Site;
import gpi.metier.SiteDAO;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class AjouterComposant {

	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;
	@FXML
	private ComboBox<String> comboboxfabr;
	@FXML
	private TextField nom;
	@FXML
	private TextArea caracteristiques;

	private Donnee donneeMat = new Donnee();

	private ObservableList<String> listNom1;

	/**
	 * Initialise les donnees Ajoute les donnees aux combobox
	 */
	@FXML
	private void initialize() {
		listNom1 = FXCollections.observableArrayList();

		for (Fabricant fab : donneeMat.getFabricantData()) {
			listNom1.add(fab.getNomFabricant().getValue());
		}
		comboboxfabr.setItems(listNom1);
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
	 * Cette procedure permet de fermer la fenetre, lorsque le bouton AJOUTER
	 * est clique
	 */
	@FXML
	private void handleOk() {
		/*ComposantDAO composantDAO = new ComposantDAO();
		FabricantDAO fabricantDAO = new FabricantDAO();
		Fabricant fabricant = fabricantDAO.recupererFabricant((comboboxfabr
				.getValue()));
		composantDAO.ajouterComposant(new Composant(
				new SimpleIntegerProperty(0), (this.nom).getText(),
				this.caracteristiques.getText(), fabricant));
		okClicked = true;*/
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
