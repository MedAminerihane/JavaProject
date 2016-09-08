package edu.esprit.services.gestion.etablishment;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.Etablishment;

@Local
public interface GestionEtablishmentLocal {

	
	Etablishment findEtablishmentByName(String name);
	List<Etablishment> findAllEtablishments();
	List<Etablishment> findAllEtablishmentsByLocationType(String type, String location);
	List<Etablishment> findEtablishmentType();
	List<Etablishment> findEtablishmentsByType(String type);
}
