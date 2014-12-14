package gpi.view;

import gpi.MainApp;
import gpi.bd.Donnee;
import gpi.metier.Site;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class SiteOverviewController {
	@FXML
	private GridPane gp_site;

    int onglet;

	@FXML
	private ImageView image_site;

	@FXML
	private Label nomSite;

	@FXML
	private ObservableList<Site> sites;

	@FXML
	private MainApp mainApp;

	public SiteOverviewController() {
		this.sites = mainApp.donnee.getSiteData();
		this.gp_site = new GridPane();
		for (int i = 0; i < sites.size() / 4 + 1; i++) {
			RowConstraints row = new RowConstraints();
			row.setPercentHeight(100 / (sites.size() / 4));
			gp_site.getRowConstraints().add(row);
		}
	}

	public int getNbSite() {
		return this.sites.size();
	}

	@FXML
	private void initialize() {
		MainApp.donnee = new Donnee();
		this.ajouterVilleGridPane(this.mainApp.donnee.getSiteData());
	}

	@FXML
	public void ajouterVilleGridPane(ObservableList<Site> sites) {
        setColumn();
        setRow();
		for (int i = 0; i < getNbLigne(); i++) {
			for (int j = 0; j < 4 && (i * 4) + j < this.getNbSite(); j++) {
				BorderPane tempo = new BorderPane();
				ImageView image = new ImageView(sites.get((i * 4) + j)
                        .getCheminImage());
                Label label = new Label(sites.get((i * 4) + j).getNomSte());
                label.setId(""+((i * 4) + j));
				image.setFitHeight(75);
				image.setFitWidth(75);
				tempo.setCenter(image);
				tempo.setBottom(label);
                tempo.setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent arg0) {
                      //  System.out.println(((Label)(tempo.getBottom())).getId());
                        String id = ((Label)(tempo.getBottom())).getId();
                        mainApp.setCritere(mainApp.donnee.getSite(Integer.parseInt(id)));
                        mainApp.changerTab("Type");
                    }
                });
                gp_site.add(tempo, j, i);
			}
		}

	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

	private void setRow() {
		for (int i = 0; i < getNbLigne(); i++) {
			RowConstraints row = new RowConstraints();
			row.setPrefHeight(150);
			gp_site.getRowConstraints().add(row);
		}
	}

    public void setColumn(){
        for(int i = 0; i<4;i++){
            ColumnConstraints col = new ColumnConstraints();
            col.setPrefWidth(200);
            gp_site.getColumnConstraints().add(col);
        }
    }

	public int getNbLigne() {
		if (this.getNbSite() % 4 == 0) {
			return this.getNbSite() / 4;
		} else {
			return this.getNbSite() / 4 + 1;
		}
	}

    public int getOnglet(){
        return 0;
    }
}
