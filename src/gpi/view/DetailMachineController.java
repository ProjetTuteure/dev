package gpi.view;

import gpi.MainApp;
import gpi.metier.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.net.URL;
import java.util.ResourceBundle;

import ping.ChangerCouleurPastille;
import ping.Ping;
import ping.PingWindows;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * @author Victor
 *
 */
public class DetailMachineController{

	@FXML
	private Text textSiteNomMachine;
	@FXML
	private Text textCheminDossierDrivers;
	@FXML
	private Circle colorCircle;
	@FXML
	private TableView<Materiel> tableViewMateriel;
	@FXML
	private TableColumn<Materiel,String> numImmoMateriel;
	@FXML
	private TableColumn<Materiel,String> nomMateriel;
	@FXML
	private TableColumn<Materiel,String> typeMateriel;
	@FXML
	private TableColumn<Materiel,String> seMateriel;
	@FXML
	private TableColumn<Materiel,String> etatMateriel;
	@FXML
	private TableColumn<Materiel,String> finGarantieMateriel;
	@FXML
	private TableColumn<Materiel,String> driversMateriel;
	@FXML
	private TableColumn<Materiel,String> siteMateriel;
	@FXML
	private TableView<Materiel> tableViewFacture;
	@FXML
	private TableColumn<Materiel,String> numFacture;
	@FXML
	private TableColumn<Materiel,String> montantFacture;
	@FXML
	private TableColumn<Materiel,String> dateFacture;
	@FXML
	private TableColumn<Materiel,String> fournisseurFacture;
	@FXML
	private TableView<Materiel> tableViewFabricant;
	@FXML
	private TableColumn<Materiel,String> numSerieFabricant;
	@FXML
	private TableColumn<Materiel,String> nomFabricant;
	@FXML
	private TableColumn<Materiel,String> telFabricant;
	@FXML
	private TableColumn<Materiel,String> adresseFabricant;
	@FXML
	private TableView<Materiel> tableViewRevendeur;
	@FXML
	private TableColumn<Materiel,String> nomRevendeur;
	@FXML
	private TableColumn<Materiel,String> telRevendeur;
	@FXML
	private TableColumn<Materiel,String> adresseRevendeur;
	@FXML
	private TableColumn<Materiel,String> numFactureRevendeur;
	@FXML
	private TableView<Materiel> tableViewMaintenances;
	@FXML
	private TableColumn<Materiel,String> numMaintenance;
	@FXML
	private TableColumn<Materiel,String> dateMaintenance;
	@FXML
	private TableColumn<Materiel,String> objetMaintenance;
	@FXML
	private TableColumn<Materiel,String> coutMaintenance;
	@FXML
	private TableColumn<Materiel,String> descriptionMaintenance;
	@FXML
	private TableView<Materiel> tableViewUtilisateurs;
	@FXML
	private TableColumn<Materiel,String> nomUtilisateur;
	@FXML
	private TableColumn<Materiel,String> prenomUtilisateur;
	@FXML
	private TableColumn<Materiel,String> telutilisateur;
	@FXML
	private TableColumn<Materiel,String> debutUtilisateur;
	@FXML
	private TableColumn<Materiel,String> finUtilisateur;
	@FXML
	private TableView<Materiel> tableViewLogiciels;
	@FXML
	private TableColumn<Materiel,String> nomLogiciel;
	@FXML
	private TableColumn<Materiel,String> versionLogiciel;
	@FXML
	private TableColumn<Materiel,String> finGarantieLogiciel;
	@FXML
	private TableColumn<Materiel,String> numFactureLogiciel;
	@FXML
	private TableView<Materiel> tableViewComposants;
	@FXML
	private TableColumn<Materiel,String> nomComposant;
	@FXML
	private TableColumn<Materiel,String> caracteristiqueComposant;
	@FXML
	private TableColumn<Materiel,String> fabricantComposant;
	@FXML
	private ImageView imageType;
	
	private Materiel materiel;
	private int index=0;
	
	public DetailMachineController() {
    }
	
