package gpi.metier;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by thibault on 22/11/14.
 */
public class Prestataire {
    private IntegerProperty idPrestataire;
    private StringProperty nomPrestataire;
    private StringProperty prenomPrestataire;
    private StringProperty telPrestataire;
    private StringProperty societePrestataire;

    public Prestataire(int idPrestataire, String nomPrestataire, String prenomPrestataire, String telPrestataire, String societePrestataire) {
        this.idPrestataire = new SimpleIntegerProperty(idPrestataire);
        this.nomPrestataire = new SimpleStringProperty(nomPrestataire);
        this.prenomPrestataire = new SimpleStringProperty(prenomPrestataire);
        this.telPrestataire = new SimpleStringProperty(telPrestataire);
        this.societePrestataire = new SimpleStringProperty(societePrestataire);
    }

    public IntegerProperty getIdPrestataire() {
        return idPrestataire;
    }

    public void setIdPrestataire(IntegerProperty idPrestataire) {
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

    public StringProperty getSocieteePrestataire() {
        return societePrestataire;
    }

    public void setSocietePrestataire(String societePrestataire) {
        this.societePrestataire.setValue(societePrestataire);
    }

    @Override
    public String toString() {
        return "Prestataire{" +
                "idPrestataire=" + idPrestataire +
                ", nomPrestataire=" + nomPrestataire +
                ", prenomPrestataire=" + prenomPrestataire +
                ", telPrestataire=" + telPrestataire +
                ", societePrestataire=" + societePrestataire +
                '}';
    }
}
