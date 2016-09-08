package edu.esprit.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: RoadTaxService
 *
 */
@Entity

public class RoadTaxService implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idRoadTaxService;
	private String requestState;
	private Date requestDate;
	private Date responseDate;
	private String response;
	private  String cin;
	@Lob
	private  byte[] drivingLicense ; 
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
	public Employee getAgent() {
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
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public byte[] getDrivingLicense() {
		return drivingLicense;
	}
	public void setDrivingLicense(byte[] drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;

	public RoadTaxService() {
		super();
	}   
	public Integer getIdRoadTaxService() {
		return this.idRoadTaxService;
	}

	public void setIdRoadTaxService(Integer idRoadTaxService) {
		this.idRoadTaxService = idRoadTaxService;
	}

   
}
