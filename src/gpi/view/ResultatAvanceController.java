package gpi.view;

import gpi.MainApp;
import gpi.bd.Donnee;
import gpi.metier.Materiel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Julien on 13/12/2014.
 */
public class ResultatAvanceController implements Initializable {
    private boolean test=false;
    private Donnee donnee=new Donnee();
    private List<Materiel> materielObservableList;

    @FXML
    private ListView<Materiel> listMateriel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        materielObservableList=donnee.getMaterielData();
        listMateriel.getItems().addAll(materielObservableList);


        listMateriel.getSelectionModel().selectedItemProperty().addListener(
                (ov, old_val, new_val) -> {
                    if (test) {
                        MainApp.setCritere(listMateriel.getFocusModel().getFocusedItem());
                        MainApp.changerTab("DetailMachine");
                    } else {
                        test = true;
                    }

                });
    }

    @FXML
    private void goToScreen1(ActionEvent event) {
        MainApp.changerTab("Avance");
    }
}
