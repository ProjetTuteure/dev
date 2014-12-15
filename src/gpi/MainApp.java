package gpi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gpi.bd.Donnee;
import gpi.metier.*;
import gpi.view.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static java.util.List.*;

public class MainApp extends Application {

	public static Donnee donnee;
	private static Stage primaryStage;
	private static TabPane rootLayout;
	private Tab SiteOverview;
	private Tab AncienneteOverview;
	private Tab EtatOverview;
	private static Tab AvanceOverview;
	private Tab ParametreOverview;

    //pour garder en memoire l'etat des onglet : utiliser ces variable :
	private static List<Object> tab0;
    private static List<Object> tab1;
    private static List<Object> tab2;
    private static List<Object> tab3;
    private static List<Object> tab4;
    ////////////////////////////////////////////

	@Override
	public void start(Stage primaryStage) {
        tab0 = new ArrayList<Object>();
        tab1 = new ArrayList<Object>();
        tab2 = new ArrayList<Object>();
        tab3 = new ArrayList<Object>();
        tab4 = new ArrayList<Object>();
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Adam SAS");
		this.primaryStage.setWidth(800);
		this.primaryStage.setResizable(false);
		initRootLayout();
		initTabOverview(this.SiteOverview, "Site");
		initTabOverview(this.AncienneteOverview, "Anciennete");
		initTabOverview(this.EtatOverview, "Etat");
		initTabOverview(this.AvanceOverview, "Avance");
		initTabOverview(this.ParametreOverview, "Parametre");
	}

	public void initTabOverview(Tab tab, String nom) {
		try {
			tab = new Tab();
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/" + nom
					+ "Overview.fxml"));
			AnchorPane tabOverview = (AnchorPane) loader.load();
			tab.setText(nom);
			tab.setContent(tabOverview);
			// Set person overview into the center of root layout.
			rootLayout.getTabs().add(tab);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initializes the root layout.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class
					.getResource("view/RootLayout.fxml"));
			rootLayout = (TabPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    public static void setCritere(Object o){
        switch (getActiveTab()) {
        	case 0:
        		tab0.add(o);
        		break;
            case 1:
                tab1.add(o);
                break;
            case 2:
                tab2.add(o);
                break;
            case 3:
                tab3.add(o);
                break;
            case 4:
                tab4.add(o);
                break;
        }
    }

    public static Object getCritere(int index){
        switch (getActiveTab()) {
        	case 0:
        		return tab0.get(index);
            case 1:
                return tab1.get(index);
            case 2:
                return tab2.get(index);
            case 3:
                return tab3.get(index);
            default:
                return tab4.get(index);
        }

    }

    public static void removeCritere(){
        switch (getActiveTab()) {
            case 0:
                tab0.remove(tab0.size()-1);
                break;
            case 1:
                tab1.remove(tab1.size()-1);
                break;
            case 2:
                tab2.remove(tab2.size()-1);
                break;
            case 3:
                tab3.remove(tab3.size()-1);
                break;
            case 4:
                tab4.remove(tab4.size()-1);
                break;
        }
    }
	public static void removeCriteres(){
		switch (getActiveTab()) {
			case 0:
				//tab0.remove(tab0.size()-1);
				break;
			case 1:
				//tab1.remove(tab1.size()-1);
				break;
			case 2:
				//tab2.remove(tab2.size()-1);
				break;
			case 3:
				tab3.removeAll(tab3);
				break;
			case 4:
				//tab4.remove(tab4.size()-1);
				break;
		}
	}

    public static int getActiveTab(){
        return rootLayout.getSelectionModel().getSelectedIndex();
    }

    /**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	//private static ObservableList<Site> siteData = FXCollections.observableArrayList();
	public static void main(String[] args) {
		donnee = new Donnee();
		launch(args);

	}

	public static void changerTab(String nom) {
		try {
			int onglet = getActiveTab();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/" + nom
					+ "Overview.fxml"));
			AnchorPane tabOverview = (AnchorPane) loader.load();
			rootLayout.getTabs().get(onglet).setContent(tabOverview);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//public static ObservableList<Site> getSiteData() {
		//return siteData;
	//}

	public static boolean showAddSiteDialog(Site site) {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/addSiteDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Ajouter un nouveau site");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			addSiteDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showSuppSiteDialog() {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/suppSiteDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Supprimer un site");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			suppSiteDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showModSiteDialog() {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/modSiteDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Modifier un site");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			modSiteDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showAddTypeDialog(Type type) {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/addTypeDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Ajouter un nouveau Type");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			addTypeDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showModTypeDialog() {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/modTypeDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Modifier un Type");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			modTypeDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showSuppTypeDialog() {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/suppTypeDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Supprimer un type");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			suppTypeDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showAddFactDialog(Facture facture) {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/addFactDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Ajouter une nouvelle facture");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			addFactDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showModFactDialog() {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/modFactDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Modifier une facture");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			modFactDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showSuppFactDialog() {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/suppFactDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Supprimer une facture");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			suppFactDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showAddFabrDialog(Fabricant fabricant) {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/addFabrDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Ajouter un nouveau fabricant");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			addFabrDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showModFabrDialog() {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/modFabrDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Modifier un fabricant");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			modFabrDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showSuppFabrDialog() {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/suppFabrDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Supprimer un fabricant");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			suppFabrDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showAddLogDialog(Logiciel logiciel) {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/addLogDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Ajouter un nouveau logiciel");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			addLogDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showModLogDialog() {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/modLogDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Modifier un logiciel");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			modLogDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showSuppLogDialog() {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/suppLogDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Supprimer un logiciel");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			suppLogDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showAddMaintDialog(Maintenance maintenance) {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/addMaintDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Ajouter une nouvelle maintenance");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			addMaintDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showModMaintDialog() {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/modMaintDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Modifier une maintenance");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			modMaintDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showSuppMaintDialog() {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/suppMaintDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Supprimer une maintenance");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			suppMaintDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showAddMatDialog(Materiel materiel) {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/addMatDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Ajouter un nouveau materiel");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			addMatDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showModMatDialog() {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/modMatDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Modifier un materiel");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			modMatDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean showSuppMatDialog() {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/suppMatDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Supprimer une maintenance");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			suppMatDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showAddPrestDialog(Prestataire prest) {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/addPrestDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Ajouter un prestataire");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			addPrestDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showModPrestDialog() {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/modPrestDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Modifier un prestataire");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			modPrestDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);


			dialogStage.showAndWait();
			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showSuppPrestDialog() {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/suppPrestDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Supprimer un prestataire");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			suppPrestDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showAddRevDialog(Revendeur rev) {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/addRevDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Ajouter un revendeur");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			addRevDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showModRevDialog() {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/modRevDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Modifier un revendeur");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			modRevDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}

	public static boolean showSuppRevDialog() {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/suppRevDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Supprimer un revendeur");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			dialogStage.setResizable(false);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			suppRevDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);

			dialogStage.showAndWait();

			return controller.isOkClicked();

		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}
	}
}
