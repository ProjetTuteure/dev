package gpi.metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by thibault on 22/11/14.
 */
public class Materiel {
    private StringProperty numImmobMat;
    private StringProperty nom;
    private Type type;
    private Etat etat;
    private StringProperty dateExpirationGarantie;
    private StringProperty repertoireDriver;
    private Facture facture;
    private Site site;
    private Fabricant fabricant;

    public Materiel(String numImmobMat, String nom, Type type, Etat etat, String dateExpirationGarantie, String repertoireDriver, Facture facture, Site site, Fabricant fabricant) {
        this.numImmobMat = new SimpleStringProperty(numImmobMat);
        this.nom= new SimpleStringProperty(nom);
        this.type = type;
        this.etat = etat;
        this.dateExpirationGarantie=new SimpleStringProperty(dateExpirationGarantie);
        this.repertoireDriver = new SimpleStringProperty(repertoireDriver);
        this.facture = facture;
        this.site = site;
        this.fabricant = fabricant;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public StringProperty getNumImmobMat() {
        return numImmobMat;
    }

    public void setNumImmobMat(String numImmobMat) {
        this.numImmobMat.setValue(numImmobMat);
    }

    
    public StringProperty getNomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public StringProperty getDateExpirationGarantie() {
        return dateExpirationGarantie;
    }

    public void setDateExpirationGarantie(String dateExpirationGarantie) {
        this.dateExpirationGarantie.set(dateExpirationGarantie);
    }

    public StringProperty getRepertoireDriver() {
        return repertoireDriver;
    }

    public void setRepertoireDriver(String repertoireDriver) {
        this.repertoireDriver.setValue(repertoireDriver);
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
    
    public Fabricant getFabricant() {
        return fabricant;
    }

    public void setFabricant(Fabricant fabricant) {
        this.fabricant = fabricant;
    }

    @Override
    public String toString() {
        return nom.getValue() +
                ", numImmobMat=" + numImmobMat.getValue()+
                ", type=" + type.getNomString() +
                ", etat=" + etat.name() +
                ", dateExpirationGarantie=" + dateExpirationGarantie.getValue() +
                ", site=" + site.getNomSte() +
                ", fabricant=" + fabricant.getNomFab().getValue()
                ;
    }
}
