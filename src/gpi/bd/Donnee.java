package gpi.bd;

import gpi.metier.*;
import javafx.beans.property.StringProperty;
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
        remplirFabricantData();
        remplireFactureData();
        remplireMaterielData();
        remplireLogicielData();
    }

    public ObservableList<Site> getSiteData() {
        return siteData;
    }

    public ObservableList<Type> getTypeData() {
        return typeData;
    }

    public ObservableList<Revendeur> getRevendeurData() {
        return revendeurData;
    }

    public ObservableList<Facture> getFactureData() {
        return factureData;
    } 
    
    public ObservableList<Fabricant> getFabricantData() {
        return fabricantData;
    }

    public ObservableList<Materiel> getMaterielData() {
        return materielData;
    }

    private void remplirFabricantData() {
        fabricantData.add(new Fabricant(1, "DELL","05.55.66.77.88" , "2 route perdu 87000"));
        fabricantData.add(new Fabricant(2, "HP","05.55.66.77.88" , "2 route perdu 87000"));
    }

    private void remplireMaterielData() {
        materielData.add(new Materiel("1IMMO","pc-martine",typeData.get(0),Etat.EN_MARCHE,"11/11/12","/driver/pc-martine",factureData.get(0),siteData.get(0),fabricantData.get(0)));
        materielData.add(new Materiel("2IMMO","pc-gertrude",typeData.get(0),Etat.EN_MARCHE,"11/11/12","/driver/pc-gertrude",factureData.get(0),siteData.get(0),fabricantData.get(1)));
		materielData.add(new Materiel("3IMMO", "PC1", typeData.get(0), Etat.EN_MARCHE, "31/12/2014", "", factureData.get(0), siteData.get(0), fabricantData.get(0)));
		materielData.add(new Materiel("4IMMO", "PC2", typeData.get(0), Etat.EN_MARCHE, "31/12/2015", "", factureData.get(0), siteData.get(1), fabricantData.get(0)));
		materielData.add(new Materiel("5IMMO", "PC3", typeData.get(0), Etat.EN_MARCHE, "05/02/2015", "", factureData.get(1), siteData.get(2), fabricantData.get(0)));
		materielData.add(new Materiel("6IMMO", "Routeur1", typeData.get(1), Etat.EN_MARCHE, "14/02/2017", "", factureData.get(1), siteData.get(3), fabricantData.get(0)));
    }

    private void remplireFactureData() {
        factureData.add(new Facture("1","11/11/11", (float) 123.50,revendeurData.get(0)));
        factureData.add(new Facture("2","12/12/12", (float) 99,revendeurData.get(1)));
    }

    private void remplireRevendeurData() {
        revendeurData.add(new Revendeur(1,"Darty"," "," "));
        revendeurData.add(new Revendeur(2,"Fnac"," "," "));
    }

    private void remplireTypeData() {
        typeData.add(new Type("PC","sources/images/pc.jpg"));
        typeData.add(new Type("Routeur","sources/images/routeur.png"));
        typeData.add(new Type("Switch","sources/images/switch.jpg"));
        typeData.add(new Type("Clé 3G","sources/images/cle3G.PNG"));
    }

    private void remplireSiteData(){
        siteData.add(new Site(1, "Agen", "sources/images/logo-ville-agen0.png"));
        siteData.add(new Site(2, "Bordeaux", "sources/images/bordeaux.jpg"));
        siteData.add(new Site(3, "Chateauroux", "sources/images/chateauroux.jpg"));
        siteData.add(new Site(4, "Gueret", "sources/images/Gueret.jpg"));
        siteData.add(new Site(5, "Limoges", "sources/images/limoges.jpg"));
        siteData.add(new Site(6, "Montlucon", "sources/images/montlucon.jpg"));
        siteData.add(new Site(7, "Saint-Agnant", "sources/images/saintAgnan.png"));
        siteData.add(new Site(8, "Saint-Junien", "sources/images/saintJunien.jpg"));
        siteData.add(new Site(9, "Saint-Junien", "sources/images/saintJunien.jpg"));
        siteData.add(new Site(6, "Montlucon", "sources/images/montlucon.jpg"));
        siteData.add(new Site(7, "Saint-Agnant", "sources/images/saintAgnan.png"));
        siteData.add(new Site(8, "Saint-Junien", "sources/images/saintJunien.jpg"));
        siteData.add(new Site(9, "Saint-Junien", "sources/images/saintJunien.jpg"));
    }


    private void remplireLogicielData() {
        this.logicielData.add(new Logiciel(1,"Microsoft Office 2012","1.0",null,this.factureData.get(1)));
    }


    public Materiel getMateriel(String value) {
        for(Materiel mat : materielData){
            if(value == mat.getNumImmobMat().getValue()){
                return mat;
            }
        }
        return null;
    }
}
