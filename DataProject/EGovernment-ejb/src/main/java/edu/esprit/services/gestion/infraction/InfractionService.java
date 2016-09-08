package edu.esprit.services.gestion.infraction;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.Infraction;



/**
 * Session Bean implementation class InfractionService
 */
@Stateless
@LocalBean
public class InfractionService implements InfractionServiceRemote, InfractionServiceLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	private EntityManager em;
    public InfractionService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Infraction> getAll() {
		Query query=em.createQuery("select c from Infraction c");
		return query.getResultList();
	}

}
