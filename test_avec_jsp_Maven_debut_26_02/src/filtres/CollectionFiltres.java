package filtres;

import java.util.ArrayList;
import filtres.ContaineurFiltre;

public class CollectionFiltres {
	
	protected ArrayList <ContaineurFiltre> cf;
	protected String nom;

	
	public CollectionFiltres (String nom) {
		
		this.nom=nom;
		this.cf = new ArrayList <ContaineurFiltre>();
	}
	
	public void addDansLaCollection (ContaineurFiltre cfiltre1) {
		this.cf.add(cfiltre1);
		
	}

	public ArrayList<ContaineurFiltre> getCf() {
		return cf;
	}

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "CollectionFiltres [cf=" + cf + ", nom=" + nom + "]";
	}
	
}
