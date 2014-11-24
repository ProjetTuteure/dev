package gpi.metier;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by thibault on 22/11/14.
 */
public class Facture {
    private String numFac;
    private StringProperty dateFac;
    private FloatProperty montantFac;
    private Revendeur revendeur;

    public Facture(String numFac, String dateFac, float montantFac, Revendeur revendeur) {
        this.numFac = numFac;
        this.dateFac.set(dateFac);
        this.montantFac.set(montantFac);
        this.revendeur = revendeur;
    }

    public String getNumFac() {
        return numFac;
    }

    public void setNumFac(String numFac) {
        this.numFac = numFac;
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
