package gpi.metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.MaConnexion;

public class RevendeurDAO {

	public RevendeurDAO()
	{}
	
	public void ajouterRevendeur(Revendeur revendeur)
	{
		Connection connexion=MaConnexion.getInstance().getConnexion();
		try {
			PreparedStatement ps=connexion.prepareStatement("INSERT INTO REVENDEUR (nomRevendeur,telRevendeur,adresseRevendeur)"
					+ "VALUES ('?','?','?')");
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
}
