package gpi.metier;

/**
 * Created by thibault on 22/11/14.
 */
public class estIntervenu {
    private Facture facture;
    private Maintenance maintenance;
    private Prestataire prestataire;

    public estIntervenu(Facture facture, Maintenance maintenance, Prestataire prestataire) {
        this.facture = facture;
        this.maintenance = maintenance;
        this.prestataire = prestataire;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Maintenance getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(Maintenance maintenance) {
        this.maintenance = maintenance;
    }

    public Prestataire getPrestataire() {
        return prestataire;
    }

    public void setPrestataire(Prestataire prestataire) {
        this.prestataire = prestataire;
    }
}
