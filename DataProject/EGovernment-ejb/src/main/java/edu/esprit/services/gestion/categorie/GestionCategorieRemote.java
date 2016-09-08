package edu.esprit.services.gestion.categorie;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.domain.Categorie;


@Remote
public interface GestionCategorieRemote {
	
	Boolean addCategorie(Categorie categorie);
	Boolean deleteCategorie(Categorie categorie);
	Boolean updateCategorie(Categorie categorie);
	Categorie findCategorieByName(String name);
	List<Categorie> findAllCategorie();
}
