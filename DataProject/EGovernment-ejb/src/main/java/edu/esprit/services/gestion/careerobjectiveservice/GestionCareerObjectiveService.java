package edu.esprit.services.gestion.careerobjectiveservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.Agent;
import edu.esprit.domain.CareerObjectiveService;
import edu.esprit.domain.Citizen;
import edu.esprit.domain.RoadTaxService;

/**
 * Session Bean implementation class GestionCareerObjectiveService
 */
@Stateless
public class GestionCareerObjectiveService implements GestionCareerObjectiveServiceRemote, GestionCareerObjectiveServiceLocal {
	@PersistenceContext(unitName="E-Goverment")EntityManager entityManager;

    public GestionCareerObjectiveService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addCareerObjectiveService(CareerObjectiveService careerObjectiveService) {
		try {
			entityManager.persist(careerObjectiveService);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteCareerObjectiveService(CareerObjectiveService careerObjectiveService) {
		try {
			entityManager.remove(entityManager.merge(careerObjectiveService));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateCareerObjectiveService(CareerObjectiveService careerObjectiveService) {
		try {
			entityManager.merge(careerObjectiveService);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public CareerObjectiveService findCareerObjectiveServiceByCin(String cin) {
		CareerObjectiveService careerObjectiveService = null;
		try {
			Query query = entityManager.createQuery(
				    "SELECT OBJECT(c) FROM CareerObjectiveService c WHERE c.cin = :cin"
				);
			query.setParameter("cin", cin);
			careerObjectiveService = (CareerObjectiveService) query.getSingleResult();
			return careerObjectiveService; 
		} catch (Exception e) {
		}
		return careerObjectiveService;
	}

	@Override
	public CareerObjectiveService findCareerObjectiveServiceByGiroAccount(String giroAccount) {
		CareerObjectiveService careerObjectiveService = null;
		try {
			Query query = entityManager.createQuery(
				    "SELECT OBJECT(c) FROM CareerObjectiveService c WHERE c.giroAccount = :giroAccount"
				);
			query.setParameter("giroAccount", giroAccount);
			careerObjectiveService = (CareerObjectiveService) query.getSingleResult();
			return careerObjectiveService; 
		} catch (Exception e) {
		}
		return careerObjectiveService;	
	}

	@Override
	public List<CareerObjectiveService> findCareerObjectiveServiceByCitizen(Citizen citizen) {
		try {
			Query query=entityManager.createQuery("select c from CareerObjectiveService c WHERE c.citizen = :citizen");
			query.setParameter("citizen", citizen);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<CareerObjectiveService> findCareerObjectiveServiceByAgent(Agent agent) {
		try {
			Query query=entityManager.createQuery("select c from CareerObjectiveService c WHERE c.agent = :agent");
			query.setParameter("agent", agent);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<CareerObjectiveService> findAllCareerObjectiveService() {
		try {
			Query query=entityManager.createQuery("select c from CareerObjectiveService c ");
			
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

}
