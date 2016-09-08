package edu.esprit.services.gestion.company;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.Company;
import edu.esprit.domain.CompanyRequest;
import edu.esprit.domain.Finance;
import edu.esprit.domain.FinanceInstitut;

/**
 * Session Bean implementation class CompanyService
 */
@Stateless
public class CompanyService implements CompanyServiceRemote, CompanyServiceLocal {

	@PersistenceContext(unitName="E-Goverment")
	EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public CompanyService() {
        // TODO Auto-generated constructor stub
    }

	public Company findCompanyByCodeFiscal(String codeFiscal) {
		Company company = null;
		try {
			Query queryCompanyByCodeFiscal = entityManager.createQuery(
				    "SELECT OBJECT(c) FROM Company c WHERE c.codeFiscal = :code"
				);
			queryCompanyByCodeFiscal.setParameter("code", codeFiscal);
			company = (Company) queryCompanyByCodeFiscal.getSingleResult();
			return company; 
		} catch (Exception e) {
		}
		return company;

	}
	
	@Override
	public Boolean addCompanyReq(CompanyRequest c) {
		try {
			entityManager.persist(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateCompanyRequest(CompanyRequest c) {
		try {
			entityManager.merge(c);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public CompanyRequest findCompanyRequestByCitizen(String cin) {
		// TODO Auto-generated method stub
		CompanyRequest careerObjectiveService = null;
		try {
			Query query = entityManager.createQuery(
				    "SELECT OBJECT(c) FROM CompanyRequest c WHERE c.citizen.cin = :cin"
				);
			query.setParameter("cin", cin);
			careerObjectiveService = (CompanyRequest) query.getSingleResult();
			return careerObjectiveService; 
		} catch (Exception e) {
		}
		return careerObjectiveService;
	}

	
	
	@Override
	public Boolean updateCompany(Company c) {
		try {
			entityManager.merge(c);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Boolean addFunding(Finance f) {
		try {
			entityManager.persist(f);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<FinanceInstitut> findAllFinanceInstitut() {
		// TODO Auto-generated method stub
		
			Query query=entityManager.createQuery("select c from FinanceInstitut c");
			return query.getResultList();
			
		}

	@Override
	public Company findCompanyById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Company.class,id);
	}
}
