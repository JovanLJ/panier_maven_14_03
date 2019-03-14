package classes_metier;

public class Marque {

	protected  int id_marque;
	protected String nom_marque;
	
	public Marque (int id_marque, String nom_marque) {

		this.id_marque = id_marque;
		this.nom_marque = nom_marque;	
	}

	public  int getId_marque() {
		return  id_marque;
	}

	public String getNom_marque() {
		return nom_marque;
	}
	
	public void setId_marque(int id_marque) {
		this.id_marque = id_marque;
	}
	
	public void setNom_marque(String nom_marque) {
		this.nom_marque = nom_marque;
	}

	@Override
	public String toString() {
		return "Marque [id_marque=" + id_marque + ", nom_marque=" + nom_marque + "]";
	}
	
	
}
