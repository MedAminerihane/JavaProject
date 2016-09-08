package edu.esprit.services.gestion.demandePharmacie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.esprit.domain.Categorie;
import edu.esprit.domain.DemandePharmacie;

/**
 * Session Bean implementation class GestionDemandePh
 */
@Stateless
public class GestionDemandePh implements GestionDemandePhRemote, GestionDemandePhLocal {

     
	@PersistenceContext(unitName="E-Goverment")
	EntityManager entityManager;
	
    public GestionDemandePh() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public Boolean addDemandePh(DemandePharmacie d) {
		try {
			entityManager.persist(d);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
