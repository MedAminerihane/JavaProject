package edu.esprit.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Claim
 *
 */
@Entity

public class Claim implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idClaim;
	private String subject;
	private String textClaim;
	private String mail;
	private String state;
	private String type; 
	@ManyToOne
	private Citizen citizen ; 
	@ManyToOne
    private Employee employee; 
	
	
	private String response ;
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}

	public Citizen getCitizen() {
		return citizen;
	}
	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	private static final long serialVersionUID = 1L;

	public Claim() {
		super();
	}   
	public Integer getIdClaim() {
		return this.idClaim;
	}

	public void setIdClaim(Integer idClaim) {
		this.idClaim = idClaim;
	}   
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}   
	public String getTextClaim() {
		return this.textClaim;
	}

	public void setTextClaim(String textClaim) {
		this.textClaim = textClaim;
	}   
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}   
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
   
}
