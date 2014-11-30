package gpi.metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by thibault on 22/11/14.
 */
public class Prestataire {

    private int idPrest;
    private StringProperty nomPrest;
    private StringProperty prenomPrest;
    private StringProperty telPrest;
    private StringProperty societee;

    public Prestataire(int idPrest, String nomPrest, String prenomPrest, String telPrest, String societee) {
        this.idPrest = idPrest;
        this.nomPrest = new SimpleStringProperty(nomPrest);
        this.prenomPrest = new SimpleStringProperty(prenomPrest);
        this.telPrest = new SimpleStringProperty(telPrest);
        this.societee = new SimpleStringProperty(societee);
    }

    public int getIdPrest() {
        return idPrest;
    }

    public void setIdPrest(int idPrest) {
        this.idPrest = idPrest;
    }

    public StringProperty getPrenomPrest() {
        return prenomPrest;
    }

    public void setPrenomPrest(String prenomPrest) {
        this.prenomPrest.setValue(prenomPrest);
    }

    public StringProperty getNomPrest() {
        return nomPrest;
    }

    public void setNomPrest(String nomPrest) {
        this.nomPrest.setValue(nomPrest);
    }

    public StringProperty getTelPrest() {
        return telPrest;
    }

    public void setTelPrest(String telPrest) {
        this.telPrest.setValue(telPrest);
    }

    public StringProperty getSocietee() {
        return societee;
    }

    public void setSocietee(String societee) {
        this.societee.setValue(societee);
    }
}
