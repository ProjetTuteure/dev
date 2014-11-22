package gpi.metier;

/**
 * Created by thibault on 22/11/14.
 */
public class estMaintenu {
    private Materiel materiel;
    private Maintenance maintenance;

    public estMaintenu(Materiel materiel, Maintenance maintenance) {
        this.materiel = materiel;
        this.maintenance = maintenance;
    }

    public Materiel getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }

    public Maintenance getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(Maintenance maintenance) {
        this.maintenance = maintenance;
    }
}
