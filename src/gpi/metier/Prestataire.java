package gpi.metier;

/**
 * Created by thibault on 22/11/14.
 */
public class Prestataire {

    private int idPrest;
    private String nomPrest;
    private String prenomPrest;
    private String telPrest;
    private String societee;

    public Prestataire(int idPrest, String nomPrest, String prenomPrest, String telPrest, String societee) {
        this.idPrest = idPrest;
        this.nomPrest = nomPrest;
        this.prenomPrest = prenomPrest;
        this.telPrest = telPrest;
        this.societee = societee;
    }

    public int getIdPrest() {
        return idPrest;
    }

    public void setIdPrest(int idPrest) {
        this.idPrest = idPrest;
    }

    public String getPrenomPrest() {
        return prenomPrest;
    }

    public void setPrenomPrest(String prenomPrest) {
        this.prenomPrest = prenomPrest;
    }

    public String getNomPrest() {
        return nomPrest;
    }

    public void setNomPrest(String nomPrest) {
        this.nomPrest = nomPrest;
    }

    public String getTelPrest() {
        return telPrest;
    }

    public void setTelPrest(String telPrest) {
        this.telPrest = telPrest;
    }

    public String getSocietee() {
        return societee;
    }

    public void setSocietee(String societee) {
        this.societee = societee;
    }
}
