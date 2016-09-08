package edu.esprit.services.gestion.cinRequest;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.CinRequest;

@Local
public interface GestionCinRequestLocal {

	List<CinRequest> findAllCinRequest() ;

}
