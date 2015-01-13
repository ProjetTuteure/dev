package gpi.metier;

import java.sql.Connection;

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
	 * Permet d'ajouter un mat�riel dans la base de donn�es
	 * @param materiel le mat�riel � ajouter dans la base de donn�es
	 */
	public void ajouterMateriel(Materiel materiel)
	{
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
}
