package edu.esprit.services.gestion.careerobjectiveservice;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.CareerObjectiveService;

@Local
public interface GestionCareerObjectiveServiceLocal {

	List<CareerObjectiveService> findAllCareerObjectiveService();

}
