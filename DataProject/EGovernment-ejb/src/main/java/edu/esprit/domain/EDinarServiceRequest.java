package edu.esprit.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: EDinarServiceRequest
 *
 */
@Entity

public class EDinarServiceRequest implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEdinarRequest;
	private String requestState;
	private Date requestDate;
	private Date responseDate;
	private String response;
	@ManyToOne
	private University university;
	@ManyToOne
	private EDinarCard eDinarCard ; 
	@ManyToOne
	private Citizen citizen; 
	@ManyToOne
	private TransportLine transportLine; 
	@ManyToOne
	private Agent agent ;
	
	public University getUniversity() {
		return university;
	}
	public void setUniversity(University university) {
		this.university = university;
	}
	public EDinarCard geteDinarCard() {
		return eDinarCard;
	}
	public void seteDinarCard(EDinarCard eDinarCard) {
		this.eDinarCard = eDinarCard;
	}
	
	public Citizen getCitizen() {
		return citizen;
	}
	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}
	public TransportLine getTransportLine() {
		return transportLine;
	}
	public void setTransportLine(TransportLine transportLine) {
		this.transportLine = transportLine;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	private static final long serialVersionUID = 1L;

	public EDinarServiceRequest() {
		super();
	}   
	public Integer getIdEdinarRequest() {
		return this.idEdinarRequest;
	}

	public void setIdEdinarRequest(Integer idEdinarRequest) {
		this.idEdinarRequest = idEdinarRequest;
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
