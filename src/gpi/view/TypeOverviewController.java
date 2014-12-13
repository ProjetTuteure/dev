package gpi.view;

import java.util.ArrayList;

import gpi.MainApp;
import gpi.bd.Donnee;
import gpi.metier.Site;
import gpi.metier.Type;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
	private GridPane gp_type;
	
	@FXML
	private ImageView image_type;

	@FXML
	private Label nomType,nomVille;

	@FXML
	private ObservableList<Type> types;

	@FXML
	private MainApp mainApp;
	
	@FXML
	private ComboBox cb_type;
	

	public TypeOverviewController() {
		gp_type=new GridPane();
		sp_type=new ScrollPane();
	}

	public int getNbType() {
		return this.types.size();
	}


	@FXML
	private void initialize() {
		Donnee donnee = new Donnee();
		this.types=donnee.getTypeData();
		this.setNomVille("Limoges");
		setListeTypeMateriel(this.types);
		this.sp_type.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.ajouterTypeGridPane(this.mainApp.donnee.getTypeData());
	}
	
	private void setNomVille(String nomVille)
	{
		this.nomVille.setText(nomVille);
	}
	
	private void setListeTypeMateriel(ObservableList<Type> types)
	{
		for(Type type : types)
		{
			cb_type.getItems().add(type.getNom().getValue());
		}
	}
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