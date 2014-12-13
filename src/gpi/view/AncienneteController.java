package gpi.view;

import gpi.MainApp;
import gpi.bd.Donnee;
import gpi.metier.Facture;
import gpi.metier.Materiel;
import gpi.metier.Revendeur;
import gpi.metier.Site;
import gpi.metier.Type;
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
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		MainApp.donnee = new Donnee();
		ObservableList<Materiel> materiel=this.mainApp.donnee.getMaterielData();
		ObservableList<Site> site=this.mainApp.donnee.getSiteData();
		ObservableList<Type> type=this.mainApp.donnee.getTypeData();
		this.addDonneeTableView(materiel,site,type);
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	public void addDonneeTableView(ObservableList<Materiel> materiel,ObservableList<Site> site,ObservableList<Type> type){
		ObservableList<String> listSite = FXCollections.observableArrayList();
		ObservableList<String> listType = FXCollections.observableArrayList();
		
		materielTable.setItems(materiel);
		nomMateriel.setCellValueFactory(cellData -> cellData.getValue()
				.getNomProperty());
		dateAchatMateriel.setCellValueFactory(cellData -> cellData.getValue()
				.getFacture().getDateFac());
		etatMateriel.setCellValueFactory(cellData -> cellData.getValue()
				.getEtatStringProperty());
		finGarantieMateriel.setCellValueFactory(cellData -> cellData.getValue()
				.getDateExpirationGarantie());
		revendeurMateriel.setCellValueFactory(cellData -> cellData.getValue()
				.getFacture().getRevendeur().getNomRev());
		fabricantMateriel.setCellValueFactory(cellData -> cellData.getValue()
				.getFabricant().getNomFab());
		siteMateriel.setCellValueFactory(cellData -> cellData.getValue()
				.getSite().getNomSteProperty());
		
		for(Site s : site){
			listSite.add(s.getNomSte());
		}
		for(Type t : type){
			listType.add(t.getNomString());
		}
		
		comboboxSiteAncienneteOverview.setItems(listSite);
		comboboxTypeAncienneteOverview.setItems(listType);
	}
}
