package gpi.metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by thibault on 22/11/14.
 */
public class Type {
    private StringProperty nom;
    private StringProperty cheminImage;

    public Type(String nom, String cheminImage) {
        this.nom = new SimpleStringProperty(nom);
        this.cheminImage = new SimpleStringProperty(cheminImage);
    }

    public StringProperty getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.setValue(nom);
    }

    public StringProperty getCheminImage() {
        return cheminImage;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage.setValue(cheminImage);
    }
}
