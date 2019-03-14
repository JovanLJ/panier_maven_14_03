package Service;

import java.util.ArrayList;

import Connection_et_DAO.CouleurDAO;
import Connection_et_DAO.DAO;
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

public class TraitementSelection {

	
	public TraitementSelection() {};
	
	@SuppressWarnings("rawtypes")
	public DAO<?> donneMoiDAO (ContaineurFiltre cf) {
		
		if (cf.getNom().equals("famille")) {
			FamilleDAO fdao = new FamilleDAO();
			return fdao;
		} else if (cf.getNom().equals("sous_famille")) {
			SousFamilleDAO sdao = new SousFamilleDAO();
			return sdao;
		} else if (cf.getNom().equals("marque")) {
			MarqueDAO mdao = new MarqueDAO();
			return mdao;
		} else if (cf.getNom().equals("couleur")) {
			CouleurDAO cdao = new CouleurDAO();
			return cdao;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList<?> donneMoiUneListe (ContaineurFiltre cfl) {
		
		if (cfl.getNom().equals("famille")) {
			ArrayList<Famille> fliste = new ArrayList<Famille>();
			return fliste;
		} else if (cfl.getNom().equals("sous_famille")) {
			ArrayList<SousFamille> sfliste = new ArrayList<SousFamille>();
			return sfliste;
		} else if (cfl.getNom().equals("marque")) {
			ArrayList<Marque> mliste = new ArrayList<Marque>();
			return mliste;
		} else if (cfl.getNom().equals("couleur")) {
			ArrayList<Couleur> cliste = new ArrayList<Couleur>();
			return cliste;
		} else {
			return null;
		}
	}
		

	public ArrayList<Filtre> executerTraitement(String[] tab, CollectionFiltres coll) {
	
		if (tab !=null) {
			ArrayList<Filtre> maListe = new ArrayList<Filtre>();
			for (ContaineurFiltre cf: coll.getCf()) {
				for (Filtre f: cf.getListeFiltre()) {
			
					f.setEtat(false);
					for (int i = 0; i < tab.length; i++) {
						if (f.getId() == Integer.parseInt(tab[i])) {
							System.out.println(tab[i]);
							//listeFiltre.get(i).setEtat(true); // ERREUR ICI car si on part là-dessu, cela affiche le nombre de checkbox séléctionnés
							f.setEtat(true);
							
							maListe = (ArrayList<Filtre>) this.donneMoiUneListe(cf);
							maListe.add((Filtre) this.donneMoiDAO(cf).find(f.getId()));
						}
					}	
				}
			}
			return maListe;
		} else {
			return null;
		}
		
	}
	
}	
	//if (tabFamille != null) {
	
		
	/*	/*Traitement_Affichage ta = new Traitement_Affichage();
		ArrayList<ContaineurFiltre> cf = new ArrayList<ContaineurFiltre>();
		cf=ta.creerCollection();
		
		((ArrayList<ContaineurFiltre>) ;
			//ICI JE FAIS LE TRAITEMENT POUR LE FILTRE FAMILLE
			for (ContaineurFiltre containeurIndividuel :cf) {
				for (Filtre f: )  {
				f.setEtat(false);
				for (int i = 0; i < tabFamille.length; i++) {
					if (f.getId() == Integer.parseInt(tab[i])) {
						System.out.println(tab[i]);
						//listeFiltre.get(i).setEtat(true); // ERREUR ICI car si on part là-dessu, cela affiche le nombre de checkbox séléctionnés
						f.setEtat(true);
						f.add(fdao.find(f.getId()));
					}
				}
			}*/
	
	
	

