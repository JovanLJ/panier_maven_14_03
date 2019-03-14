package classes_metier;

public class Panier {

	protected int id_panier;
	protected Client proprio;
	protected boolean etat_validation;
	
	
	public Panier (int id, Client p, boolean etat) {
		
		this.id_panier = id;
		this.proprio = p;
		this.etat_validation=etat;
	}

	public Panier (Client p, boolean etat) {
		
		this.proprio = p;
		this.etat_validation=etat;
	}

	public int getId_panier() {
		return id_panier;
	}


	public Client getProprio() {
		return proprio;
	}

	public int getIdProprio() {
		
		return proprio.getId();
	}

	public boolean isEtat_validation() {
		return etat_validation;
	}


	public void setId_panier(int id_panier) {
		this.id_panier = id_panier;
	}


	public void setProprio(Client proprio) {
		this.proprio = proprio;
	}


	public void setEtat_validation(boolean etat_validation) {
		this.etat_validation = etat_validation;
	}


	@Override
	public String toString() {
		return "Panier [id_panier=" + id_panier + ", proprio=" + proprio + ", etat_validation=" + etat_validation + "]";
	}
	
	
}
