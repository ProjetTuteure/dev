package gpi.metier;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by thibault on 22/11/14.
 */
public class Site {
    private SimpleIntegerProperty idSite;
    private SimpleStringProperty nomSte;
    private SimpleStringProperty cheminImage;

    public String getNomSte() {
        return this.nomSte.get();
    }

    public SimpleStringProperty getNomSteProperty()
    {
    	return this.nomSte;
    }
    public void setNomSte(String nomSte) {
        this.nomSte.set(nomSte);
    }

    public SimpleIntegerProperty getIdSiteProperty() {
        return idSite;
    }
    
    public int getIdSite()
    {
    	return this.idSite.get();
    }

    public void setIdSite(int idSite) {
        this.idSite.set(idSite);
    }

    public String getCheminImage() {
        return cheminImage.get();
    }
    
    public SimpleStringProperty getCheminImageProperty()
    {
    	return this.cheminImage;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage.set(cheminImage);
    }
    
    public Site(int idSite, String nomSte, String cheminImage) {
        this.idSite = new SimpleIntegerProperty(idSite);
        this.nomSte=new SimpleStringProperty(nomSte);
        this.cheminImage=new SimpleStringProperty(cheminImage);
    }
}
