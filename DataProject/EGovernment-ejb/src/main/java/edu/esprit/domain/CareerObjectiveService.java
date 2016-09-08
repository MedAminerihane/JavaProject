package edu.esprit.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CareerObjectiveService
 *
 */
@Entity

public class CareerObjectiveService implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCareer;
	private String cin;
	private String b3;
	@Lob
	private  byte[] birthcertificate;
	private String giroAccount;
	private String requestState;
	private Date requestDate;
	private Date responseDate;
	private String response;
	@ManyToOne
	private Citizen citizen ; 
	@ManyToOne
	private Service service  ;
	@ManyToOne
	private Agent agent;
	
	
	public Citizen getCitizen() {
		return citizen;
	}
	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public String getRequestState() {
		return requestState;
	}
	public void setRequestState(String requestState) {
		this.requestState = requestState;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public Date getResponseDate() {
		return responseDate;
	}
	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	public CareerObjectiveService() {
		super();
	}   
	public Integer getIdCareer() {
		return this.idCareer;
	}

	public void setIdCareer(Integer idCareer) {
		this.idCareer = idCareer;
	}   
	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}   
	public String getB3() {
		return this.b3;
	}

	public void setB3(String b3) {
		this.b3 = b3;
	}   
 
	
	public byte[] getBirthcertificate() {
		return birthcertificate;
	}
	public void setBirthcertificate(byte[] birthcertificate) {
		this.birthcertificate = birthcertificate;
	}
	public String getGiroAccount() {
		return this.giroAccount;
	}

	public void setGiroAccount(String giroAccount) {
		this.giroAccount = giroAccount;
	}
   
}
