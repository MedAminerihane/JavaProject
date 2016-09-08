package edu.esprit.domain;

import edu.esprit.domain.Employee;
import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Agent
 *
 */
@Entity
@DiscriminatorValue(value="agent")
public class Agent extends Employee implements Serializable {

	@ManyToOne
	private Etablishment etablishment ; 
	@OneToMany(mappedBy="agent")
	private List<CinRequest> cinRequestList; 
	@OneToMany(mappedBy="agent")
	private List<BirthRegistration> birthRegistrationList; 
	@OneToMany(mappedBy="agent")
	private List<EDinarServiceRequest> eDinarServiceRequestList ; 
	@OneToMany(mappedBy="agent")
	private List<CareerObjectiveService> careerObjectiveServiceList ; 
	@OneToMany(mappedBy="agent")
	private List<RoadTaxService> RoadTaxServiceList; 
	
	
	private static final long serialVersionUID = 1L;

	public Agent() {
		super();
	}
	
	public Etablishment getEtablishment() {
		return etablishment;
	}
	public void setEtablishment(Etablishment etablishment) {
		this.etablishment = etablishment;
	}
	
}
