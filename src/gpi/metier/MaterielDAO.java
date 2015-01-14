package gpi.metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.MaConnexion;

public class MaterielDAO {
	/**
	 * Constructeur materielDAO
	 * @param connexion
	 */
	public MaterielDAO()
	{
	}
	
	/**
	 * Permet d'ajouter un mat�riel dans la base de donn�es
	 * @param materiel le mat�riel � ajouter dans la base de donn�es
	 */
	public void ajouterMateriel(Materiel materiel)
	{
		Connection connexion=MaConnexion.getInstance().getConnexion();
		try {
			PreparedStatement ps=connexion.prepareStatement("INSERT INTO MATERIEL (numImmobMateriel,nomMateriel,dateExpirationGarantieMateriel,"
					+ "repertoireDrivers,modeleMateriel,etat,idFacture,idFabricant,idSite,nomType) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,materiel.getNumImmobMateriel().getValue());
			ps.setString(2,materiel.getNomMateriel().getValue());
			ps.setString(3,materiel.getDateExpirationGarantie().toString());
			ps.setString(4,materiel.getRepertoireDriverMateriel().getValue());
			ps.setString(5,materiel.getModeleMateriel());
			ps.setString(6,materiel.getEtatMateriel().toString());
			ps.setString(7,materiel.getFactureMateriel().getNumFacture());
			ps.setInt(8,materiel.getFabricantMateriel().getIdFabricant().getValue());
			ps.setInt(9,materiel.getSiteMateriel().getIdSiteProperty().getValue());
			ps.setString(10,materiel.getTypeMateriel().getNomType().getValue());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				connexion.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void modifierMateriel(Materiel materiel)
	{
		Connection connexion=MaConnexion.getInstance().getConnexion();
		try {
			PreparedStatement ps=connexion.prepareStatement("UPDATE MATERIEL SET numImmobMateriel,nomMateriel,dateExpirationGarantieMateriel,"
					+ "repertoireDrivers,modeleMateriel,etat,idFacture,idFabricant,idSite,nomType  "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?) WHERE idMateriel=?");
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
