package gpi.metier.controller;

/**
 * Created by Julien on 23/11/2014.
 */
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class ComboboxController implements Initializable {

    @FXML
    private ComboBox<String> comboboxSiteAvanceOverview;
    @FXML
    private ComboBox<String> comboboxAncienneteAvanceOverview;
    @FXML
    private ComboBox<String> comboboxTypeAvanceOverview;
    @FXML
    private ComboBox<String> comboboxSiteAncienneteOverview;
    @FXML
    private ComboBox<String> comboboxTypeAncienneteOverview;

    ObservableList<String> list1 = FXCollections.observableArrayList("Agen","Bordeaux","Chateroux","Guéret","Limoges","Montluçon","Saint Agan","Saint Junien","Tout");
    ObservableList<String> list2 = FXCollections.observableArrayList("moins d'un ans","moins de deux ans","moins de trois ans","moins de quattre ans","moins de cinq ans","moins de six ans","moins de sept ans","plus de sept ans");
    ObservableList<String> list3 = FXCollections.observableArrayList("Ordinateur","Switch","Routeur","Clé 3G","Tout");

    
    @Override
    public void initialize(URL url,ResourceBundle rb){
        comboboxSiteAvanceOverview.setItems(list1);
        comboboxAncienneteAvanceOverview.setItems(list2);
        comboboxTypeAvanceOverview.setItems(list3);
        //comboboxSiteAncienneteOverview.setItems(list1);
        //comboboxTypeAncienneteOverview.setItems(list3);
    }
}