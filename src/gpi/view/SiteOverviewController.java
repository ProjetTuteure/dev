package gpi.view;

import java.util.ArrayList;
import java.util.Iterator;

import gpi.bd.Donnee;
import gpi.metier.Site;
import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;

public class SiteOverviewController {
	private GridPane gp_site;
	private Donnee donnee;
	private ObservableList<Site> sites;
	
	public SiteOverviewController()
	{
		this.donnee=new Donnee();
		this.sites=donnee.getSiteData();
		this.gp_site=new GridPane();
	}
	
	public int getNbSite()
	{
		return this.sites.size();
	}

}
