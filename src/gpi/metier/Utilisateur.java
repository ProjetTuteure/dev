package gpi.metier;

/**
 * Created by thibault on 22/11/14.
 */
public class Utilisateur {
    private int idUti;
    private String nomUti;
    private String prenomUti;
    private String telUti;

    public Utilisateur(int idUti, String nomUti, String prenomUti, String telUti) {
        this.idUti = idUti;
        this.nomUti = nomUti;
        this.prenomUti = prenomUti;
        this.telUti = telUti;
    }

    public int getIdUti() {
        return idUti;
    }

    public void setIdUti(int idUti) {
        this.idUti = idUti;
    }

    public String getNomUti() {
        return nomUti;
    }

    public void setNomUti(String nomUti) {
        this.nomUti = nomUti;
    }

    public String getPrenomUti() {
        return prenomUti;
    }

    public void setPrenomUti(String prenomUti) {
        this.prenomUti = prenomUti;
    }

    public String getTelUti() {
        return telUti;
    }

    public void setTelUti(String telUti) {
        this.telUti = telUti;
    }
}
