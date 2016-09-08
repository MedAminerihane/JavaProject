package edu.esprit.services.gestion.etablishment;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.domain.Etablishment;

@Remote
public interface GestionEtablishmentRemote {
	
	Boolean addEtablishment(Etablishment etablishment);
	Boolean deleteEtablishment(Etablishment etablishment);
	Boolean updateEtablishment(Etablishment etablishment);
	Etablishment findEtablishmentByName(String name);
	List<Etablishment> findAllEtablishments();
	
}
