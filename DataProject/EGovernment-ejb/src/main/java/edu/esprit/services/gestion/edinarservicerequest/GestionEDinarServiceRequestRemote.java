package edu.esprit.services.gestion.edinarservicerequest;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.domain.Agent;
import edu.esprit.domain.EDinarServiceRequest;
import edu.esprit.domain.Service;
import edu.esprit.domain.TransportLine;
import edu.esprit.domain.University;

@Remote
public interface GestionEDinarServiceRequestRemote {
	Boolean addEDinarServiceRequest(EDinarServiceRequest eDinarServiceRequest);
	Boolean deleteEDinarServiceRequest(EDinarServiceRequest eDinarServiceRequest);
	Boolean updateEDinarServiceRequest(EDinarServiceRequest eDinarServiceRequest);
	List<EDinarServiceRequest> findEDinarServiceRequestByService(Service service);
	List<EDinarServiceRequest> findEDinarServiceRequestByUniversity(University university);
	List<EDinarServiceRequest> findEDinarServiceRequestByTransportLine(TransportLine transportLine);
	List<EDinarServiceRequest> findEDinarServiceRequestByAgent(Agent agent);
	List<EDinarServiceRequest> findAllEDinarServiceRequest();
}
