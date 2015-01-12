package gpi.metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

/**
 * Created by thibault on 22/11/14.
 */
public class Materiel {
    private int idMateriel;
    private StringProperty numImmobMat;
    private StringProperty nom;
    private Type type;
    private Etat etat;
    private LocalDate dateExpirationGarantie;
    private StringProperty repertoireDriver;
    private Facture facture;
    private Site site;
    private Fabricant fabricant;
    private String modele;

    public Materiel(int idMateriel,String numImmobMat, String nom, Type type, Etat etat, LocalDate dateExpirationGarantie, String repertoireDriver, Facture facture, Site site, Fabricant fabricant,String modele) {
        this.idMateriel=idMateriel;
        this.numImmobMat = new SimpleStringProperty(numImmobMat);
        this.nom= new SimpleStringProperty(nom);
        this.type = type;
        this.etat = etat;
        this.dateExpirationGarantie=dateExpirationGarantie;
        this.repertoireDriver = new SimpleStringProperty(repertoireDriver);
        this.facture = facture;
        this.site = site;
        this.fabricant = fabricant;
        this.modele=modele;
    }

    public int getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
    
    public String getSiteString(){
    	return site.getNomSte();
    }

    public StringProperty getNumImmobMat() {
        return numImmobMat;
    }

    public void setNumImmobMat(String numImmobMat) {
        this.numImmobMat.setValue(numImmobMat);
    }

    
    public StringProperty getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }
    
    public String getEtatString(){
    	return etat.name();
    }

    public StringProperty getEtatStringProperty(){
    	return new SimpleStringProperty(etat.name());
    }
    public LocalDate getDateExpirationGarantie() {
        return dateExpirationGarantie;
    }

    public StringProperty getDateExpirationGarantieStringProperty() {
        String chaine1="";
        String chaine2="";
        if(dateExpirationGarantie.getDayOfMonth()<10){
            chaine1="0";
        }
        if(dateExpirationGarantie.getMonthValue()<10){
            chaine2="0";
        }
        String dateFacture=chaine1+this.dateExpirationGarantie.getDayOfMonth()+"/"+chaine2+this.dateExpirationGarantie.getMonthValue()+"/"+this.dateExpirationGarantie.getYear();
        return new SimpleStringProperty(dateFacture);
    }

    public void setDateExpirationGarantie(LocalDate dateExpirationGarantie) {
        this.dateExpirationGarantie=dateExpirationGarantie;
    }

    public StringProperty getRepertoireDriver() {
        return repertoireDriver;
    }

    public void setRepertoireDriver(String repertoireDriver) {
        this.repertoireDriver.setValue(repertoireDriver);
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }
    
    public String getFactureString(){
    	return facture.getNumFac();
    }
    
    public Fabricant getFabricant() {
        return fabricant;
    }

    public void setFabricant(Fabricant fabricant) {
        this.fabricant = fabricant;
    }
    
    public String getFabricantString(){
    	return fabricant.getNomFab().getValue();
    }

    public String getModele() {
        return modele;
    }

    @Override
    public String toString() {
        return nom.getValue() +
                ", numImmobMat=" + numImmobMat.getValue()+
                ", type=" + type.getNomString() +
                ", etat=" + etat.name() +
                ", dateExpirationGarantie=" + getDateExpirationGarantieStringProperty().getValue() +
                ", site=" + site.getNomSte() +
                ", fabricant=" + fabricant.getNomFab().getValue()
                ;
    }


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materiel other = (Materiel) obj;
		if (dateExpirationGarantie == null) {
			if (other.dateExpirationGarantie != null)
				return false;
		} else if (!dateExpirationGarantie.equals(other.dateExpirationGarantie))
			return false;
		if (etat != other.etat)
			return false;
		if (fabricant == null) {
			if (other.fabricant != null)
				return false;
		} else if (!fabricant.equals(other.fabricant))
			return false;
		if (facture == null) {
			if (other.facture != null)
				return false;
		} else if (!facture.equals(other.facture))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numImmobMat == null) {
			if (other.numImmobMat != null)
				return false;
		} else if (!numImmobMat.equals(other.numImmobMat))
			return false;
		if (repertoireDriver == null) {
			if (other.repertoireDriver != null)
				return false;
		} else if (!repertoireDriver.equals(other.repertoireDriver))
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}
