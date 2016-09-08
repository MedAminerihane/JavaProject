package edu.esprit.services.gestion.taxe;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.Categorie;
import edu.esprit.domain.Taxe;

/**
 * Session Bean implementation class TaxeService
 */
@Stateless
public class TaxeService implements TaxeServiceRemote, TaxeServiceLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext(unitName="E-Goverment")
	EntityManager entityManager;
	
    public TaxeService() {
        // TODO Auto-generated constructor stub
    }

	public Boolean addTaxe(Taxe taxe) {
		try {
			entityManager.persist(taxe);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean updateTaxe(Taxe taxe) {
		try {
			entityManager.merge(taxe);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public List<Taxe> findTaxeByCompany(String codeFiscal) {
		try {
			Query queryTaxeByCode = entityManager.createQuery(
				    "SELECT OBJECT(t) FROM Taxe t WHERE t.company.codeFiscal = :code"
				);
			queryTaxeByCode.setParameter("code", codeFiscal);
			return queryTaxeByCode.getResultList(); 
		} catch (Exception e) {
		}
		return null;

	}
    
}
