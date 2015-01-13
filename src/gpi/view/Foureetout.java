package gpi.view;

public class Foureetout {

}

//package gpi.view;
//
//import gpi.bd.Donnee;
//import gpi.metier.Type;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.ComboBox;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class SupprimerType {
//	@FXML
//	private Stage dialogStage;
//	@FXML
//	private boolean okClicked = false;
//	@FXML
//	private ComboBox<String> comboboxtype;
//
//	private Donnee donneetype = new Donnee();
//
//	private ObservableList<String> listNom;
//
//	/**
//	 * Initialise les donn�es Ajoute les donn�es aux combobox
//	 */
//	@FXML
//	private void initialize() {
//		listNom = FXCollections.observableArrayList();
//
//		for (Type type : donneetype.getTypeData()) {
//			listNom.add(type.getNomTypeString());
//		}
//		comboboxtype.setItems(listNom);
//
//	}
//
//	/**
//	 * Cette methode permet de mettre en fenetre active le popup
//	 * 
//	 * @param dialogStage
//	 *            la fenetre active
//	 */
//	public void setDialogStage(Stage dialogStage) {
//		this.dialogStage = dialogStage;
//	}
//
//	/**
//	 * Cette methode permet de savoir si le bouton SUPPRIMER est clique ou pas
//	 * 
//	 * @return vrai si le bouton SUPPRIMER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton SUPPRIMER
//	 * est clique
//	 */
//	@FXML
//	private void handleOk() {
//
//		okClicked = true;
//		dialogStage.close();
//
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton ANNULER
//	 * est clique
//	 */
//	@FXML
//	private void handleCancel() {
//		dialogStage.close();
//	}
//
//}
//
//
//
//
//
//package gpi.view;
//
//import gpi.bd.Donnee;
//import gpi.metier.Site;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.ComboBox;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class SupprimerSite {
//	@FXML
//	private Stage dialogStage;
//	@FXML
//	private boolean okClicked = false;
//	@FXML
//	private ComboBox<String> comboboxSiteSupp;
//
//	private Donnee donneesite = new Donnee();
//
//	private ObservableList<String> listNom;
//
//	/**
//	 * Initialise les donn�es Ajoute les donn�es aux combobox
//	 */
//	@FXML
//	private void initialize() {
//		listNom = FXCollections.observableArrayList();
//
//		for (Site site : donneesite.getSiteData()) {
//			listNom.add(site.getNomSiteString());
//		}
//		comboboxSiteSupp.setItems(listNom);
//	}
//
//	/**
//	 * Cette methode permet de mettre en fenetre active le popup
//	 * 
//	 * @param dialogStage
//	 *            la fenetre active
//	 */
//	public void setDialogStage(Stage dialogStage) {
//		this.dialogStage = dialogStage;
//	}
//
//	/**
//	 * Cette methode permet de savoir si le bouton SUPPRIMER est clique ou pas
//	 * 
//	 * @return vrai si le bouton SUPPRIMER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton SUPPRIMER
//	 * est clique
//	 */
//	@FXML
//	private void handleOk() {
//
//		okClicked = true;
//		dialogStage.close();
//
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton ANNULER
//	 * est clique
//	 */
//	@FXML
//	private void handleCancel() {
//		dialogStage.close();
//	}
//
//}
//
//
//
//
//
//package gpi.view;
//
//import gpi.bd.Donnee;
//import gpi.metier.Revendeur;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.ComboBox;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class SupprimerRevendeur {
//	@FXML
//	private Stage dialogStage;
//	@FXML
//	private boolean okClicked = false;
//
//	@FXML
//	private ComboBox<String> comboboxrev;
//
//	private Donnee donneesite = new Donnee();
//
//	private ObservableList<String> listNom;
//
//	/**
//	 * Initialise les donn�es Ajoute les donn�es aux combobox
//	 */
//	@FXML
//	private void initialize() {
//		listNom = FXCollections.observableArrayList();
//
//		for (Revendeur rv : donneesite.getRevendeurData()) {
//			listNom.add(rv.getNomRevendeur().getValue());
//		}
//		comboboxrev.setItems(listNom);
//	}
//
//	/**
//	 * Cette methode permet de mettre en fenetre active le popup
//	 * 
//	 * @param dialogStage
//	 *            la fenetre active
//	 */
//	public void setDialogStage(Stage dialogStage) {
//		this.dialogStage = dialogStage;
//	}
//
//	/**
//	 * Cette methode permet de savoir si le bouton SUPPRIMER est clique ou pas
//	 * 
//	 * @return vrai si le bouton SUPPRIMER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton SUPPRIMER
//	 * est clique
//	 */
//	@FXML
//	private void handleOk() {
//
//		okClicked = true;
//		dialogStage.close();
//
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton ANNULER
//	 * est clique
//	 */
//	@FXML
//	private void handleCancel() {
//		dialogStage.close();
//	}
//
//}
//
//
//
//
//
//package gpi.view;
//
//import gpi.bd.Donnee;
//import gpi.metier.Prestataire;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.ComboBox;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class SupprimerPrestataire {
//	@FXML
//	private Stage dialogStage;
//	@FXML
//	private boolean okClicked = false;
//
//	@FXML
//	private ComboBox<String> comboboxnom;
//	@FXML
//	private ComboBox<String> comboboxprenom;
//
//	private Donnee donneesite = new Donnee();
//
//	private ObservableList<String> listnom;
//	private ObservableList<String> listprenom;
//
//	/**
//	 * Initialise les donn�es Ajoute les donn�es aux combobox
//	 */
//	@FXML
//	private void initialize() {
//		listnom = FXCollections.observableArrayList();
//
//		for (Prestataire pr : donneesite.getPrestataireData()) {
//			listnom.add(pr.getNomPrestataire().getValue());
//		}
//		comboboxnom.setItems(listnom);
//	}
//
//	/**
//	 * Cette methode permet de mettre en fenetre active le popup
//	 * 
//	 * @param dialogStage
//	 *            la fenetre active
//	 */
//	public void setDialogStage(Stage dialogStage) {
//		this.dialogStage = dialogStage;
//	}
//
//	/**
//	 * Cette methode permet de savoir si le bouton SUPPRIMER est clique ou pas
//	 * 
//	 * @return vrai si le bouton SUPPRIMER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton SUPPRIMER
//	 * est clique
//	 */
//	@FXML
//	private void handleOk() {
//
//		okClicked = true;
//		dialogStage.close();
//
//	}
//
//	/**
//	 * Cette methode permet de pre remplir le combobox du prenom du prestataire
//	 * lorsqu'un nom du prestataire est selectionne
//	 */
//	@FXML
//	private void handlechange() {
//		Prestataire selected = donneesite.getPrestaire(comboboxnom.getValue());
//
//		listprenom = FXCollections.observableArrayList();
//		for (Prestataire pr : donneesite.getPrestataireData()) {
//			if (pr.getNomPrestataire().getValue()
//					.equals(selected.getNomPrestataire().getValue())) {
//				listprenom.add(selected.getPrenomPrestataire().getValue());
//			}
//		}
//		comboboxprenom.setItems(listprenom);
//	}
//
//}
//
//
//
//
//
//package gpi.view;
//
//import gpi.bd.Donnee;
//import gpi.metier.Materiel;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.ComboBox;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class SupprimerMateriel {
//	@FXML
//	private Stage dialogStage;
//	@FXML
//	private boolean okClicked = false;
//	@FXML
//	private ComboBox<String> comboboxmat;
//
//	private Donnee donneesite = new Donnee();
//
//	private ObservableList<String> listmat;
//
//	/**
//	 * Initialise les donn�es Ajoute les donn�es aux combobox
//	 */
//	@FXML
//	private void initialize() {
//		listmat = FXCollections.observableArrayList();
//
//		for (Materiel mat : donneesite.getMaterielData()) {
//			listmat.add(mat.getNumImmobMateriel().getValue());
//		}
//		comboboxmat.setItems(listmat);
//	}
//
//	/**
//	 * Cette methode permet de mettre en fenetre active le popup
//	 * 
//	 * @param dialogStage
//	 *            la fenetre active
//	 */
//	public void setDialogStage(Stage dialogStage) {
//		this.dialogStage = dialogStage;
//	}
//
//	/**
//	 * Cette methode permet de savoir si le bouton SUPPRIMER est clique ou pas
//	 * 
//	 * @return vrai si le bouton SUPPRIMER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton SUPPRIMER
//	 * est clique
//	 */
//	@FXML
//	private void handleOk() {
//
//		okClicked = true;
//		dialogStage.close();
//
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton ANNULER
//	 * est clique
//	 */
//	@FXML
//	private void handleCancel() {
//		dialogStage.close();
//	}
//
//}
//
//
//
//
//
//
//package gpi.view;
//
//import gpi.bd.Donnee;
//import gpi.metier.Maintenance;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.ComboBox;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class SupprimerMaintenance {
//	@FXML
//	private Stage dialogStage;
//	@FXML
//	private boolean okClicked = false;
//
//	@FXML
//	private ComboBox<String> comboboxobj;
//	@FXML
//	private ComboBox<String> comboboxdate;
//
//	private Donnee donnee = new Donnee();
//
//	private ObservableList<String> listobj;
//	private ObservableList<String> listdate;
//
//	@FXML
//	private void initialize() {
//		listobj = FXCollections.observableArrayList();
//
//		for (Maintenance m : donnee.getMaintenanceData()) {
//			listobj.add(m.getObjetMaintenance());
//		}
//		comboboxobj.setItems(listobj);
//	}
//
//	public void setDialogStage(Stage dialogStage) {
//		this.dialogStage = dialogStage;
//	}
//
//	/**
//	 * Cette methode permet de savoir si le bouton SUPPRIMER est clique ou pas
//	 * 
//	 * @return vrai si le bouton SUPPRIMER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton SUPPRIMER
//	 * est clique
//	 */
//	@FXML
//	private void handleOk() {
//
//		okClicked = true;
//		dialogStage.close();
//
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton ANNULER
//	 * est clique
//	 */
//	@FXML
//	private void handleCancel() {
//		dialogStage.close();
//	}
//
//	@FXML
//	private void handlechange() {
//		Maintenance selected = donnee.getMaintenance(comboboxobj.getValue());
//
//		listdate = FXCollections.observableArrayList();
//		for (Maintenance m : donnee.getMaintenanceData()) {
//			if (m.getObjetMaintenance().equals(selected.getObjetMaintenance())) {
//				listdate.add(selected.getdateMaintenanceStringProperty().getValue());
//			}
//		}
//		comboboxdate.setItems(listdate);
//	}
//
//}
//
//
//
//
//
//package gpi.view;
//
//import gpi.bd.Donnee;
//import gpi.metier.Logiciel;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.ComboBox;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class SupprimerLogiciel {
//	@FXML
//	private Stage dialogStage;
//	@FXML
//	private boolean okClicked = false;
//
//	@FXML
//	private ComboBox<String> comboboxlog;
//	@FXML
//	private ComboBox<String> comboboxvers;
//
//	private Donnee donneesite = new Donnee();
//
//	private ObservableList<String> listlog;
//	private ObservableList<String> listvers;
//
//	/**
//	 * Initialise les donn�es Ajoute les donn�es aux combobox
//	 */
//	@FXML
//	private void initialize() {
//		listlog = FXCollections.observableArrayList();
//
//		for (Logiciel log : donneesite.getLogicielData()) {
//			listlog.add(log.getNomLogiciel().getValue());
//		}
//		comboboxlog.setItems(listlog);
//	}
//
//	/**
//	 * Cette methode permet de mettre en fenetre active le popup
//	 * 
//	 * @param dialogStage
//	 *            la fenetre active
//	 */
//	public void setDialogStage(Stage dialogStage) {
//		this.dialogStage = dialogStage;
//	}
//
//	/**
//	 * Cette methode permet de savoir si le bouton SUPPRIMER est clique ou pas
//	 * 
//	 * @return vrai si le bouton SUPPRIMER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton SUPPRIMER
//	 * est clique
//	 */
//	@FXML
//	private void handleOk() {
//
//		okClicked = true;
//		dialogStage.close();
//
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton ANNULER
//	 * est clique
//	 */
//	@FXML
//	private void handleCancel() {
//		dialogStage.close();
//	}
//
//	/**
//	 * Cette methode permet de pre remplir le combobox de la version de logiciel
//	 * lorsqu'un nom du logiciel est selectionne
//	 */
//	@FXML
//	private void handlechange() {
//		Logiciel selected = donneesite.getLogiciel(comboboxlog.getValue());
//
//		listvers = FXCollections.observableArrayList();
//		for (Logiciel log : donneesite.getLogicielData()) {
//			if (log.getNomLogiciel().getValue()
//					.equals(selected.getNomLogiciel().getValue())) {
//				listvers.add(selected.getVersionLogiciel().getValue());
//			}
//		}
//		comboboxvers.setItems(listvers);
//	}
//
//}
//
//
//
//
//
//package gpi.view;
//
//import gpi.bd.Donnee;
//import gpi.metier.Facture;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.ComboBox;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class SupprimerFacture {
//	@FXML
//	private Stage dialogStage;
//	@FXML
//	private boolean okClicked = false;
//
//	@FXML
//	private ComboBox<String> comboboxfact;
//
//	private Donnee donneesite = new Donnee();
//
//	private ObservableList<String> listNum;
//
//	/**
//	 * Initialise les donn�es Ajoute les donn�es aux combobox
//	 */
//	@FXML
//	private void initialize() {
//		listNum = FXCollections.observableArrayList();
//
//		for (Facture fac : donneesite.getFactureData()) {
//			listNum.add(fac.getNumFacture());
//		}
//		comboboxfact.setItems(listNum);
//	}
//
//	/**
//	 * Cette methode permet de mettre en fenetre active le popup
//	 * 
//	 * @param dialogStage
//	 *            la fenetre active
//	 */
//	public void setDialogStage(Stage dialogStage) {
//		this.dialogStage = dialogStage;
//	}
//
//	/**
//	 * Cette methode permet de savoir si le bouton SUPPRIMER est clique ou pas
//	 * 
//	 * @return vrai si le bouton SUPPRIMER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton SUPPRIMER
//	 * est clique
//	 */
//	@FXML
//	private void handleOk() {
//
//		okClicked = true;
//		dialogStage.close();
//
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton ANNULER
//	 * est clique
//	 */
//	@FXML
//	private void handleCancel() {
//		dialogStage.close();
//	}
//
//}
//
//
//
//
//
//package gpi.view;
//
//import gpi.bd.Donnee;
//import gpi.metier.Fabricant;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.ComboBox;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class SupprimerFabricant {
//	@FXML
//	private Stage dialogStage;
//	@FXML
//	private boolean okClicked = false;
//
//	@FXML
//	private ComboBox<String> comboboxfabr;
//
//	private Donnee donneesite = new Donnee();
//
//	private ObservableList<String> listNom;
//
//	/**
//	 * Initialise les donn�es Ajoute les donn�es aux combobox
//	 */
//	@FXML
//	private void initialize() {
//		listNom = FXCollections.observableArrayList();
//
//		for (Fabricant fb : donneesite.getFabricantData()) {
//			listNom.add(fb.getNomFabricantString());
//		}
//		comboboxfabr.setItems(listNom);
//	}
//
//	/**
//	 * Cette methode permet de mettre en fenetre active le popup
//	 * 
//	 * @param dialogStage
//	 *            la fenetre active
//	 */
//	public void setDialogStage(Stage dialogStage) {
//		this.dialogStage = dialogStage;
//	}
//
//	/**
//	 * Cette methode permet de savoir si le bouton SUPPRIMER est clique ou pas
//	 * 
//	 * @return vrai si le bouton SUPPRIMER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton SUPPRIMER
//	 * est clique
//	 */
//	@FXML
//	private void handleOk() {
//
//		okClicked = true;
//		dialogStage.close();
//
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton ANNULER
//	 * est clique
//	 */
//	@FXML
//	private void handleCancel() {
//		dialogStage.close();
//	}
//
//}
//
//
//
//
//
//package gpi.view;
//
//import gpi.bd.Donnee;
//import gpi.metier.Composant;
//import gpi.metier.Facture;
//import gpi.metier.Maintenance;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class ModifierComposant {
//
//	@FXML
//	private Stage dialogStage;
//	@FXML
//	private boolean okClicked = false;
//
//	@FXML
//	private TextField nomfield;
//	@FXML
//	private TextArea caracfield;
//	@FXML
//	private boolean choix1 = false;
//
//	@FXML
//	private ComboBox<String> comboboxnom;
//	@FXML
//	private ComboBox<String> comboboxcarac;
//	@FXML
//	private ComboBox<String> comboboxfabr;
//
//	private Donnee donnee = new Donnee();
//
//	private ObservableList<String> listnom;
//	private ObservableList<String> listcarac;
//	private ObservableList<String> listfabr;
//
//	@FXML
//	private void initialize() {
//		listnom = FXCollections.observableArrayList();
//
//		for (Composant c : donnee.getComposantData()) {
//			listnom.add(c.getNomComposant());
//		}
//		comboboxnom.setItems(listnom);
//	}
//
//	public void setDialogStage(Stage dialogStage) {
//		this.dialogStage = dialogStage;
//	}
//
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	@FXML
//	private void handleOk() {
//
//		okClicked = true;
//		dialogStage.close();
//
//	}
//
//	@FXML
//	private void handleCancel() {
//		dialogStage.close();
//	}
//
//	@FXML
//	private void handlechange1() {
//		choix1 = true;
//		Composant selected = donnee.getComposant(comboboxnom.getValue());
//		listcarac = FXCollections.observableArrayList();
//
//		for (Composant c : donnee.getComposantData()) {
//			if (c.getNomComposant().equals(selected.getNomComposant())) {
//				listcarac.add(selected.getFabricantComposant().getNomFabricant().getValue());
//			}
//		}
//		comboboxcarac.setItems(listcarac);
//	}
//
//	@FXML
//	private void handlechange2() {
//		try {
//			if (choix1 = true) {
//				listfabr = FXCollections.observableArrayList();
//				String test = comboboxnom.getValue() + " "
//						+ comboboxcarac.getValue();
//				Composant selected2 = donnee.getComposant2(test);
//				nomfield.setText(selected2.getNomComposant());
//				caracfield.setText(selected2.getcaracteristiqueComposant());
//				
//				for (Composant co : donnee.getComposantData()) {
//					listfabr.add(co.getFabricantComposant().getNomFabricant().getValue());
//				}
//				comboboxfabr.setItems(listfabr);
//				comboboxfabr.setPromptText(selected2.getFabricantComposant().getNomFabricant().getValue());
//				
//			}
//		} catch (NullPointerException e) {
//
//		}
//	}
//
//}
//
//
//
//
//
//package gpi.view;
//
//import gpi.bd.Donnee;
//import gpi.metier.Composant;
//import gpi.metier.Maintenance;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.ComboBox;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class SupprimerComposant {
//	@FXML
//	private Stage dialogStage;
//	@FXML
//	private boolean okClicked = false;
//
//	@FXML
//	private ComboBox<String> comboboxnom;
//	@FXML
//	private ComboBox<String> comboboxcarac;
//
//	private Donnee donnee = new Donnee();
//
//	private ObservableList<String> listnom;
//	private ObservableList<String> listcarac;
//
//	@FXML
//	private void initialize() {
//		listnom = FXCollections.observableArrayList();
//
//		for (Composant c : donnee.getComposantData()) {
//			listnom.add(c.getNomComposant());
//		}
//		comboboxnom.setItems(listnom);
//	}
//
//	public void setDialogStage(Stage dialogStage) {
//		this.dialogStage = dialogStage;
//	}
//
//	/**
//	 * Cette methode permet de savoir si le bouton SUPPRIMER est clique ou pas
//	 * 
//	 * @return vrai si le bouton SUPPRIMER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton SUPPRIMER
//	 * est clique
//	 */
//	@FXML
//	private void handleOk() {
//
//		okClicked = true;
//		dialogStage.close();
//
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton ANNULER
//	 * est clique
//	 */
//	@FXML
//	private void handleCancel() {
//		dialogStage.close();
//	}
//
//	@FXML
//	private void handlechange() {
//		Composant selected = donnee.getComposant(comboboxnom.getValue());
//
//		listcarac = FXCollections.observableArrayList();
//		for (Composant c : donnee.getComposantData()) {
//			if (c.getNomComposant().equals(selected.getNomComposant())) {
//				listcarac.add(selected.getcaracteristiqueComposant());
//			}
//		}
//		comboboxcarac.setItems(listcarac);
//	}
//
//}

