package gpi.metier;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Julien on 12/01/2015.
 */
public class Composant {
    private IntegerProperty idComposant;
    private StringProperty nomComposant;
    private StringProperty cheminImageComposant;
    private Fabricant fabricantComposant;

    public Composant(IntegerProperty idComposant, String nomComposant, String cheminImageComposant, Fabricant fabricantComposant) {
        this.idComposant = idComposant;
        this.nomComposant = new SimpleStringProperty(nomComposant);
        this.cheminImageComposant = new SimpleStringProperty(cheminImageComposant);
        this.fabricantComposant = fabricantComposant;
    }

    public int getIdComposant() {
        return idComposant.get();
    }

    public IntegerProperty idComposantProperty() {
        return idComposant;
    }

    public void setIdComposant(int idComposant) {
        this.idComposant.set(idComposant);
    }

    public String getNomComposant() {
        return nomComposant.get();
    }

    public StringProperty nomComposantProperty() {
        return nomComposant;
    }

    public void setNomComposant(String nomComposant) {
        this.nomComposant.set(nomComposant);
    }

    public String getCheminImageComposant() {
        return cheminImageComposant.get();
    }

    public StringProperty cheminImageComposantProperty() {
        return cheminImageComposant;
    }

    public void setCheminImageComposant(String cheminImageComposant) {
        this.cheminImageComposant.set(cheminImageComposant);
    }

    public Fabricant getFabricantComposant() {
        return fabricantComposant;
    }

    public void setFabricantComposant(Fabricant fabricantComposant) {
        this.fabricantComposant = fabricantComposant;
    }
}
