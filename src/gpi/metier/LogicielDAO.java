package gpi.metier;

import gpi.exception.ConnexionBDException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import utils.MaConnexion;

public class LogicielDAO {

	
	public LogicielDAO(){}
	
	public int ajouterLogiciel(Logiciel logiciel) throws ConnexionBDException{
		Connection connection=null;
		int resultat;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection.prepareStatement("INSERT INTO LOGICIEL(nomLogiciel,versionLogiciel,dateExpirationGarantie,factureLogiciel) VALUES (?,?,?,?);");
			prep.setString(1, logiciel.getNomLogiciel().getValue());
			prep.setString(2, logiciel.getVersionLogiciel().getValue());
			prep.setString(3, logiciel.getDateExpirationLogiciel().toString());
			prep.setInt(4, logiciel.getFactureLogiciel().getIdFacture().getValue());
			
			resultat=prep.executeUpdate();
			return resultat;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	
	public int modifierLogiciel(Logiciel logiciel) throws ConnexionBDException{
		Connection connection=null;
		int resultat;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection.prepareStatement("UPDATE LOGICIEL SET nomLogiciel=?, versionLogiciel=?, dateExpirationGarantie=?, factureLogiciel=? WHERE idLogiciel=? ;");
			prep.setString(1, logiciel.getNomLogiciel().getValue());
			prep.setString(2, logiciel.getVersionLogiciel().getValue());
			prep.setString(3, logiciel.getDateExpirationLogiciel().toString());
			prep.setInt(4, logiciel.getFactureLogiciel().getIdFacture().getValue());
			prep.setInt(5, logiciel.getIdLogiciel().getValue());
			
			resultat=prep.executeUpdate();
			return resultat;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int supprimerLogiciel(Logiciel logiciel) throws ConnexionBDException{
		Connection connection=null;
		int resultat;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection.prepareStatement("DELETE FROM LOGICIEL WHERE idLogiciel=?;");
			
			prep.setInt(1, logiciel.getIdLogiciel().getValue());
			
			resultat=prep.executeUpdate();
			return resultat;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public Logiciel recupererLogicielParId(int idLogiciel) throws ConnexionBDException{
		Connection connection=null;
		ResultSet resultat;
		LocalDate dateExpirationGarantie;
		String nomLogiciel,versionLogiciel;
		int idFacture;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			FactureDAO factureDAO=new FactureDAO();
			PreparedStatement prep = connection.prepareStatement("SELECT * FROM LOGICIEL WHERE idLogiciel=?;");
		
			prep.setInt(1, idLogiciel);
			
			resultat=prep.executeQuery();
			nomLogiciel=resultat.getString("nomLogiciel");
			versionLogiciel=resultat.getString("versionLogiciel");
			dateExpirationGarantie=LocalDate.parse(resultat.getString("dateExpirationGarantie"));
			idFacture=resultat.getInt("factureLogiciel");
		
			return new Logiciel(idLogiciel,nomLogiciel,versionLogiciel,dateExpirationGarantie,factureDAO.recupererFactureParId(idFacture));
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
		
	public List<Logiciel> recupererAllLogiciel() throws ConnexionBDException{
		Connection connection=null;
		FactureDAO factureDAO=new FactureDAO();
		List<Logiciel> listLogiciel=new ArrayList<Logiciel>();
		ResultSet resultat;
		LocalDate dateExpirationGarantie;
		String nomLogiciel,versionLogiciel;
		int idFacture,idLogiciel;
		Logiciel logiciel;
		try{
			connection=MaConnexion.getInstance().getConnexion();
			PreparedStatement prep = connection.prepareStatement("SELECT * FROM LOGICIEL;");
			
			
			resultat=prep.executeQuery();
			while(resultat.next()){
				idLogiciel=resultat.getInt("idLogiciel");
				nomLogiciel=resultat.getString("nomLogiciel");
				versionLogiciel=resultat.getString("versionLogiciel");
				dateExpirationGarantie=LocalDate.parse(resultat.getString("dateExpirationGarantie"));
				idFacture=resultat.getInt("factureLogiciel");
				logiciel=new Logiciel(idLogiciel,nomLogiciel,versionLogiciel,dateExpirationGarantie,factureDAO.recupererFactureParId(idFacture));
				listLogiciel.add(logiciel);
			}
			return listLogiciel;
			}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}


