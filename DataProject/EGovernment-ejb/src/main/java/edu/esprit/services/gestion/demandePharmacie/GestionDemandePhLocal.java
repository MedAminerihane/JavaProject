package edu.esprit.services.gestion.demandePharmacie;

import javax.ejb.Local;

import edu.esprit.domain.DemandePharmacie;

@Local
public interface GestionDemandePhLocal {
	
	Boolean addDemandePh(DemandePharmacie d) ;
}
