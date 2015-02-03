package gpi.view;

import java.util.List;

import utils.Popup;
import gpi.MainApp;
import gpi.exception.ConnexionBDException;
import gpi.metier.Site;
import gpi.metier.Type;
import gpi.metier.TypeDAO;
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

	
	private TypeDAO typeDAO;
	
	
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
	 * Permet de cr�er et ins�rer les �l�ments dans
	 * la fen�tre
	 */
	@FXML
	private void initialize() {
		Site site;
		this.typeDAO = new TypeDAO();
		site=(Site)(MainApp.getCritere(0));
		List<Type> AllType = null;
		try {
			AllType = typeDAO.recupererAllType();
		} catch (ConnexionBDException e) {
			new Popup(e.getMessage());
		}
		if (AllType != null){
			this.types=FXCollections.observableArrayList(AllType);
			this.setLabelNomVille(site.getNomSiteString());
			this.sp_type.setHbarPolicy(ScrollBarPolicy.NEVER);
			this.ajouterTypeGridPane(this.types);
			this.ajouterActionBouton(b_type);
		}
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
		    	MainApp.removeCritere();
		        MainApp.changerTab("Site");
		    }
		});
	}
	
	/**
	 * Permet de cr�er la police ainsi que de changer le label
	 * nomVille situ� en haut � gauche de la fen�tre.
	 * @param nomVille
	 */
	private void setLabelNomVille(String nomVille)
	{
		this.nomVille.setFont(new Font("Arial",20));
		this.nomVille.setText(nomVille);
	}
	
	/**
	 * Permet de calculer le nombre de ligne n�cessaire 
	 * pour le gridPane.
	 * @param types la liste de type de mat�riel que l'on doit ajouter
	 * au GridPane
	 * @return le nombre de ligne necessaire pour pouvoir afficher tous les types
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
	
	/**
	 * Permet d'ajouter les types dans le gridPane
	 * @param types la liste des types � ajouter dans le gridPane
	 */
	@FXML
	public void ajouterTypeGridPane(ObservableList<Type> types) {
		int ligne=0;
		int colonne=0; 
		int hauteurCellule=150;
		int largeurCellule=getLargeurCellule(types);
		String cheminImage;
		for(int i=0;i<this.getNbType();i++)
		{
			Type type=types.get(i);
			cheminImage=type.getCheminImageType().getValue();
			ImageView image=new ImageView();
			image.setImage(new Image(cheminImage));
			image.setFitHeight(100);
			image.setFitWidth(100);
			Label label=new Label();
			label.setText(type.getNomTypeString());
			label.setId(""+type.getIdType());
			label.setFont(new Font("Arial",20));
			BorderPane bp_type=new BorderPane();
			bp_type.setCenter(image);
			bp_type.setBottom(label);
			BorderPane.setAlignment(label,Pos.CENTER);
			bp_type.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					MainApp.setCritere(type);
					MainApp.changerTab("Materiel");
				}
			});
			if(i%4==0 && i!=0)
			{
				ligne=ligne+1;
				colonne=0;
			}
			gp_type.getColumnConstraints().add(new ColumnConstraints(largeurCellule));
			//gp_type.getRowConstraints().add(new RowConstraints(hauteurCellule));
			this.gp_type.add(bp_type, colonne, ligne);
			colonne=colonne+1;
		}
		/*for(int i=0;i<4;i++)
		{
			gp_type.getColumnConstraints().add(new ColumnConstraints(largeurCellule));
		}
		for(int i=0;i<getNbLigne(types);i++)
		{
			gp_type.getRowConstraints().add(new RowConstraints(hauteurCellule));
		}*/
	}
	
	/**
	 * Retourne la largeur de cellule qu'il faut pour pouvoir afficher tous les types
	 * @param types la liste de type
	 * @return la largeur de la cellule
	 */
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