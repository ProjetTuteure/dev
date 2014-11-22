package gpi.metier;

/**
 * Created by thibault on 22/11/14.
 */
public class Revendeur {
    private int idRev;
    private String nomRev;
    private String telRev;
    private String adresse;

    public Revendeur(int idRev, String nomRev, String telRev, String adresse) {
        this.idRev = idRev;
        this.nomRev = nomRev;
        this.telRev = telRev;
        this.adresse = adresse;
    }

    public int getIdRev() {
        return idRev;
    }

    public void setIdRev(int idRev) {
        this.idRev = idRev;
    }

    public String getNomRev() {
        return nomRev;
    }

    public void setNomRev(String nomRev) {
        this.nomRev = nomRev;
    }

    public String getTelRev() {
        return telRev;
    }

    public void setTelRev(String telRev) {
        this.telRev = telRev;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
