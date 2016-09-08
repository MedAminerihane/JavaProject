package edu.esprit.services.gestion.entreprise;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.Entreprise;

@Local
public interface GestionEntrepriseLocal {
	Boolean addEntreprise(Entreprise entreprise);
	Boolean deleteEntreprise(Entreprise entreprise);
	Boolean updateEntreprise(Entreprise entreprise);
	
	Entreprise findEntrepriseById (int idEntreprise);
	Entreprise findEntrepriseByTitre (String titre);
	Entreprise findEntrepriseByGerant(String gerant);
	
	List<Entreprise> findAllEntreprise();
	List<Entreprise> findEntrepriseBystat(String stat);
}
