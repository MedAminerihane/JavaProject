package edu.esprit.services.gestion.company;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.Company;
import edu.esprit.domain.CompanyRequest;
import edu.esprit.domain.Finance;
import edu.esprit.domain.FinanceInstitut;

@Local
public interface CompanyServiceLocal {

	Company findCompanyByCodeFiscal(String codeFiscal);
	Boolean addCompanyReq(CompanyRequest c);
	Boolean updateCompanyRequest(CompanyRequest c);
	CompanyRequest findCompanyRequestByCitizen(String c);
	Boolean updateCompany(Company c);
	Boolean addFunding(Finance f);
	List<FinanceInstitut> findAllFinanceInstitut();
	Company findCompanyById(int id);
}
