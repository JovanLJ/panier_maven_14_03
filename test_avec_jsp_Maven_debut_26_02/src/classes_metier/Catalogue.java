package classes_metier;

public class Catalogue{

	protected float prixUnitaire;
	protected int qte;
	protected Couleur couleur;
	protected Produit produit;
	
	
	public Catalogue(float prixUnitaire, int qte, Couleur couleur, Produit produit) {
		super();
		this.prixUnitaire = prixUnitaire;
		this.qte = qte;
		this.couleur = couleur;
		this.produit = produit;
	}


	public float getPrixUnitaire() {
		return prixUnitaire;
	}


	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}


	public int getQte() {
		return qte;
	}


	public void setQte(int qte) {
		this.qte = qte;
	}


	public Couleur getCouleur() {
		return couleur;
	}


	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}


	public Produit getProduit() {
		return produit;
	}


	public void setProduit(Produit produit) {
		this.produit = produit;
	}


	@Override
	public String toString() {
		return "prixUnitaire=" + prixUnitaire + ", qte=" + qte + ", couleur=" + couleur + ", produit="
				+ produit + "";
	}
	
	
	
	

	 
}
