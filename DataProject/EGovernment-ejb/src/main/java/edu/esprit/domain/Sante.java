package edu.esprit.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sante implements Serializable{

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idSante;
	//Conditions d'ouverture d'une pharmacie
	private String pharmacie;
	private String reppharmacies;
	private String lieu ; 
	//Maladies à déclaration obligatoire
	private String maladies ;
	private String notification ;
	private static final long serialVersionUID = 1L;
	
	public Sante(){
		super();
	}

	public Integer getIdSante() {
		return idSante;
	}

	public void setIdSante(Integer idSante) {
		this.idSante = idSante;
	}

	public String getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(String pharmacie) {
		this.pharmacie = pharmacie;
	}

	public String getReppharmacies() {
		return reppharmacies;
	}

	public void setReppharmacies(String reppharmacies) {
		this.reppharmacies = reppharmacies;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getMaladies() {
		return maladies;
	}

	public void setMaladies(String maladies) {
		this.maladies = maladies;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
