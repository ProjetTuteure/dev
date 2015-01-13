package gpi.view;

public class Fourretout {

}
//
//
//package gpi.view;
//
//import javafx.fxml.FXML;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class AjouterFabricant {
//	@FXML
//	private Stage dialogStage;
//
//	@FXML
//	private boolean okClicked = false;
//
//	/**
//	 * Initialise les données
//	 */
//	@FXML
//	private void initialize() {
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
//	 * Cette methode permet de savoir si le bouton AJOUTER est clique ou pas
//	 * 
//	 * @return vrai si le bouton AJOUTER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton AJOUTER
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
//}
//
//
//
//
//
//package gpi.view;
//
//import javafx.fxml.FXML;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class AjouterFacture {
//	@FXML
//	private Stage dialogStage;
//
//	@FXML
//	private boolean okClicked = false;
//
//	/**
//	 * Initialise les données
//	 */
//	@FXML
//	private void initialize() {
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
//	 * Cette methode permet de savoir si le bouton AJOUTER est clique ou pas
//	 * 
//	 * @return vrai si le bouton AJOUTER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton AJOUTER
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
//public class AjouterLogiciel {
//	@FXML
//	private Stage dialogStage;
//
//	@FXML
//	private boolean okClicked = false;
//
//	@FXML
//	private ComboBox<String> comboboxfact;
//
//	private Donnee donneeLog = new Donnee();
//
//	private ObservableList<String> listfact;
//
//	/**
//	 * Initialise les donnï¿½es Ajoute les donnï¿½es aux combobox
//	 */
//	@FXML
//	private void initialize() {
//		listfact = FXCollections.observableArrayList();
//		for (Facture fac : donneeLog.getFactureData()) {
//			listfact.add(fac.getNumFacture());
//		}
//		comboboxfact.setItems(listfact);
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
//	 * Cette methode permet de savoir si le bouton AJOUTER est clique ou pas
//	 * 
//	 * @return vrai si le bouton AJOUTER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton AJOUTER
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
//import javafx.fxml.FXML;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class AjouterMaintenance {
//	@FXML
//	private Stage dialogStage;
//
//	@FXML
//	private boolean okClicked = false;
//
//	/**
//	 * Initialise les données
//	 */
//	@FXML
//	private void initialize() {
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
//	 * Cette methode permet de savoir si le bouton AJOUTER est clique ou pas
//	 * 
//	 * @return vrai si le bouton AJOUTER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton AJOUTER
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
//import java.io.File;
//
//import gpi.bd.Donnee;
//import gpi.metier.Etat;
//import gpi.metier.Fabricant;
//import gpi.metier.Facture;
//import gpi.metier.Site;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.ComboBox;
//import javafx.stage.DirectoryChooser;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class AjouterMateriel {
//
//	@FXML
//	private Stage dialogStage;
//	@FXML
//	private boolean okClicked = false;
//	@FXML
//	private ComboBox<String> comboboxetat;
//	@FXML
//	private ComboBox<String> comboboxfabr;
//	@FXML
//	private ComboBox<String> comboboxfact;
//	@FXML
//	private ComboBox<String> comboboxsite;
//
//	private Donnee donneeMat = new Donnee();
//
//	private ObservableList<String> listNom1;
//	private ObservableList<String> listNom2;
//	private ObservableList<String> listNom3;
//	private ObservableList<String> listNom4;
//
//	/**
//	 * Initialise les donnï¿½es Ajoute les donnï¿½es aux combobox
//	 */
//	@FXML
//	private void initialize() {
//		listNom1 = FXCollections.observableArrayList();
//		listNom2 = FXCollections.observableArrayList();
//		listNom3 = FXCollections.observableArrayList();
//		listNom4 = FXCollections.observableArrayList();
//
//		for (Etat etat : Etat.values()) {
//			listNom1.add(etat.name());
//		}
//		comboboxetat.setItems(listNom1);
//
//		for (Fabricant fab : donneeMat.getFabricantData()) {
//			listNom2.add(fab.getNomFabricant().getValue());
//		}
//		comboboxfabr.setItems(listNom2);
//
//		for (Facture fac : donneeMat.getFactureData()) {
//			listNom3.add(fac.getNumFacture());
//		}
//		comboboxfact.setItems(listNom3);
//
//		for (Site site : donneeMat.getSiteData()) {
//			listNom4.add(site.getNomSiteString());
//		}
//		comboboxsite.setItems(listNom4);
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
//	 * Cette methode permet de savoir si le bouton AJOUTER est clique ou pas
//	 * 
//	 * @return vrai si le bouton AJOUTER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton AJOUTER
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
//	 * Cette methode permet de pre remplir les champs lorsqu'un Materiel est
//	 * selectionne
//	 */
//	@FXML
//	private void handleChoose() {
//		DirectoryChooser directoryChooser = new DirectoryChooser();
//		directoryChooser.setTitle("Choisir un dossier");
//		File selectedDirectory = directoryChooser.showDialog(null);
//
//		if (selectedDirectory != null) {
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
//import javafx.fxml.FXML;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class AjouterPrestataire {
//
//	@FXML
//	private Stage dialogStage;
//
//	@FXML
//	private boolean okClicked = false;
//
//	/**
//	 * Initialise les données
//	 */
//	@FXML
//	private void initialize() {
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
//	 * Cette methode permet de savoir si le bouton AJOUTER est clique ou pas
//	 * 
//	 * @return vrai si le bouton AJOUTER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton AJOUTER
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
//import javafx.fxml.FXML;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class AjouterRevendeur {
//	@FXML
//	private Stage dialogStage;
//
//	@FXML
//	private boolean okClicked = false;
//
//	/**
//	 * Initialise les données
//	 */
//	@FXML
//	private void initialize() {
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
//	 * Cette methode permet de savoir si le bouton AJOUTER est clique ou pas
//	 * 
//	 * @return vrai si le bouton AJOUTER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton AJOUTER
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
//import java.io.File;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.TextField;
//import javafx.stage.FileChooser;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class AjouterSite {
//	@FXML
//	private TextField NameSiteField;
//	@FXML
//	private Stage dialogStage;
//	// @FXML
//	// private Site site;
//	@FXML
//	private boolean okClicked = false;
//
//	/**
//	 * Initialise les données
//	 */
//	@FXML
//	private void initialize() {
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
//	// public void setPerson(Site site) {
//	// this.site = site;
//	//
//	// NameSiteField.setText(site.getNomSte());
//	//
//	// }
//
//	/**
//	 * Cette methode permet de savoir si le bouton AJOUTER est clique ou pas
//	 * 
//	 * @return vrai si le bouton AJOUTER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton AJOUTER
//	 * est clique
//	 */
//	@FXML
//	private void handleOk() {
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
//}
//
//
//
//
//
//package gpi.view;
//
//import java.io.File;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.stage.FileChooser;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class AjouterType {
//
//	@FXML
//	private Stage dialogStage;
//
//	@FXML
//	private boolean okClicked = false;
//
//	/**
//	 * Initialise les données
//	 */
//	@FXML
//	private void initialize() {
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
//	 * Cette methode permet de savoir si le bouton AJOUTER est clique ou pas
//	 * 
//	 * @return vrai si le bouton AJOUTER est clique, faux sinon
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton AJOUTER
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
//	private void handleChoose(ActionEvent event) {
//		FileChooser fileChooser = new FileChooser();
//		fileChooser.setTitle("Open File");
//		File file = fileChooser.showOpenDialog(null);
//		if (file != null) {
//		}
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
//import javafx.fxml.FXML;
//import javafx.stage.Stage;
//
///**
// * Created by Kevin
// */
//
//public class AjouterUtilisateur {
//
//	@FXML
//	private Stage dialogStage;
//
//	@FXML
//	private boolean okClicked = false;
//
//	/**
//	 * Initialise les données
//	 */
//	@FXML
//	private void initialize() {
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
//	 * Cette methode permet de savoir si le bouton AJOUTER est clique
//	 * 
//	 * @return vrai si le bouton AJOUTER est clique
//	 */
//	public boolean isOkClicked() {
//		return okClicked;
//	}
//
//	/**
//	 * Cette procedure permet de fermer la fenetre, lorsque le bouton AJOUTER
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
//*/