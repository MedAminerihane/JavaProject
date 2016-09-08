package edu.esprit.services.gestion.careerobjectiveservice;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.domain.Agent;
import edu.esprit.domain.CareerObjectiveService;
import edu.esprit.domain.Citizen;


@Remote
public interface GestionCareerObjectiveServiceRemote {
	Boolean addCareerObjectiveService(CareerObjectiveService careerObjectiveService);
	Boolean deleteCareerObjectiveService(CareerObjectiveService careerObjectiveService);
	Boolean updateCareerObjectiveService(CareerObjectiveService careerObjectiveService);
	CareerObjectiveService findCareerObjectiveServiceByCin(String cin);
	CareerObjectiveService findCareerObjectiveServiceByGiroAccount(String giroAccount);
	List<CareerObjectiveService> findCareerObjectiveServiceByCitizen(Citizen citizen);
	List<CareerObjectiveService> findCareerObjectiveServiceByAgent(Agent agent);
	List<CareerObjectiveService> findAllCareerObjectiveService();
}
