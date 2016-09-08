package edu.esprit.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class FinanceInstitut {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idFinanceInstitut;
	private String name;
	private String description;
	private String mail;
	@OneToMany(mappedBy="financeInstitut")
	private List<Finance> financeRequestList ; 
	
	
	public Integer getIdFinanceInstitut() {
		return idFinanceInstitut;
	}
	public void setIdFinanceInstitut(Integer idFinanceInstitut) {
		this.idFinanceInstitut = idFinanceInstitut;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((idFinanceInstitut == null) ? 0 : idFinanceInstitut.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FinanceInstitut other = (FinanceInstitut) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idFinanceInstitut == null) {
			if (other.idFinanceInstitut != null)
				return false;
		} else if (!idFinanceInstitut.equals(other.idFinanceInstitut))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
	

}
