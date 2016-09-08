package edu.esprit.domain;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: university
 *
 */
@Entity

public class University implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUniversity;
	private String name;
	private String location;
	private String mail;
	private String contact;
	private Float fees;
	@OneToMany(mappedBy="university")
	private List<EDinarServiceRequest> eDinarServiceRequestList  ; 
	private static final long serialVersionUID = 1L;

	public University() {
		super();
	}   
	public Integer getIdUniversity() {
		return this.idUniversity;
	}

	public void setIdUniversity(Integer idUniversity) {
		this.idUniversity = idUniversity;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}   
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}   
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}   
	public Float getFees() {
		return this.fees;
	}

	public void setFees(Float fees) {
		this.fees = fees;
	}
   
}
