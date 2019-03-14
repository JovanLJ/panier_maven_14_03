package filtres;

public class Filtre{

	protected int id;
	protected String intitule;
	protected boolean etat;
	

	public Filtre(int id, String intitule) {
		this.id = id;
		this.intitule = intitule;
		etat = false;
	}


	public int getId() {
		return id;
	}


	public String getIntitule() {
		return intitule;
	}


	public boolean isEtat() {
		return etat;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	
	public String getChecked() {
		if (etat==true) { 
			return "checked";
		} else {
			return "";
		}
	}
	
}
