package gpi.view;

import gpi.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class RechercheAvanceController implements Initializable {
	ScreensController myController;

	@FXML
	private ComboBox<String> comboboxSiteAvanceOverview;
	@FXML
	private ComboBox<String> comboboxAncienneteAvanceOverview;
	@FXML
	private ComboBox<String> comboboxTypeAvanceOverview;

	ObservableList<String> list1 = FXCollections.observableArrayList("Agen",
			"Bordeaux", "Chateroux", "Guéret", "Limoges", "Montluçon",
			"Saint Agan", "Saint Junien", "Tout");
	ObservableList<String> list2 = FXCollections.observableArrayList(
			"moins d'un ans", "moins de deux ans", "moins de trois ans",
			"moins de quattre ans", "moins de cinq ans", "moins de six ans",
			"moins de sept ans", "plus de sept ans");
	ObservableList<String> list3 = FXCollections.observableArrayList(
			"Ordinateur", "Switch", "Routeur", "Clé 3G", "Tout");

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		comboboxSiteAvanceOverview.setItems(list1);
		comboboxAncienneteAvanceOverview.setItems(list2);
		comboboxTypeAvanceOverview.setItems(list3);
	}

	@FXML
	private void goToScreen2(ActionEvent event) {
		MainApp.changerTab("ResultatAvance");
	}
}
