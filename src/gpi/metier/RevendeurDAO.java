package gpi.metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.MaConnexion;

public class RevendeurDAO {

	public RevendeurDAO()
	{}
	
	/**
	 * Permet d'ajouter un revendeur à la bd
	 * @param revendeur le revendeur à ajouter à la base de données
	 */
	public void ajouterRevendeur(Revendeur revendeur)
	{
		Connection connexion=MaConnexion.getInstance().getConnexion();
		try {
			PreparedStatement ps=connexion.prepareStatement("INSERT INTO REVENDEUR (nomRevendeur,telRevendeur,adresseRevendeur) "
					+ "VALUES (?,?,?)");
			ps.setString(1,revendeur.getNomRevendeur().getValue());
			ps.setString(2,revendeur.getTelRevendeur().getValue());
			ps.setString(3, revendeur.getAdresseRevendeur().getValue());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connexion.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
	}
	
	/**
	 * Permet de modifier un revendeur
	 * @param revendeur le revendeur à modifier
	 */
	public void modifierRevendeur(Revendeur revendeur)
	{
		Connection connexion=MaConnexion.getInstance().getConnexion();
		try {
			PreparedStatement ps=connexion.prepareStatement("UPDATE REVENDEUR SET nomRevendeur=?,telRevendeur=?,adresseRevendeur=? "
					+ "WHERE idRevendeur=?");
			ps.setString(1,revendeur.getNomRevendeur().getValue());
			ps.setString(2,revendeur.getTelRevendeur().getValue());
			ps.setString(3, revendeur.getAdresseRevendeur().getValue());
			ps.setInt(4,revendeur.getIdRevendeur().getValue());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connexion.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
	}
	
	/**
	 * Permet de supprimer un revendeur
	 * @param revendeur le revendeur à supprimer
	 */
	public void supprimerRevendeur(Revendeur revendeur)
	{
		Connection connexion=MaConnexion.getInstance().getConnexion();
		try {
			PreparedStatement ps=connexion.prepareStatement("DELETE FROM REVENDEUR WHERE idRevendeur=?");
			ps.setInt(1,revendeur.getIdRevendeur().getValue());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connexion.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
	}
	
	public List<Revendeur> recupererAllRevendeur()
	{
		Connection connexion=MaConnexion.getInstance().getConnexion();
		List<Revendeur> listeRevendeur=new ArrayList<>();
		try {
			PreparedStatement ps=connexion.prepareStatement("SELECT * FROM REVENDEUR");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				listeRevendeur.add(new Revendeur(new SimpleIntegerProperty(rs.getInt("idRevendeur")),
						rs.getString("nomRevendeur"),
						rs.getString("telRevendeur"),
						rs.getString("adresseRevendeur")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connexion.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		return listeRevendeur;
	}
	
	/**
	 * Retourne un revendeur par son id
	 * @param idRevendeur l'id du revendeur à retourner
	 * @return revendeur le revendeur correspondant à l'id passé en paramètre
	 */
	public Revendeur recupererRevendeurParId(int idRevendeur)
	{
		Connection connexion=MaConnexion.getInstance().getConnexion();
		Revendeur revendeurARetourner=null;
		try {
			PreparedStatement ps=connexion.prepareStatement("SELECT * FROM REVENDEUR WHERE idRevendeur=?");
			ps.setInt(1,idRevendeur);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				revendeurARetourner=new Revendeur(new SimpleIntegerProperty(rs.getInt("idRevendeur")),
						rs.getString("nomRevendeur"),
						rs.getString("telRevendeur"),
						rs.getString("adresseRevendeur"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				connexion.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		return revendeurARetourner;
	}
}