	/**
	 * Initialise les donnï¿½es et affecte l'index en fonction de la page
	 * courante
	 */
	@FXML
	public void initialize() {
		switch(MainApp.getActiveTab()){
			case 0:
				index=2;
				break;
			case 1:
				index=0;
				break;
			case 2:
				index=0;
				break;
			case 3:
                //index=0;
				index=11;
				break;
		}
		materiel=(Materiel)MainApp.getCritere(index);
		textSiteNomMachine.setText(materiel.getSiteMateriel().getNomSiteProperty().getValue()+" --> "+materiel.getNomMateriel().getValueSafe());
		textCheminDossierDrivers.setText(materiel.getRepertoireDriverMateriel().getValueSafe());
		imageType.setImage(new Image(materiel.getTypeMateriel().getCheminImageType().getValue()));
//		listViewMateriel.getItems().addAll(donneesMaterielToList(materiel));
//		listViewFacture.getItems().addAll(donneesFactureToList(materiel.getFactureMateriel()));
//		listViewFabricant.getItems().addAll(donneesFabricantToList(materiel.getFabricantMateriel()));
//		listViewRevendeur.getItems().addAll(donneesRevendeurToList(materiel.getFactureMateriel().getRevendeurFacture()));
//		listViewMaintenance.getItems().addAll(donneesMaintenanceToList(materiel));
//		listViewUtilisateur.getItems().addAll(donneesUtilisateurToList(materiel));
		colorCircle.setVisible(false);
		//Condition si ordinateur ou non à rajouter
		PingWindows pingWindows=new PingWindows(materiel);
		ChangerCouleurPastille pastille=new ChangerCouleurPastille(colorCircle,pingWindows);
		Thread threadPing=new Thread(pingWindows);
		threadPing.start();
		Platform.runLater(pastille);
	}

	/**
	 * Ajoute les donnï¿½es d'un materiel dans une liste
	 * @param materiel le materiel a
	 * @return la liste des informations concernant le materiel passï¿½ en paramï¿½tre
	 */
	private ObservableList<String> donneesMaterielToList(Materiel materiel) {
		ObservableList<String> list= FXCollections.observableArrayList();
		list.add("Num Immo : "+materiel.getNumImmobMateriel().getValueSafe()+"\n");
		list.add("Nom : "+materiel.getNomMateriel().getValueSafe()+"\n");
		list.add("Type : "+materiel.getTypeMateriel().getNomType().getValueSafe()+"\n");
		list.add("Etat : "+materiel.getEtatMaterielString()+"\n");
		list.add("Fin de garantie : "+materiel.getDateExpirationGarantieMaterielStringProperty().getValueSafe()+"\n");
		list.add("Repertoire drivers : "+materiel.getRepertoireDriverMateriel().getValueSafe()+"\n");
		list.add("Site : "+materiel.getSiteMaterielString());
		return list;
	}

	/**
	 * Ajoute les donnï¿½es d'une facture dans une liste de chaï¿½ne de caractï¿½re
	 * @param facture la facture dont on veut mettre les donnï¿½es dans la chaï¿½ne
	 * @return la liste des donnï¿½es relatives ï¿½ la facture passï¿½e en paramï¿½tre
	 */
	private ObservableList<String> donneesFactureToList(Facture facture) {
		ObservableList<String> list= FXCollections.observableArrayList();
		list.add("Num Facture : "+facture.getNumFacture()+"\n");
		list.add("Date facture : "+facture.getDateFacStringProperty().getValue()+"\n");
		list.add("Montant facture : "+facture.getMontantFacture().getValue());
		return list;
	}
	
	/**
	 * Ajoute les donnï¿½es relatives ï¿½ un fabricant dans une liste de chaï¿½ne de caractï¿½re
	 * @param fabricant le fabricant dont on veut mettre les donnï¿½es dans la chaï¿½ne
	 * @return la liste des donnï¿½es relatives au fabricant passï¿½ en paramï¿½tre
	 */
	private ObservableList<String> donneesFabricantToList(Fabricant fabricant) {
		ObservableList<String> list= FXCollections.observableArrayList();
		list.add("Nom fabricant : "+fabricant.getNomFabricantString()+"\n");
		list.add("Telephone fabricant : "+fabricant.getTelFabricant().getValueSafe()+"\n");
		list.add("Adresse fabricant : "+fabricant.getAdresseFabricant().getValueSafe());
		return list;
	}
	
