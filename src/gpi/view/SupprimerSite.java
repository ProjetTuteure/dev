package gpi.view;

import java.util.ArrayList;
import java.util.List;

import gpi.bd.Donnee;
import gpi.metier.Site;
import gpi.metier.SiteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * Created by Kevin
 */

public class SupprimerSite {
	@FXML
	private Stage dialogStage;
	@FXML
	private boolean okClicked = false;
	@FXML
	private ComboBox<String> comboboxSiteSupp;

	private Donnee donneesite = new Donnee();

	private ObservableList<String> listSiteObservable;
	List<Site> listSite;

	/**
	 * Initialise les donn�es Ajoute les donn�es aux combobox
	 */
	@FXML
	private void initialize() {
		SiteDAO siteDAO=new SiteDAO();
		
		listSite=new ArrayList<Site>();
		listSiteObservable = FXCollections.observableArrayList();
		listSite=siteDAO.recupererAllSite();
		for (Site site : listSite){
			listSiteObservable.add(site.getNomSiteString());
		}
		comboboxSiteSupp.setItems(listSiteObservable);
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

		SiteDAO siteDAO=new SiteDAO();
		int selected=comboboxSiteSupp.getSelectionModel().getSelectedIndex();
		int id=listSite.get(selected).getIdSite();
		siteDAO.supprimerSite(new Site(id,null,null));
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