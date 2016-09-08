package edu.esprit.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.sql.Blob;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: BirthRegistration
 *
 */
@Entity

public class BirthRegistration implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idBirthRegistration;
	@Lob
	private byte[] marriageContract;
	private String cin;
	private String childName;
	private Date birthDate;
	private Date registrationDate;
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
	
	private static final long serialVersionUID = 1L;
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
	

	public BirthRegistration() {
		super();
	}   
	public Integer getIdBirthRegistration() {
		return this.idBirthRegistration;
	}

	public void setIdBirthRegistration(Integer idBirthRegistration) {
		this.idBirthRegistration = idBirthRegistration;
	}   
	  
	
	public byte[] getMarriageContract() {
		return marriageContract;
	}
	public void setMarriageContract(byte[] marriageContract) {
		this.marriageContract = marriageContract;
	}
	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}   
	public String getChildName() {
		return this.childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}   
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}   
	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
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
   
}
