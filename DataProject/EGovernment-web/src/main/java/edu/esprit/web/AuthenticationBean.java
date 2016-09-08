package edu.esprit.web;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.esprit.domain.Company;
import edu.esprit.services.gestion.company.CompanyServiceLocal;


@ManagedBean
@SessionScoped
public class AuthenticationBean {

	@EJB
	CompanyServiceLocal service;

	private Company company;
	private boolean loggedIn = false;
	private String userType;

	public AuthenticationBean() {
	}

	@PostConstruct
	public void init() {

		company = new Company();
	}

	public String connect() {

		String navigateTo = "";

		company = service.findCompanyByCodeFiscal(company.getCodeFiscal());
         System.out.println(" "+company.getCodeFiscal());
         System.err.println(" "+company.getCodeFiscal());
		if (null == company) {

		

		} else {
			loggedIn = true;

			if (company instanceof Company) {

				navigateTo = "/pages/Company/Secteurs/DemandeCinema";
				userType = "company";
				
			}
		}
		return navigateTo ;
	}

	public String logout() {

		loggedIn = false;
		company = new Company();
		return "/welcome";
	}



	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	

}
