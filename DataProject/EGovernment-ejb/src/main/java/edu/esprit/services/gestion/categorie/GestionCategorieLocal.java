package edu.esprit.services.gestion.categorie;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.Categorie;

@Local
public interface GestionCategorieLocal {

	Boolean addCategorie(Categorie categorie);
	Boolean deleteCategorie(Categorie categorie);
	Boolean updateCategorie(Categorie categorie);
	Categorie findCategorieByName(String name);
	List<Categorie> findAllCategorie();
	
}
