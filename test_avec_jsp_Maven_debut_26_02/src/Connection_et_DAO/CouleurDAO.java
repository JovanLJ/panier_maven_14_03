package Connection_et_DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes_metier.Couleur;

public class CouleurDAO implements DAO<Couleur> {


	/* (non-Javadoc)
	 * @see modele.DAO#create(java.lang.Object)
	 */
	@Override
	public Couleur create(Couleur obj) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#delete(java.lang.Object)
	 */
	@Override
	public Couleur delete(Couleur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#update(java.lang.Object)
	 */
	@Override
	public Couleur update(Couleur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#find(int)
	 */
	@Override
	public Couleur find(int id) {
		
		Couleur cc = null;
		String requete = ("SELECT * FROM COULEUR WHERE ID_COULEUR = " + id);
		
		try {
			
			Statement stmt = new ConnectBDD().getConnect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		    // execution de la requete
			ResultSet result = stmt.executeQuery(requete);
			
			//s'il y a un resultat, je cree l'objet fam avec les donnees trouvees
		    if(result.first()) {
		    	cc= new Couleur(id, result.getString("INTITULE_COULEUR"), result.getString("HEXA_ROUGE"), result.getString("HEXA_VERT"),result.getString("HEXA_BLEU"), result.getString("RVB_ROUGE"),result.getString("RVB_VERT"), result.getString("RVB_BLEU"));
		    	System.out.println("couleur trouvée");
			}
		    // puis fermeture de la connexion
		    
		    stmt.close();
		    System.out.println("Fermeture connexion Couleur ok");
		    	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cc;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#findAll()
	 */
	@Override
	public List<Couleur> findAll() {
		
		ArrayList <Couleur> listeCouleur = new ArrayList<Couleur>();
		
		String requete = "SELECT * FROM COULEUR ORDER BY ID_COULEUR";
		
		try {
			
			Statement stmt = new ConnectBDD().getConnect().createStatement();
		    // execution de la requete
			ResultSet result = stmt.executeQuery(requete);
			
			System.out.println("Entrée dans Couleur.findAll()");
			
			//tant que...
			while (result.next()) {
				//cc= new Couleur(result.getInt("ID_COULEUR"), result.getString("INTITULE_COULEUR"), result.getString("HEXA_ROUGE"), result.getString("HEXA_VERT"),result.getString("HEXA_BLEU"), result.getString("RVB_ROUGE"),result.getString("RVB_VERT"), result.getString("RVB_BLEU"));
				listeCouleur.add(new Couleur(result.getInt("ID_COULEUR"), result.getString("INTITULE_COULEUR"), result.getString("HEXA_ROUGE"), result.getString("HEXA_VERT"),result.getString("HEXA_BLEU"), result.getString("RVB_ROUGE"),result.getString("RVB_VERT"), result.getString("RVB_BLEU")));
				//listeCouleur.add(this.find(result.getInt("ID_COULEUR")));
				
			}
		    // puis fermeture de la connexion
		    stmt.close();
		    System.out.println("Fermeture connexion Couleur.findALL() ok");
		    	
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    }
		return listeCouleur;
	}


}
