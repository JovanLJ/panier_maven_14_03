package Controleur;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Service.Traitement_Affichage;
import classes_metier.Client;
import filtres.CollectionFiltres;
import filtres.ContaineurFiltre;

/**
 * Servlet implementation class Controlleur_Servlet
 */
@WebServlet("/Controlleur_Servlet")
public class AffichageTousLesFiltresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffichageTousLesFiltresServlet() {
        super();
      
    }

	// ICI JE VAIS DIRE QUE C'EST MA METHODE PROCESS QUI VA S'OCCUPER DU DOGET ET DU DOPOST
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
    	process (request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		process (request, response);
	}
	
	protected void process (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html"); // format de texte qui va sortir
		System.out.println("entré dans la Servlet Validation"); //j'affiche dans le console que je suis entrée dans Controleur_Servlet
		
		Client client= (Client) request.getSession().getAttribute("client");
		String id = request.getParameter("identifiant"); // je récupère le string tout en mettant le meme nom précisé dans name de l'input
		String mdp = request.getParameter("password");
		
		if (client ==null && id!=null && mdp!=null) {
			client= new Client(id, mdp); // je crée le client avec les deux strings récupérés
		
			if (client.validate()==true) {	
				//je récupère la connexion et je définis que c'est le client qui ouvre la session
				request.getSession().setAttribute("client", client);
				// je crée un objet qui va me rajouter les elemnts de la base de données dans la collection cf
				Traitement_Affichage ta = new Traitement_Affichage();
				System.out.println("Traitement affichage créé dans Servlet Validation");
				// j'instancie ma collection de filtres
				//CollectionFiltres cf = new CollectionFiltres("maCollection");
				System.out.println("Collection de filtres vide créée dans Servlet Validation");
				//je récupère la collection des containuers filtres récupérés depuis la BD dans ma collection
				
				System.out.println("cf dans Servlet Validation récupère la collection de filtres depuis la classe traitementAffichage");
				// je parcours avec chaque objet CollectionFiltre la liste de la Colletion 			
				/*for (ContaineurFiltre c: cf.getCf()) {
					// je défnis le nom de chaque collection et les l'evois dans la jsp ; login
					request.getSession().setAttribute(c.getNom(), c); 
				}*/
				// j'envois ma collection de containeurs dans la jsp
				request.getSession().setAttribute("maCollection", ta.creerCollection());
				System.out.println("Collection créée avec succès dans Servlet Validation");
				request.getRequestDispatcher("/WEB-INF/login_success.jsp").forward(request, response); // ici je précise que mon fichier jsp se trouve bien dans WEB-INF. Si non, cela ne marchera pas     
			} else {
				request.getRequestDispatcher("/WEB-INF/login_error.jsp").forward(request, response); // pareil ci-dessus, indiquer le dossier WEB-INF
			}
		} else {
		 request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}
		}
}


/*------------- VERSION INITIALE TEST QUAND JE N'AVAIS PAS DE CONNEXION BD-----------
//CREATION FAMILLES ICI - PLUS TARD J'IRAI LES RECUPERER EN BD
Filtre filtreFamille = new Filtre (1, "Elastique Loom");
Filtre famille2 = new Filtre(2, "Elastique de sécurité");
Filtre famille3 = new Filtre(3, "Elastique crochet");
Filtre famille4 = new Filtre(4, "Elastique bracelet");
//CREATION LISTE ET RAJOUT FAMILLES DANS LA LISTE
ArrayList <Filtre> ListeFamille = new ArrayList();
ListeFamille.add(filtreFamille);
ListeFamille.add(famille2);
ListeFamille.add(famille3);
ListeFamille.add(famille4);
//----------------------

Filtre filtreC1 = new Filtre (1, "Abricot");
Filtre filtreC2 = new Filtre (2, "Jaune");
Filtre filtreC3 = new Filtre (3, "Rouge");
Filtre filtreC4 = new Filtre (4, "Bleu");

ArrayList <Filtre> listeCouleur = new ArrayList();

listeCouleur.add(filtreC1);
listeCouleur.add(filtreC2);
listeCouleur.add(filtreC3);
listeCouleur.add(filtreC4);
*/
//request.setAttribute("client", client);// !!! ce paramètre me servira pour afficher le nom du client. Il envoie le le paramètre client que j'ai appellé ici "client"
//request.setAttribute("filtre", Liste);	
// ---- VERSION PRECEDENTE request.getSession().setAttribute("filtreCouleur", listeCouleur);
