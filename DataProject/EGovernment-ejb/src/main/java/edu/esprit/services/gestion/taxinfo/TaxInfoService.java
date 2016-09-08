package edu.esprit.services.gestion.taxinfo;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.Cinema;
import edu.esprit.domain.TaxInfo;

/**
 * Session Bean implementation class TaxInfoService
 */
@Stateless
public class TaxInfoService implements TaxInfoServiceRemote, TaxInfoServiceLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext(unitName="E-Goverment")
	EntityManager entityManager;
	
    public TaxInfoService() {
        // TODO Auto-generated constructor stub
    }

	public TaxInfo findAllTaxInfo() {
		Query query=entityManager.createQuery("select t from TaxInfo t WHERE c.idTaxInfo =1");
        try {
			return (TaxInfo)query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
    
}
