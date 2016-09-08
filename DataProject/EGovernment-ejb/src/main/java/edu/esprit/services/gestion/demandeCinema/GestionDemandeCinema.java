package edu.esprit.services.gestion.demandeCinema;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.Categorie;
import edu.esprit.domain.DemandeCinema;

/**
 * Session Bean implementation class GestionDemandeCinema
 */
@Stateless
public class GestionDemandeCinema implements GestionDemandeCinemaRemote, GestionDemandeCinemaLocal {


	@PersistenceContext(unitName="E-Goverment")
	EntityManager entityManager; 
	
    public GestionDemandeCinema() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public Boolean addDemandeCinema(DemandeCinema d) {
		try {
			entityManager.persist(d);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

    public int lastId(){
    	Query q=entityManager.createQuery(" select  max(idDemandeCinema) FROM DemandeCinema ");
    	try {
			return (int) q.getSingleResult() ;
		} catch (Exception e) {
			return 0;
		}
    	
    }
    
    
	@Override
	public DemandeCinema getLastDemandeCinema() {
		int id=this.lastId();
		Query query=entityManager.createQuery(""
				+ "select e from DemandeCinema e WHERE e.idDemandeCinema = "+id);
		
		try {
			return (DemandeCinema) query.getSingleResult() ;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Boolean updateDemandeCinema(DemandeCinema d) {
		try {
			entityManager.merge(d);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
