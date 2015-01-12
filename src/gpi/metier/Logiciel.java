package gpi.metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

/**
 * Created by thibault on 22/11/14.
 */
public class Logiciel {
    private int idLog;
    private StringProperty nomLog;
    private StringProperty version;
    private LocalDate dateExpiration;
    private Facture facture;

    public Logiciel(int idLog, String nomLog, String version, LocalDate dateExpiration, Facture facture) {
        this.idLog = idLog;
        this.nomLog = new SimpleStringProperty(nomLog);
        this.version = new SimpleStringProperty(version);
        this.dateExpiration = dateExpiration;
        this.facture = facture;
    }

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public StringProperty getNomLog() {
        return nomLog;
    }

    public void setNomLog(String nomLog) {
        this.nomLog.setValue(nomLog);
    }

    public StringProperty getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version.setValue(version);
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public StringProperty getDateExpirationStringProperty() {
        String dateFacture=this.dateExpiration.getDayOfMonth()+"/"+this.dateExpiration.getMonthValue()+"/"+this.dateExpiration.getYear();
        return new SimpleStringProperty(dateFacture);
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration=dateExpiration;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
}
