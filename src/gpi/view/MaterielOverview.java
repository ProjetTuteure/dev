package gpi.view;

import gpi.MainApp;
import gpi.bd.Donnee;
import gpi.metier.Materiel;
import gpi.metier.Site;
import gpi.metier.Type;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;


public class MaterielOverview {
	@FXML
	private ScrollPane sp_materiel;
	
	@FXML
	private Button b_retour;
	
	@FXML
	private GridPane gp_materiel;
	
	@FXML
	private ImageView image_type;

	@FXML
	private Label materielVille;

	@FXML
	private ObservableList<Materiel> materiel;

	@FXML
	private MainApp mainApp;
	
	private Donnee donnees;
	
	
	public MaterielOverview()
	{
		this.donnees=new Donnee();
		this.materiel=FXCollections.observableArrayList();
	}
	
	@FXML
	private void initialize() {
		Site site;
		site=(Site)(mainApp.getCritere(2));
		Type type;
		type=(Type)mainApp.getCritere(1);
		System.out.println(site.getNomSte());
		System.out.println(site.getCheminImage());
		System.out.println(type.getNomString());
		System.out.println(type.getCheminImage().getValue());
		this.materiel=donnees.rechercher(site,type);
		for(Materiel materiels:materiel)
		{
			System.out.println(materiels.getSiteString());
		}
		this.setLabelMaterielVille(site.getNomSte()+" -> "+type.getNom().getValue());
		this.sp_materiel.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.ajouterMaterielGridPane(materiel);
		this.ajouterActionBouton(b_retour);
	}
	
	/**
	 * Ajoute un action Listener au bouton passé en paramètre
	 * @param bouton le bouton dont on veut ajouter un action listener
	 */
	private void ajouterActionBouton(Button bouton)
	{
		bouton.setOnAction(new EventHandler<ActionEvent>() {
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
	private void setLabelMaterielVille(String éléments)
	{
		this.materielVille.setFont(new Font("Arial",20));
		this.materielVille.setText(éléments);
	}
	
	/**
	 * Permet d'ajouter les types dans le gridPane
	 * @param types la liste des types à ajouter dans le gridPane
	 */
	@FXML
	public void ajouterMaterielGridPane(ObservableList<Materiel> materiel) {
		int ligne=0;
		int colonne=0; 
		int hauteurCellule=150;
		int largeurCellule=getLargeurCellule(materiel);
		String cheminImage;
		for(int i=0;i<this.getNbMateriel();i++)
		{
			cheminImage=materiel.get(i).getType().getCheminImage().getValue();
			ImageView image=new ImageView();
			image.setImage(new Image(cheminImage));
			image.setFitHeight(100);
			image.setFitWidth(100);
			Label label=new Label();
			label.setText(materiel.get(i).getNom().getValue());
			label.setFont(new Font("Arial",20));
			BorderPane bp_type=new BorderPane();
			bp_type.setCenter(image);
			bp_type.setBottom(label);
			bp_type.setAlignment(label,Pos.CENTER);
			bp_type.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					Type type=donnees.getTypeByNom(label.getText());
					mainApp.setCritere(type);
					Site site=(Site)mainApp.getCritere(0);
					mainApp.setCritere(site);
					System.out.println(mainApp.getCritere(0));
					System.out.println(mainApp.getCritere(1));
					mainApp.changerTab("Materiel");
				}
			});
			if(i%4==0 && i!=0)
			{
				ligne=ligne+1;
				colonne=0;
			}
			this.gp_materiel.add(bp_type, colonne, ligne);
			colonne=colonne+1;
		}
		for(int i=0;i<4;i++)
		{
			gp_materiel.getColumnConstraints().add(new ColumnConstraints(largeurCellule));
		}
		for(int i=0;i<getNbLigne(materiel);i++)
		{
			gp_materiel.getRowConstraints().add(new RowConstraints(hauteurCellule));
		}
	}
	
	/**
	 * Retourne la largeur de cellule qu'il faut pour pouvoir afficher tous les types
	 * @param types la liste de type
	 * @return la largeur de la cellule
	 */
	private int getLargeurCellule(ObservableList<Materiel> materiel)
	{
		if(materiel.size()<9)
		{
			return 200;
		}
		else
		{
			 return 196;
		}
	}
	
	/**
	 * Permet de calculer le nombre de ligne nécessaire 
	 * pour le gridPane.
	 * @param types la liste de type de matériel que l'on doit ajouter
	 * au GridPane
	 * @return le nombre de ligne nécessaire pour pouvoir afficher tous les types
	 */
	private int getNbLigne(ObservableList<Materiel> materiel)
	{
		if(this.materiel.size()%4!=0)
		{
			return 1+materiel.size()/4;
		}
		else
		{
			return materiel.size()/4;
		}
	}
	
	private int getNbMateriel()
	{
		return this.materiel.size();
	}
}
