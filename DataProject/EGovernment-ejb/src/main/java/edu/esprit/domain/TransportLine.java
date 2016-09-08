package edu.esprit.domain;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TransportLine
 *
 */
@Entity

public class TransportLine implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idLine;
	private String numeroLine;
	private Float fees;
	@OneToMany(mappedBy="transportLine")
	private List<EDinarServiceRequest> eDinarServiceRequestList  ; 
	private static final long serialVersionUID = 1L;

	public TransportLine() {
		super();
	}   
	public Integer getIdLine() {
		return this.idLine;
	}

	public void setIdLine(Integer idLine) {
		this.idLine = idLine;
	}   
	public String getNumeroLine() {
		return this.numeroLine;
	}

	public void setNumeroLine(String numeroLine) {
		this.numeroLine = numeroLine;
	}   
	public Float getFees() {
		return this.fees;
	}

	public void setFees(Float fees) {
		this.fees = fees;
	}
   
}
