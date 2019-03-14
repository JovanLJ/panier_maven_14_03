package classes_metier;

public class Client {

	protected String name;
	protected String password;
	protected int id;
			

	public Client(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	
	public Client () {
	}

	public int getId() {
		return this.id;
	}
	
	public void setId(int i) {
		this.id=i;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validate() {
		if ("jovan".equals(name)  && "jovan".equals(password)) {
			return true;
		} else {
			return false;
		}
	}
	
}	
	

