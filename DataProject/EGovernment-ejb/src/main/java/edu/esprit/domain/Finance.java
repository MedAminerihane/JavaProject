package edu.esprit.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Finance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idFinance;
	private String companyName;
	private String mailCompany;
	private String adress;
	private float amount;
	@ManyToOne
	private FinanceInstitut financeInstitut ; 
	
	
	public Integer getIdFinance() {
		return idFinance;
	}
	public void setIdFinance(Integer idFinance) {
		this.idFinance = idFinance;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getMailCompany() {
		return mailCompany;
	}
	public void setMailCompany(String mailCompany) {
		this.mailCompany = mailCompany;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public FinanceInstitut getFinanceInstitut() {
		return financeInstitut;
	}
	public void setFinanceInstitut(FinanceInstitut financeInstitut) {
		this.financeInstitut = financeInstitut;
	}

	
	

}
