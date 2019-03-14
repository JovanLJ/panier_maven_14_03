package filtres;

import java.util.ArrayList;
import java.util.List;

public class ContaineurFiltre {
	
	protected String nom;
	protected List <Filtre> listeFiltre;
	
	
	public ContaineurFiltre (String s) {
		
		this.nom=s;
		this.listeFiltre= new ArrayList <Filtre>();
	}

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public List<Filtre> getListeFiltre() {
		return listeFiltre;
	}


	public void setListeFiltre(List<Filtre> listeFiltre) {
		this.listeFiltre = listeFiltre;
	}
	
	public void addFiltre (Filtre f) {
		this.listeFiltre.add(f);
	}
	

}
