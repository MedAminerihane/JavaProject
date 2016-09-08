package edu.esprit.services.gestion.cinRequest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.Agent;

import edu.esprit.domain.CinRequest;
import edu.esprit.domain.Citizen;
import edu.esprit.domain.Service;

/**
 * Session Bean implementation class GestionCinRequest
 */
@Stateless
public class GestionCinRequest implements GestionCinRequestRemote, GestionCinRequestLocal {

	@PersistenceContext(unitName="E-Goverment")
	EntityManager entityManager;
    public GestionCinRequest() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public Boolean addCinRequest(CinRequest cinRequest) {
		try {
			entityManager.persist(cinRequest);
			return true;
		} catch (Exception e) {
			return false;
		}
		}
	@Override
	public Boolean deleteCinRequest(CinRequest cinRequest) {
		try {
			entityManager.remove(entityManager.merge(cinRequest));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Override
	public Boolean updateCinRequest(CinRequest cinRequest) {
		try {
			entityManager.merge(cinRequest);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	@Override
	public CinRequest findCinRequestBybirthExcerpt(String birthExcerpt) {
		CinRequest cinRequest = null;
		try {
			Query queryCinRequestBybirthExcerpt = entityManager.createQuery(
				    "SELECT OBJECT(c) FROM CinRequest c WHERE c.birthExcerpt = :birthExcerpt"
				);
			queryCinRequestBybirthExcerpt.setParameter("birthExcerpt", birthExcerpt);
			cinRequest = (CinRequest) queryCinRequestBybirthExcerpt.getSingleResult();
			return cinRequest; 
		} catch (Exception e) {
		}
		return cinRequest;
	}
	@Override
	public CinRequest findCinRequestByCitizen(Citizen citizen) {
		CinRequest cinRequest = null;
		try {
			Query queryCinRequestByCitizen = entityManager.createQuery(
				    "SELECT OBJECT(c) FROM CinRequest c WHERE c.citizen = :citizen"
				);
			queryCinRequestByCitizen.setParameter("citizen", citizen);
			cinRequest = (CinRequest) queryCinRequestByCitizen.getSingleResult();
			return cinRequest; 
		} catch (Exception e) {
		}
		return cinRequest;
	}
	@Override
	public CinRequest findCinRequestByService(Service service) {
		CinRequest cinRequest = null;
		try {
			Query queryCinRequestByCitizen = entityManager.createQuery(
				    "SELECT OBJECT(c) FROM CinRequest c WHERE c.service = :service"
				);
			queryCinRequestByCitizen.setParameter("service", service);
			cinRequest = (CinRequest) queryCinRequestByCitizen.getSingleResult();
			return cinRequest; 
		} catch (Exception e) {
		}
		return cinRequest;
	}
	@Override
	public CinRequest findCinRequestByAgent(Agent agent) {
		CinRequest cinRequest = null;
		try {
			Query queryCinRequestByAgent = entityManager.createQuery(
				    "SELECT OBJECT(c) FROM CinRequest c WHERE c.agent = :agent"
				);
			queryCinRequestByAgent.setParameter("agent", agent);
			cinRequest = (CinRequest) queryCinRequestByAgent.getSingleResult();
			return cinRequest; 
		} catch (Exception e) {
		}
		return cinRequest;
	}
	@Override
	public List<CinRequest> findAllCinRequestByRequestState(String state) {
		try {
			Query query=entityManager.createQuery("select c from CinRequest c WHERE c.state = :state");
			query.setParameter("state", state);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public List<CinRequest> findAllResidenceCertificate(CinRequest cinrequest) {
		try {
			Query query=entityManager.createQuery("select c from CinRequest c WHERE c.idCinRequest = :cinrequest");
			query.setParameter("idCinRequest", cinrequest.getIdCinRequest());
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public List<CinRequest> findAllCinRequest() {
		try {
			Query query=entityManager.createQuery("select c from CinRequest c");
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

}
