package gpi.view;

import java.util.ArrayList;
import java.util.Iterator;

import gpi.metier.Site;
import javafx.scene.layout.GridPane;

public class SiteOverviewController {
	private GridPane gp_site;
	private Site agen;
	private Site bordeaux;
	private Site chateauroux;
	private Site gueret;
	private Site limoges;
	private Site montlucon;
	private Site saintAgnan;
	private Site saintJunien;
	
	public SiteOverviewController()
	{
		this.agen=new Site(1,"Agen","sources/images/logo-ville-agen0.jpg");
		this.bordeaux=new Site(2,"Bordeaux","sources/images/bordeaux.jpg");
		this.chateauroux=new Site(3,"Chateauroux","sources/images/chateauroux.jpg");
		this.gueret=new Site(4,"Gueret","sources/images/Gueret.jpg");
		this.limoges=new Site(5,"Limoges","sources/images/limoges.jpg");
		this.montlucon=new Site(6,"Montluçon","sources/images/montlucon.jpg");
		this.saintAgnan=new Site(7,"Saint Agnan","sources/images/saintAgnan.jpg");
		this.saintJunien=new Site(8,"Saint Junien","sources/images/saintJunien.jpg");
		
		this.gp_site=new GridPane();
	}
	
	public void setGridPane(GridPane gp_site)
	{
		
	}
	
	public void ajouterVille(ArrayList<Site> listeVille)
	{
		
	}
}
