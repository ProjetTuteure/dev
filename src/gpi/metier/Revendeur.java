package gpi.metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by thibault on 22/11/14.
 */
public class Revendeur {
    private int idRevendeur;
    private StringProperty nomRevendeur;
    private StringProperty telRevendeur;
    private StringProperty adresseRevendeur;

    public Revendeur(int idRevendeur, String nomRevendeur, String telRevendeur, String adresseRevendeur) {
        this.idRevendeur = idRevendeur;
        this.nomRevendeur= new SimpleStringProperty(nomRevendeur);
        this.telRevendeur = new SimpleStringProperty(telRevendeur);
        this.adresseRevendeur = new SimpleStringProperty(adresseRevendeur);
    }

    public int getIdRevendeur() {
        return idRevendeur;
    }

    public void setIdRevendeur(int idRevendeur) {
        this.idRevendeur = idRevendeur;
    }

    public StringProperty getNomRevendeur() {
        return this.nomRevendeur;
    }

    public void setNomRevendeur(String nomRevendeur) {
        this.nomRevendeur.set(nomRevendeur);
    }

    public StringProperty getTelRevendeur() {
        return telRevendeur;
    }

    public void setTelRevendeur(String telRevendeur) {
        this.telRevendeur.setValue(telRevendeur);
    }

    public StringProperty getAdresseRevendeur() {
        return adresseRevendeur;
    }

    public void setAdresseRevendeur(String adresseRevendeur) {
        this.adresseRevendeur.setValue(adresseRevendeur);
    }
}
