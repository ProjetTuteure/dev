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
    private Tab SiteOverview;
    private Tab AncienneteOverview;
    private Tab EtatOverview;
    private Tab AvanceOverview;
    private Tab ParametreOverview;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Adam SAS");
        initRootLayout();
        initOverview(this.SiteOverview, "Site");
        initOverview(this.AncienneteOverview, "Anciennete");
        initOverview(this.EtatOverview, "Etat");
        initOverview(this.AvanceOverview, "Avance");
        initOverview(this.ParametreOverview, "Parametre");
    }

    public void initOverview(Tab tab,String nom){
        try {
            tab = new Tab();
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/"+nom+"Overview.fxml"));
            AnchorPane siteOverview = (AnchorPane) loader.load();
            tab.setText(nom);
            tab.setContent(siteOverview);
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
