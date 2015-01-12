package gpi.view;


import gpi.MainApp;
import gpi.bd.Donnee;
import gpi.metier.Facture;
import gpi.metier.Materiel;
import gpi.metier.Revendeur;
import gpi.metier.Site;
import gpi.metier.Type;

import gpi.metier.Materiel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Victor on 24/11/2014.
 */
public class AncienneteController implements Initializable {

	@FXML
	private ComboBox<String> comboboxSiteAncienneteOverview;
	@FXML
	private ComboBox<String> comboboxTypeAncienneteOverview;
	@FXML
	private TableView<Materiel> materielTable;
	@FXML
	private TableColumn<Materiel, String> nomMateriel;
	@FXML
	private TableColumn<Materiel, String> dateAchatMateriel;
	@FXML
	private TableColumn<Materiel, String> etatMateriel;
	@FXML
	private TableColumn<Materiel, String> finGarantieMateriel;
	@FXML
	private TableColumn<Materiel, String> revendeurMateriel;
	@FXML
	private TableColumn<Materiel, String> fabricantMateriel;
	@FXML
	private TableColumn<Materiel, String> siteMateriel;
	
	private MainApp mainApp;
	
	public AncienneteController() {
    }
	
	/**
	 * Initialise les donn�es
	 * ajoute les donn�es dans la tableView
	 * ajoute les actions aux combobox
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {

		MainApp.donnee = new Donnee();
		ObservableList<Materiel> materiel=this.mainApp.donnee.getMaterielData();
		ObservableList<Site> site=this.mainApp.donnee.getSiteData();
		ObservableList<Type> type=this.mainApp.donnee.getTypeData();
		this.addDonneeTableView(materiel,site,type);
		
		comboboxSiteAncienneteOverview.setOnAction((event) -> {
			actionOnCombo(materiel);
		});
		
		comboboxTypeAncienneteOverview.setOnAction((event) -> {
			actionOnCombo(materiel);
		});
		
		materielTable.setOnMouseClicked((event) -> {
			MainApp.setCritere(materielTable.getSelectionModel().getSelectedItem());
			MainApp.changerTab("DetailMachine");
		});
	}
	
	/**
	 * Permet de gerer la restriction en fonction du combo box.
	 * @param materiel la liste de materiel qui sera affichee dans la tableView en fonction
	 * des restrictions
	 */
	public void actionOnCombo(ObservableList<Materiel> materiel){
		String selectedSite="";
		String selectedType="";
		selectedSite = comboboxSiteAncienneteOverview.getSelectionModel().getSelectedItem();
	    selectedType = comboboxTypeAncienneteOverview.getSelectionModel().getSelectedItem();
		if(selectedSite==null){
			selectedSite="Tous";
		}
		if(selectedType==null){
			selectedType="Tous";
		}
	    if(selectedSite!=null || selectedType!=null){
	    	addDonneeRestrictTableView(materiel,selectedSite,selectedType);
	    }
	}
	
	/**
	 * Set le MainApp
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	/**
	 * ajoute les materiels dans les colonnes de la tableView
	 * @param materiel la liste des materiels que l'on ajoute.
	 */
	public void setItemsTableMateriel(ObservableList<Materiel> materiel){
		materielTable.setItems(materiel);
		nomMateriel.setCellValueFactory(cellData -> cellData.getValue().getNom());
		dateAchatMateriel.setCellValueFactory(cellData -> cellData.getValue().getFacture().getDateFacStringProperty());
		etatMateriel.setCellValueFactory(cellData -> cellData.getValue().getEtatStringProperty());
		finGarantieMateriel.setCellValueFactory(cellData -> cellData.getValue().getDateExpirationGarantie());
		revendeurMateriel.setCellValueFactory(cellData -> cellData.getValue().getFacture().getRevendeur().getNomRev());
		fabricantMateriel.setCellValueFactory(cellData -> cellData.getValue().getFabricant().getNomFab());
		siteMateriel.setCellValueFactory(cellData -> cellData.getValue().getSite().getNomSteProperty());	
	}
	
	/**
	 * Ajoute les donn�es dans la tableView et dans les combobox
	 * @param materiel la liste de materiels � ajouter dans le tableau de materiel
	 * @param site la liste de site � ajouter dans la combobox de site
	 * @param type la liste de type � ajouter dans la combobox de type
	 */
	public void addDonneeTableView(ObservableList<Materiel> materiel,ObservableList<Site> site,ObservableList<Type> type){
		ObservableList<String> listSite = FXCollections.observableArrayList();
		ObservableList<String> listType = FXCollections.observableArrayList();
		
		setItemsTableMateriel(materiel);
		
		for(Site s : site){
			listSite.add(s.getNomSte());
		}
		listSite.add("Tous");
		for(Type t : type){
			listType.add(t.getNomString());
		}
		listType.add("Tous");
		
		comboboxSiteAncienneteOverview.setItems(listSite);
		comboboxTypeAncienneteOverview.setItems(listType);
	}
	
	/**
	 * Permet de restreindre l'affichage des donn�es dans la TableView en fonction des crit�res
	 * s�lectionn�s dans les combobox
	 * @param materiel la liste de mat�riel � afficher dans la tableView
	 * @param selectedSite le site dans lequel les mat�riels sont
	 * @param selectedType le type de mat�riel � afficher
	 */
	public void addDonneeRestrictTableView(ObservableList<Materiel> materiel,String selectedSite, String selectedType){
		ObservableList<Materiel> restrictedMateriel = FXCollections.observableArrayList();
		boolean isOk;
		for(Materiel m : materiel){
			isOk=true;
			if(selectedSite!="Tous"){
				if(m.getSiteString()!=selectedSite){
					isOk=false;
				}
			}
			if(selectedType!="Tous"){
				if(m.getType().getNomString()!=selectedType){
					isOk=false;
				}
			}
			if(isOk){
				restrictedMateriel.add(m);
			}
			setItemsTableMateriel(restrictedMateriel);
		}
	}
	
}
