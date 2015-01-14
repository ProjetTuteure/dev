package gpi.metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import utils.MaConnexion;

public class ComposantDAO {

	public ComposantDAO(){}
	

	public int ajouterComposant(Composant composant){
		Connection connexion = MaConnexion.getInstance().getConnexion();
		int resultat;
		try{
			connexion=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connexion.prepareStatement("INSERT INTO SITE VALUES (?,?,?,?);");
			
			prep.setInt(1, composant.getIdComposant() );
			prep.setString(2, composant.getNomComposant());
			prep.setString(3, composant.getcaracteristiqueComposant());
			prep.setInt(4, composant.getFabricantComposant().getIdFabricant().getValue() );
			
			resultat = prep.executeUpdate();
			return resultat;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				connexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int suprimerComposant(Composant composant){
		
		Connection connexion = MaConnexion.getInstance().getConnexion();
		int resultat;
		try{
			connexion=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connexion.prepareStatement("DELETE FROM COMPOSANT WHERE idComposant = ?;");
			
			prep.setInt(1, composant.getIdComposant() );
			resultat = prep.executeUpdate();
			return resultat;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				connexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int  modifierComposant(Composant composant){
		Connection connexion = MaConnexion.getInstance().getConnexion();
		int resultat;
		try{
			connexion=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connexion.prepareStatement("UPDATE COMPOSANT SET nomComposant=?, caracteristiqueComposant=?, idFabricant=? WHERE idComposant=?");
			
			prep.setString(1, composant.getNomComposant());
			prep.setString(2, composant.getcaracteristiqueComposant());
			prep.setInt(3, composant.getFabricantComposant().getIdFabricant().getValue());
			prep.setInt(4,composant.getIdComposant());
			resultat = prep.executeUpdate();
			return resultat;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				connexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
		
	}
	
	/*public Composant recupererComposant(int idComposant){
		Connection connexion = MaConnexion.getInstance().getConnexion();
		int resultat;
		try{
			connexion=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connexion.prepareStatement("SELECT * from COMPOSANT WHERE idcomposant=?");
			
			prep.setInt(1, idComposant);
			resultat = prep.execute();
			resultMeta = resultat.getMetaData();
			while(resultat.next()){         
		       	for(int i = 1; i <= resultMeta.getColumnCount(); i++)
		       		System.out.println(resultat.getObject(i));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				connexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}*/
}
