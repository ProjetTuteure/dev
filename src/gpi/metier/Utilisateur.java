package gpi.metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by thibault on 22/11/14.
 */
public class Utilisateur {
    private int idUti;
    private StringProperty nomUti;
    private StringProperty prenomUti;
    private StringProperty telUti;

    public Utilisateur(int idUti, String nomUti, String prenomUti, String telUti) {
        this.idUti = idUti;
        this.nomUti = new SimpleStringProperty(nomUti);
        this.prenomUti = new SimpleStringProperty(prenomUti);
        this.telUti = new SimpleStringProperty(telUti);
    }

    public int getIdUti() {
        return idUti;
    }

    public void setIdUti(int idUti) {
        this.idUti = idUti;
    }

    public StringProperty getNomUti() {
        return nomUti;
    }

    public void setNomUti(String nomUti) {
        this.nomUti.setValue(nomUti);
    }

    public StringProperty getPrenomUti() {
        return prenomUti;
    }

    public void setPrenomUti(String prenomUti) {
        this.prenomUti.setValue(prenomUti);
    }

    public StringProperty getTelUti() {
        return telUti;
    }

    public void setTelUti(String telUti) {
        this.telUti.setValue(telUti);
    }
}
