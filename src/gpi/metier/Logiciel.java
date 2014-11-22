package gpi.metier;

/**
 * Created by thibault on 22/11/14.
 */
public class Logiciel {
    private int idLog;
    private String nomLog;
    private String version;
    private String dateExpiration;
    private Facture facture;

    public Logiciel(int idLog, String nomLog, String version, String dateExpiration, Facture facture) {
        this.idLog = idLog;
        this.nomLog = nomLog;
        this.version = version;
        this.dateExpiration = dateExpiration;
        this.facture = facture;
    }

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public String getNomLog() {
        return nomLog;
    }

    public void setNomLog(String nomLog) {
        this.nomLog = nomLog;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
}
