package gpi.view;

import gpi.metier.Site;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NodeSite extends Parent{
	Label nomVille;
	ImageView logoVille;
	
	public NodeSite(Site site)
	{
		Label nomVille=new Label(site.getNomSte());
		ImageView logoVille=new ImageView(new Image(site.getCheminImage()));
		this.getChildren().add(nomVille);
		this.getChildren().add(logoVille);
	}
}
