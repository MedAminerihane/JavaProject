package edu.esprit.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Taxe
 *
 */
@Entity

public class Taxe implements Serializable {

	   
	/*public enum Regime {
	    Normal, Simplifié, Simplifié_agricole
	}
	
	public enum Type {
	    Achat_de_Bien, Livraison, Achat_Prestation_De_Service, Exporation
	}*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTaxe;
	private String firstName;
	private String LastName;
	private Date periode;
	private String regime;
	private String type;
	private double perCentTaxe;
	@ManyToOne
	private Company company;
	
	private static final long serialVersionUID = 1L;

	public Taxe() {
		super();
	}   
	
	public Integer getIdTaxe() {
		return this.idTaxe;
	}

	public void setIdTaxe(Integer idTaxe) {
		this.idTaxe = idTaxe;
	}   
	
	public String getRegime() {
		return this.regime;
	}

	public void setRegime(String regime) {
		this.regime = regime;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}   
	public double getPerCentTaxe() {
		return this.perCentTaxe;
	}

	public void setPerCentTaxe(double perCentTaxe) {
		this.perCentTaxe = perCentTaxe;
	}

	public Date getPeriode() {
		return periode;
	}

	public void setPeriode(Date periode) {
		this.periode = periode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
}
