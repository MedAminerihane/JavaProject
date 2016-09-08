package edu.esprit.services.gestion.entreprise;

import java.util.List;

import javax.ejb.Remote;
import edu.esprit.domain.Entreprise;

@Remote
public interface GestionEntrepriseRemote {
	Boolean addEntreprise(Entreprise entreprise);
	Boolean deleteEntreprise(Entreprise entreprise);
	Boolean updateEntreprise(Entreprise entreprise);
	
	Entreprise findEntrepriseById (int idEntreprise);
	Entreprise findEntrepriseByTitre (String titre);
	Entreprise findEntrepriseByGerant(String gerant);
	
	List<Entreprise> findAllEntreprise();
	List<Entreprise> findEntrepriseBystat(String stat);
	
}
