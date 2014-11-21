package gpi.metier;

/**
 * Created by admin on 21/11/14.
 */
public class Fabricant {
    private int idFab;
    private String nomFab;
    private String telFab;
    private String adresseFab;

    public Fabricant(int idFab, String nomFab, String telFab, String adresseFab) {
        this.idFab = idFab;
        this.nomFab = nomFab;
        this.telFab = telFab;
        this.adresseFab = adresseFab;
    }

    public int getIdFab() {
        return idFab;
    }

    public void setIdFab(int idFab) {
        this.idFab = idFab;
    }

    public String getNomFab() {
        return nomFab;
    }

    public void setNomFab(String nomFab) {
        this.nomFab = nomFab;
    }

    public String getTelFab() {
        return telFab;
    }

    public void setTelFab(String telFab) {
        this.telFab = telFab;
    }

    public String getAdresseFab() {
        return adresseFab;
    }

    public void setAdresseFab(String adresseFab) {
        this.adresseFab = adresseFab;
    }
}
