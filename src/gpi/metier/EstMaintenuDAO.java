package gpi.metier;

import gpi.exception.ConnexionBDException;
import utils.MaConnexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julien on 15/01/2015.
 */
public class EstMaintenuDAO {
    private Connection connection;
    public int ajouterEstMaintenu(EstMaintenu estMaintenu) throws ConnexionBDException {
        int nombreLigneAffectee=0;
        try {
            connection= MaConnexion.getInstance().getConnexion();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ESTMAINTENU (idMaintenance,idMateriel) VALUES(?,?)");
            preparedStatement.setInt(1,estMaintenu.getIdMaintenanceEstMaintenu());
            preparedStatement.setInt(2,estMaintenu.getIdMaterielEstMaintenu());

            nombreLigneAffectee=preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nombreLigneAffectee;
    }

    public int supprimerEstMaintenu(EstMaintenu estMaintenu) throws ConnexionBDException{
        Connection connection=null;
        int nombreLigneAffectee=0;
        try{
            connection=MaConnexion.getInstance().getConnexion();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ESTMAINTENU WHERE idMaintenance=? AND idMateriel=?;");

            preparedStatement.setInt(1, estMaintenu.getIdMaintenanceEstMaintenu());
            preparedStatement.setInt(2, estMaintenu.getIdMaterielEstMaintenu());

            nombreLigneAffectee=preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return nombreLigneAffectee;
    }

    public List<EstMaintenu> recupererAllFabricant() throws ConnexionBDException{
        List<EstMaintenu> estMaintenuList= new ArrayList<EstMaintenu>();
        ResultSet resultat;
        try{
            connection= MaConnexion.getInstance().getConnexion();
            Statement statement = connection.createStatement();
            resultat=statement.executeQuery("SELECT * FROM ESTMAINTENU");
            while(resultat.next()){
                MaintenanceDAO maintenanceDAO=new MaintenanceDAO();
                MaterielDAO materielDAO=new MaterielDAO();
                Maintenance maintenance=null;
                Materiel materiel=null;
                estMaintenuList.add(new EstMaintenu(maintenance,materiel));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return estMaintenuList;
    }

    public EstMaintenu recupererFabricantParId(int idMaintenance,int idMateriel) throws ConnexionBDException{
        ResultSet resultat;
        EstMaintenu estMaintenu=null;
        try{
            connection=MaConnexion.getInstance().getConnexion();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ESTMAINTENU WHERE idMaintenance=? AND idMateriel=?;");
            preparedStatement.setInt(1, idMaintenance);
            preparedStatement.setInt(1, idMateriel);
            resultat=preparedStatement.executeQuery();
            resultat.next();
            MaintenanceDAO maintenanceDAO=new MaintenanceDAO();
            MaterielDAO materielDAO=new MaterielDAO();
            Maintenance maintenance=null;
            Materiel materiel=null;
            estMaintenu=new EstMaintenu(maintenance,materiel);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return estMaintenu;
    }
}
