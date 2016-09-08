package edu.esprit.web;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import edu.esprit.domain.TaxInfo;
import edu.esprit.services.gestion.taxinfo.TaxInfoServiceLocal;


@ManagedBean
@ViewScoped
public class InfoTax {

	@EJB
	TaxInfoServiceLocal taxInfoService;
	
	private TaxInfo taxInfo;
	
	public InfoTax() {
		
	}
	
	
	@PostConstruct
	public void init() {

		taxInfo = taxInfoService.findAllTaxInfo();
		taxInfo = new TaxInfo();
	}

	public TaxInfo getTaxInfo() {
		return taxInfo;
	}
	public void setTaxInfo(TaxInfo taxInfo) {
		this.taxInfo = taxInfo;
	}
}
