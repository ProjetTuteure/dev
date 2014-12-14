package gpi.view;

import java.util.ArrayList;

import gpi.MainApp;
import gpi.bd.Donnee;
import gpi.metier.Site;
import gpi.metier.Type;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;

/**
 * Created by admin on 09/12/14.
 */
public class TypeOverviewController {
	
	@FXML
	private ScrollPane sp_type;
	
	@FXML
	private Button b_type;
	
	@FXML
	private GridPane gp_type;
	
	@FXML
	private ImageView image_type;

	@FXML
	private Label nomType,nomVille;

	@FXML
	private ObservableList<Type> types;

	@FXML
	private MainApp mainApp;
	

	/**
	 * Constructeur
	 * instancie le gridPane et le scrollPane.
	 */
	public TypeOverviewController() {
		gp_type=new GridPane();
		sp_type=new ScrollPane();
	}

	/**
	 * Retourne le nombre de type qu'il y'a dans l'ObservableList types
	 * types
	 * @return nbType le nombre de type qu'il y'a dans l'ObservableList types
	 */
	public int getNbType() {
		return this.types.size();
	}

	/**
	 * Permet de créer et insérer les éléments dans
	 * la fenêtre
	 */
	@FXML
	private void initialize() {
		Donnee donnee = new Donnee();
		Site site;
		site=(Site)(mainApp.getCritere(0));
		this.types=donnee.getTypeData();
		this.setLabelNomVille(site.getNomSte());
		this.sp_type.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.ajouterTypeGridPane(this.mainApp.donnee.getTypeData());
		b_type.setOnAction(new EventHandler<ActionEvent>() {
			/**
			 * On change
			 */
		    @Override 
		    public void handle(ActionEvent e) {
		    	mainApp.removeCritere();
		        mainApp.changerTab("Site");
		    }
		});
	}
	
	/**
	 * Permet de créer la police ainsi que de changer le label
	 * nomVille situé en haut à gauche de la fenêtre.
	 * @param nomVille
	 */
	private void setLabelNomVille(String nomVille)
	{
		this.nomVille.setFont(new Font("Arial",20));
		this.nomVille.setText(nomVille);
	}
	
	/**
	 * Permet de calculer le nombre de ligne nécessaire 
	 * pour le gridPane.
	 * @param types la liste de type de matériel que l'on doit ajouter
	 * au GridPane
	 * @return le nombre de ligne nécessaire pour pouvoir afficher tous les types
	 */
	private int getNbLigne(ObservableList<Type> types)
	{
		if(this.types.size()%4!=0)
		{
			return 1+types.size()/4;
		}
		else
		{
			return types.size()/4;
		}
	}
	
	@FXML
	public void ajouterTypeGridPane(ObservableList<Type> types) {
		int ligne=0;
		int colonne=0; 
		int hauteurCellule=150;
		int largeurCellule=getLargeurCellule(types);
		for(int i=0;i<this.getNbType();i++)
		{
			ImageView image=new ImageView();
			image.setImage(new Image(types.get(i).getCheminImage().getValue()));
			image.setFitHeight(100);
			image.setFitWidth(100);
			Label label=new Label();
			label.setText(types.get(i).getNomString());
			label.setFont(new Font("Arial",20));
			BorderPane bp_type=new BorderPane();
			bp_type.setCenter(image);
			bp_type.setBottom(label);
			bp_type.setAlignment(label,Pos.CENTER);
			if(i%4==0 && i!=0)
			{
				ligne=ligne+1;
				colonne=0;
			}
			this.gp_type.add(bp_type, colonne, ligne);
			colonne=colonne+1;
		}
		for(int i=0;i<4;i++)
		{
			gp_type.getColumnConstraints().add(new ColumnConstraints(largeurCellule));
		}
		for(int i=0;i<getNbLigne(types);i++)
		{
			gp_type.getRowConstraints().add(new RowConstraints(hauteurCellule));
		}
	}
	
	private int getLargeurCellule(ObservableList<Type> types)
	{
		if(types.size()<9)
		{
			return 200;
		}
		else
		{
			 return 196;
		}
	}
}