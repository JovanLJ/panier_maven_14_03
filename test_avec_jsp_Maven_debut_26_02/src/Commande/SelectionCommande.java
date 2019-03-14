package Commande;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.TraitementSelection;
import filtres.CollectionFiltres;
import filtres.Filtre;

public class SelectionCommande implements ICommande {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("entrée dans SelectionCommande");
		CollectionFiltres coll = (CollectionFiltres)request.getSession().getAttribute("maCollection");
		String [] tab = request.getParameterValues("selection");
		TraitementSelection monTraitement = new TraitementSelection();
		ArrayList <Filtre> maListeFiltres = monTraitement.executerTraitement(tab, coll);
		request.getSession().setAttribute("filtres", maListeFiltres);
		try {
			System.out.println("entrée dans try dans SelectionCommande");
			return ("/WEB-INF/login_success.jsp");	
		} catch (Exception e){
			return ("/WEB-INF/actionInexistante.jsp");
		}
	}
}
