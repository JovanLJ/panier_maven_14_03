package Connection_et_DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes_metier.Produit;


/**
 * @author nico
 */
public class ProduitDAO implements DAO<Produit> {

	/* (non-Javadoc)
	 * @see modele.DAO#create(java.lang.Object)
	 */
	@Override
	public Produit create(Produit obj) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#delete(java.lang.Object)
	 */
	@Override
	public Produit delete(Produit obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#update(java.lang.Object)
	 */
	@Override
	public Produit update(Produit obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#find(int)
	 */
	@Override
	public Produit find(int id) {
		
		Produit produit = null;
		String requete = ("SELECT * FROM PRODUIT WHERE ID_PRODUIT = " + id);
		
		try {
			
			Statement stmt = new ConnectBDD().getConnect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		    // execution de la requete
			ResultSet result = stmt.executeQuery(requete);
			
			//s'il y a un resultat, je cree l'objet fam avec les donnees trouvees
		    if(result.first()) {
		    	MarqueDAO mdao = new MarqueDAO();
		    	FamilleDAO fdao = new FamilleDAO();
		    	SousFamilleDAO sdao = new SousFamilleDAO();
		    	
		    	produit = new Produit (id, result.getString("NOM_PRODUIT"), (fdao.find(result.getInt("ID_FAMILLEPRODUIT"))), (sdao.find(result.getInt("ID_SSFAMILLEPRODUIT"))), (mdao.find(result.getInt("ID_FABRICANTPRODUIT"))));
			    	System.out.println("produit trouvé");
			}
		    // puis fermeture de la connexion
		    
		    stmt.close();
		    System.out.println("Fermeture connexion produit ok");
		    	
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    }
		return produit;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#findAll()
	 */
	@Override
	public List<Produit> findAll() {
		
		ArrayList <Produit> listeProduit = new ArrayList<Produit>();
		
		String requete = "SELECT ID_PRODUIT FROM PRODUIT ORDER BY ID_PRODUIT";
		
		try {
			
			Statement stmt = new ConnectBDD().getConnect().createStatement();
		    // execution de la requete
			ResultSet result = stmt.executeQuery(requete);
			
			//tant que...
			while (result.next()) {
				listeProduit.add(this.find(result.getInt("ID_FABRIQUANT")));
				
			}
		    // puis fermeture de la connexion
		    stmt.close();
		    System.out.println("Fermeture connexion ok");
		    	
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    }
		return listeProduit;
	}

}
