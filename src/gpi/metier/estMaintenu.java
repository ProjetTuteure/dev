package gpi.metier;

/**
 * Created by Julien on 15/01/2015.
 */
public class EstMaintenu {
    private Materiel materielEstMaintenu;
    private Maintenance maintenanceEstMaintenu;

    public EstMaintenu(Materiel materielEstMaintenu, Maintenance maintenanceEstMaintenu) {
        this.materielEstMaintenu = materielEstMaintenu;
        this.maintenanceEstMaintenu = maintenanceEstMaintenu;
    }

    public Materiel getMaterielEstMaintenu() {
        return this.materielEstMaintenu;
    }

    public int getIdMaterielEstMaintenu() {
        return this.materielEstMaintenu.getIdMateriel().getValue();
    }

    public void setMaterielEstMaintenu(Materiel materielEstMaintenu) {
        this.materielEstMaintenu = materielEstMaintenu;
    }

    public Maintenance getMaintenanceEstMaintenu() {
        return this.maintenanceEstMaintenu;
    }

    public int getIdMaintenanceEstMaintenu() {
        return this.maintenanceEstMaintenu.getIdMaintenance().getValue();
    }

    public void setMaintenanceEstMaintenu(Maintenance maintenanceEstMaintenu) {
        this.maintenanceEstMaintenu = maintenanceEstMaintenu;
    }
}