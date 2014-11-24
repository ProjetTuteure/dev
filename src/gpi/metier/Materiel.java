package gpi.metier;

import javafx.beans.property.StringProperty;

/**
 * Created by thibault on 22/11/14.
 */
public class Materiel {
    private String numImmobMat;
    private StringProperty nom;
    private Type type;
    private Etat etat;
    private StringProperty dateExpirationGarantie;
    private String repertoireDriver;
    private Facture facture;
    private Site site;

    public Materiel(String numImmobMat, String nom, Type type, Etat etat, String dateExpirationGarantie, String repertoireDriver, Facture facture,Site site) {
        this.numImmobMat = numImmobMat;
        this.nom.set(nom);
        this.type = type;
        this.etat = etat;
        this.dateExpirationGarantie.set(dateExpirationGarantie);
        this.repertoireDriver = repertoireDriver;
        this.facture = facture;
        this.site = site;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public String getNumImmobMat() {
        return numImmobMat;
    }

    public void setNumImmobMat(String numImmobMat) {
        this.numImmobMat = numImmobMat;
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

    public String getRepertoireDriver() {
        return repertoireDriver;
    }

    public void setRepertoireDriver(String repertoireDriver) {
        this.repertoireDriver = repertoireDriver;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
}
