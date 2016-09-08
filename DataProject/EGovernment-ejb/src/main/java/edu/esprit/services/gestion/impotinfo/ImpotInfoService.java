package edu.esprit.services.gestion.impotinfo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.ImpotInfo;
import edu.esprit.domain.TaxInfo;

/**
 * Session Bean implementation class ImpotInfoService
 */
@Stateless
public class ImpotInfoService implements ImpotInfoServiceRemote, ImpotInfoServiceLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext(unitName="E-Goverment")
	EntityManager entityManager;
	
    public ImpotInfoService() {
        // TODO Auto-generated constructor stub
    }

	public ImpotInfo findAllImpot() {
		Query query=entityManager.createQuery("select t from TaxInfo t WHERE c.idTaxInfo =1");
        try {
			return (ImpotInfo)query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
