package utils;

public class UtilisateursDetailsMachine{
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private String telUtilisateur;
	private String dateDebutUtilisation;
	private String dateFinUtilisation;
	
	public UtilisateursDetailsMachine(String nomUtilisateur, String prenomUtilisateur, String telUtilisateur, String dateDebutUtilisation, String dateFinUtilisation){
		this.nomUtilisateur=nomUtilisateur;
		this.prenomUtilisateur=prenomUtilisateur;
		this.telUtilisateur=telUtilisateur;
		this.dateDebutUtilisation=dateDebutUtilisation;
		this.dateFinUtilisation=dateFinUtilisation;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getTelUtilisateur() {
		return telUtilisateur;
	}

	public void setTelUtilisateur(String telUtilisateur) {
		this.telUtilisateur = telUtilisateur;
	}

	public String getDateDebutUtilisation() {
		return dateDebutUtilisation;
	}

	public void setDateDebutUtilisation(String dateDebutUtilisation) {
		this.dateDebutUtilisation = dateDebutUtilisation;
	}

	public String getDateFinUtilisation() {
		return dateFinUtilisation;
	}

	public void setDateFinUtilisation(String dateFinUtilisation) {
		this.dateFinUtilisation = dateFinUtilisation;
	}
}