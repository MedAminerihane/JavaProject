package edu.esprit.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import edu.esprit.domain.Company;
import edu.esprit.domain.Taxe;
import edu.esprit.services.gestion.company.CompanyService;
import edu.esprit.services.gestion.taxe.TaxeServiceLocal;;

@ManagedBean
@SessionScoped
public class TaxeBean {
	
	@EJB
	TaxeServiceLocal taxeService;
	

	private List<Taxe> taxes;

	private Taxe tax;
	private Taxe taxUpdate;
	private Taxe taxSelected;

	public TaxeBean() {
	}

	@PostConstruct
	public void init() {

		taxes = taxeService.findTaxeByCompany("123456");
		tax = new Taxe();
	}


	public void addTax(){
		//tax.setCompany(companyService.findCompanyByCodeFiscal("123456"));
		taxeService.addTaxe(tax);
		taxes = taxeService.findTaxeByCompany("123456");
		tax = new Taxe();
	}
	
	public String updateTaxe() {

		taxeService.updateTaxe(taxUpdate);
		taxes = taxeService.findTaxeByCompany("123456");
		taxUpdate = new Taxe();
		return "/pages/Company/Fiscalite/DisplayTax";
	}
	
	public String openUpdateTaxe(Taxe tax) {
		setTaxUpdate(tax);
		return "/pages/Company/Fiscalite/UpdateTax";
	}
	
	public List<Taxe> getTaxes() {
		return taxes;
	}
	
	public String payTax(Taxe tax){
		setTaxSelected(tax);
		return "/pages/Company/Fiscalite/PayTax";
	}

	public Taxe getTax() {
		return tax;
	}

	public void setTax(Taxe tax) {
		this.tax = tax;
	}

	public Taxe getTaxUpdate() {
		return taxUpdate;
	}

	public void setTaxUpdate(Taxe taxUpdate) {
		this.taxUpdate = taxUpdate;
	}

	public Taxe getTaxSelected() {
		return taxSelected;
	}

	public void setTaxSelected(Taxe taxSelected) {
		this.taxSelected = taxSelected;
	}	
}
