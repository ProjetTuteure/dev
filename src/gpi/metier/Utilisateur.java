package gpi.metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by thibault on 22/11/14.
 */
public class Utilisateur {
    private int idUtilisateur;
    private StringProperty nomUtilisateur;
    private StringProperty prenomUtilisateur;
    private StringProperty telUtilisateur;

    public Utilisateur(int idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String telUtilisateur) {
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = new SimpleStringProperty(nomUtilisateur);
        this.prenomUtilisateur = new SimpleStringProperty(prenomUtilisateur);
        this.telUtilisateur = new SimpleStringProperty(telUtilisateur);
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public StringProperty getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur.setValue(nomUtilisateur);
    }

    public StringProperty getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur.setValue(prenomUtilisateur);
    }

    public StringProperty getTelUtilisateur() {
        return telUtilisateur;
    }

    public void setTelUtilisateur(String telUtilisateur) {
        this.telUtilisateur.setValue(telUtilisateur);
    }
}
