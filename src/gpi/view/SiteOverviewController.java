package gpi.view;

import java.awt.Panel;
import java.util.ArrayList;
import java.util.Iterator;

import gpi.MainApp;
import gpi.bd.Donnee;
import gpi.metier.Site;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class SiteOverviewController {
	@FXML
	private GridPane gp_site;

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
		setRow();
		for (int i = 0; i < getNbLigne(); i++) {
			for (int j = 0; j < 4 && (i * 4) + j < this.getNbSite(); j++) {
				BorderPane tempo = new BorderPane();
				ImageView image = new ImageView(sites.get((i * 4) + j)
						.getCheminImage());
				image.setFitHeight(75);
				image.setFitWidth(75);
				tempo.setCenter(image);
				tempo.setBottom(new Label(sites.get((i * 4) + j).getNomSte()));
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
			row.setPercentHeight(100 / getNbLigne());
			gp_site.getRowConstraints().add(row);
		}
	}

	public int getNbLigne() {
		if (this.getNbSite() % 4 == 0) {
			return this.getNbSite() / 4;
		} else {
			return this.getNbSite() / 4 + 1;
		}
	}
}
