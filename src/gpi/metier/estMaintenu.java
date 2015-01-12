package gpi.metier;

/**
 * Created by thibault on 22/11/14.
 */
public class estMaintenu {
    private Materiel materielEstMaintenu;
    private Maintenance maintenanceEstMaintenu;

    public estMaintenu(Materiel materielEstMaintenu, Maintenance maintenanceEstMaintenu) {
        this.materielEstMaintenu = materielEstMaintenu;
        this.maintenanceEstMaintenu = maintenanceEstMaintenu;
    }

    public Materiel getMaterielEstMaintenu() {
        return materielEstMaintenu;
    }

    public void setMaterielEstMaintenu(Materiel materielEstMaintenu) {
        this.materielEstMaintenu = materielEstMaintenu;
    }

    public Maintenance getMaintenanceEstMaintenu() {
        return maintenanceEstMaintenu;
    }

    public void setMaintenanceEstMaintenu(Maintenance maintenanceEstMaintenu) {
        this.maintenanceEstMaintenu = maintenanceEstMaintenu;
    }
}
