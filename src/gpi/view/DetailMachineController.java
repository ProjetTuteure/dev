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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
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
	private ListView<String> listViewMateriel;
	@FXML
	private ListView<String> listViewFacture;
	@FXML
	private ListView<String> listViewFabricant;
	@FXML
	private ListView<String> listViewRevendeur;
	@FXML
	private ListView<String> listViewMaintenance;
	@FXML
	private ListView<String> listViewUtilisateur;
	@FXML
	private ImageView imageType;
	
	private Materiel materiel;
	private int index=0;
	
	public DetailMachineController() {
    }
	
	/**
	 * Initialise les donn�es et affecte l'index en fonction de la page
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
		listViewMateriel.getItems().addAll(donneesMaterielToList(materiel));
		listViewFacture.getItems().addAll(donneesFactureToList(materiel.getFactureMateriel()));
		listViewFabricant.getItems().addAll(donneesFabricantToList(materiel.getFabricantMateriel()));
		listViewRevendeur.getItems().addAll(donneesRevendeurToList(materiel.getFactureMateriel().getRevendeurFacture()));
		listViewMaintenance.getItems().addAll(donneesMaintenanceToList(materiel));
		listViewUtilisateur.getItems().addAll(donneesUtilisateurToList(materiel));
		//Condition si ordinateur ou non � rajouter
		PingWindows pingWindows=new PingWindows(materiel);
		ChangerCouleurPastille pastille=new ChangerCouleurPastille(colorCircle,pingWindows);
		Thread threadPing=new Thread(pingWindows);
		threadPing.start();
		Thread threadChangerCouleur=new Thread(pastille);
		threadChangerCouleur.start();
		/*synchronized(pingWindows)
		{
			try {
				pingWindows.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(pingWindows.getResultatPing()==true)
			{
				colorCircle.setFill(Color.GREEN);
			}
			else
			{
				colorCircle.setFill(Color.ORANGE);
			}
		}*/
		
		/*switch(materiel.getEtatMateriel().toString()){
			case "EN_MARCHE":
				colorCircle.setFill(Color.GREEN);
				break;
				
			case "HS":
				colorCircle.setFill(Color.RED);
				break;
			
			case "EN_PANNE":
				colorCircle.setFill(Color.ORANGE);
				break;
		}*/
	}

	/**
	 * Ajoute les donn�es d'un materiel dans une liste
	 * @param materiel le materiel a
	 * @return la liste des informations concernant le materiel pass� en param�tre
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
	 * Ajoute les donn�es d'une facture dans une liste de cha�ne de caract�re
	 * @param facture la facture dont on veut mettre les donn�es dans la cha�ne
	 * @return la liste des donn�es relatives � la facture pass�e en param�tre
	 */
	private ObservableList<String> donneesFactureToList(Facture facture) {
		ObservableList<String> list= FXCollections.observableArrayList();
		list.add("Num Facture : "+facture.getNumFacture()+"\n");
		list.add("Date facture : "+facture.getDateFacStringProperty().getValue()+"\n");
		list.add("Montant facture : "+facture.getMontantFacture().getValue());
		return list;
	}
	
	/**
	 * Ajoute les donn�es relatives � un fabricant dans une liste de cha�ne de caract�re
	 * @param fabricant le fabricant dont on veut mettre les donn�es dans la cha�ne
	 * @return la liste des donn�es relatives au fabricant pass� en param�tre
	 */
	private ObservableList<String> donneesFabricantToList(Fabricant fabricant) {
		ObservableList<String> list= FXCollections.observableArrayList();
		list.add("Nom fabricant : "+fabricant.getNomFabricantString()+"\n");
		list.add("Telephone fabricant : "+fabricant.getTelFabricant().getValueSafe()+"\n");
		list.add("Adresse fabricant : "+fabricant.getAdresseFabricant().getValueSafe());
		return list;
	}
	
	/**
	 * Ajoute les donn�es relatives � un revendeur dans une liste de cha�ne de caract�re
	 * @param revendeur le revendeur dont on veut ajouter les donn�es dans la cha�ne
	 * @return la liste des donn�es relatives au revendeur pass� en param�tre
	 */
	private ObservableList<String> donneesRevendeurToList(Revendeur revendeur) {
		ObservableList<String> list= FXCollections.observableArrayList();
		list.add("Nom revendeur : "+revendeur.getNomRevendeur().getValueSafe()+"\n");
		list.add("Telephone revendeur : "+revendeur.getTelRevendeur().getValueSafe()+"\n");
		list.add("Adresse revendeur : "+revendeur.getAdresseRevendeur().getValueSafe());
		return list;
	}
	
	/**
	 * Ajoute les donn�es relatives � une maintenance dans une liste de cha�ne de caract�re
	 * @param materiel le materiel concern� par la maintenance � ajouter
	 * @return la liste des donn�es relatives � la maintenance du materiel pass� en param�tre
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
	 * Ajoute les donn�es relatives � un utilisateur dans une liste de cha�ne de caract�re
	 * @param materiel le materiel appartenant � l'utilisateur 
	 * @return la liste des donn�es relatives � l'utilisateur utilisant le materiel pass� en param�tre
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
	 * Permet le retour sur les pages pr�c�dentes
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
