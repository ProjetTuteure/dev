package gpi.metier;

/**
 * Created by thibault on 22/11/14.
 */
public class Site {
    private int idSite;
    private String nomSte;
    private String cheminImage;

    public String getNomSte() {
        return nomSte;
    }

    public void setNomSte(String nomSte) {
        this.nomSte = nomSte;
    }

    public int getIdSite() {
        return idSite;
    }

    public void setIdSite(int idSite) {
        this.idSite = idSite;
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }

    public Site(int idSite, String nomSte, String cheminImage) {

        this.idSite = idSite;
        this.nomSte = nomSte;
        this.cheminImage = cheminImage;
    }
}
