package gpi.view;

public class Fouretout {

}

//package gpi.view;
//
//import gpi.bd.Donnee;
//import gpi.metier.Type;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TextField;
//import javafx.stage.FileChooser;
//import javafx.stage.Stage;
//
//import java.io.File;
//
///**
// * Created by Kevin
// */
//
//public class ModifierType {
//
//	@FXML
//	private Stage dialogStage;
//	@FXML
//	private boolean okClicked = false;
//
//	@FXML
//	private ComboBox<String> comboboxTypeMod;
//
//	private Donnee donneetype = new Donnee();
//
//	private ObservableList<String> listNom;
//
//	@FXML
//	private TextField typefield;
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
//		comboboxTypeMod.setItems(listNom);
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
//	 * Cette methode permet de savoir si le bouton MODIFIER est clique ou pas
//	 * 
//	 * @return vrai si le bouton MODIFIER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton MODIFIER
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
//	 * Cette methode permet de faire apparaitre un Filechooser lorsqu'on clique
//	 * sur "choisir l'image"
//	 * 
//	 * @param event
//	 *            un evenement sur le bouton "choisir l'image"
//	 */
//	@FXML
//	private void handleChoose(ActionEvent event) {
//		FileChooser fileChooser = new FileChooser();
//		fileChooser.setTitle("Open File");
//		File file = fileChooser.showOpenDialog(null);
//
//		if (file != null) {
//		}
//
//	}
//
//	/**
//	 * Cette methode permet de pre remplir les champs lorsqu'un type est
//	 * selectionne
//	 */
//	@FXML
//	private void handlechange() {
//		Type selected = donneetype.gettype(comboboxTypeMod.getValue());
//
//		typefield.setText(selected.getNomType().getValue());
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
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.TextField;
//import javafx.stage.FileChooser;
//import javafx.stage.Stage;
//
//import java.io.File;
//
///**
// * Created by Kevin
// */
//
//public class ModifierSite {
//	@FXML
//	private TextField NameSiteField;
//
//	@FXML
//	private Stage dialogStage;
//	// @FXML
//	// private Site site;
//	@FXML
//	private boolean okClicked = false;
//
//	@FXML
//	private ComboBox<String> comboboxSiteMod;
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
//		comboboxSiteMod.setItems(listNom);
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
//	// a voir pour la suite
//	// public void setPerson(Site site) {
//	// this.site = site;
//	//
//	// NameSiteField.setText(site.getNomSte());
//	//
//	// }
//
//	/**
//	 * Cette methode permet de savoir si le bouton MODIFIER est clique ou pas
//	 * 
//	 * @return vrai si le bouton MODIFIER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton MODIFIER
//	 * est clique
//	 */
//	@FXML
//	private void handleOk() {
//		// a voir pour la suite
//		// if (isInputValid()) {
//		// site.setNomSte(NameSiteField.getText());
//
//		okClicked = true;
//		dialogStage.close();
//		// }
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
//	// a voir pour la suite
//	// private boolean isInputValid() {
//	// String errorMessage = "";
//	//
//	// if (NameSiteField.getText() == null
//	// || NameSiteField.getText().length() == 0) {
//	// errorMessage += "Nom de site invalide\n";
//	// }
//	//
//	// if (errorMessage.length() == 0) {
//	// return true;
//	// } else {
//	// // Show the error message
//	// Dialogs.showErrorDialog(dialogStage, errorMessage,
//	// "Veuillez corriger le champ", "Champ invalide");
//	// return false;
//	// }
//	// }
//
//	/**
//	 * Cette methode permet de faire apparaitre un Filechooser lorsqu'on clique
//	 * sur "choisir l'image"
//	 * 
//	 * @param event
//	 *            un evenement sur le bouton "choisir l'image"
//	 */
//	@FXML
//	private void handleChoose(ActionEvent event) {
//		FileChooser fileChooser = new FileChooser();
//		fileChooser.setTitle("Open File");
//		File file = fileChooser.showOpenDialog(null); // you could pass a stage
//														// reference here if you
//														// wanted.
//
//		if (file != null) {
//		}// do something interesting with the file.
//
//	}
//
//	/**
//	 * Cette methode permet de pre remplir les champs lorsqu'un site est
//	 * selectionne
//	 */
//	@FXML
//	private void handlechange(ActionEvent event) {
//		NameSiteField.setText(comboboxSiteMod.getValue());
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
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class ModifierRevendeur {
//	@FXML
//	private Stage dialogStage;
//
//	@FXML
//	private boolean okClicked = false;
//
//	@FXML
//	private TextField nomfield;
//	@FXML
//	private TextField telfield;
//	@FXML
//	private TextField adrfield;
//
//	@FXML
//	private ComboBox<String> comboboxrev;
//
//	private Donnee donneesite = new Donnee();
//
//	private ObservableList<String> listrev;
//
//	/**
//	 * Initialise les donn�es Ajoute les donn�es aux combobox
//	 */
//	@FXML
//	private void initialize() {
//		listrev = FXCollections.observableArrayList();
//
//		for (Revendeur rev : donneesite.getRevendeurData()) {
//			listrev.add(rev.getNomRevendeur().getValue());
//		}
//		comboboxrev.setItems(listrev);
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
//	 * Cette methode permet de savoir si le bouton MODIFIER est clique ou pas
//	 * 
//	 * @return vrai si le bouton MODIFIER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton MODIFIER
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
//	 * Cette methode permet de pre remplir les champs lorsqu'un revendeur est
//	 * selectionne
//	 */
//	@FXML
//	private void handlechange() {
//
//		Revendeur selected = donneesite.getRevendeur(comboboxrev.getValue());
//		nomfield.setText(selected.getNomRevendeur().getValue());
//		telfield.setText(selected.getTelRevendeur().getValue());
//		adrfield.setText(selected.getAdresseRevendeur().getValue());
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
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class ModifierPrestataire {
//	@FXML
//	private Stage dialogStage;
//	@FXML
//	private boolean okClicked = false;
//
//	@FXML
//	private TextField nomfield;
//	@FXML
//	private TextField prenomfield;
//	@FXML
//	private TextField telfield;
//	@FXML
//	private TextField socfield;
//	@FXML
//	private boolean choix1 = false;
//
//	@FXML
//	private ComboBox<String> comboboxnom;
//	@FXML
//	private ComboBox<String> comboboxprenom;
//
//	private Donnee donnee = new Donnee();
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
//		for (Prestataire pr : donnee.getPrestataireData()) {
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
//	 * Cette methode permet de savoir si le bouton MODIFIER est clique ou pas
//	 * 
//	 * @return vrai si le bouton MODIFIER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton MODIFIER
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
//	 * Cette methode permet de pre remplir le combobox avec les prenoms afin
//	 * d'avoir un seul et unique prestataire cibl�
//	 */
//	@FXML
//	private void handlechange1() {
//		choix1 = true;
//		Prestataire selected = donnee.getPrestaire(comboboxnom.getValue());
//		listprenom = FXCollections.observableArrayList();
//
//		for (Prestataire pr : donnee.getPrestataireData()) {
//			if (pr.getNomPrestataire().getValue()
//					.equals(selected.getNomPrestataire().getValue())) {
//				listprenom.add(pr.getPrenomPrestataire().getValue());
//			}
//		}
//		comboboxprenom.setItems(listprenom);
//	}
//
//	/**
//	 * Cette methode permet de pre remplir les champs lorsqu'un prestataire est
//	 * selectionne avec son pr�nom et son nom
//	 */
//	@FXML
//	private void handlechange2() {
//		try {
//			if (choix1 = true) {
//				String test = comboboxnom.getValue() + " "
//						+ comboboxprenom.getValue();
//				Prestataire selected2 = donnee.getPrestaire2(test);
//
//				nomfield.setText(selected2.getNomPrestataire().getValue());
//				prenomfield.setText(selected2.getPrenomPrestataire().getValue());
//				telfield.setText(selected2.getTelPrestataire().getValue());
//				socfield.setText(selected2.getSocieteePrestataire().getValue());
//			}
//		} catch (NullPointerException e) {
//
//		}
//	}
//}
//
//
//
//
//
//package gpi.view;
//
//import java.io.File;
//import gpi.bd.Donnee;
//import gpi.metier.*;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.TextField;
//import javafx.stage.DirectoryChooser;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class ModifierMateriel {
//	@FXML
//	private Stage dialogStage;
//	@FXML
//	private boolean okClicked = false;
//	@FXML
//	private TextField nomfield;
//	@FXML
//	private TextField typefield;
//	@FXML
//	private TextField immofield;
//	@FXML
//	private DatePicker datefield;
//	@FXML
//	private ComboBox<String> comboboxetat;
//	@FXML
//	private ComboBox<String> comboboxfab;
//	@FXML
//	private ComboBox<String> comboboxfact;
//	@FXML
//	private ComboBox<String> comboboxsite;
//	@FXML
//	private ComboBox<String> comboboximmo;
//
//	private Donnee donneesite = new Donnee();
//
//	private ObservableList<String> listimmo;
//	private ObservableList<String> listEtat;
//	private ObservableList<String> listSite;
//	private ObservableList<String> listFabr;
//	private ObservableList<String> listFact;
//
//	@FXML
//	private void initialize() {
//		listimmo = FXCollections.observableArrayList();
//
//		for (Materiel materiel : donneesite.getMaterielData()) {
//			listimmo.add(materiel.getNumImmobMateriel().getValue());
//		}
//		comboboximmo.setItems(listimmo);
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
//	private void handlechoose() {
//		DirectoryChooser directoryChooser = new DirectoryChooser();
//		directoryChooser.setTitle("Choisir un dossier");
//		File selectedDirectory = directoryChooser.showDialog(null);
//
//		if (selectedDirectory != null) {
//		}
//	}
//
//	@FXML
//	private void handlechange() {
//		listEtat = FXCollections.observableArrayList();
//		listSite = FXCollections.observableArrayList();
//		listFact = FXCollections.observableArrayList();
//		listFabr = FXCollections.observableArrayList();
//
//		Materiel selected = donneesite.getMateriel(comboboximmo.getValue());
//
//		nomfield.setText(selected.getNomMateriel().getValue());
//		typefield.setText(selected.getTypeMateriel().getNomType().getValue());
//		immofield.setText(selected.getNumImmobMateriel().getValue());
//		datefield
//				.setPromptText(selected.getDateExpirationGarantieMaterielStringProperty().getValue());
//
//		for (Etat etat : Etat.values()) {
//			listEtat.add(etat.name());
//		}
//		comboboxetat.setItems(listEtat);
//		comboboxetat.setPromptText(selected.getEtatMateriel().name());
//
//		for (Facture fac : donneesite.getFactureData()) {
//			listFact.add(fac.getNumFacture());
//		}
//		comboboxfact.setItems(listFact);
//		comboboxfact.setPromptText(selected.getFactureMateriel().getNumFacture());
//
//		for (Fabricant fb : donneesite.getFabricantData()) {
//			listFabr.add(fb.getNomFabricant().getValue());
//		}
//		comboboxfab.setItems(listFabr);
//		comboboxfab.setPromptText(selected.getFabricantMaterielString());
//
//		for (Site st : donneesite.getSiteData()) {
//			listSite.add(st.getNomSiteString());
//		}
//		comboboxsite.setItems(listEtat);
//		comboboxsite.setPromptText(selected.getSiteMateriel().getNomSiteString());
//
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
//public class ModifierMaintenance {
//
//	@FXML
//	private Stage dialogStage;
//	@FXML
//	private boolean okClicked = false;
//
//	@FXML
//	private TextField objfield;
//	@FXML
//	private TextField coutfield;
//	@FXML
//	private DatePicker datefield;
//	@FXML
//	private TextArea descfield;
//	@FXML
//	private boolean choix1 = false;
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
//		Maintenance selected = donnee.getMaintenance(comboboxobj.getValue());
//		listdate = FXCollections.observableArrayList();
//
//		for (Maintenance m : donnee.getMaintenanceData()) {
//			if (m.getObjetMaintenance().equals(selected.getObjetMaintenance())) {
//				listdate.add(selected.getdateMaintenanceStringProperty().getValue());
//			}
//		}
//		comboboxdate.setItems(listdate);
//	}
//
//	@FXML
//	private void handlechange2() {
//		try {
//			if (choix1 = true) {
//
//				String test = comboboxobj.getValue() + " "
//						+ comboboxdate.getValue();
//				Maintenance selected2 = donnee.getMaintenance2(test);
//				System.out.println(selected2.getObjetMaintenance());
//				System.out.println(selected2.getDescriptionMaintenance());
//				objfield.setText(selected2.getObjetMaintenance());
//				datefield.setPromptText(selected2.getdateMaintenanceStringProperty().getValue());
//				descfield.setText(selected2.getDescriptionMaintenance());
//				coutfield.setText(selected2.getCoutMaintenanceString());
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
//import gpi.metier.Facture;
//import gpi.metier.Logiciel;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class ModifierLogiciel {
//
//	@FXML
//	private Stage dialogStage;
//	@FXML
//	private boolean okClicked = false;
//
//	@FXML
//	private TextField nomfield;
//	@FXML
//	private TextField versfield;
//	@FXML
//	private DatePicker datefield;
//	@FXML
//	private boolean choix1 = false;
//
//	@FXML
//	private ComboBox<String> comboboxlog;
//	@FXML
//	private ComboBox<String> comboboxvers;
//	@FXML
//	private ComboBox<String> comboboxfact;
//
//	private Donnee donneeLog = new Donnee();
//
//	private ObservableList<String> listlog;
//	private ObservableList<String> listvers;
//	private ObservableList<String> listfact;
//
//	@FXML
//	private void initialize() {
//		listlog = FXCollections.observableArrayList();
//		listfact = FXCollections.observableArrayList();
//		for (Logiciel log : donneeLog.getLogicielData()) {
//			listlog.add(log.getNomLogiciel().getValue());
//		}
//		comboboxlog.setItems(listlog);
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
//
//		Logiciel selected = donneeLog.getLogiciel(comboboxlog.getValue());
//
//		listvers = FXCollections.observableArrayList();
//		for (Logiciel log : donneeLog.getLogicielData()) {
//			if (log.getNomLogiciel().getValue()
//					.equals(selected.getNomLogiciel().getValue())) {
//				listvers.add(selected.getVersionLogiciel().getValue());
//			}
//		}
//		comboboxvers.setItems(listvers);
//	}
//
//	@FXML
//	private void handlechange2() {
//		try {
//			if (choix1 = true) {
//				listvers = FXCollections.observableArrayList();
//				String test = comboboxlog.getValue() + " "
//						+ comboboxvers.getValue();
//				Logiciel selected2 = donneeLog.getLogiciel2(test);
//
//				nomfield.setText(selected2.getNomLogiciel().getValue());
//				versfield.setText(selected2.getVersionLogiciel().getValue());
//				datefield.setPromptText(selected2.getDateExpirationLogicielStringProperty().getValue());
//
//				for (Facture fac : donneeLog.getFactureData()) {
//					listfact.add(fac.getNumFacture());
//				}
//				comboboxfact.setItems(listfact);
//				comboboxfact.setPromptText(selected2.getFactureLogiciel().getNumFacture());
//			}
//		} catch (NullPointerException e) {
//
//		}
//	}
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
//import javafx.scene.control.DatePicker;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class ModifierFacture {
//
//	@FXML
//	private Stage dialogStage;
//	@FXML
//	private boolean okClicked = false;
//
//	@FXML
//	private ComboBox<String> comboboxfact;
//
//	private Donnee donneeFact = new Donnee();
//
//	private ObservableList<String> listfact;
//
//	@FXML
//	private TextField numfield;
//	@FXML
//	private TextField revfield;
//	@FXML
//	private TextField montantfield;
//	@FXML
//	private DatePicker datefield;
//
//	@FXML
//	private void initialize() {
//		listfact = FXCollections.observableArrayList();
//
//		for (Facture fact : donneeFact.getFactureData()) {
//			listfact.add(fact.getNumFacture());
//		}
//		comboboxfact.setItems(listfact);
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
//	private void handlechange() {
//		Facture selected = donneeFact.getFacture(comboboxfact.getValue());
//		numfield.setText(selected.getNumFacture());
//		montantfield.setText(selected.getMontantFactureString());
//		datefield.setPromptText(selected.getDateFacStringProperty().getValue());
//		revfield.setText(selected.getRevendeurFacture().getNomRevendeur().getValue());
//	}
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
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class ModifierFabricant {
//
//	@FXML
//	private Stage dialogStage;
//	@FXML
//	private boolean okClicked = false;
//	@FXML
//	private ComboBox<String> comboboxfabr;
//
//	private Donnee donneeFabr = new Donnee();
//
//	private ObservableList<String> listFabr;
//
//	@FXML
//	private TextField nomfield;
//	@FXML
//	private TextField adrfield;
//	@FXML
//	private TextField telfield;
//
//	/**
//	 * Initialise les donn�es Ajoute les donn�es aux combobox
//	 */
//	@FXML
//	private void initialize() {
//		listFabr = FXCollections.observableArrayList();
//
//		for (Fabricant fab : donneeFabr.getFabricantData()) {
//			listFabr.add(fab.getNomFabricant().getValue());
//		}
//		comboboxfabr.setItems(listFabr);
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
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton MODIFIER
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
//	 * Cette methode permet de savoir si le bouton MODIFIER est clique ou pas
//	 * 
//	 * @return vrai si le bouton MODIFIER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette methode permet de pre remplir les champs lorsqu'un Fabricant est
//	 * selectionne
//	 */
//	@FXML
//	private void handlechange() {
//		Fabricant selected = donneeFabr.getFabricant(comboboxfabr.getValue());
//		nomfield.setText(selected.getNomFabricant().getValue());
//		telfield.setText(selected.getTelFabricant().getValue());
//		adrfield.setText(selected.getAdresseFabricant().getValue());
//	}
//
//}






