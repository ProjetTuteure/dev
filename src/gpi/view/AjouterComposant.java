package gpi.view;

import java.util.ArrayList;
import java.util.List;

import utils.Constante;
import utils.Popup;
import gpi.bd.Donnee;
import gpi.exception.ConnexionBDException;
import gpi.metier.Composant;
import gpi.metier.ComposantDAO;
import gpi.metier.Fabricant;
import gpi.metier.FabricantDAO;
import gpi.metier.Revendeur;
import gpi.metier.RevendeurDAO;
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
	
	ComposantDAO composantdao=new ComposantDAO();
	FabricantDAO fabricantDAO=new FabricantDAO();

	private ObservableList<String> listFabricant;
	
	private List<Fabricant> listeFabricant;

	/**
	 * Initialise les donnees Ajoute les donnees aux combobox
	 */
	@FXML
	private void initialize() {
		listFabricant = FXCollections.observableArrayList();
		listeFabricant=new ArrayList<Fabricant>();
		try
		{
			listeFabricant=fabricantDAO.recupererAllFabricant();
		}
		catch(ConnexionBDException ce)
		{
			new Popup(ce.getMessage());
			this.dialogStage.close();
		}
		
		for (Fabricant fab : listeFabricant) {
			listFabricant.add(fab.getNomFabricant().getValue());
		}
		comboboxfabr.setItems(listFabricant);
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
		Composant composantAAjouter;
		if(nom.getText().equals(""))
		{
			new Popup("Le champ \"Nom du composant\" doit �tre rempli");
		}
		else if(nom.getText().length()>Constante.LONGUEUR_NOM_COMPOSANT)
		{
			new Popup("Le nom du composant doit etre inf�rieur � "+Constante.LONGUEUR_NOM_COMPOSANT+" caract�res");
		}
		else if(caracteristiques.getText().length()>Constante.LONGUEUR_ADRESSE)
		{
			new Popup("Les caract�ristiques ne peuvent pas d�passer "+Constante.LONGUEUR_CARACTERISTIQUE_COMPOSANT+" caract�res");
		}
		else
		{
			Fabricant fabricant = listeFabricant.get(comboboxfabr.getSelectionModel().getSelectedIndex());		
			composantAAjouter=new Composant(new SimpleIntegerProperty(0),nom.getText(),caracteristiques.getText(), fabricant);
			try
			{
				composantdao.ajouterComposant(composantAAjouter);;
				new Popup("Revendeur "+composantAAjouter.getNomComposant()+" ajout� !");
			}
			catch(ConnexionBDException ce)
			{
				new Popup(ce.getMessage());
			}
			okClicked = true;
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

}
