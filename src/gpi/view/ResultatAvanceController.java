package gpi.view;

import gpi.MainApp;
import gpi.bd.Donnee;
import gpi.metier.Materiel;
import gpi.metier.Utilise;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Julien on 13/12/2014.
 */
public class ResultatAvanceController implements Initializable {
    private boolean test=false;
    private Donnee donnee=new Donnee();
    private List<Materiel> materielObservableList;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yy");

    @FXML
    private ListView<Materiel> listMateriel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        materielObservableList=donnee.getMaterielData();
        for(Materiel materiel:materielObservableList){
            List<Utilise> utilises=donnee.getUtiliseData();

            boolean estUtilise=false;
            for(Utilise utilise :utilises){
                if(utilise.getUtilisateur().getNomUti().getValue().equals(MainApp.getCritere(5))&&
                        utilise.getMateriel().equals(materiel)
                        ){
                    estUtilise=true;
                }
            }

            //Pour connaitre l'ancienneté
            boolean estContenu=false;
            GregorianCalendar calendar = new java.util.GregorianCalendar();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String dateInString = materiel.getFacture().getDateFac().getValue();
            Date date=null;
            try {

                date = formatter.parse(dateInString);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(MainApp.getCritere(3).equals("moins d'un ans") || MainApp.getCritere(3).equals("")){
                calendar.setTime(new Date());
                calendar.add(Calendar.YEAR,-1);
                if(calendar.getTime().before(date)){
                    estContenu=true;
                }
            }
            if(MainApp.getCritere(3).equals("moins de deux ans")|| MainApp.getCritere(3).equals("")){
                calendar.setTime(new Date());
                calendar.add(Calendar.YEAR,-2);
                if(calendar.getTime().before(date)){
                    estContenu=true;
                }
            }
            if(MainApp.getCritere(3).equals("moins de trois ans")|| MainApp.getCritere(3).equals("")){
                calendar.setTime(new Date());
                calendar.add(Calendar.YEAR, -3);
                if(calendar.getTime().before(date)){
                    estContenu=true;
                }
            }
            if(MainApp.getCritere(3).equals("moins de quattre ans")|| MainApp.getCritere(3).equals("")){
                calendar.setTime(new Date());
                calendar.add(Calendar.YEAR,-4);
                if(calendar.getTime().before(date)){
                    estContenu=true;
                }
            }
            if(MainApp.getCritere(3).equals("moins de cinq ans")|| MainApp.getCritere(3).equals("")){
                calendar.setTime(new Date());
                calendar.add(Calendar.YEAR,-5);
                if(calendar.getTime().before(date)){
                    estContenu=true;
                }
            }
            if(MainApp.getCritere(3).equals("moins de six ans")|| MainApp.getCritere(3).equals("")){
                calendar.setTime(new Date());
                calendar.add(Calendar.YEAR,-6);
                if(calendar.getTime().before(date)){
                    estContenu=true;
                }
            }
            if(MainApp.getCritere(3).equals("moins de sept ans")|| MainApp.getCritere(3).equals("")){
                calendar.setTime(new Date());
                calendar.add(Calendar.YEAR,-7);
                if(calendar.getTime().before(date)){
                    estContenu=true;
                }
            }
            if(MainApp.getCritere(3).equals("plus de sept ans")|| MainApp.getCritere(3).equals("")){
                calendar.setTime(new Date());
                calendar.add(Calendar.YEAR,-7);
                if(calendar.getTime().after(date)){
                    estContenu=true;
                }
            }


            if((materiel.getNumImmobMat().getValue().equals(MainApp.getCritere(0)) || MainApp.getCritere(0).equals("")) &&
                    (materiel.getNom().getValue().equals(MainApp.getCritere(1)) || MainApp.getCritere(1).equals("")) &&
                    (materiel.getSite().getNomSte().equals(MainApp.getCritere(2)) || MainApp.getCritere(2)==null) &&
                    (estContenu || MainApp.getCritere(3).equals("")) &&
                    (materiel.getType().getNom().getValue().equals(MainApp.getCritere(4)) || MainApp.getCritere(4)==null) &&
                    (estUtilise || MainApp.getCritere(5).equals("") )&&
                    (materiel.getFacture().getDateFac().getValue().equals(MainApp.getCritere(6)) || MainApp.getCritere(6).equals("")) &&
                    (materiel.getFacture().getNumFac().equals(MainApp.getCritere(7)) || MainApp.getCritere(7).equals("")) &&
                    (materiel.getFacture().getRevendeur().getNomRev().getValue().equals(MainApp.getCritere(8)) || MainApp.getCritere(8).equals("")) &&
                    (materiel.getFabricant().getNomFab().getValue().equals(MainApp.getCritere(9)) || MainApp.getCritere(9).equals("")) &&
                    (materiel.getModele().equals(MainApp.getCritere(10)) || MainApp.getCritere(10).equals(""))
                    ){
                listMateriel.getItems().add(materiel);
            }
        }


        listMateriel.setOnMouseClicked((event)->{
            MainApp.setCritere(listMateriel.getFocusModel().getFocusedItem());
            MainApp.changerTab("DetailMachine");
        });
    }

    @FXML
    private void goToScreen1(ActionEvent event) {
        MainApp.removeCriteres();
        MainApp.changerTab("Avance");
    }
}
