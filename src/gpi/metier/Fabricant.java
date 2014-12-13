package gpi.metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by thibault on 22/11/14.
 */
public class Fabricant {
    private int idFab;
    private StringProperty nomFab;
    private StringProperty telFab;
    private StringProperty adresseFab;


    public Fabricant(int idFab, String nomFab, String telFab, String adresseFab) {

        this.idFab = idFab;
        this.nomFab = new SimpleStringProperty(nomFab);
        this.telFab = new SimpleStringProperty(telFab);
        this.adresseFab = new SimpleStringProperty(adresseFab);
    }

    public int getIdFab() {
        return idFab;
    }

    public void setIdFab(int idFab) {
        this.idFab = idFab;
    }

    public StringProperty getTelFab() {
        return telFab;
    }

    public void setTelFab(String telFab) {
        this.telFab.setValue(telFab);
    }

    public StringProperty getAdresseFab() {
        return adresseFab;
    }

    public void setAdresseFab(String adresseFab) {
        this.adresseFab.setValue(adresseFab);
    }

    public StringProperty getNomFab() {
        return nomFab;
    }



    public void setNomFab(String nomFab) {
        this.nomFab.setValue(nomFab);
    }
}
