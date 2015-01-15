package gpi.metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleIntegerProperty;
import utils.MaConnexion;
import gpi.exception.ConnexionBDException;

public class MaintenanceDAO {
	public MaintenanceDAO()
	{}
	
	/**
	 * Permet d'insérer une maintenance dans la BD
	 * @param maintenance la maintenance à insérer dans la BD
	 */
	public void ajouterMaintenance(Maintenance maintenance) throws ConnexionBDException
	{
		Connection connexion=MaConnexion.getInstance().getConnexion();
		try {
			PreparedStatement ps=connexion.prepareStatement("INSERT INTO MAINTENANCE (dateMaintenance,objetMaintenance,descriptionMaintenance,coutMaintenance) "
					+ "VALUES (?,?,?,?)");
			ps.setString(1,maintenance.getdateMaintenanceStringProperty().getValue());
			ps.setString(2,maintenance.getObjetMaintenance());
			ps.setString(3,maintenance.getDescriptionMaintenance());
			ps.setFloat(4,maintenance.getCoutMaintenance());
			ps.executeUpdate();
		} catch (SQLException e) {
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
	
	public List<Maintenance> recupererAllMaintenance() throws ConnexionBDException
	{
		List<Maintenance> listeARetourner=new ArrayList<Maintenance>();
		Connection connexion=MaConnexion.getInstance().getConnexion();
		try {
			PreparedStatement ps=connexion.prepareStatement("SELECT * FROM MAINTENANCE");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				listeARetourner.add(new Maintenance(rs.getInt("idMaintenance"),
						LocalDate.parse(rs.getString("dateMaintenance")),
						rs.getString("objetMaintenance"),
						rs.getString("descriptionMaintenance"),
						rs.getFloat("coutMaintenance")
						));
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
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listeARetourner;
	}
	
	public void modifierMaintenance(Maintenance maintenance) throws ConnexionBDException
	{
		Connection connexion=MaConnexion.getInstance().getConnexion();
		try {
			PreparedStatement ps=connexion.prepareStatement("UPDATE MAINTENANCE SET dateMaintenance=?,"
					+ "objetMaintenance=?,"
					+ "descriptionMaintenance=?,"
					+ "coutMaintenance=?"
					+ "WHERE idMaintenance=?");
			ps.setString(1,maintenance.getdateMaintenanceStringProperty().getValue());
			ps.setString(2,maintenance.getObjetMaintenance());
			ps.setString(3, maintenance.getDescriptionMaintenance());
			ps.setFloat(4,maintenance.getCoutMaintenance());
			ps.setInt(5,maintenance.getIdMaintenance().getValue());
			ps.execute();
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
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void supprimerMaintenance(Maintenance maintenance) throws ConnexionBDException
	{
		Connection connexion=MaConnexion.getInstance().getConnexion();
		try {
			PreparedStatement ps=connexion.prepareStatement("DELETE FROM MAINTENANCE WHERE idMaintenance=?");
			ps.setInt(1,maintenance.getIdMaintenance().getValue());
			ps.execute();
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
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
