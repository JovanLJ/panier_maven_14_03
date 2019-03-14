package Connection_et_DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import classes_metier.SousFamille;

/**
 * @author nico
 */
public class SousFamilleDAO implements DAO<SousFamille> {

	/* (non-Javadoc)
	 * @see modele.DAO#create(java.lang.Object)
	 */
	@Override
	public SousFamille create(SousFamille obj) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#delete(java.lang.Object)
	 */
	@Override
	public SousFamille delete(SousFamille obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#update(java.lang.Object)
	 */
	@Override
	public SousFamille update(SousFamille obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#find(int)
	 */
	@Override
	public SousFamille find(int id) {
		
		SousFamille ssFam = null;
		String requete = ("SELECT * FROM ssfamille WHERE ID_SSFAMILLE = " + id);
		
		try {
			
			Statement stmt = new ConnectBDD().getConnect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		    // execution de la requete
			ResultSet result = stmt.executeQuery(requete);
			
			//s'il y a un resultat, je cree l'objet fam avec les donnees trouvees
		    if(result.first()) {
		    	ssFam = new SousFamille(id, result.getString("NOM_SSFAMILLE"));
		    	System.out.println("objet sous_famille trouvee");
			}
		    // puis fermeture de la connexion
		    
		    stmt.close();
		    System.out.println("Fermeture connexion ssFam ok");
		    	
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    }
		return ssFam;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#findAll()
	 */
	@Override
	public List<SousFamille> findAll() {
		
		ArrayList <SousFamille> listeSousFam = new ArrayList<SousFamille>();
		
		String requete = "SELECT ID_SSFAMILLE FROM ssfamille ORDER BY ID_SSFAMILLE";
		
		try {
			
			Statement stmt = new ConnectBDD().getConnect().createStatement();
		    // execution de la requete
			ResultSet result = stmt.executeQuery(requete);
			
			//tant que...
			while (result.next()) {
				listeSousFam.add(this.find(result.getInt("ID_SSFAMILLE")));
				
			}
		    // puis fermeture de la connexion
		    stmt.close();
		    System.out.println("Fermeture connexion ok");
		    	
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    }
		return listeSousFam;
	}

}
