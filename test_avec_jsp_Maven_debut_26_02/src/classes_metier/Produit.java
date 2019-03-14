package classes_metier;

public class Produit {
	
	protected int id_produit;
	protected String libelle_produit;
	protected Famille famille;
	protected SousFamille sous_famille;
	protected Marque marque;
	
	


	public Produit (int id_produit, String libelle, Famille f, SousFamille sf, Marque m) {
		
		this.id_produit = id_produit;
		this.libelle_produit = libelle;
		this.famille = f;
		this.sous_famille=sf;
		this.marque=m;
	}

	public int getId_produit() {
		return id_produit;
	}

	public String getLibelle_produit() {
		return libelle_produit;
	}

	public Famille getFamille() {
		return famille;
	}
	
	public int getFamilleId() {
		return famille.getId_famille();
		
	}

	public SousFamille getSous_famille() {
		return sous_famille;
	}
	
	public int getIdsous_famille() {
		
		return sous_famille.getId();
	}

	public Marque getMarque() {
		return marque;
	}
	
	public int getMarqueId() {
		
		return marque.getId_marque();
	}

	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}

	public void setLibelle_produit(String libelle_produit) {
		this.libelle_produit = libelle_produit;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	public void setSous_famille(SousFamille sous_famille) {
		this.sous_famille = sous_famille;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	@Override
	public String toString() {
		return "Produit [id_produit=" + id_produit + ", libelle_produit=" + libelle_produit + ", famille=" + famille
				+ ", sous_famille=" + sous_famille + ", marque=" + marque + "]";
	}
	
	
	
}
