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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


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
    @FXML
    private TextField noImmobilisation;
    @FXML
    private TextField nomMateriel;
    @FXML
    private TextField utilisateur;
    @FXML
    private TextField dateAchat;
    @FXML
    private TextField noFacture;
    @FXML
    private TextField revendeur;
    @FXML
    private TextField fabriquant;
    @FXML
    private TextField modele;

    private Donnee donnee=new Donnee();

    ObservableList<Site> list1 = donnee.getSiteData();
    ObservableList<String> list2 = FXCollections.observableArrayList(
            "moins d'un ans", "moins de deux ans", "moins de trois ans",
            "moins de quattre ans", "moins de cinq ans", "moins de six ans",
            "moins de sept ans", "plus de sept ans");
    ObservableList<Type> list3 = donnee.getTypeData();

    /**
     * Initialise les combobox
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboboxSiteAvanceOverview.setItems(getNomSite(list1));
        comboboxAncienneteAvanceOverview.setItems(list2);
        comboboxTypeAvanceOverview.setItems(getNomType(list3));
    }

    /**
     * Permet d'afficher les r�sultats de la recherche avanc�e.
     * @param event
     */
    @FXML
    private void goToScreen2(ActionEvent event) {
        MainApp.setCritere(noImmobilisation.getText());
        MainApp.setCritere(nomMateriel.getText());
        MainApp.setCritere(comboboxSiteAvanceOverview.getValue());
        if (comboboxAncienneteAvanceOverview.getValue()==null){
            MainApp.setCritere("");
        }else{
            MainApp.setCritere(comboboxAncienneteAvanceOverview.getValue());
        }
        MainApp.setCritere(comboboxTypeAvanceOverview.getValue());
        MainApp.setCritere(utilisateur.getText());
        MainApp.setCritere(dateAchat.getText());
        MainApp.setCritere(noFacture.getText());
        MainApp.setCritere(revendeur.getText());
        MainApp.setCritere(fabriquant.getText());
        MainApp.setCritere(modele.getText());
        MainApp.changerTab("ResultatAvance");
    }

    /**
     * Permet de r�cup�rer les sites et les ajouter les noms des sites dans une liste
     * @param sites la liste de sites 
     * @return la liste compos�e des noms des sites pass�s en param�tre
     */
    public ObservableList<String> getNomSite(List<Site> sites){
        ObservableList<String> list=FXCollections.observableArrayList();
        for(Site site:sites){
            list.add(site.getNomSiteString());
        }
        return list;
    }

    /**
     * Permet de r�cup�rer les sites et les ajouter les noms des sites dans une liste
     * @param types la liste de types
     * @return la liste des noms des types pass�s en param�tre
     */
    public ObservableList<String> getNomType(List<Type> types){
        ObservableList<String> list=FXCollections.observableArrayList();
        for(Type type:types){
            list.add(type.getNomType().getValue());
        }
        return list;
    }
}
