package gpi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gpi.bd.Donnee;
import gpi.metier.*;
import gpi.view.addSiteDialogController;
import gpi.view.modSiteDialogController;
import gpi.view.suppSiteDialogController;
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

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Adam SAS");
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

	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	private static ObservableList<Site> siteData = FXCollections
			.observableArrayList();

	public static void main(String[] args) {
		donnee = new Donnee();
		siteData.add(new Site(1, "Limoges", ""));
		siteData.add(new Site(1, "Tulle", ""));
		siteData.add(new Site(1, "Paris", ""));
		siteData.add(new Site(1, "Brive", ""));
		siteData.add(new Site(1, "Toulouse", ""));
		siteData.add(new Site(1, "Marseille", ""));
		launch(args);
	}

	public static void changerTab(String nom, int onglet) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/" + nom
					+ "Overview.fxml"));
			AnchorPane tabOverview = (AnchorPane) loader.load();
			rootLayout.getTabs().get(onglet).setContent(tabOverview);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ObservableList<Site> getSiteData() {
		return siteData;
	}

	public static boolean showAddSiteDialog(Site site) {
		try {
			FXMLLoader loader = new FXMLLoader(
					MainApp.class.getResource("view/addSiteDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Ajouter un nouveau site");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			addSiteDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			// controller.setPerson(site);

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

}
