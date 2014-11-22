package gpi.metier;

/**
 * Created by thibault on 22/11/14.
 */
public class Maintenance {
    private int idMaint;
    private String dateMaint;
    private String objet;
    private String description;
    private float cout;

    public Maintenance(int idMaint, String dateMaint, String objet, String description, float cout) {
        this.idMaint = idMaint;
        this.dateMaint = dateMaint;
        this.objet = objet;
        this.description = description;
        this.cout = cout;
    }

    public int getIdMaint() {
        return idMaint;
    }

    public void setIdMaint(int idMaint) {
        this.idMaint = idMaint;
    }

    public float getCout() {
        return cout;
    }

    public void setCout(float cout) {
        this.cout = cout;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getDateMaint() {
        return dateMaint;
    }

    public void setDateMaint(String dateMaint) {
        this.dateMaint = dateMaint;
    }
}
