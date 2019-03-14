package classes_metier;

public class Famille {

	protected int id_famille;
	protected String intitule_famille;
	
	public Famille (int id_famille, String intitule_famille) {
		
		this.id_famille = id_famille;
		this.intitule_famille = intitule_famille;
	}

	public int getId_famille() {
		return id_famille;
	}
	
	public String getIntitule_famille() {
		return intitule_famille;
	}

	public void setId_famille(int id_famille) {
		this.id_famille = id_famille;
	}

	public void setIntitule_famille(String intitule_famille) {
		this.intitule_famille = intitule_famille;
	}

	@Override
	public String toString() {
		return "Famille [id_famille=" + id_famille + ", intitule_famille=" + intitule_famille + "]";
	}
	
	
	
}
