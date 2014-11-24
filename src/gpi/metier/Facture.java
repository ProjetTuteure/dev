package gpi.metier;

/**
 * Created by thibault on 22/11/14.
 */
public class Facture {
    private String numFac;
    private String dateFac;
    private float montantFac;
    private Revendeur revendeur;

    public Facture(String numFac, String dateFac, float montantFac, Revendeur revendeur) {
        this.numFac = numFac;
        this.dateFac = dateFac;
        this.montantFac = montantFac;
        this.revendeur = revendeur;
    }

    public String getNumFac() {
        return numFac;
    }

    public void setNumFac(String numFac) {
        this.numFac = numFac;
    }

    public String getDateFac() {
        return dateFac;
    }

    public void setDateFac(String dateFac) {
        this.dateFac = dateFac;
    }

    public float getMontantFac() {
        return montantFac;
    }

    public void setMontantFac(float montantFac) {
        this.montantFac = montantFac;
    }

    public Revendeur getRevendeur() {
        return revendeur;
    }

    public void setRevendeur(Revendeur revendeur) {
        this.revendeur = revendeur;
    }
}
