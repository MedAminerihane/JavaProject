package edu.esprit.services.gestion.cinRequest;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.domain.Agent;
import edu.esprit.domain.Categorie;
import edu.esprit.domain.CinRequest;
import edu.esprit.domain.Citizen;
import edu.esprit.domain.Service;


@Remote
public interface GestionCinRequestRemote {

	Boolean addCinRequest(CinRequest cinRequest);
	Boolean deleteCinRequest(CinRequest cinRequest);
	Boolean updateCinRequest(CinRequest cinRequest);
	CinRequest findCinRequestBybirthExcerpt(String birthExcerpt);
	CinRequest findCinRequestByCitizen(Citizen citizen);
	CinRequest findCinRequestByService(Service service);
	CinRequest findCinRequestByAgent(Agent agent);
	List<CinRequest> findAllCinRequestByRequestState(String state);
	List<CinRequest> findAllResidenceCertificate(CinRequest cinRequest);
	List<CinRequest> findAllCinRequest() ;
}
