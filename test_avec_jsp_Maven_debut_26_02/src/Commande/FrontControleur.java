package Commande;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * Servlet implementation class FrontControleur
 */
@WebServlet("/FrontControleur")
public class FrontControleur extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	/*//private Map commands = (Map) new HashMap();
	
	public void init() {
		//((HashMap) commands).put("controleClient", new LoginCommande());
	}*/
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process ( request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}
	

	protected void process (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("entrée dans FrontControleur process");
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		String cmd = req.getParameter("cmd"); // je le récupère depuis une JSP. mais qu'est-ce que je fais quand je repcère les éléments depuis une autre ICommande et n'ai pas de cmd???? Impossible de mettre une setparameter depuis une ICommande
		
		// les paramètres sont des éléments d'une page html et cela vient du côté client
		// les attributs sont des objets stockés côté serveur. Ca sert à faire la persistance entre les requêtes
		// "?" c'est la définition d'un attribut dans la jsp
		ICommande iComObjet = null; // je le mets en vide
		
			try {
				// si je recpuère un cm ddepuis une jsp
				// on va essayer de récuperer objet ICommande
				System.out.println("entrée dans try FrontControleur process");
				iComObjet = (ICommande) Class.forName("Commande."+cmd).newInstance(); // cela doit correspondre à une classe java. Il doit y avoir une correlation entre la demande et la commnde qui va la gérer. Il faut avoir les conventions de nommage.
				String urlSuite = iComObjet.execute(req, res); 
				System.out.println("revenu dans FrontControleur pour forwarder le request: afficher la page ou envoyer vers une autre ICommande");
				req.getRequestDispatcher(urlSuite).forward(req, res);
				//si non je recupère un string normal et je renvoie vers une autre page command
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) { // intérêt interface Commande -> ne plus toucher aucune ligne de commande
				// si ce n'est pass possbile, tu m'envoies une exception
				// TODO Auto-generated catch block
				e.printStackTrace();
				req.getRequestDispatcher("/WEB-INF/ActionInexistante.jsp");
				// envoyer vers une page error et puis vers index.
		} 	
	}
}


