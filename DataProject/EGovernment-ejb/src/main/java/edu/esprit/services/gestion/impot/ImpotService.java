package edu.esprit.services.gestion.impot;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.Impot;

/**
 * Session Bean implementation class ImpotService
 */
@Stateless
public class ImpotService implements ImpotServiceRemote, ImpotServiceLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext(unitName="E-Goverment")
	EntityManager entityManager;
	
    public ImpotService() {
        // TODO Auto-generated constructor stub
    }

	public List<Impot> findAllImpot() {
		Query query=entityManager.createQuery("select i from Impot i");
		List<Impot> l = query.getResultList();
		return query.getResultList();
	}

}
