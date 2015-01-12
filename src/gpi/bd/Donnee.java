package gpi.bd;

import gpi.metier.*;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

/**
 * Created by admin on 24/11/14.
 */
public class Donnee {
    private ObservableList<estIntervenu> estIntervenuData = FXCollections.observableArrayList();
    private ObservableList<estMaintenu> estMaintenuData = FXCollections.observableArrayList();
    private ObservableList<Etat> etatData = FXCollections.observableArrayList();
    private ObservableList<Fabricant> fabricantData = FXCollections.observableArrayList();
    private ObservableList<Facture> factureData = FXCollections.observableArrayList();
    private ObservableList<Logiciel> logicielData = FXCollections.observableArrayList();
    private ObservableList<Maintenance> maintenanceData = FXCollections.observableArrayList();
    private ObservableList<Materiel> materielData = FXCollections.observableArrayList();
    private ObservableList<Prestataire> prestataireData = FXCollections.observableArrayList();
    private ObservableList<Revendeur> revendeurData = FXCollections.observableArrayList();
    private ObservableList<Site> siteData = FXCollections.observableArrayList();
    private ObservableList<Type> typeData = FXCollections.observableArrayList();
    private ObservableList<Utilisateur> utilisateurData = FXCollections.observableArrayList();
    private ObservableList<Utilise> utiliseData = FXCollections.observableArrayList();

    public Donnee(){
        remplirSiteData();
        remplirTypeData();
        remplirRevendeurData();
        remplirFabricantData();
        remplirFactureData();
        remplirMaterielData();
        remplirLogicielData();
        remplirUtilisateurData();
        remplirUtiliseData();
        remplirMaintenanceData();
        remplirEstMaintenuData();
        remplirPrestaraireData();
    }

    public ObservableList<Site> getSiteData() {
        return siteData;
    }

    public ObservableList<Type> getTypeData() {
        return typeData;
    }

    public ObservableList<Revendeur> getRevendeurData() {
        return revendeurData;
    }
    
    public ObservableList<Prestataire> getPrestataireData() {
        return prestataireData;
    }

    public ObservableList<Facture> getFactureData() {
        return factureData;
    } 
    
    public ObservableList<Fabricant> getFabricantData() {
        return fabricantData;
    }

    public ObservableList<Materiel> getMaterielData() {
        return materielData;
    }

    public ObservableList<Maintenance> getMaintenanceData() {
        return maintenanceData;
    }
    
    public ObservableList<estMaintenu> getEstMaintenuData(){
        return estMaintenuData;
    }
    
    public ObservableList<Utilise> getUtiliseData(){
        return utiliseData;
    }
    
    public ObservableList<Logiciel> getLogicielData() {
        return logicielData;
    }
    
    private void remplirFabricantData() {
        fabricantData.add(new Fabricant(1, "DELL","05.55.66.77.88" , "2 route perdu 87000"));
        fabricantData.add(new Fabricant(2, "HP","05.55.66.77.88" , "2 route perdu 87000"));
    }
    
    private void remplirPrestaraireData() {
        prestataireData.add(new Prestataire(1, "Caillou", "Pierre", "05.55.69.87.23", "Caillou et Co."));
        prestataireData.add(new Prestataire(2, "Noel", "Papa", "00.36.65.65.65", "Pole Nord"));
    }

    private void remplirMaterielData() {
        materielData.add(new Materiel(1,"1IMMO","pc-martine",typeData.get(0),Etat.EN_MARCHE,LocalDate.parse("2012-11-11"),"/driver/pc-martine",factureData.get(0),siteData.get(0),fabricantData.get(0),"XXX1"));
        materielData.add(new Materiel(2,"2IMMO","pc-gertrude",typeData.get(0),Etat.EN_MARCHE,LocalDate.parse("2012-11-11"),"/driver/pc-gertrude",factureData.get(0),siteData.get(0),fabricantData.get(1),"XXX2"));
		materielData.add(new Materiel(3,"3IMMO", "PC1", typeData.get(0), Etat.EN_MARCHE,LocalDate.parse("2014-12-31"), "", factureData.get(0), siteData.get(0), fabricantData.get(0),"XXX3"));
		materielData.add(new Materiel(4,"4IMMO", "PC2", typeData.get(0), Etat.EN_MARCHE,LocalDate.parse("2015-12-31"), "", factureData.get(0), siteData.get(1), fabricantData.get(0),"XXX4"));
		materielData.add(new Materiel(5,"5IMMO", "PC3", typeData.get(0), Etat.EN_MARCHE,LocalDate.parse("2014-02-05"), "", factureData.get(1), siteData.get(2), fabricantData.get(0),"XXX5"));
		materielData.add(new Materiel(6,"6IMMO", "Routeur1", typeData.get(1), Etat.EN_MARCHE,LocalDate.parse("2017-02-14"), "", factureData.get(1), siteData.get(3), fabricantData.get(0),"XXX6"));
		materielData.add(new Materiel(7,"7IMMO", "Routeur2", typeData.get(1), Etat.EN_PANNE,LocalDate.parse("2012-03-14"), "", factureData.get(1), siteData.get(3), fabricantData.get(0),"XXX7<"));
	    }

