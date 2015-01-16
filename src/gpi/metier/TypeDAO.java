package gpi.metier;

import gpi.exception.ConnexionBDException;
import utils.MaConnexion;

import java.sql.*;
import java.util.*;

/**
 * Created by Julien on 13/01/2015.
 */
public class TypeDAO {

    private Connection connection;

    public int ajouterType(Type type) throws ConnexionBDException {
        int nombreLigneAffectee=0;
        try {
            connection=MaConnexion.getInstance().getConnexion();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO TYPE (nomType, cheminImageType) VALUES(?,?)");

            preparedStatement.setString(1,type.getNomTypeString());
            preparedStatement.setString(2,type.getCheminImageType().getValue());

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

    public int modifierType(Type type) throws ConnexionBDException {
        int nombreLigneAffectee=0;
        try {
            connection=MaConnexion.getInstance().getConnexion();
            PreparedStatement preparedStatement =connection.prepareStatement("UPDATE TYPE SET nomType=?,cheminImageType=? WHERE idType=?");
            preparedStatement.setString(1, type.getNomTypeString());
            preparedStatement.setString(2, type.getCheminImageType().getValue());
            preparedStatement.setInt(3, type.getIdType());
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

    public int supprimerType(Type type) throws ConnexionBDException {
        int nombreLigneAffectee=0;
        try{
            connection=MaConnexion.getInstance().getConnexion();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM TYPE WHERE idType=?;");

            preparedStatement.setInt(1, type.getIdType());

            nombreLigneAffectee=preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return nombreLigneAffectee;
    }

    public List<Type> recupererAllType() throws ConnexionBDException {
        List<Type> typeList= new ArrayList<Type>();
        ResultSet resultat;
        try{
            connection= MaConnexion.getInstance().getConnexion();
            Statement statement = connection.createStatement();
            resultat=statement.executeQuery("SELECT * FROM TYPE");
            while(resultat.next()) {
                typeList.add(new Type(resultat.getInt("idType"),resultat.getString("nomType"),resultat.getString("cheminImageType")));
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
        return typeList;
    }

    public Type recupererTypeParId(int idType) throws ConnexionBDException {
        ResultSet resultat;
        Type type=null;
        try{
            connection=MaConnexion.getInstance().getConnexion();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM TYPE WHERE idType=?;");
            preparedStatement.setInt(1, idType);
            resultat=preparedStatement.executeQuery();
            resultat.next();
            type=new Type(idType,resultat.getString("nomType"),resultat.getString("cheminImageType"));
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return type;
    }



}
