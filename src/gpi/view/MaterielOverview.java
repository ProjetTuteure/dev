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
	
	/**
	 * Initialise les donn�es et ajoute les materiels dans le gridPane
	 */
	@FXML
	private void initialize() {
		Site site;
		site=(Site)(mainApp.getCritere(0));
		Type type;
		type=(Type)mainApp.getCritere(1);
		this.materiel=donnees.rechercher(site,type);
		this.setLabelMaterielVille(site.getNomSte()+" -> "+type.getNom().getValue());
		this.sp_materiel.setHbarPolicy(ScrollBarPolicy.NEVER);
		this.ajouterMaterielGridPane(materiel);
		this.ajouterActionBouton(b_retour);
	}
	
	/**
	 * Ajoute un action Listener au bouton pass� en param�tre
	 * @param bouton le bouton dont on veut ajouter un action listener
	 */
	private void ajouterActionBouton(Button bouton)
	{
		bouton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	mainApp.removeCritere();
		        mainApp.changerTab("Type");
		    }
		});
	}
	
	/**
	 * Permet de cr�er la police ainsi que de changer le label
	 * nomVille situ�e en haut � gauche de la fen�tre.
	 * @param elements le nom � mettre dans le mat�riel ville
	 */
	private void setLabelMaterielVille(String elements)
	{
		this.materielVille.setFont(new Font("Arial",20));
		this.materielVille.setText(elements);
	}
	
	/**
	 * Permet d'ajouter les types dans le gridPane
	 * @param materiel la liste des types � ajouter dans le gridPane
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
			cheminImage=materiel.get(i).getTypeMateriel().getCheminImage().getValue();
			ImageView image=new ImageView();
			image.setImage(new Image(cheminImage));
			image.setFitHeight(100);
			image.setFitWidth(100);
			Label label=new Label();
			label.setText(materiel.get(i).getNomMateriel().getValue());
            label.setId(materiel.get(i).getNumImmobMateriel().getValue());
			label.setFont(new Font("Arial",20));
			BorderPane bp_type=new BorderPane();
			bp_type.setCenter(image);
			bp_type.setBottom(label);
			bp_type.setAlignment(label,Pos.CENTER);
			bp_type.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
                    Materiel mat = donnees.getMateriel(((Label)(bp_type.getBottom())).getId());
                    mainApp.setCritere(mat);
					mainApp.changerTab("DetailMachine");
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
	 * @param materiel la liste de type
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
	 * Permet de calculer le nombre de ligne n�cessaire 
	 * pour le gridPane.
	 * @param materiel la liste de type de mat�riel que l'on doit ajouter
	 * au GridPane
	 * @return le nombre de ligne n�cessaire pour pouvoir afficher tous les types
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
	
	/**
	 * Retourne le nombre de materiel de la liste
	 * @return
	 */
	private int getNbMateriel()
	{
		return this.materiel.size();
	}
}
