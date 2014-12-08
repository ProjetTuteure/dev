package gpi.view;

import gpi.metier.Site;

import java.awt.TextField;

import javafx.fxml.FXML;
import javafx.scene.control.Dialogs;
import javafx.stage.Stage;




public class addSiteDialogController {
	  @FXML
	    private TextField NameSiteField;
	  
	  private Stage dialogStage;
	    private Site site;
	    private boolean okClicked = false;

	 
	    @FXML
	    private void initialize() {

	    }

	  
	    public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }

	    
	    public void setPerson(Site site) {
	        this.site = site;

	        NameSiteField.setText(site.getNomSte());
	       
	    }

	 
	    public boolean isOkClicked() {
	        return okClicked;
	    }

	    
	    @FXML
	    private void handleOk() {
	        if (isInputValid()) {
	            site.setNomSte(NameSiteField.getText());
	     

	            okClicked = true;
	            dialogStage.close();
	        }
	    }

	    
	    @FXML
	    private void handleCancel() {
	        dialogStage.close();
	    }

	    
	    private boolean isInputValid() {
	        String errorMessage = "";

	        if (NameSiteField.getText() == null || NameSiteField.getText().length() == 0) {
	            errorMessage += "Nom de site invalide\n"; 
	        }
	       
	        if (errorMessage.length() == 0) {
	            return true;
	        } else {
	            // Show the error message
	            Dialogs.showErrorDialog(dialogStage, errorMessage,
	                    "Veuillez corriger le champ", "Champ invalide");
	            return false;
	        }
	    }
	}

