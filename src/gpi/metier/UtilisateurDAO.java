package gpi.metier;

import java.sql.Connection;
import java.sql.PreparedStatement;

import utils.MaConnexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;

public class UtilisateurDAO {

	public UtilisateurDAO() {
	}

	public void ajouterUtilisateur(Utilisateur utilisateur) {
		Connection connexion=MaConnexion.getInstance().getConnexion();
		int resultat;
		try {
			PreparedStatement ps=connexion.prepareStatement("INSERT INTO UTILISATEUR (nomUtilisateur,prenomUtilisateur,telUtilisateur) "
					+ "VALUES (?,?,?)");
			ps.setString(1,utilisateur.getNomUtilisateur().getValue());
			ps.setString(2,utilisateur.getPrenomUtilisateur().getValue());
			ps.setString(3, utilisateur.getTelUtilisateur().getValue());
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

	public void modifierUtilisateur(Utilisateur utilisateur) {
		Connection connexion=MaConnexion.getInstance().getConnexion();
		try {
			PreparedStatement ps=connexion.prepareStatement("UPDATE UTILISATEUR SET nomUtilisateur=?,prenomUtilisateur=?,telUtilisateur=? "
					+ "WHERE idUtilisateur=?");
			ps.setString(1,utilisateur.getNomUtilisateur().getValue());
			ps.setString(2,utilisateur.getPrenomUtilisateur().getValue());
			ps.setString(3,utilisateur.getTelUtilisateur().getValue());
			ps.setInt(4,utilisateur.getIdUtilisateur().getValue());
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
		
	public boolean supprimerUtilisateur(Utilisateur utilisateur) 
	{
		Connection connexion=MaConnexion.getInstance().getConnexion();
		try {
			PreparedStatement ps=connexion.prepareStatement("DELETE FROM UTILISATEUR WHERE idUtilisateur=?");
			ps.setInt(1,utilisateur.getIdUtilisateur().getValue());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally
		{
			try
			{
				connexion.close();
			}
			catch(SQLException se)
			{
				return false;
			}
		}
		return true;
	}

	public Utilisateur recupererUtilisateurParId(int idUtilisateur) {
		Connection connexion=MaConnexion.getInstance().getConnexion();
		Utilisateur utilisateurARetourner=null;
		try {
			PreparedStatement ps=connexion.prepareStatement("SELECT * FROM UTILISATEUR WHERE idUtilisateur=?");
			ps.setInt(1,idUtilisateur);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				utilisateurARetourner=new Utilisateur(new SimpleIntegerProperty(rs.getInt("idUtilisateur")),
						rs.getString("nomUtilisateur"),
						rs.getString("prenomUtilisateur"),
						rs.getString("telUtilisateur"));
				
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
		return utilisateurARetourner;
	}


	public List<Utilisateur> recupererUtilisateurParNom(String nomUtilisateur) {
		Connection connexion=MaConnexion.getInstance().getConnexion();
		List<Utilisateur> list = null;
		try {
			PreparedStatement ps=connexion.prepareStatement("SELECT * FROM UTILISATEUR WHERE nomUtilisateur=?");
			ps.setString(1,nomUtilisateur);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				list=new ArrayList<Utilisateur>();
				list.add(new Utilisateur(new SimpleIntegerProperty(rs.getInt("idUtilisateur")),
						rs.getString("nomUtilisateur"),
						rs.getString("prenomUtilisateur"),
						rs.getString("telUtilisateur")));
				
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
		return list;
	}
		
		
			
		
		/*
		Connection connection = null;
		List<Utilisateur> list = null; 
		ResultSet resultat;
		String prenomUtilisateur, telUtilisateur;
		int idUtilisateur;
		try {
			connection = MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection
					.prepareStatement("SELECT * FROM UTILISATEUR WHERE nomUtilisateur=?;");

			prep.setString(1,nomUtilisateur);

			resultat = prep.executeQuery();
		idUtilisateur = resultat.getInt(1);
			prenomUtilisateur = resultat.getString(2);
			telUtilisateur = resultat.getString(3);

			while (resultat.next()){
				list=new ArrayList<Utilisateur>();
				list.add(new Utilisateur(new SimpleIntegerProperty(resultat.getInt("idUtilisateur")),
						resultat.getString("nomUtilisateur"),
						resultat.getString("prenomUtilisateur"),
						resultat.getString("telUtilisateur")));
				//list.add(new Utilisateur(new SimpleIntegerProperty(idUtilisateur), nomUtilisateur, prenomUtilisateur, telUtilisateur));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
*/
	public List<Utilisateur> recupererAllUtilisateur() {
		Connection connexion=MaConnexion.getInstance().getConnexion();
		List<Utilisateur> listeUtilisateur=new ArrayList<>();
		try {
			PreparedStatement ps=connexion.prepareStatement("SELECT * FROM UTILISATEUR");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				listeUtilisateur.add(new Utilisateur(new SimpleIntegerProperty(rs.getInt("idUtilisateur")),
						rs.getString("nomUtilisateur"),
						rs.getString("prenomUtilisateur"),
						rs.getString("telUtilisateur")));
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
		return listeUtilisateur;
	}

}
