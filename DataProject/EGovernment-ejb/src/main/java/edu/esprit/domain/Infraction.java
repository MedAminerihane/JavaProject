package edu.esprit.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Infraction
 *
 */
@Entity

public class Infraction implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInfraction;
	private String date;
	private float montant;
	private int delai;
	private String title;
	
	private static final long serialVersionUID = 1L;

	public Infraction() {
		super();
	}

	public int getIdInfraction() {
		return idInfraction;
	}

	public void setIdInfraction(int idInfraction) {
		this.idInfraction = idInfraction;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	
	
	
   
}
