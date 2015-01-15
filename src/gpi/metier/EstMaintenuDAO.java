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
}
