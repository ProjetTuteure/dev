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
    private int idMaint;
    private LocalDate dateMaint;
    private String objet;
    private String description;
    private float cout;

    public Maintenance(int idMaint, LocalDate dateMaint, String objet, String description, float cout) {
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
    
    public String getCoutString() {
        return ""+this.getCout();
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

    public LocalDate getDateMaint() {
        return dateMaint;
    }

    public StringProperty getDateMaintStringProperty() {
        String chaine1="";
        String chaine2="";
        if(dateMaint.getDayOfMonth()<10){
            chaine1="0";
        }
        if(dateMaint.getMonthValue()<10){
            chaine2="0";
        }
        String dateFacture=chaine1+this.dateMaint.getDayOfMonth()+"/"+chaine2+this.dateMaint.getMonthValue()+"/"+this.dateMaint.getYear();
        return new SimpleStringProperty(dateFacture);
    }

    public void setDateMaint(LocalDate dateMaint) {
        this.dateMaint = dateMaint;
    }
}
