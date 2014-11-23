package gpi.metier.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

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


    ObservableList<String> list1 = FXCollections.observableArrayList("Agen", "Bordeaux", "Chateroux", "Guéret", "Limoges", "Montluçon", "Saint Agan", "Saint Junien", "Tout");
    ObservableList<String> list2 = FXCollections.observableArrayList("Ordinateur","Switch","Routeur","Clé 3G","Tout");

    @Override
    public void initialize(URL url,ResourceBundle rb){

        comboboxSiteAncienneteOverview.setItems(list1);
        comboboxTypeAncienneteOverview.setItems(list2);
    }
}
