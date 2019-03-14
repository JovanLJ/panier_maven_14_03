package classes_metier;

public class Elastique extends Produit {

	protected int stock;
	protected float prix;
	protected Couleur c;
	
	public Elastique(int id_produit, String libelle, Famille f, SousFamille sf, Marque m, Couleur c, int stock, float prix) {
		super(id_produit, libelle, f, sf, m);
		this.c=c;
		this.stock=stock;
		this.prix=prix;
	
	}

	public int getStock() {
		return stock;
	}

	public float getPrix() {
		return prix;
	}

	public Couleur getC() {
		return c;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public void setC(Couleur c) {
		this.c = c;
	}	

}