    private void remplirFactureData() {
        factureData.add(new Facture("1", LocalDate.parse("2011-11-11"), (float) 123.50,revendeurData.get(0)));
        factureData.add(new Facture("2", LocalDate.parse("2012-12-12"), (float) 99,revendeurData.get(1)));
    }

    private void remplirRevendeurData() {
        revendeurData.add(new Revendeur(1,"Darty","05.55.21.36.54","4 rue n'importe ou"));
        revendeurData.add(new Revendeur(2,"Fnac","05.55.68.57.41","5 rue je sais pas ou "));
    }

    private void remplirTypeData() {
        typeData.add(new Type("PC","sources/images/pc.jpg"));
        typeData.add(new Type("Routeur","sources/images/routeur.png"));
        typeData.add(new Type("Switch","sources/images/switch.jpg"));
        typeData.add(new Type("Clef 3G","sources/images/cle3G.PNG"));
    }

    private void remplirSiteData(){
        siteData.add(new Site(1, "Agen", "sources/images/logo-ville-agen0.png"));
        siteData.add(new Site(2, "Bordeaux", "sources/images/bordeaux.jpg"));
        siteData.add(new Site(3, "Chateauroux", "sources/images/chateauroux.jpg"));
        siteData.add(new Site(4, "Gueret", "sources/images/Gueret.jpg"));
        siteData.add(new Site(5, "Limoges", "sources/images/limoges.jpg"));
        siteData.add(new Site(6, "Montlucon", "sources/images/montlucon.jpg"));
        siteData.add(new Site(7, "Saint-Agnant", "sources/images/saintAgnan.png"));
        siteData.add(new Site(8, "Saint-Junien", "sources/images/saintJunien.jpg"));

    }


    private void remplirLogicielData() {
        this.logicielData.add(new Logiciel(1,"Microsoft Office 2012","1.0",LocalDate.parse("2014-10-01"),this.factureData.get(1)));
    }

    private void remplirUtilisateurData(){
    	this.utilisateurData.add(new Utilisateur(1, "Bon", "Jean", "055212354"));
    	this.utilisateurData.add(new Utilisateur(2, "Leroy", "Arthur", "055684515"));
    	this.utilisateurData.add(new Utilisateur(3, "Fury", "Johanna", "0556519819"));
    	this.utilisateurData.add(new Utilisateur(4, "Garves", "Eddy", "058749841"));
    }
    
    private void remplirUtiliseData(){
    	this.utiliseData.add(new Utilise(utilisateurData.get(0), materielData.get(0)));
    	this.utiliseData.add(new Utilise(utilisateurData.get(1), materielData.get(0)));
    	this.utiliseData.add(new Utilise(utilisateurData.get(1), materielData.get(1)));
    	this.utiliseData.add(new Utilise(utilisateurData.get(2), materielData.get(2)));
    	this.utiliseData.add(new Utilise(utilisateurData.get(3), materielData.get(4)));
    	this.utiliseData.add(new Utilise(utilisateurData.get(3), materielData.get(3)));
    }
    
    private void remplirMaintenanceData(){
    	this.maintenanceData.add(new Maintenance(1, LocalDate.parse("2014-10-01"), "erreur", "une erreur inconnue est survenue", 10));
    	this.maintenanceData.add(new Maintenance(2, LocalDate.parse("2012-02-27"), "orage", "tout a grille", 5000));
    	this.maintenanceData.add(new Maintenance(3, LocalDate.parse("2014-04-10"), "neige", "il a neige dans la salle des serveurs", 999));
    	this.maintenanceData.add(new Maintenance(4, LocalDate.parse("2011-11-11"), "utilisateur", "j'ai besoin d'une grosse description pour voir ce que ca donne alors je cherche des trucs a ecrire mais comme je trouve pas grand chose je continue a dire n'importe quoi voila la je pense que ca suffira", 1));
    }
    
