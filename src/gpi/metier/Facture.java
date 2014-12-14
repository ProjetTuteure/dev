package gpi.metier;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by thibault on 22/11/14.
 */
public class Facture {
    private StringProperty numFac;
    private StringProperty dateFac;
    private FloatProperty montantFac;
    private Revendeur revendeur;

    public Facture(String numFac, String dateFac, float montantFac, Revendeur revendeur) {
        this.numFac = new SimpleStringProperty(numFac);
        this.dateFac= new SimpleStringProperty(dateFac);
        this.montantFac= new SimpleFloatProperty(montantFac);
        this.revendeur = revendeur;
    }

    public StringProperty dateFacProperty() {
        return dateFac;
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

    public StringProperty getDateFac() {
        return dateFac;
    }

    public void setDateFac(String dateFac) {
        this.dateFac.set(dateFac);
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
