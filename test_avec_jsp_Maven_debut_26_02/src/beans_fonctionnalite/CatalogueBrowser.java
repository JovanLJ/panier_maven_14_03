package beans_fonctionnalite;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;

import Service.Traitement_Affichage;
import classes_metier.Client;
import classes_metier.Panier;
import filtres.CollectionFiltres;
import filtres.ContaineurFiltre;

public class CatalogueBrowser {
	
	// ATTRIBUTS
	private Client 				client;		//blabla
	private CollectionFiltres 	cf ;		//dfgdgdg
	private Panier 				monPanier;	//sdgfdfgfdhfgdhfgdhgfdhfghgfh

	// CONSTRUCTEURS
	public CatalogueBrowser (Client client) {	
		this.client=client;		
		cf = Traitement_Affichage.creerCollection();
		monPanier = new Panier(client, false);
	}

	// GETTERS & SETTERS
	
	public Client getClient() {
		
		return this.client;
	}
	
	public CollectionFiltres getcollection () {
		return cf;
	}
	
	public Panier getPanier () {
		
		return this.monPanier;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void setCf(CollectionFiltres cf) {
		this.cf = cf;
	}

	public void setMonPanier(Panier monPanier) {
		this.monPanier = monPanier;
	}

	@Override
	public String toString() {
		return "CatalogueBrowser [client=" + client + ", cf=" + cf + ", monPanier=" + monPanier + "]";
	}
		
	
}
