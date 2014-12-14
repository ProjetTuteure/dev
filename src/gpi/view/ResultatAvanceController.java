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

        for(Materiel materiel:materielObservableList){
            if((materiel.getNumImmobMat().getValue().equals(MainApp.getCritere(0)) || MainApp.getCritere(0).equals("")) &&
                    (materiel.getNom().getValue().equals(MainApp.getCritere(1)) || MainApp.getCritere(1).equals("")) &&
                    (materiel.getSite().getNomSte().equals(MainApp.getCritere(2)) || MainApp.getCritere(2)==null) &&
                    // (materiel.get().equals(MainApp.getCritere(3)) || MainApp.getCritere(3).equals("")) &&
                    (materiel.getType().getNom().getValue().equals(MainApp.getCritere(4)) || MainApp.getCritere(4)==null) &&
                    //(materiel.().equals(MainApp.getCritere(5)) || MainApp.getCritere(5).equals("")) &&
                    (materiel.getFacture().getDateFac().getValue().equals(MainApp.getCritere(6)) || MainApp.getCritere(6).equals("")) &&
                    (materiel.getFacture().getNumFac().equals(MainApp.getCritere(7)) || MainApp.getCritere(7).equals("")) &&
                    (materiel.getFacture().getRevendeur().getNomRev().getValue().equals(MainApp.getCritere(8)) || MainApp.getCritere(8).equals("")) &&
                    (materiel.getFabricant().getNomFab().getValue().equals(MainApp.getCritere(9)) || MainApp.getCritere(9).equals("")) &&
                    (materiel.getModele().equals(MainApp.getCritere(10)) || MainApp.getCritere(10).equals(""))
                    ){
                listMateriel.getItems().add(materiel);
            }
        }


        listMateriel.setOnMouseClicked((event)->{
            MainApp.setCritere(listMateriel.getFocusModel().getFocusedItem());
            MainApp.changerTab("DetailMachine");
        });
    }

    @FXML
    private void goToScreen1(ActionEvent event) {
        MainApp.removeCriteres();
        MainApp.changerTab("Avance");
    }
}
