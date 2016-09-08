package edu.esprit.services.gestion.edinarservicerequest;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.EDinarServiceRequest;

@Local
public interface GestionEDinarServiceRequestLocal {

	List<EDinarServiceRequest> findAllEDinarServiceRequest();

}
