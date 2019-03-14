package Service;

import java.util.ArrayList;
import java.util.List;

import Connection_et_DAO.CouleurDAO;
import Connection_et_DAO.FamilleDAO;
import Connection_et_DAO.MarqueDAO;
import Connection_et_DAO.SousFamilleDAO;
import classes_metier.Couleur;
import classes_metier.Famille;
import classes_metier.Marque;
import classes_metier.SousFamille;
import filtres.CollectionFiltres;
import filtres.ContaineurFiltre;
import filtres.Filtre;

public class Traitement_Affichage {
	
	public Traitement_Affichage() {	};
	
	public static CollectionFiltres creerCollection() {
		
			FamilleDAO fdao = new FamilleDAO();
			SousFamilleDAO sdao = new SousFamilleDAO();
			MarqueDAO mdao = new MarqueDAO();
			CouleurDAO cdao = new CouleurDAO();
		
			ContaineurFiltre cfiltre = new ContaineurFiltre("famille");
			ContaineurFiltre cfiltreSF = new ContaineurFiltre ("sous_famille");
			ContaineurFiltre cfiltreM = new ContaineurFiltre ("marque");
			ContaineurFiltre cfiltreC = new ContaineurFiltre ("couleur");
		
			CollectionFiltres coll = new CollectionFiltres("macoll");
			
			List<Famille> lfamille =  fdao.findAll();
			List <SousFamille> lsfamille = sdao.findAll();
			List<Marque> lmarque =  mdao.findAll();
			List<Couleur> lcouleur=cdao.findAll();
			
			for (Famille f: lfamille) {
				// je crée un filtre avec l'ide de la famille et l'intitule de la famille et le rajoute dans l'arraylist qui se trouve dans le containeur
				cfiltre.addFiltre(new Filtre(f.getId_famille(), f.getIntitule_famille()));
			} 
			System.out.println("Traitement affichage : succès création containeur Filtre Famille");
			for (SousFamille s : lsfamille) {
				
				cfiltreSF.addFiltre(new Filtre(s.getId(), s.getIntitule_ssFamille()));
			} 
			System.out.println("Traitement affichage : succès création containeur Filtre sous-famille");
			for (Marque m: lmarque) {
				
				cfiltreM.addFiltre(new Filtre(m.getId_marque(), m.getNom_marque()));
			} 
			System.out.println("Traitement affichage : succès création containeur Filtre marque");
			for (Couleur cc: lcouleur) {
				cfiltreC.addFiltre(new Filtre(cc.getId_couleur(), cc.getNom_couleur()));
			}
			System.out.println("Traitement affichage : succès création containeur Filtre couleur");
			
			coll.addDansLaCollection(cfiltre);
			coll.addDansLaCollection(cfiltreSF);
			coll.addDansLaCollection(cfiltreM);
			coll.addDansLaCollection(cfiltreC);
			
			System.out.println("Traitement affichage : succès rajout tous les containeurs dans la collection");
			
			return coll;	
	}
}
