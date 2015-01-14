package gpi.metier;

import javafx.beans.property.SimpleIntegerProperty;
import utils.MaConnexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julien on 14/01/2015.
 */
public class FabricantDAO {
    private Connection connection;

    public int ajouterFabricant(Fabricant fabricant){
        int nombreLigneAffectee=0;
        try {
            connection= MaConnexion.getInstance().getConnexion();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO FABRICANT (nomFabricant,telFabricant,adresseFabricant) VALUES(?,?,?)");
            preparedStatement.setString(1,fabricant.getNomFabricantString());
            preparedStatement.setString(2,fabricant.getTelFabricant().getValue());
            preparedStatement.setString(3,fabricant.getAdresseFabricant().getValue());

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

    public int modifierFabricant(Fabricant fabricant){
        int nombreLigneAffectee=0;
        try {
            connection=MaConnexion.getInstance().getConnexion();
            PreparedStatement preparedStatement =connection.prepareStatement("UPDATE FABRICANT SET nomFabricant=?,telFabricant=?,adresseFabricant=? WHERE idFabricant=?");
            preparedStatement.setString(1, fabricant.getNomFabricantString());
            preparedStatement.setString(2, fabricant.getTelFabricant().getValue());
            preparedStatement.setString(3, fabricant.getAdresseFabricant().getValue());
            preparedStatement.setInt(4, fabricant.getIdFabricant().getValue());
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

    public int supprimerFabricant(Fabricant fabricant){
        int nombreLigneAffectee=0;
        try{
            connection=MaConnexion.getInstance().getConnexion();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM FABRICANT WHERE idFabricant=?;");

            preparedStatement.setInt(1, fabricant.getIdFabricant().getValue());

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

    public List<Fabricant> recupererAllFabricant(){
        List<Fabricant> fabricantList= new ArrayList<Fabricant>();
        ResultSet resultat;
        try{
            connection= MaConnexion.getInstance().getConnexion();
            Statement statement = connection.createStatement();
            resultat=statement.executeQuery("SELECT * FROM FABRICANT");
            while(resultat.next()){
                fabricantList.add(new Fabricant(resultat.getInt("idFabricant"),resultat.getString("nomFabricant"),resultat.getString("telFabricant"),resultat.getString("adresseFabricant")));
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
        return fabricantList;
    }

    public Fabricant recupererFabricantParId(int idFabricant){
        ResultSet resultat;
        Fabricant fabricant=null;
        try{
            connection=MaConnexion.getInstance().getConnexion();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM FABRICANT WHERE idFabricant=?;");
            preparedStatement.setInt(1, idFabricant);
            resultat=preparedStatement.executeQuery();
            resultat.next();
            fabricant=new Fabricant(idFabricant,resultat.getString("nomFabricant"),resultat.getString("telFabricant"),resultat.getString("adresseFabricant"));
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return fabricant;
    }

}
