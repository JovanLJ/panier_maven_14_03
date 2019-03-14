package Commande;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.Traitement_Affichage;
import classes_metier.Client;

public class LoginSuccessCommande implements ICommande{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Traitement affichage créé dans LoginSuccess");
		Client client = (Client) request.getSession().getAttribute("client");
		if (client==null) {
			return ("/WEB-INF/index");
		} else {
			if (client.validate()) {
				response.setContentType("text/html"); // format de texte qui va sortir
				System.out.println("entré dans LoginSuccess "); //j'affiche dans le console que je suis entrée dans Controleur_Servlet
			
				Traitement_Affichage ta = new Traitement_Affichage();
				System.out.println("Traitement affichage créé dans LoginSuccess");
				ta.creerCollection();
				System.out.println("Collection crée");			
				System.out.println("Collection créée avec succès dans Servlet Validation");
				request.getSession().setAttribute("maCollection", ta.creerCollection());
				return ("/WEB-INF/login_success.jsp");
		   
			} else {
					return ("/WEB-INF/login_error.jsp");
			}
		}			
	}	
}
