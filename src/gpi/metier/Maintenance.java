package gpi.metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by thibault on 22/11/14.
 */
public class Maintenance {
    private int idMaintenance;
    private LocalDate dateMaintenance;
    private String objetMaintenance;
    private String descriptionMaintenance;
    private float coutMaintenance;

    public Maintenance(int idMaintenance, LocalDate dateMaintenance, String objetMaintenance, String descriptionMaintenance, float coutMaintenance) {
        this.idMaintenance = idMaintenance;
        this.dateMaintenance = dateMaintenance;
        this.objetMaintenance = objetMaintenance;
        this.descriptionMaintenance = descriptionMaintenance;
        this.coutMaintenance = coutMaintenance;
    }

    public int getIdMaintenance() {
        return idMaintenance;
    }

    public void setIdMaintenance(int idMaintenance) {
        this.idMaintenance = idMaintenance;
    }

    public float getCoutMaintenance() {
        return coutMaintenance;
    }
    
    public String getCoutMaintenanceString() {
        return ""+this.getCoutMaintenance();
    }

    public void setCoutMaintenance(float coutMaintenance) {
        this.coutMaintenance = coutMaintenance;
    }

    public String getDescriptionMaintenance() {
        return descriptionMaintenance;
    }

    public void setDescriptionMaintenance(String descriptionMaintenance) {
        this.descriptionMaintenance = descriptionMaintenance;
    }

    public String getObjetMaintenance() {
        return objetMaintenance;
    }

    public void setObjetMaintenance(String objetMaintenance) {
        this.objetMaintenance = objetMaintenance;
    }

    public LocalDate getdateMaintenance() {
        return dateMaintenance;
    }

    public StringProperty getdateMaintenanceStringProperty() {
        String chaine1="";
        String chaine2="";
        if(dateMaintenance.getDayOfMonth()<10){
            chaine1="0";
        }
        if(dateMaintenance.getMonthValue()<10){
            chaine2="0";
        }
        String dateFacture=chaine1+this.dateMaintenance.getDayOfMonth()+"/"+chaine2+this.dateMaintenance.getMonthValue()+"/"+this.dateMaintenance.getYear();
        return new SimpleStringProperty(dateFacture);
    }

    public void setdateMaintenance(LocalDate dateMaintenance) {
        this.dateMaintenance = dateMaintenance;
    }
}
