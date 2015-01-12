package gpi.metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by thibault on 22/11/14.
 */
public class Fabricant {
    private int idFabricant;
    private StringProperty nomFabricant;
    private StringProperty telFabricant;
    private StringProperty adresseFabricant;


    public Fabricant(int idFab, String nomFab, String telFab, String adresseFab) {

        this.idFabricant = idFab;
        this.nomFabricant = new SimpleStringProperty(nomFab);
        this.telFabricant = new SimpleStringProperty(telFab);
        this.adresseFabricant = new SimpleStringProperty(adresseFab);
    }

    public int getIdFabricant() {
        return idFabricant;
    }

    public void setIdFabricant(int idFab) {
        this.idFabricant = idFab;
    }

    public StringProperty getTelFabricant() {
        return telFabricant;
    }

    public void setTelFabricant(String telFab) {
        this.telFabricant.setValue(telFab);
    }

    public StringProperty getAdresseFabricant() {
        return adresseFabricant;
    }

    public void setAdresseFabricant(String adresseFab) {
        this.adresseFabricant.setValue(adresseFab);
    }

    public StringProperty getNomFabricant() {
        return nomFabricant;
    }

    public String getNomFabricantString(){
    	return this.getNomFabricant().getValue();
    }

    public void setNomFab(String nomFab) {
        this.nomFabricant.setValue(nomFab);
    }
}
