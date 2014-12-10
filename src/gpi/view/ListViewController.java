package gpi.view;

import gpi.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ListViewController implements Initializable {

    @FXML
    private ListView<String> listMateriel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listMateriel.getItems().add("Materiel 1");
        listMateriel.getItems().add("Materiel 2");
        listMateriel.getItems().add("Materiel 3");
        listMateriel.getItems().add("Materiel 4");
    }

    @FXML
    private void goToScreen1(ActionEvent event){
        MainApp.changerTab("Avance", 3);
    }

    @FXML
    private void goToScreen3(ActionEvent event){
        System.out.println(1);
        MainApp.changerTab("Avance", 3);
        System.out.println(2);
    }
}