	/**
	 * Ajoute les donnï¿½es relatives ï¿½ un revendeur dans une liste de chaï¿½ne de caractï¿½re
	 * @param revendeur le revendeur dont on veut ajouter les donnï¿½es dans la chaï¿½ne
	 * @return la liste des donnï¿½es relatives au revendeur passï¿½ en paramï¿½tre
	 */
	private ObservableList<String> donneesRevendeurToList(Revendeur revendeur) {
		ObservableList<String> list= FXCollections.observableArrayList();
		list.add("Nom revendeur : "+revendeur.getNomRevendeur().getValueSafe()+"\n");
		list.add("Telephone revendeur : "+revendeur.getTelRevendeur().getValueSafe()+"\n");
		list.add("Adresse revendeur : "+revendeur.getAdresseRevendeur().getValueSafe());
		return list;
	}
	
	/**
	 * Ajoute les donnï¿½es relatives ï¿½ une maintenance dans une liste de chaï¿½ne de caractï¿½re
	 * @param materiel le materiel concernï¿½ par la maintenance ï¿½ ajouter
	 * @return la liste des donnï¿½es relatives ï¿½ la maintenance du materiel passï¿½ en paramï¿½tre
	 */
	private ObservableList<String> donneesMaintenanceToList(Materiel materiel) {
		ObservableList<String> list= FXCollections.observableArrayList();
		ObservableList<Maintenance> listMaintenanceMateriel = FXCollections.observableArrayList();
		for(EstMaintenu em : MainApp.donnee.getEstMaintenuData()){
			if(em.getMaterielEstMaintenu().toString().equals(materiel.toString())){
				listMaintenanceMateriel.add(em.getMaintenanceEstMaintenu());
			}
		}
		int i=1;
		for(Maintenance m : listMaintenanceMateriel){
			list.add("\nMaintenance "+i+" : \n");
			list.add("\t Id : "+String.valueOf(m.getIdMaintenance())+"\n");
			list.add("\t Date : "+m.getdateMaintenance()+"\n");
			list.add("\t Objet : "+m.getObjetMaintenance()+"\n");
			list.add("\t Description : "+m.getDescriptionMaintenance()+"\n");
			list.add("\t Cout : "+String.valueOf(m.getCoutMaintenance())+"\n");
			i++;
		}
		return list;
	}
	
	/**
	 * Ajoute les donnï¿½es relatives ï¿½ un utilisateur dans une liste de chaï¿½ne de caractï¿½re
	 * @param materiel le materiel appartenant ï¿½ l'utilisateur 
	 * @return la liste des donnï¿½es relatives ï¿½ l'utilisateur utilisant le materiel passï¿½ en paramï¿½tre
	 */
	private ObservableList<String> donneesUtilisateurToList(Materiel materiel) {
		ObservableList<String> list= FXCollections.observableArrayList();
		ObservableList<Utilisateur> listUtilisateurMateriel = FXCollections.observableArrayList();
		for(Utilise u : MainApp.donnee.getUtiliseData()){
			if(u.getMaterielUtilise().toString().equals(materiel.toString())){
				listUtilisateurMateriel.add(u.getUtilisateurUtilise());
			}
		}
		for(Utilisateur u : listUtilisateurMateriel){
			list.add("\nUtilisateur "+String.valueOf(u.getIdUtilisateur())+" :\n");
			list.add("Nom : "+u.getNomUtilisateur().getValueSafe()+"\n");
			list.add("Prenom : "+u.getPrenomUtilisateur().getValueSafe()+"\n");
			list.add("Telephone : "+u.getTelUtilisateur().getValueSafe()+"\n");
		}
		return list;
	}
	
	/**
	 * Permet le retour sur les pages prï¿½cï¿½dentes
	 * @param event 
	 */
	@FXML
    private void goBack(ActionEvent event) {
		switch(MainApp.getActiveTab()){
		case 0:
			MainApp.removeCritere();
			MainApp.changerTab("Materiel");
			break;
		case 1:
			MainApp.removeCritere();
			MainApp.changerTab("Anciennete");
			break;
		case 2:
			MainApp.removeCritere();
			MainApp.changerTab("Etat");
			break;
		case 3:
			MainApp.removeCritere();
			MainApp.changerTab("ResultatAvance");
			break;
		}
    }
}
