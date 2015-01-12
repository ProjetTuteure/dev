package gpi.view;

import gpi.MainApp;
import gpi.bd.Donnee;
import gpi.metier.Etat;
import gpi.metier.Materiel;
import gpi.metier.estMaintenu;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;

/**
 * @author Victor
 *
 */
public class EtatController implements Initializable{
	
	@FXML
	private CheckBox checkBoxEnService;
	@FXML
	private CheckBox checkBoxEnReparation;
	@FXML
	private CheckBox checkBoxHorsService;
	@FXML
	private TableView<Materiel> materielTable;
	@FXML
	private TableColumn<Materiel, String> nomMateriel;
	@FXML
	private TableColumn<Materiel, String> etatMateriel;
	@FXML
	private TableColumn<Materiel, String> siteMateriel;
	@FXML
	private TableColumn<Materiel, String> etatDepuisDateMateriel;

	
	private MainApp mainApp;
	
	public EtatController() {
    }
	
	/**
	 * Initialise les données  et ajoute les évènements aux différents composants
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		MainApp.donnee = new Donnee();
		ObservableList<Materiel> materiel=this.mainApp.donnee.getMaterielData();
		this.addDonneeTableView(materiel);
		
		checkBoxEnService.setOnAction((event) -> {
			actionOnCheckBox(materiel);
		});
		
		checkBoxEnReparation.setOnAction((event) -> {
			actionOnCheckBox(materiel);
		});
		
		checkBoxHorsService.setOnAction((event) -> {
			actionOnCheckBox(materiel);
		});
		
		materielTable.setOnMouseClicked((event) -> {
			MainApp.setCritere(materielTable.getSelectionModel().getSelectedItem());
			MainApp.changerTab("DetailMachine");
		});
	}

	/**
	 * Ajoute les données à la TableView suite aux checkBox cochées
	 * @param materiel la liste de materiel à ajouter à la TableView
	 */
	public void actionOnCheckBox(ObservableList<Materiel> materiel){
		boolean checkEnService=checkBoxEnService.selectedProperty().getValue();
		boolean checkEnReparation=checkBoxEnReparation.selectedProperty().getValue();
		boolean checkHorsService=checkBoxHorsService.selectedProperty().getValue();
		addDonneeRestrictTableView(materiel,checkEnService,checkEnReparation,checkHorsService);
	}
	
	/**
	 * Ajoute les données dans la tableView en fonction des checkBox cochées
	 * @param materiel la liste des materiels à ajouter dans les tableView
	 * @param checkEnService est vrai si la checkBox enService est cochée faux sinon
	 * @param checkEnReparation est vrai si la checkBox enReparation est cochée faux sinon
	 * @param checkHorsService est vrai si la checkBox horsService est cochée faux sinon
	 */
	private void addDonneeRestrictTableView(ObservableList<Materiel> materiel,boolean checkEnService, boolean checkEnReparation,boolean checkHorsService) {
		ObservableList<Materiel> restrictedMateriel = FXCollections.observableArrayList();
		
		boolean isOk;
		for(Materiel m : materiel){
			isOk=false;
			if(m.getEtat()==Etat.EN_MARCHE && checkEnService){
				isOk=true;
			}else if(m.getEtat()==Etat.EN_PANNE && checkEnReparation){
				isOk=true;
			}else if(m.getEtat()==Etat.HS && checkHorsService){
				isOk=true;
			}
			if(isOk){
				restrictedMateriel.add(m);
			}
		}
		addDonneeTableView(restrictedMateriel);
	}

	/**
	 * Ajoute les données relatives à la liste des materiels dans les cases de la tableView
	 * @param materiel la liste des materiels à ajouter dans les cases de la tableView
	 */
	private void addDonneeTableView(ObservableList<Materiel> materiel) {
		materielTable.setItems(materiel);
		nomMateriel.setCellValueFactory(cellData -> cellData.getValue().getNom());
		etatMateriel.setCellValueFactory(cellData -> cellData.getValue().getEtatStringProperty());
		siteMateriel.setCellValueFactory(cellData -> cellData.getValue().getSite().getNomSteProperty());
		
		ObservableList<String> listMaintenanceMateriel = FXCollections.observableArrayList();
		etatDepuisDateMateriel.setCellValueFactory(new Callback<CellDataFeatures<Materiel, String>, ObservableValue<String>>() {
		     public ObservableValue<String> call(CellDataFeatures<Materiel, String> p) {
		         return new ReadOnlyObjectWrapper("[TODO] Recherche derniere maintenance");
		     }
		  });
	}

}

