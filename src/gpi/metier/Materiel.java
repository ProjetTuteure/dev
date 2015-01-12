package gpi.metier;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thibault on 22/11/14.
 */
public class Materiel {
    private IntegerProperty idMateriel;
    private StringProperty numImmobMateriel;
    private StringProperty nomMateriel;
    private Type typeMateriel;
    private Etat etatMateriel;
    private LocalDate dateExpirationGarantieMateriel;
    private StringProperty repertoireDriverMateriel;
    private Facture factureMateriel;
    private Site siteMateriel;
    private Fabricant fabricantMateriel;
    private String modeleMateriel;
    private List<Composant> listComposantMateriel;

    public Materiel(IntegerProperty idMateriel,String numImmobMateriel, String nomMateriel, Type typeMateriel, Etat etatMateriel, LocalDate dateExpirationGarantieMateriel, String repertoireDriverMateriel, Facture factureMateriel, Site siteMateriel, Fabricant fabricantMateriel,String modeleMateriel) {
        this.idMateriel=idMateriel;
        this.numImmobMateriel = new SimpleStringProperty(numImmobMateriel);
        this.nomMateriel= new SimpleStringProperty(nomMateriel);
        this.typeMateriel = typeMateriel;
        this.etatMateriel = etatMateriel;
        this.dateExpirationGarantieMateriel=dateExpirationGarantieMateriel;
        this.repertoireDriverMateriel = new SimpleStringProperty(repertoireDriverMateriel);
        this.factureMateriel = factureMateriel;
        this.siteMateriel = siteMateriel;
        this.fabricantMateriel = fabricantMateriel;
        this.modeleMateriel=modeleMateriel;
        this.listComposantMateriel=new ArrayList<Composant>();

    }

    public IntegerProperty getIdMateriel() {
        return idMateriel;
    }

    public void setIdMateriel(IntegerProperty idMateriel) {
        this.idMateriel = idMateriel;
    }

    public Site getSiteMateriel() {
        return siteMateriel;
    }

    public void setSiteMateriel(Site siteMateriel) {
        this.siteMateriel = siteMateriel;
    }
    
    public String getSiteMaterielString(){
    	return siteMateriel.getNomSite();
    }

    public StringProperty getNumImmobMateriel() {
        return numImmobMateriel;
    }

    public void setNumImmobMateriel(String numImmobMateriel) {
        this.numImmobMateriel.setValue(numImmobMateriel);
    }

    
    public StringProperty getNomMateriel() {
        return nomMateriel;
    }

    public void setNomMateriel(String nomMateriel) {
        this.nomMateriel.set(nomMateriel);
    }

    public Type getTypeMateriel() {
        return typeMateriel;
    }

    public void setTypeMateriel(Type typeMateriel) {
        this.typeMateriel = typeMateriel;
    }

    public Etat getEtatMateriel() {
        return etatMateriel;
    }

    public void setEtatMateriel(Etat etatMateriel) {
        this.etatMateriel = etatMateriel;
    }
    
    public String getEtatMaterielString(){
    	return etatMateriel.name();
    }

    public StringProperty getEtatMaterielStringProperty(){
    	return new SimpleStringProperty(etatMateriel.name());
    }
    public LocalDate getDateExpirationGarantie() {
        return dateExpirationGarantieMateriel;
    }

    public StringProperty getDateExpirationGarantieMaterielStringProperty() {
        String chaine1="";
        String chaine2="";
        if(dateExpirationGarantieMateriel.getDayOfMonth()<10){
            chaine1="0";
        }
        if(dateExpirationGarantieMateriel.getMonthValue()<10){
            chaine2="0";
        }
        String dateFacture=chaine1+this.dateExpirationGarantieMateriel.getDayOfMonth()+"/"+chaine2+this.dateExpirationGarantieMateriel.getMonthValue()+"/"+this.dateExpirationGarantieMateriel.getYear();
        return new SimpleStringProperty(dateFacture);
    }

    public void setDateExpirationGarantieMateriel(LocalDate dateExpirationGarantieMateriel) {
        this.dateExpirationGarantieMateriel=dateExpirationGarantieMateriel;
    }

    public StringProperty getRepertoireDriverMateriel() {
        return repertoireDriverMateriel;
    }

    public void setRepertoireDriverMateriel(String repertoireDriverMateriel) {
        this.repertoireDriverMateriel.setValue(repertoireDriverMateriel);
    }

    public Facture getFactureMateriel() {
        return factureMateriel;
    }

    public void setFactureMateriel(Facture factureMateriel) {
        this.factureMateriel = factureMateriel;
    }
    
    public String getFactureStringMateriel(){
    	return factureMateriel.getNumFacture();
    }
    
    public Fabricant getFabricantMateriel() {
        return fabricantMateriel;
    }

    public void setFabricantMateriel(Fabricant fabricantMateriel) {
        this.fabricantMateriel = fabricantMateriel;
    }
    
    public String getFabricantMaterielString(){
    	return fabricantMateriel.getNomFabricant().getValue();
    }

    public String getModeleMateriel() {
        return modeleMateriel;
    }

    public List<Composant> getListComposantMateriel() {
        return listComposantMateriel;
    }

    public void setListComposantMateriel(List<Composant> listComposantMateriel){
        this.listComposantMateriel=listComposantMateriel;
    }

    public void ajouterComposantListComposantMateriel(Composant composant){
        this.listComposantMateriel.add(composant);
    }

    public void ajouterListComposantListComposantMateriel(List<Composant> listComposantMateriel){
        this.listComposantMateriel.addAll(listComposantMateriel);
    }


    @Override
    public String toString() {
        return nomMateriel.getValue() +
                ", numImmobMat=" + numImmobMateriel.getValue()+
                ", type=" + typeMateriel.getNomTypeString() +
                ", etat=" + etatMateriel.name() +
                ", dateExpirationGarantie=" + getDateExpirationGarantieMaterielStringProperty().getValue() +
                ", site=" + siteMateriel.getNomSite() +
                ", fabricant=" + fabricantMateriel.getNomFabricant().getValue()
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
		if (dateExpirationGarantieMateriel == null) {
			if (other.dateExpirationGarantieMateriel != null)
				return false;
		} else if (!dateExpirationGarantieMateriel.equals(other.dateExpirationGarantieMateriel))
			return false;
		if (etatMateriel != other.etatMateriel)
			return false;
		if (fabricantMateriel == null) {
			if (other.fabricantMateriel != null)
				return false;
		} else if (!fabricantMateriel.equals(other.fabricantMateriel))
			return false;
		if (factureMateriel == null) {
			if (other.factureMateriel != null)
				return false;
		} else if (!factureMateriel.equals(other.factureMateriel))
			return false;
		if (nomMateriel == null) {
			if (other.nomMateriel != null)
				return false;
		} else if (!nomMateriel.equals(other.nomMateriel))
			return false;
		if (numImmobMateriel == null) {
			if (other.numImmobMateriel != null)
				return false;
		} else if (!numImmobMateriel.equals(other.numImmobMateriel))
			return false;
		if (repertoireDriverMateriel == null) {
			if (other.repertoireDriverMateriel != null)
				return false;
		} else if (!repertoireDriverMateriel.equals(other.repertoireDriverMateriel))
			return false;
		if (siteMateriel == null) {
			if (other.siteMateriel != null)
				return false;
		} else if (!siteMateriel.equals(other.siteMateriel))
			return false;
		if (typeMateriel == null) {
			if (other.typeMateriel != null)
				return false;
		} else if (!typeMateriel.equals(other.typeMateriel))
			return false;
		return true;
	}
}
