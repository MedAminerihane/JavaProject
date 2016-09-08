package edu.esprit.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Citizen
 *
 */
@Entity
@DiscriminatorValue(value="citizen")
public class Citizen extends Client implements Serializable {

	private String firstName;
	private String lastName;
	private String cin; 
	private String B3;
	private String carteGrise;
	private String pictureID;
	private String statusResidence;
	private String drivingLicense;
	@OneToMany(mappedBy="citizen")
	private List<CinRequest> cinRequestList; 
	@OneToMany(mappedBy="citizen")
	private List<BirthRegistration> birthRegistrationList; 
	@OneToMany(mappedBy="citizen")
	private List<EDinarServiceRequest> eDinarServiceRequestList ; 
	@OneToMany(mappedBy="citizen")
	private List<CareerObjectiveService> careerObjectiveServiceList ; 
	@OneToMany(mappedBy="citizen")
	private List<Claim> ClaimList ; 
	@OneToMany(mappedBy="citizen")
	private List<RoadTaxService> RoadTaxServiceList  ; 
	@OneToMany(mappedBy="citizen")
	private List<EDinarCard>   eDianrCardList ; 
	private static final long serialVersionUID = 1L;

	public Citizen() {
		super();
	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getB3() {
		return B3;
	}

	public void setB3(String b3) {
		B3 = b3;
	}

	public String getCarteGrise() {
		return carteGrise;
	}

	public void setCarteGrise(String carteGrise) {
		this.carteGrise = carteGrise;
	}

	public String getPictureID() {
		return pictureID;
	}

	public void setPictureID(String pictureID) {
		this.pictureID = pictureID;
	}

	public String getStatusResidence() {
		return statusResidence;
	}

	public void setStatusResidence(String statusResidence) {
		this.statusResidence = statusResidence;
	}

	public String getDrivingLicense() {
		return drivingLicense;
	}

	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	
	
   
}
