package gpi.metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by thibault on 22/11/14.
 */
public class Revendeur {
    private int idRev;
    private StringProperty nomRev;
    private StringProperty telRev;
    private StringProperty adresse;

    public Revendeur(int idRev, String nomRev, String telRev, String adresse) {
        this.idRev = idRev;
        this.nomRev= new SimpleStringProperty(nomRev);
        this.telRev = new SimpleStringProperty(telRev);
        this.adresse = new SimpleStringProperty(adresse);
    }

    public int getIdRev() {
        return idRev;
    }

    public void setIdRev(int idRev) {
        this.idRev = idRev;
    }

    public StringProperty getNomRev() {
        return this.nomRev;
    }

    public void setNomRev(String nomRev) {
        this.nomRev.set(nomRev);
    }

    public StringProperty getTelRev() {
        return telRev;
    }

    public void setTelRev(String telRev) {
        this.telRev.setValue(telRev);
    }

    public StringProperty getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse.setValue(adresse);
    }
}
