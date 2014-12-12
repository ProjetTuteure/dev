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

}
