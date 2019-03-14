package classes_metier;

public class Couleur {
	
	protected int id_couleur;
	protected String nom_couleur;
	protected String code_hexa_r;
	protected String code_hexa_v;
	protected String code_hexa_b;
	protected String code_rvb_r;
	protected String code_rvb_v;
	protected String code_rvb_b;
	protected String ref_hexa;
	
	public Couleur (int id, String nom, String code1, String code2, String code3, String code4, String code5, String code6) {
		
		this.id_couleur=id;
		this.nom_couleur=nom;
		this.code_hexa_r=code1;
		this.code_hexa_v=code2;
		this.code_hexa_b=code3;
		this.code_rvb_r=code4;
		this.code_rvb_v=code5;
		this.code_rvb_b=code6;
		this.ref_hexa= new String("#"+this.code_hexa_r+this.code_hexa_v+this.code_hexa_b);
		
	}
	
	public Couleur (int id, String nom, String code1, String code2, String code3, String code4, String code5, String code6, String refHexa) {
		
		this.id_couleur=id;
		this.nom_couleur=nom;
		this.code_hexa_r=code1;
		this.code_hexa_v=code2;
		this.code_hexa_b=code3;
		this.code_rvb_r=code4;
		this.code_rvb_v=code5;
		this.code_rvb_b=code6;
		this.ref_hexa= refHexa;
		
	}

	public int getId_couleur() {
		return id_couleur;
	}

	public String getNom_couleur() {
		return nom_couleur;
	}

	public String getCode_hexa_r() {
		return code_hexa_r;
	}

	public String getCode_hexa_v() {
		return code_hexa_v;
	}

	public String getCode_hexa_b() {
		return code_hexa_b;
	}

	public String getCode_rvb_r() {
		return code_rvb_r;
	}

	public String getCode_rvb_v() {
		return code_rvb_v;
	}

	public String getCode_rvb_b() {
		return code_rvb_b;
	}

	public void setId_couleur(int id_couleur) {
		this.id_couleur = id_couleur;
	}

	public void setNom_couleur(String nom_couleur) {
		this.nom_couleur = nom_couleur;
	}

	public void setCode_hexa_r(String code_hexa_r) {
		this.code_hexa_r = code_hexa_r;
	}

	public void setCode_hexa_v(String code_hexa_v) {
		this.code_hexa_v = code_hexa_v;
	}

	public void setCode_hexa_b(String code_hexa_b) {
		this.code_hexa_b = code_hexa_b;
	}

	public void setCode_rvb_r(String code_rvb_r) {
		this.code_rvb_r = code_rvb_r;
	}

	public void setCode_rvb_v(String code_rvb_v) {
		this.code_rvb_v = code_rvb_v;
	}

	public void setCode_rvb_b(String code_rvb_b) {
		this.code_rvb_b = code_rvb_b;
	}

	@Override
	public String toString() {
		return "Couleur [id_couleur=" + id_couleur + ", nom_couleur=" + nom_couleur + ", code_hexa_r=" + code_hexa_r
				+ ", code_hexa_v=" + code_hexa_v + ", code_hexa_b=" + code_hexa_b + ", code_rvb_r=" + code_rvb_r
				+ ", code_rvb_v=" + code_rvb_v + ", code_rvb_b=" + code_rvb_b + "]";
	}
	
	public String getRefHexa() {
		return "#"+code_hexa_r+code_hexa_v+code_hexa_b;
	}

}
