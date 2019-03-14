package Connection_et_DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes_metier.Catalogue;

public class CatalogueDAO implements DAO<Catalogue> {

	@Override
	public Catalogue create(Catalogue obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Catalogue delete(Catalogue obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Catalogue update(Catalogue obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Catalogue find2param(int id_couleur, int id_produit) {
		
		Catalogue catalogue = null;
		String requete = ("SELECT * FROM CATALOGUE WHERE ID_COULEUR = " + id_couleur + " AND ID_PRODUIT="+id_produit);
		
		try {
			
			Statement stmt = new ConnectBDD().getConnect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		    // execution de la requete
			ResultSet result = stmt.executeQuery(requete);
			
			//s'il y a un resultat, je cree l'objet fam avec les donnees trouvees
		    if(result.first()) {
		    	ProduitDAO pdao = new ProduitDAO();
		    	CouleurDAO cdao=new CouleurDAO();
		    	catalogue = new Catalogue(result.getFloat("PRIX_UNITAIRE"), result.getInt("STOCK"),cdao.find(result.getInt("ID_COULEUR")), pdao.find(result.getInt("ID_PRODUIT")));
		    	System.out.println("catalogue trouvé");
			}
		    // puis fermeture de la connexion
		    
		    stmt.close();
		    System.out.println("Fermeture connexion catalogue ok");
		    	
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    }
		return catalogue;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#findAll()
	 */
	@Override
	public List<Catalogue> findAll() {
		
		ArrayList <Catalogue> listeCatalogue = new ArrayList<Catalogue>();
		
		String requete = "SELECT * FROM CATALOGUE ORDER BY ID_PRODUIT";
		
		try {
			
			Statement stmt = new ConnectBDD().getConnect().createStatement();
		    // execution de la requete
			ResultSet result = stmt.executeQuery(requete);
			
			//tant que...
			while (result.next()) {
				listeCatalogue.add(this.find(result.getInt("SELECT * FROM CATALOGUE")));
				
			}
		    // puis fermeture de la connexion
		    stmt.close();
		    System.out.println("Fermeture connexion ok");
		    	
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    }
		return listeCatalogue;
	}

	@Override
	public Catalogue find(int id) {
		// TODO Auto-generated method stub
		return null;
	}



}
