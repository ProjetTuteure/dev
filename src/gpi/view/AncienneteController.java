package gpi.view;

import gpi.metier.Facture;
import gpi.metier.Materiel;
import gpi.metier.Revendeur;
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
 * Created by Julien on 24/11/2014.
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
    private TableColumn<Materiel, String> ageMateriel;
    @FXML
    private TableColumn<Materiel, String> revendeurMateriel;
    @FXML
    private TableColumn<Materiel, String> montantAchatMateriel;
    @FXML
    private TableColumn<Materiel, String> dateAchatMateriel;
    @FXML
    private TableColumn<Materiel, String> etatMateriel;

    ObservableList<String> list1 = FXCollections.observableArrayList("Agen", "Bordeaux", "Chateroux", "Guéret", "Limoges", "Montluçon", "Saint Agan", "Saint Junien", "Tout");
    ObservableList<String> list2 = FXCollections.observableArrayList("Ordinateur","Switch","Routeur","Clé 3G","Tout");

    @Override
    public void initialize(URL url,ResourceBundle rb){

        comboboxSiteAncienneteOverview.setItems(list1);
        comboboxTypeAncienneteOverview.setItems(list2);
        
        nomMateriel.setCellValueFactory(cellData -> cellData.getValue().getNomProperty());
        ageMateriel.setCellValueFactory(cellData -> cellData.getValue().getDateExpirationGarantie());
        revendeurMateriel.setCellValueFactory(cellData -> cellData.getValue().getFacture().getRevendeur().getNomRev());
        montantAchatMateriel.setCellValueFactory(cellData -> cellData.getValue().getSite().getNomSteProperty());
        dateAchatMateriel.setCellValueFactory(cellData -> cellData.getValue().getFacture().getDateFac());
        etatMateriel.setCellValueFactory(cellData -> cellData.getValue().getNomProperty());
    }
}
