package gpi;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainApp extends Application {

    private Stage primaryStage;
    private TabPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Adam SAS");

        initRootLayout();

        showSiteOverview();
        showAncienneteOverview();
        showEtatOverview();
        showAvanceOverview();
        showParametreOverview();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (TabPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showSiteOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SiteOverview.fxml"));
            AnchorPane siteOverview = (AnchorPane) loader.load();

            Tab tab = new Tab();
            tab.setText("Site");
            tab.setContent(siteOverview);
            // Set person overview into the center of root layout.
            rootLayout.getTabs().add(tab);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showAncienneteOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AncienneteOverview.fxml"));
            AnchorPane AncienneteOverview = (AnchorPane) loader.load();

            Tab tab = new Tab();
            tab.setText("Ancienneté");
            tab.setContent(AncienneteOverview);
            // Set person overview into the center of root layout.
            rootLayout.getTabs().add(tab);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showEtatOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/EtatOverview.fxml"));
            AnchorPane EtatOverview = (AnchorPane) loader.load();

            Tab tab = new Tab();
            tab.setText("Etat");
            tab.setContent(EtatOverview);
            // Set person overview into the center of root layout.
            rootLayout.getTabs().add(tab);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void showAvanceOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/AvanceOverview.fxml"));
            AnchorPane AvanceOverview = (AnchorPane) loader.load();

            Tab tab = new Tab();
            tab.setText("Avancé");
            tab.setContent(AvanceOverview);
            // Set person overview into the center of root layout.
            rootLayout.getTabs().add(tab);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showParametreOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ParametreOverview.fxml"));
            AnchorPane ParametreOverview = (AnchorPane) loader.load();

            Tab tab = new Tab();
            tab.setText("Paramètre");
            tab.setContent(ParametreOverview);
            // Set person overview into the center of root layout.
            rootLayout.getTabs().add(tab);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
