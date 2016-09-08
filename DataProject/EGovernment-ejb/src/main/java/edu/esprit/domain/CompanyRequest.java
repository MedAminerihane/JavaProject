package edu.esprit.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CompanyRequest {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCompanyRequest;
	private String name;

	private String requestState;
	private Date requestDate;
	private Date responseDate;
	private String response;
	private String description;
	private String eDinarCard ; 
	private String secteurActivity;
	private String type;
	@ManyToOne
	private Citizen citizen; 

	@ManyToOne
	private Agent agent ;

	public Integer getIdCompanyRequest() {
		return idCompanyRequest;
	}

	public void setIdCompanyRequest(Integer idCompanyRequest) {
		this.idCompanyRequest = idCompanyRequest;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String geteDinarCard() {
		return eDinarCard;
	}

	public void seteDinarCard(String eDinarCard) {
		this.eDinarCard = eDinarCard;
	}

	public String getSecteurActivity() {
		return secteurActivity;
	}

	public void setSecteurActivity(String secteurActivity) {
		this.secteurActivity = secteurActivity;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	

}
