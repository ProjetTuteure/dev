package gpi;

import java.util.ArrayList;
import java.util.List;

public class GestionDonneesOnglet {
	private List<Object> donnees;
	
	public GestionDonneesOnglet()
	{
		this.donnees=new ArrayList<>();
	}
	
	public void setDonnees(List<Object> donnees)
	{
		this.donnees=donnees;
	}
	
	public void ajouterDonnees(Object o)
	{
		this.donnees.add(o);
	}
}
