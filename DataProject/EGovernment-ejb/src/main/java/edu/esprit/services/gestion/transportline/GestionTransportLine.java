package edu.esprit.services.gestion.transportline;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.RoadTaxService;
import edu.esprit.domain.TransportLine;

/**
 * Session Bean implementation class GestionTransportLine
 */
@Stateless
public class GestionTransportLine implements GestionTransportLineRemote, GestionTransportLineLocal {

	@PersistenceContext(unitName="E-Goverment")EntityManager entityManager;
    public GestionTransportLine() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addTransportLine(TransportLine transportLine) {
		try {
			entityManager.persist(transportLine);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteTransportLine(TransportLine transportLine) {
		try {
			entityManager.remove(entityManager.merge(transportLine));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateTransportLine(TransportLine transportLine) {
		try {
			entityManager.merge(transportLine);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public TransportLine findTransportLineByNumeroLine(String numeroLine) {
		TransportLine transportLine = null;
		try {
			Query query = entityManager.createQuery(
				    "SELECT OBJECT(c) FROM TransportLine c WHERE c.numeroLine = :numeroLine"
				);
			query.setParameter("numeroLine",numeroLine);
			transportLine = (TransportLine) query.getSingleResult();
			return transportLine; 
		} catch (Exception e) {
		}
		return transportLine;
	}

	@Override
	public List<TransportLine> findAllTransportLines() {
		try {
			Query query=entityManager.createQuery("select c from TransportLine c");
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

}
