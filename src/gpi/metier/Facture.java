package gpi.metier;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

/**
 * Created by thibault on 22/11/14.
 */
public class Facture {
    private StringProperty numFacture;
    private LocalDate dateFacture;
    private FloatProperty montantFacture;
    private Revendeur revendeur;


    public Facture(String numFac, LocalDate dateFac, float montantFac, Revendeur revendeur) {
        this.numFacture = new SimpleStringProperty(numFac);
        this.dateFacture= dateFac;
        this.montantFacture= new SimpleFloatProperty(montantFac);
        this.revendeur = revendeur;
    }

    public StringProperty getDateFacStringProperty() {
        String chaine1="";
        String chaine2="";
        if(dateFacture.getDayOfMonth()<10){
            chaine1="0";
        }
        if(dateFacture.getMonthValue()<10){
            chaine2="0";
        }
        String dateFacture=chaine1+this.dateFacture.getDayOfMonth()+"/"+chaine2+this.dateFacture.getMonthValue()+"/"+this.dateFacture.getYear();
        return new SimpleStringProperty(dateFacture);
    }

    public String getNumFacture() {
        return numFacture.get();
    }

    public StringProperty numFactureProperty() {
        return numFacture;
    }

    public void setNumFacture(String numFac) {
        this.numFacture.set(numFac);
    }

    public FloatProperty montantFactureProperty() {
        return montantFacture;
    }

    public LocalDate getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(LocalDate dateFac) {
        this.dateFacture=(dateFac);
    }

    public FloatProperty getMontantFacture() {
        return montantFacture;
    }
    
    public String getMontantFactureString() {
        return ""+this.getMontantFacture().floatValue();
    }

    public void setMontantFacture(float montantFac) {
        this.montantFacture.set(montantFac);
    }

    public Revendeur getRevendeur() {
        return revendeur;
    }

    public void setRevendeur(Revendeur revendeur) {
        this.revendeur = revendeur;
    }
}