    private void remplirEstMaintenuData(){
    	this.estMaintenuData.add(new estMaintenu(materielData.get(0), maintenanceData.get(0)));
    	this.estMaintenuData.add(new estMaintenu(materielData.get(0), maintenanceData.get(1)));
    	this.estMaintenuData.add(new estMaintenu(materielData.get(1), maintenanceData.get(3)));
    	this.estMaintenuData.add(new estMaintenu(materielData.get(2), maintenanceData.get(2)));
    	this.estMaintenuData.add(new estMaintenu(materielData.get(3), maintenanceData.get(2)));
    	this.estMaintenuData.add(new estMaintenu(materielData.get(3), maintenanceData.get(0)));
    }

    public Type getTypeByNom(String nom)
    {
    	for(Type type:typeData)
    	{
    		if(nom.equals(type.getNom().getValue()))
    		{
    			return type;
    		}
    	}
    	return null;
    }
    
    public Fabricant getFabricant(String value) {
        for(Fabricant fab : fabricantData){
            if(value == fab.getNomFabricantString()){
                return fab;
            }
        }
        return null;
    }
    
    public Revendeur getRevendeur(String value) {
        for(Revendeur rev : revendeurData){
            if(value == rev.getNomRev().getValue()){
                return rev;
            }
        }
        return null;
    }
    
    public Maintenance getMaintenance(String value) {
        for(Maintenance m : maintenanceData){
            if(value == m.getObjet()){
                return m;
            }
        }
        return null;
    }
    
    public Maintenance getMaintenance2(String value) {
        for(Maintenance m : maintenanceData){
            if(value.equals(m.getObjet()+" "+m.getDateMaintStringProperty().getValue())){
                return m;
            }
        }
        return null;
    }
    
    public Prestataire getPrestaire(String value) {
        for(Prestataire pr : prestataireData){
            if(value == pr.getNomPrest().getValue()){
                return pr;
            }
        }
        return null;
    }
    
    public Prestataire getPrestaire2(String value) {
        for(Prestataire pr : prestataireData){
            if(value.equals(pr.getNomPrest().getValue()+" "+pr.getPrenomPrest().getValue())){
                return pr;
            }
        }
        return null;
    }
    
    public Materiel getMateriel(String value) {
        for(Materiel mat : materielData){
            if(value == mat.getNumImmobMat().getValue()){
                return mat;
            }
        }
        return null;
    }
    
    public Site getSite(int index)
    {
    	for(Site site:this.siteData)
    	{
    		if(index==site.getIdSite())
    		{
    			return site;
    		}
    	}
    	return null;
    }
    
    public Type gettype(String value)
    {
    	for(Type type:this.typeData)
    	{
    		if(value==type.getNomString())
    		{
    			return type;
    		}
    	}
    	return null;
    }

    public Facture getFacture(String value)
    {
    	for(Facture fact:this.factureData)
    	{
    		if(value==fact.getNumFacture())
    		{
    			return fact;
    		}
    	}
    	return null;
    }
    
    public Logiciel getLogiciel(String value) {
        for(Logiciel log : logicielData){
            if(value == log.getNomLogiciel().getValue()){
                return log;
            }
        }
        return null;
    }
    
    public Logiciel getLogiciel2(String value) {
        for(Logiciel log : logicielData){
            if(value.equals(log.getNomLogiciel().getValue()+" "+log.getVersionLogiciel().getValue())){
                return log;
            }
        }
        return null;
    }
    
    /**
     * Retourne une liste de materiel en fonction du site et du type de materiel.
     * @param site
     * @param type
     * @return
     */
    public ObservableList<Materiel> rechercher(Site site, Type type){
        ObservableList<Materiel> resultat = FXCollections.observableArrayList();
        for(Materiel mat : materielData){
            if(site.getIdSite() == mat.getSite().getIdSite() && type.getNom().getValue().equals(mat.getType().getNom().getValue())){
                resultat.add(mat);
            }
        }
        return resultat;
    }
}
