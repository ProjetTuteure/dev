package gpi.view;

import gpi.MainApp;
import gpi.metier.*;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.DirectoryChooser;

/**
 * Created by Kevin
 */

public class ParametreController implements Initializable {

	@FXML
	private void handleaddEtat(ActionEvent event) {

	}

	@FXML
	private void handlemodEtat(ActionEvent event) {

	}

	@FXML
	private void handlesuppEtat(ActionEvent event) {

	}

	@FXML
	private void handleaddFabr(ActionEvent event) {
		Fabricant fabricant = new Fabricant(0, null, null, null);
		boolean okClicked = MainApp.showAddFabrDialog(fabricant);
		if (okClicked) {

		}
	}

	@FXML
	private void handlemodFabr(ActionEvent event) {
		boolean okClicked = MainApp.showModFabrDialog();
		if (okClicked) {

		}
	}

	@FXML
	private void handlesuppFabr(ActionEvent event) {
		boolean okClicked = MainApp.showSuppFabrDialog();
		if (okClicked) {

		}
	}

	@FXML
	private void handleaddFact(ActionEvent event) {
		Facture facture = new Facture(null, null, 0, null);
		boolean okClicked = MainApp.showAddFactDialog(facture);
		if (okClicked) {

		}
	}

	@FXML
	private void handlemodFact(ActionEvent event) {
		boolean okClicked = MainApp.showModFactDialog();
		if (okClicked) {

		}
	}

	@FXML
	private void handlesuppFact(ActionEvent event) {
		boolean okClicked = MainApp.showSuppFactDialog();
		if (okClicked) {

		}
	}

	@FXML
	private void handleaddLog(ActionEvent event) {
		Logiciel logiciel = new Logiciel(0, null, null, null, null);
		boolean okClicked = MainApp.showAddLogDialog(logiciel);
		if (okClicked) {

		}
	}

	@FXML
	private void handlemodLog(ActionEvent event) {
		boolean okClicked = MainApp.showModLogDialog();
		if (okClicked) {

		}
	}

	@FXML
	private void handlesuppLog(ActionEvent event) {
		boolean okClicked = MainApp.showSuppLogDialog();
		if (okClicked) {

		}
	}

	@FXML
	private void handleaddMaint(ActionEvent event) {
		Maintenance maintenance = new Maintenance(0, null, null, null, 0);
		boolean okClicked = MainApp.showAddMaintDialog(maintenance);
		if (okClicked) {

		}
	}

	@FXML
	private void handlemodMaint(ActionEvent event) {
		boolean okClicked = MainApp.showModMaintDialog();
		if (okClicked) {

		}
	}

	@FXML
	private void handlesuppMaint(ActionEvent event) {
		boolean okClicked = MainApp.showSuppMaintDialog();
		if (okClicked) {

		}
	}

	@FXML
	private void handleaddMat(ActionEvent event) {

	}

	@FXML
	private void handlemodMat(ActionEvent event) {

	}

	@FXML
	private void handlesuppMat(ActionEvent event) {

	}

	@FXML
	private void handleaddPrest(ActionEvent event) {

	}

	@FXML
	private void handlemodPrest(ActionEvent event) {

	}

	@FXML
	private void handlesuppPrest(ActionEvent event) {

	}

	@FXML
	private void handleaddRev(ActionEvent event) {

	}

	@FXML
	private void handlemodRev(ActionEvent event) {

	}

	@FXML
	private void handlesuppRev(ActionEvent event) {

	}

	@FXML
	private void handleaddSite(ActionEvent event) {
		Site site = new Site(0, null, null);
		boolean okClicked = MainApp.showAddSiteDialog(site);
		if (okClicked) {

		}

	}

	@FXML
	private void handlemodSite(ActionEvent event) {
		boolean okClicked = MainApp.showModSiteDialog();
		if (okClicked) {

		}
	}

	@FXML
	private void handlesuppSite(ActionEvent event) {
		boolean okClicked = MainApp.showSuppSiteDialog();
		if (okClicked) {

		}

	}

	@FXML
	private void handleaddType(ActionEvent event) {
		Type type = new Type(null, null);
		boolean okClicked = MainApp.showAddTypeDialog(type);
		if (okClicked) {

		}
	}

	@FXML
	private void handlemodType(ActionEvent event) {
		boolean okClicked = MainApp.showModTypeDialog();
		if (okClicked) {

		}
	}

	@FXML
	private void handlesuppType(ActionEvent event) {
		boolean okClicked = MainApp.showSuppTypeDialog();
		if (okClicked) {

		}
	}

	@FXML
	private void handleaddUser(ActionEvent event) {

	}

	@FXML
	private void handlemodUser(ActionEvent event) {

	}

	@FXML
	private void handlesuppUser(ActionEvent event) {

	}

	@FXML
	private void handleaddUse(ActionEvent event) {

	}

	@FXML
	private void handlemodUse(ActionEvent event) {

	}

	@FXML
	private void handlesuppUse(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	private void handleChoose(ActionEvent event) {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Open directory");
		File selectedDirectory = directoryChooser.showDialog(null);

		if (selectedDirectory != null) {
		}

	}
}
