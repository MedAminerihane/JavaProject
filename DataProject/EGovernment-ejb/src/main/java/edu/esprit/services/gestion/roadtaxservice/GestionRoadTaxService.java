package edu.esprit.services.gestion.roadtaxservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.Agent;
import edu.esprit.domain.Categorie;
import edu.esprit.domain.Citizen;
import edu.esprit.domain.RoadTaxService;

/**
 * Session Bean implementation class GestionRoadTaxService
 */
@Stateless
public class GestionRoadTaxService implements GestionRoadTaxServiceRemote, GestionRoadTaxServiceLocal {

	@PersistenceContext(unitName="E-Goverment")EntityManager entityManager;
    public GestionRoadTaxService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addRoadTaxService(RoadTaxService roadTaxService) {
		try {
			entityManager.persist(roadTaxService);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteRoadTaxService(RoadTaxService roadTaxService) {
		try {
			entityManager.remove(entityManager.merge(roadTaxService));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateRoadTaxService(RoadTaxService roadTaxService) {
		try {
			entityManager.merge(roadTaxService);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public RoadTaxService findRoadTaxServiceByCitizen(Citizen citizen) {
		RoadTaxService roadTaxService = null;
		try {
			Query queryroadTaxService = entityManager.createQuery(
				    "SELECT OBJECT(c) FROM RoadTaxService c WHERE c.citizen = :citizen"
				);
			queryroadTaxService.setParameter("citizen", citizen);
			roadTaxService = (RoadTaxService) queryroadTaxService.getSingleResult();
			return roadTaxService; 
		} catch (Exception e) {
		}
		return roadTaxService;
	}

	@Override
	public List<RoadTaxService> findRoadTaxServiceByAgent(Agent agent) {
		try {
			Query query=entityManager.createQuery("select c from RoadTaxService c WHERE c.agent = :agent");
			query.setParameter("agent", agent);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<RoadTaxService> findAllRoadTaxService() {
		try {
			Query query=entityManager.createQuery("select c from RoadTaxService c");
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

}
