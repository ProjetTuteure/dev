package gpi.view;

import gpi.MainApp;
import gpi.bd.Donnee;
import gpi.metier.Fabricant;
import gpi.metier.Facture;
import gpi.metier.Maintenance;
import gpi.metier.Materiel;
import gpi.metier.Revendeur;
import gpi.metier.Utilisateur;
import gpi.metier.Utilise;
import gpi.metier.estMaintenu;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class DetailMachineController implements Initializable{

	@FXML
	private Text textSiteNomMachine;
	@FXML
	private Text textCheminDossierDrivers;
	@FXML
	private Circle colorCircle;
	@FXML
	private ListView listViewMateriel;
	@FXML
	private ListView listViewFacture;
	@FXML
	private ListView listViewFabricant;
	@FXML
	private ListView listViewRevendeur;
	@FXML
	private ListView listViewMaintenance;
	@FXML
	private ListView listViewUtilisateur;

	@FXML
	private ImageView imageType;
	
	private MainApp mainApp;
	
	public DetailMachineController() {
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		int index = 0;
		MainApp.donnee = new Donnee();
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
		Materiel materiel=(Materiel)mainApp.getCritere(index);
		textSiteNomMachine.setText(materiel.getSite().getNomSteProperty().getValue()+" --> "+materiel.getNom().getValueSafe());
		textCheminDossierDrivers.setText(materiel.getRepertoireDriver().getValueSafe());
		switch(materiel.getEtat().toString()){
			case "EN_MARCHE":
				colorCircle.setFill(Color.GREEN);;
				break;
				
			case "HS":
				colorCircle.setFill(Color.RED);
				break;
			
			case "EN_PANNE":
				colorCircle.setFill(Color.ORANGE);;
				break;
		}
		imageType.setImage(new Image(materiel.getType().getCheminImage().getValue()));
		listViewMateriel.getItems().addAll(donneesMaterielToList(materiel));
		listViewFacture.getItems().addAll(donneesFactureToList(materiel.getFacture()));
		listViewFabricant.getItems().addAll(donneesFabricantToList(materiel.getFabricant()));
		listViewRevendeur.getItems().addAll(donneesRevendeurToList(materiel.getFacture().getRevendeur()));
		listViewMaintenance.getItems().addAll(donneesMaintenanceToList(materiel));
		listViewUtilisateur.getItems().addAll(donneesUtilisateurToList(materiel));
	}

	private ObservableList<String> donneesMaterielToList(Materiel materiel) {
		ObservableList<String> list= FXCollections.observableArrayList();
		list.add("Num Immo : "+materiel.getNumImmobMat().getValueSafe()+"\n");
		list.add("Nom : "+materiel.getNom().getValueSafe()+"\n");
		list.add("Type : "+materiel.getType().getNom().getValueSafe()+"\n");
		list.add("Etat : "+materiel.getEtatString()+"\n");
		list.add("Fin de garantie : "+materiel.getDateExpirationGarantie().getValueSafe()+"\n");
		list.add("Repertoire drivers : "+materiel.getRepertoireDriver().getValueSafe()+"\n");
		list.add("Site : "+materiel.getSiteString());
		return list;
	}

	private ObservableList<String> donneesFactureToList(Facture facture) {
		ObservableList<String> list= FXCollections.observableArrayList();
		list.add("Num Facture : "+facture.getNumFac()+"\n");
		list.add("Date facture : "+facture.getDateFac().getValueSafe()+"\n");
		list.add("Montant facture : "+facture.getMontantFac().getValue());
		return list;
	}
	
	private ObservableList<String> donneesFabricantToList(Fabricant fabricant) {
		ObservableList<String> list= FXCollections.observableArrayList();
		list.add("Nom fabricant : "+fabricant.getNomFabString()+"\n");
		list.add("Telephone fabricant : "+fabricant.getTelFab().getValueSafe()+"\n");
		list.add("Adresse fabricant : "+fabricant.getAdresseFab().getValueSafe());
		return list;
	}
	
	private ObservableList<String> donneesRevendeurToList(Revendeur revendeur) {
		ObservableList<String> list= FXCollections.observableArrayList();
		list.add("Nom revendeur : "+revendeur.getNomRev().getValueSafe()+"\n");
		list.add("Telephone revendeur : "+revendeur.getTelRev().getValueSafe()+"\n");
		list.add("Adresse revendeur : "+revendeur.getAdresse().getValueSafe());
		return list;
	}
	
	private ObservableList<String> donneesMaintenanceToList(Materiel materiel) {
		ObservableList<String> list= FXCollections.observableArrayList();
		ObservableList<Maintenance> listMaintenanceMateriel = FXCollections.observableArrayList();
		for(estMaintenu em : mainApp.donnee.getEstMaintenuData()){
			if(em.getMateriel().toString().equals(materiel.toString())){
				listMaintenanceMateriel.add(em.getMaintenance());
			}
		}
		int i=1;
		for(Maintenance m : listMaintenanceMateriel){
			list.add("\nMaintenance "+i+" : \n");
			list.add("\t Id : "+String.valueOf(m.getIdMaint())+"\n");
			list.add("\t Date : "+m.getDateMaint()+"\n");
			list.add("\t Objet : "+m.getObjet()+"\n");
			list.add("\t Description : "+m.getDescription()+"\n");
			list.add("\t Cout : "+String.valueOf(m.getCout())+"\n");
			i++;
		}
		return list;
	}
	
	private ObservableList<String> donneesUtilisateurToList(Materiel materiel) {
		ObservableList<String> list= FXCollections.observableArrayList();
		ObservableList<Utilisateur> listUtilisateurMateriel = FXCollections.observableArrayList();
		for(Utilise u : mainApp.donnee.getUtiliseData()){
			if(u.getMateriel().toString().equals(materiel.toString())){
				listUtilisateurMateriel.add(u.getUtilisateur());
			}
		}
		for(Utilisateur u : listUtilisateurMateriel){
			list.add("\nUtilisateur "+String.valueOf(u.getIdUti())+" :\n");
			list.add("Nom : "+u.getNomUti().getValueSafe()+"\n");
			list.add("Prenom : "+u.getPrenomUti().getValueSafe()+"\n");
			list.add("Telephone : "+u.getTelUti().getValueSafe()+"\n");
		}
		return list;
	}
	
	@FXML
    private void goBack(ActionEvent event) {
		switch(MainApp.getActiveTab()){
		case 0:
			MainApp.removeCritere();
			MainApp.changerTab("Site");
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
