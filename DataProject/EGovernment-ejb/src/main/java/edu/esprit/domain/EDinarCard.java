package edu.esprit.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: EDianrCard
 *
 */
@Entity

public class EDinarCard implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEDinarCard;
	private String numeroCard;
	private String passwordCard;
	private Date expirationDate;
	private Date creationDate;
	@ManyToOne
	private Citizen citizen;
	@OneToMany(mappedBy="eDinarCard")
	private List<EDinarServiceRequest> eDinarServiceRequestList  ; 
	private static final long serialVersionUID = 1L;

	public EDinarCard() {
		super();
	}   
	public Integer getIdEDinarCard() {
		return this.idEDinarCard;
	}

	public void setIdEDinarCard(Integer idEDinarCard) {
		this.idEDinarCard = idEDinarCard;
	}   
	public String getNumeroCard() {
		return this.numeroCard;
	}

	public void setNumeroCard(String numeroCard) {
		this.numeroCard = numeroCard;
	}   
	public String getPasswordCard() {
		return this.passwordCard;
	}

	public void setPasswordCard(String passwordCard) {
		this.passwordCard = passwordCard;
	}   
	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}   
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Citizen getCitizen() {
		return citizen;
	}
	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}
	public List<EDinarServiceRequest> geteDinarServiceRequestList() {
		return eDinarServiceRequestList;
	}
	public void seteDinarServiceRequestList(List<EDinarServiceRequest> eDinarServiceRequestList) {
		this.eDinarServiceRequestList = eDinarServiceRequestList;
	}

   
}
