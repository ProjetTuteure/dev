package gpi.metier;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by thibault on 22/11/14.
 */
public class Type {
    private StringProperty nomType;
    private StringProperty cheminImageType;

    public Type(String nomType, String cheminImageType) {
        this.nomType = new SimpleStringProperty(nomType);
        this.cheminImageType = new SimpleStringProperty(cheminImageType);
    }
    
    public StringProperty getNomType() {
        return nomType;
    }

    public void setNomType(String nomType) {
        this.nomType.setValue(nomType);
    }
    
    public String getNomTypeString(){
    	return this.nomType.get();
    }

    public StringProperty getCheminImageType() {
        return cheminImageType;
    }

    public void setCheminImageType(String cheminImageType) {
        this.cheminImageType.setValue(cheminImageType);
    }
}
