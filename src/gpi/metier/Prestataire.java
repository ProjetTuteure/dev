package gpi.metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by thibault on 22/11/14.
 */
public class Prestataire {

    private int idPrestataire;
    private StringProperty nomPrestataire;
    private StringProperty prenomPrestataire;
    private StringProperty telPrestataire;
    private StringProperty societeePrestataire;

    public Prestataire(int idPrestataire, String nomPrestataire, String prenomPrestataire, String telPrestataire, String societeePrestataire) {
        this.idPrestataire = idPrestataire;
        this.nomPrestataire = new SimpleStringProperty(nomPrestataire);
        this.prenomPrestataire = new SimpleStringProperty(prenomPrestataire);
        this.telPrestataire = new SimpleStringProperty(telPrestataire);
        this.societeePrestataire = new SimpleStringProperty(societeePrestataire);
    }

    public int getIdPrestataire() {
        return idPrestataire;
    }

    public void setIdPrestataire(int idPrestataire) {
        this.idPrestataire = idPrestataire;
    }

    public StringProperty getPrenomPrestataire() {
        return prenomPrestataire;
    }

    public void setPrenomPrestataire(String prenomPrestataire) {
        this.prenomPrestataire.setValue(prenomPrestataire);
    }

    public StringProperty getNomPrestataire() {
        return nomPrestataire;
    }

    public void setNomPrestataire(String nomPrestataire) {
        this.nomPrestataire.setValue(nomPrestataire);
    }

    public StringProperty getTelPrestataire() {
        return telPrestataire;
    }

    public void setTelPrestataire(String telPrestataire) {
        this.telPrestataire.setValue(telPrestataire);
    }

    public StringProperty getsocieteePrestataire() {
        return societeePrestataire;
    }

    public void setsocieteePrestataire(String societeePrestataire) {
        this.societeePrestataire.setValue(societeePrestataire);
    }
}
