package edu.esprit.services.gestion.roadtaxservice;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.RoadTaxService;

@Local
public interface GestionRoadTaxServiceLocal {
	List<RoadTaxService> findAllRoadTaxService();

}
