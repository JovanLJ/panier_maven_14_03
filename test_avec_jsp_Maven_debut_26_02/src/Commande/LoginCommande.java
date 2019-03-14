package Commande;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans_fonctionnalite.CatalogueBrowser;
import classes_metier.Client;

public class LoginCommande implements ICommande {


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// if session est vide par défault je vais 
		Client client = new Client();
		HttpSession session = request.getSession();

		client.setName(request.getParameter("identifiant"));
		client.setPassword(request.getParameter("password"));
		if (client.validate()) {
					
			CatalogueBrowser monCatalogue = new CatalogueBrowser (client);
			session.setAttribute("monCatalogue", monCatalogue);
			System.out.println("je suis dans LoginCommande");
			return ("/WEB-INF/login_success.jsp");
			//String nouvelle_page = new String("FrontControleur?cmd=LoginSuccessCommande");
			//return (nouvelle_page);
			//req.setParameter(cmd);
		} else {
			System.out.println("LoginCommande-error");
			return ("WEB-INF/login_error");
		}
	}
	
}
