package edu.esprit.domain;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Impot
 *
 */
@Entity

public class Impot implements Serializable {
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idImpot;
	private String type;
	private String activite_statue_juridique;
	private static final long serialVersionUID = 1L;

	public Impot() {
		super();
	}   
	public Integer getIdImpot() {
		return this.idImpot;
	}

	public void setIdImpot(Integer idImpot) {
		this.idImpot = idImpot;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}   
	public String getActivite_statue_juridique() {
		return this.activite_statue_juridique;
	}

	public void setActivite_statue_juridique(String activite_statue_juridique) {
		this.activite_statue_juridique = activite_statue_juridique;
	}
   
}
