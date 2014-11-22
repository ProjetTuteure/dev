package gpi.metier;

/**
 * Created by thibault on 22/11/14.
 */
public class Type {
    private String nom;
    private String cheminImage;

    public Type(String nom, String cheminImage) {
        this.nom = nom;
        this.cheminImage = cheminImage;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }
}
