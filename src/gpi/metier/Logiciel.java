package gpi.metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

/**
 * Created by thibault on 22/11/14.
 */
public class Logiciel {
    private int idLogiciel;
    private StringProperty nomLogiciel;
    private StringProperty versionLogiciel;
    private LocalDate dateExpirationLogiciel;
    private Facture factureLogiciel;

    public Logiciel(int idLogiciel, String nomLogiciel, String versionLogiciel, LocalDate dateExpirationLogiciel, Facture factureLogiciel) {
        this.idLogiciel = idLogiciel;
        this.nomLogiciel = new SimpleStringProperty(nomLogiciel);
        this.versionLogiciel = new SimpleStringProperty(versionLogiciel);
        this.dateExpirationLogiciel = dateExpirationLogiciel;
        this.factureLogiciel = factureLogiciel;
    }

    public int getIdLogiciel() {
        return idLogiciel;
    }

    public void setIdLogiciel(int idLogiciel) {
        this.idLogiciel = idLogiciel;
    }

    public StringProperty getNomLogiciel() {
        return nomLogiciel;
    }

    public void setNomLogiciel(String nomLogiciel) {
        this.nomLogiciel.setValue(nomLogiciel);
    }

    public StringProperty getVersionLogiciel() {
        return versionLogiciel;
    }

    public void setVersionLogiciel(String versionLogiciel) {
        this.versionLogiciel.setValue(versionLogiciel);
    }

    public LocalDate getDateExpirationLogiciel() {
        return dateExpirationLogiciel;
    }

    public StringProperty getDateExpirationLogicielStringProperty() {
        String chaine1="";
        String chaine2="";
        if(dateExpirationLogiciel.getDayOfMonth()<10){
            chaine1="0";
        }
        if(dateExpirationLogiciel.getMonthValue()<10){
            chaine2="0";
        }
        String dateFacture=chaine1+this.dateExpirationLogiciel.getDayOfMonth()+"/"+chaine2+this.dateExpirationLogiciel.getMonthValue()+"/"+this.dateExpirationLogiciel.getYear();
        return new SimpleStringProperty(dateFacture);
    }

    public void setDateExpirationLogiciel(LocalDate dateExpiration) {
        this.dateExpirationLogiciel=dateExpiration;
    }

    public Facture getFactureLogiciel() {
        return factureLogiciel;
    }

    public void setFactureLogiciel(Facture factureLogiciel) {
        this.factureLogiciel = factureLogiciel;
    }
}
