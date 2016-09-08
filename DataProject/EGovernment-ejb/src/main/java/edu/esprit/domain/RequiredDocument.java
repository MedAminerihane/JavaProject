package edu.esprit.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: RequiredDocument
 *
 */
@Entity

public class RequiredDocument implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idRequiredDocument;
	private String name;
	private String description;
	@ManyToOne
	private Service service ; 
	
	private static final long serialVersionUID = 1L;
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}

	

	public RequiredDocument() {
		super();
	}   
	public Integer getIdRequiredDocument() {
		return this.idRequiredDocument;
	}

	public void setIdRequiredDocument(Integer idRequiredDocument) {
		this.idRequiredDocument = idRequiredDocument;
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
