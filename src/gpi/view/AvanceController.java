package gpi.view;

import gpi.MainApp;
import gpi.bd.Donnee;
import gpi.metier.Site;
import gpi.metier.Type;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Julien on 13/12/2014.
 */
public class AvanceController implements Initializable {
    @FXML
    private ComboBox<String> comboboxSiteAvanceOverview;
    @FXML
    private ComboBox<String> comboboxAncienneteAvanceOverview;
    @FXML
    private ComboBox<String> comboboxTypeAvanceOverview;

    private Donnee donnee=new Donnee();

    ObservableList<Site> list1 = donnee.getSiteData();
    ObservableList<String> list2 = FXCollections.observableArrayList(
            "moins d'un ans", "moins de deux ans", "moins de trois ans",
            "moins de quattre ans", "moins de cinq ans", "moins de six ans",
            "moins de sept ans", "plus de sept ans");
    ObservableList<Type> list3 = donnee.getTypeData();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboboxSiteAvanceOverview.setItems(getNomSite(list1));
        comboboxAncienneteAvanceOverview.setItems(list2);
        comboboxTypeAvanceOverview.setItems(getNomType(list3));
    }

    @FXML
    private void goToScreen2(ActionEvent event) {
        MainApp.changerTab("ResultatAvance");
    }

    public ObservableList<String> getNomSite(List<Site> sites){
        ObservableList<String> list=FXCollections.observableArrayList();
        for(Site site:sites){
            list.add(site.getNomSte());
        }
        return list;
    }

    public ObservableList<String> getNomType(List<Type> types){
        ObservableList<String> list=FXCollections.observableArrayList();
        for(Type type:types){
            list.add(type.getNom().getValue());
        }
        return list;
    }
}
