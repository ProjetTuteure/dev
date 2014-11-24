package gpi.bd;

import gpi.metier.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by admin on 24/11/14.
 */
public class Donnee {
    private ObservableList<estIntervenu> estIntervenuData = FXCollections.observableArrayList();
    private ObservableList<estMaintenu> estMaintenuData = FXCollections.observableArrayList();
    private ObservableList<Etat> etatData = FXCollections.observableArrayList();
    private ObservableList<Fabricant> fabricantData = FXCollections.observableArrayList();
    private ObservableList<Facture> factureData = FXCollections.observableArrayList();
    private ObservableList<Logiciel> logicielData = FXCollections.observableArrayList();
    private ObservableList<Maintenance> maintenanceData = FXCollections.observableArrayList();
    private ObservableList<Materiel> materielData = FXCollections.observableArrayList();
    private ObservableList<Prestataire> prestataireData = FXCollections.observableArrayList();
    private ObservableList<Revendeur> revendeurData = FXCollections.observableArrayList();
    private ObservableList<Site> siteData = FXCollections.observableArrayList();
    private ObservableList<Type> typeData = FXCollections.observableArrayList();
    private ObservableList<Utilisateur> UtilisateurData = FXCollections.observableArrayList();
    private ObservableList<Utilise> UtiliseData = FXCollections.observableArrayList();

    public Donnee(){
        remplireSiteData();
        remplireTypeData();
        remplireRevendeurData();
        remplireFactureData();
        remplireMaterielData();
    }

    private void remplireMaterielData() {
        materielData.add(new Materiel("1","pc-martine",typeData.get(0),Etat.EN_MARCHE,"11/11/12","/driver/pc-martine",factureData.get(0),siteData.get(0)));
        materielData.add(new Materiel("1","pc-gertrude",typeData.get(0),Etat.EN_MARCHE,"11/11/12","/driver/pc-gertrude",factureData.get(0),siteData.get(0)));
    }

    private void remplireFactureData() {
        factureData.add(new Facture("1","11/11/11", (float) 123.50,revendeurData.get(0)));
    }

    private void remplireRevendeurData() {
        revendeurData.add(new Revendeur(1,"Darti","",""));
        revendeurData.add(new Revendeur(2,"Fnac","",""));
    }

    private void remplireTypeData() {
        typeData.add(new Type("PC",""));
        typeData.add(new Type("Routeur",""));
        typeData.add(new Type("Switch",""));
        typeData.add(new Type("Clé 3G",""));
    }

    private void remplireSiteData(){
        siteData.add(new Site(1, "Agen", ""));
        siteData.add(new Site(2, "Bordeaux", ""));
        siteData.add(new Site(3, "Chateauroux", ""));
        siteData.add(new Site(4, "Guéret", ""));
        siteData.add(new Site(5, "Limoges", ""));
        siteData.add(new Site(6, "Montluçon", ""));
        siteData.add(new Site(7, "Saint-Agnant", ""));
        siteData.add(new Site(8, "Saint-Junien", ""));
    }


}
