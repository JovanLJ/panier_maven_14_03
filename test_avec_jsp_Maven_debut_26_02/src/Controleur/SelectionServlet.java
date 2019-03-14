package Controleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection_et_DAO.CatalogueDAO;
import Connection_et_DAO.CouleurDAO;
import Connection_et_DAO.DAO;
import Connection_et_DAO.FamilleDAO;
import Connection_et_DAO.MarqueDAO;
import Connection_et_DAO.SousFamilleDAO;
import Service.TraitementSelection;
import classes_metier.Catalogue;
import classes_metier.Couleur;
import classes_metier.Famille;
import classes_metier.Marque;
import classes_metier.SousFamille;
import filtres.CollectionFiltres;
import filtres.ContaineurFiltre;
import filtres.Filtre;

/**
 * Servlet implementation class ServletFiltre
 */
@WebServlet("/SelectionServlet")
public class SelectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest requ, HttpServletResponse resp)
			throws ServletException, IOException {
		doProcess(requ, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, res);
	}
	
	
	protected void doProcess (HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Entrée dans Selection Servlet");
		
		CollectionFiltres coll = (CollectionFiltres)request.getSession().getAttribute("maCollection");
		String [] tab = request.getParameterValues("selection");
		TraitementSelection monTraitement = new TraitementSelection();
		ArrayList <Filtre> maListeFiltres = monTraitement.executerTraitement(tab, coll);
		request.getSession().setAttribute("filtres", maListeFiltres);
	
		try {
			request.getRequestDispatcher("/WEB-INF/login_success.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}

