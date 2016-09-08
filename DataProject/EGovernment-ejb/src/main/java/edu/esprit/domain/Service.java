package edu.esprit.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Service
 *
 */
@Entity

public class Service implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idService;
	private String name;
	private String description;
	@ManyToOne
	private Etablishment etablishment ; 
	@ManyToOne
	private Categorie categorie ; 
	@OneToMany(mappedBy="service")
	private List<CinRequest> cinRequestList; 
	@OneToMany(mappedBy="service")
	private List<BirthRegistration> birthRegistrationList; 
	@OneToMany(mappedBy="service")
	private List<CareerObjectiveService> careerObjectiveServiceList ; 
	@OneToMany(mappedBy="service")
	private List<RoadTaxService> RoadTaxServiceList  ; 
	@OneToMany(mappedBy="service")
	private List<RequiredDocument>  requiredDocumentList ; 
	
	public Etablishment getEtablishment() {
		return etablishment;
	}
	public void setEtablishment(Etablishment etablishment) {
		this.etablishment = etablishment;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	private static final long serialVersionUID = 1L;

	public Service() {
		super();
	}   
	public Integer getIdService() {
		return this.idService;
	}

	public void setIdService(Integer idService) {
		this.idService = idService;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}
