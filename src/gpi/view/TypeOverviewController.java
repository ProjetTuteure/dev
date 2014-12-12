package gpi.view;

import gpi.MainApp;
import gpi.bd.Donnee;
import gpi.metier.Site;
import gpi.metier.Type;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Box;

/**
 * Created by admin on 09/12/14.
 */
public class TypeOverviewController {
	@FXML
	private GridPane gp_type;

	@FXML
	private ImageView image_type;

	@FXML
	private Label nomSite;

	@FXML
	private ObservableList<Type> types;

	@FXML
	private MainApp mainApp;

	public TypeOverviewController() {
		this.types = mainApp.donnee.getTypeData();
		this.gp_type = new GridPane();
	}

	public int getNbSite() {
		return this.types.size();
	}

	@FXML
	private void initialize() {
		MainApp.donnee = new Donnee();
		this.ajouterVilleGridPane(this.mainApp.donnee.getTypeData());
	}

	@FXML
	public void ajouterVilleGridPane(ObservableList<Type> types) {

		for (int i = 0; i < this.getNbSite() / 4; i++) {
			for (int j = 0; j < 4; j++) {
				BorderPane tempo = new BorderPane();
				tempo.setBottom(new Label(types.get(i * j).getNom().getValue()));
				tempo.setCenter(new ImageView(types.get(i * j).getCheminImage()
						.getValue()));
				gp_type.add(new BorderPane(), i, j);
			}
		}
		Label label = new Label("Coucou");
		gp_type.add(label, 1, 2);
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

}
