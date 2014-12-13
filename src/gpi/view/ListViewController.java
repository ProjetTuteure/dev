package gpi.view;

import gpi.MainApp;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class ListViewController implements Initializable {

	private boolean test=false;

	@FXML
	private ListView<String> listMateriel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		listMateriel.getItems().add("Materiel 1 0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		listMateriel.getItems().add("Materiel 2");
		listMateriel.getItems().add("Materiel 3");
		listMateriel.getItems().add("Materiel 4");

		listMateriel.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<String>() {
					public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
						if(test){
							MainApp.changerTab("DetailMachine", 3);
						}else{
							test=true;
						}

					}
				});
	}

	@FXML
	private void goToScreen1(ActionEvent event) {
		MainApp.changerTab("Avance", 3);
	}

	@FXML
	private void goToScreen3(MouseEvent event) {

	}
}
