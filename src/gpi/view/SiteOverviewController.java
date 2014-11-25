package gpi.view;

import java.awt.Panel;
import java.util.ArrayList;
import java.util.Iterator;

import gpi.MainApp;
import gpi.bd.Donnee;
import gpi.metier.Site;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	
	public SiteOverviewController(){
		this.sites=mainApp.donnee.getSiteData();
		this.gp_site=new GridPane();
        for(int i =0; i<sites.size()/4 +1;i++){
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100 / (sites.size()/4));
            gp_site.getRowConstraints().add(row);
        }
	}
	
	public int getNbSite()
	{
		return this.sites.size();
	}
	
	@FXML
	private void initialize(){
		MainApp.donnee=new Donnee();
		this.ajouterVilleGridPane(MainApp.donnee.getSiteData());
	}
	
	@FXML
	public void ajouterVilleGridPane(ObservableList<Site> sites){
		Label nomVille;
		ImageView logoVille;
		for(int i=0;i<this.getNbSite()/4;i++){
			nomVille=new Label();
			logoVille=new ImageView();
			//On affecte aux Node les objets.
			nomVille.setText(sites.get(i).getNomSte());
			logoVille.setImage(new Image(sites.get(i).getCheminImage()));
			//On positionne les Node
			for (int j=0;j<4;j++){
				gp_site.add(nomVille,j,i);
				gp_site.add(logoVille,j,i);
			}	
		}
	}
	
	public void setMainApp(MainApp mainApp){
		this.mainApp=mainApp;
	}

}
