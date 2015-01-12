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

    public Materiel getmaterielEstMaintenu() {
        return materielEstMaintenu;
    }

    public void setmaterielEstMaintenu(Materiel materielEstMaintenu) {
        this.materielEstMaintenu = materielEstMaintenu;
    }

    public Maintenance getmaintenanceEstMaintenu() {
        return maintenanceEstMaintenu;
    }

    public void setmaintenanceEstMaintenu(Maintenance maintenanceEstMaintenu) {
        this.maintenanceEstMaintenu = maintenanceEstMaintenu;
    }
}
