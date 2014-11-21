package gpi.metier;

/**
 * Created by thibault on 21/11/14.
 */
public class Site {

    private int idSite;
    private String nomSite;
    private String cheminImage;

    public Site (int idSite, String nomSite, String CheminImage){
        this.idSite = idSite;
        this.nomSite = nomSite;
        this.cheminImage = cheminImage;
    }

    public String getNomSite() {
        return nomSite;
    }

    public void setNomSite(String nomSite) {
        this.nomSite = nomSite;
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
}
