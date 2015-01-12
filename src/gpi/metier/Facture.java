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
    private StringProperty numFac;
    private LocalDate dateFac;
    private FloatProperty montantFac;
    private Revendeur revendeur;


    public Facture(String numFac, LocalDate dateFac, float montantFac, Revendeur revendeur) {
        this.numFac = new SimpleStringProperty(numFac);
        this.dateFac= dateFac;
        this.montantFac= new SimpleFloatProperty(montantFac);
        this.revendeur = revendeur;
    }

    public StringProperty getDateFacStringProperty() {
        String dateFacture=dateFac.getDayOfMonth()+""+dateFac.getMonthValue()+"/"+dateFac.getYear();
        return new SimpleStringProperty(dateFacture);
    }

    public String getNumFac() {
        return numFac.get();
    }

    public StringProperty numFacProperty() {
        return numFac;
    }

    public void setNumFac(String numFac) {
        this.numFac.set(numFac);
    }

    public FloatProperty montantFacProperty() {
        return montantFac;
    }

    public LocalDate getDateFac() {
        return dateFac;
    }

    public void setDateFac(LocalDate dateFac) {
        this.dateFac=(dateFac);
    }

    public FloatProperty getMontantFac() {
        return montantFac;
    }
    
    public String getMontantFacString() {
        return ""+this.getMontantFac().floatValue();
    }

    public void setMontantFac(float montantFac) {
        this.montantFac.set(montantFac);
    }

    public Revendeur getRevendeur() {
        return revendeur;
    }

    public void setRevendeur(Revendeur revendeur) {
        this.revendeur = revendeur;
    }
}
