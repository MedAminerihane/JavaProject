package edu.esprit.services.gestion.demandeCinema;

import javax.ejb.Local;

import edu.esprit.domain.DemandeCinema;

@Local
public interface GestionDemandeCinemaLocal {

	Boolean addDemandeCinema(DemandeCinema d);
	Boolean updateDemandeCinema(DemandeCinema d);
	DemandeCinema getLastDemandeCinema();
}
