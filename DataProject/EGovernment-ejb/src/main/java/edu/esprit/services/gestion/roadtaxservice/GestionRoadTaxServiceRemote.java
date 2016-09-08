package edu.esprit.services.gestion.roadtaxservice;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.domain.Agent;
import edu.esprit.domain.Citizen;
import edu.esprit.domain.RoadTaxService;



@Remote
public interface GestionRoadTaxServiceRemote {
	Boolean addRoadTaxService(RoadTaxService roadTaxService);
	Boolean deleteRoadTaxService(RoadTaxService roadTaxService);
	Boolean updateRoadTaxService(RoadTaxService roadTaxService);
	RoadTaxService findRoadTaxServiceByCitizen(Citizen citizen);
	List<RoadTaxService> findRoadTaxServiceByAgent(Agent agent);
	List<RoadTaxService> findAllRoadTaxService();
}
