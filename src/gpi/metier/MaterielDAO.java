package gpi.metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaterielDAO {
	private Connection connexion;
	/**
	 * Constructeur materielDAO
	 * @param connexion
	 */
	public MaterielDAO(Connection connexion)
	{
		this.connexion=connexion;
	}
	
	/**
	 * Permet d'ajouter un matériel dans la base de données
	 * @param materiel le matériel à ajouter dans la base de données
	 */
	public void ajouterMateriel(Materiel materiel)
	{
		try {
			PreparedStatement ps=connexion.prepareStatement("INSERT INTO MATERIEL (numImmobMateriel,nomMateriel,dateExpirationGarantieMateriel,"
					+ "repertoireDriver,modeleMateriel,etat,idFacture,idFabricant,idSite,nomType) "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,materiel.getNumImmobMateriel().getValue());
			ps.setString(2,materiel.getNomMateriel().getValue());
			ps.setString(3,materiel.getDateExpirationGarantie().toString());
			ps.setString(4,materiel.getRepertoireDriverMateriel().getValue());
			ps.setString(5,materiel.getModeleMateriel());
			ps.setString(6,materiel.getEtatMateriel().toString());
			ps.setString(7,materiel.getFactureMateriel().getNumFacture());
			ps.setString(8,materiel.getFabricantMateriel().getIdFabricant().toString());
			ps.setString(9,materiel.getSiteMateriel().getIdSiteProperty().toString());
			ps.setString(10,materiel.getTypeMateriel().getNomType().getValue());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String requete="INSERT INTO MATERIEL (numImmobMateriel,nomMateriel,dateExpirationGarantieMateriel,"
				+ "repertoireDriver,modeleMateriel,etat,idFacture,idFabricant,idSite,nomType) "
				+ "VALUES("+materiel.getNumImmobMateriel()+","+materiel.getNomMateriel()+","
				+ materiel.getDateExpirationGarantieMaterielStringProperty().getValue()+","
				+ materiel.getRepertoireDriverMateriel().getValue()+","
				+ materiel.getModeleMateriel()+","
				+ materiel.getEtatMaterielString()+","
				+ materiel.getFactureMateriel().getNumFacture()+","
				+ materiel.getFabricantMateriel().getIdFabricant()+","
				+ materiel.getSiteMateriel().getIdSite()+","
				+ materiel.getTypeMateriel().getNomTypeString()
				+")";
	}
	
	public void modifierMateriel(Materiel materiel)
	{
		String requete="UPDATE MATERIEL";
	}
}
