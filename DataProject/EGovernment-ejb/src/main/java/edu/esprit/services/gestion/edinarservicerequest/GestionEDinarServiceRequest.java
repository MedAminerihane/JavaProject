package edu.esprit.services.gestion.edinarservicerequest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.Agent;
import edu.esprit.domain.EDinarServiceRequest;
import edu.esprit.domain.Service;
import edu.esprit.domain.TransportLine;
import edu.esprit.domain.University;

/**
 * Session Bean implementation class GestionEDinarServiceRequest
 */
@Stateless
public class GestionEDinarServiceRequest implements GestionEDinarServiceRequestRemote, GestionEDinarServiceRequestLocal {

	@PersistenceContext(unitName="E-Goverment")EntityManager entityManager;
    public GestionEDinarServiceRequest() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addEDinarServiceRequest(EDinarServiceRequest eDinarServiceRequest) {
		try {
			entityManager.persist(eDinarServiceRequest);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteEDinarServiceRequest(EDinarServiceRequest eDinarServiceRequest) {
		try {
			entityManager.remove(entityManager.merge(eDinarServiceRequest));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateEDinarServiceRequest(EDinarServiceRequest eDinarServiceRequest) {
		try {
			entityManager.merge(eDinarServiceRequest);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<EDinarServiceRequest> findEDinarServiceRequestByService(Service service) {
		Query query=entityManager.createQuery(""
				+ "select e from EDinarServiceRequest e WHERE e.service = :service");
		query.setParameter("service", service);
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<EDinarServiceRequest> findEDinarServiceRequestByUniversity(University university) {
		Query query=entityManager.createQuery(""
				+ "select e from EDinarServiceRequest e WHERE e.university = :university");
		query.setParameter("university", university);
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<EDinarServiceRequest> findEDinarServiceRequestByTransportLine(TransportLine transportLine) {
		Query query=entityManager.createQuery(""
				+ "select e from EDinarServiceRequest e WHERE e.transportLine = :transportLine");
		query.setParameter("transportLine", transportLine);
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<EDinarServiceRequest> findEDinarServiceRequestByAgent(Agent agent) {
		Query query=entityManager.createQuery(""
				+ "select e from EDinarServiceRequest e WHERE e.agent = :agent");
		query.setParameter("agent", agent);
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<EDinarServiceRequest> findAllEDinarServiceRequest() {
		Query query=entityManager.createQuery("select e from EDinarServiceRequest e");
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

}
