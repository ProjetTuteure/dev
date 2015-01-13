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
	
	public void ajouterMateriel(Materiel materiel)
	{
		String requete="INSERT INTO MATERIEL (numImmobMateriel, VALUES("+materiel.getNumImmobMateriel()+","
	}
}
