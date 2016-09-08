package edu.esprit.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Etablishment
 *
 */
@Entity

public class Etablishment implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEtablishment;
	private String name;
	private String location;
	private String longitude;
	private String latitude;
	private String description;
	private String contact;
	private Integer phonenumber;
	private Integer numberCustumer;
	private String type;

	@OneToMany(fetch = FetchType.EAGER,mappedBy="etablishment",cascade = CascadeType.ALL)
	private List<Agent> listAgents; 
	@OneToMany(fetch = FetchType.EAGER,mappedBy="etablishment",cascade = CascadeType.ALL)
	private List<Service> listService; 
	private static final long serialVersionUID = 1L;

	public Etablishment() {
		super();
	}   
	public Integer getIdEtablishment() {
		return this.idEtablishment;
	}

	public void setIdEtablishment(Integer idEtablishment) {
		this.idEtablishment = idEtablishment;
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
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}   
	public Integer getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(Integer phonenumber) {
		this.phonenumber = phonenumber;
	}
	public List<Agent> getListAgents() {
		return listAgents;
	}
	public void setListAgents(List<Agent> listAgents) {
		this.listAgents = listAgents;
	}
	public List<Service> getListService() {
		return listService;
	}
	public void setListService(List<Service> listService) {
		this.listService = listService;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public Integer getNumberCustumer() {
		return numberCustumer;
	}
	public void setNumberCustumer(Integer numberCustumer) {
		this.numberCustumer = numberCustumer;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
   
}