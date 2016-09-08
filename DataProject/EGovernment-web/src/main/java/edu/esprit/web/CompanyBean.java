package edu.esprit.web;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import edu.esprit.domain.Company;
import edu.esprit.domain.CompanyRequest;
import edu.esprit.domain.Finance;
import edu.esprit.domain.FinanceInstitut;
import edu.esprit.services.gestion.company.CompanyServiceLocal;

@ManagedBean
@ViewScoped
public class CompanyBean {

	@EJB
	CompanyServiceLocal companyService;

	private CompanyRequest comRequest;
	private Finance finance;
	private List<FinanceInstitut> financeInsList;
	private FinanceInstitut financeInst;
	private Company company;

	public CompanyBean() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		financeInst = new FinanceInstitut();
		finance = new Finance();
		company = companyService.findCompanyById(1);
		financeInsList = companyService.findAllFinanceInstitut();

		comRequest = new CompanyRequest();
	}

	public FinanceInstitut getFinanceInst() {
		return financeInst;
	}

	public void setFinanceInst(FinanceInstitut financeInst) {
		this.financeInst = financeInst;
	}

	public List<FinanceInstitut> getFinanceInsList() {
		return financeInsList;
	}

	public void setFinanceInsList(List<FinanceInstitut> financeInsList) {
		this.financeInsList = financeInsList;
	}

	public CompanyRequest getComRequest() {
		return comRequest;
	}

	public void setComRequest(CompanyRequest comRequest) {
		this.comRequest = comRequest;
	}

	public Finance getFinance() {
		return finance;
	}

	public void setFinance(Finance finance) {
		this.finance = finance;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String addCompanyRequest() {
		comRequest.setRequestDate(new Date());
		comRequest.setRequestState("0");
		// comRequest.setCitizen(new Citizen());
		companyService.addCompanyReq(comRequest);
		comRequest = new CompanyRequest();
		return "/pages/Company/Manage/addFinance?faces-redirect=true";
	}

	public String addFinanceRequest() {

		// comRequest.setCitizen(new Citizen());
		// finance.setFinanceInstitut(financeInst);
		companyService.addFunding(finance);
		finance = new Finance();

		return "/Setup?faces-redirect=true";
	}

	public String redirectToRequestFinance() {

		return "/pages/Company/Manage/addFinance?faces-redirect=true";

	}

	public String update() {
		companyService.updateCompany(company);
		company = new Company();
		return "/pages/Company/Manage/addFinance?faces-redirect=true";

	}

	public String updateForm() {
		companyService.updateCompany(company);
		return "/pages/Company/Manage/addFinance?faces-redirect=true";
	}
}
