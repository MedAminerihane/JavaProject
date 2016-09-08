package edu.esprit.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;


@Entity
public class DemandePharmacie implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idDemande;
	private String nom ; 
	private String prenom ;
	private String lieu ; 
	private double montant ; 
	@Lob
	private byte[] cin ; 
	@Lob
	private byte[] diplome ; 
	
	private static final long serialVersionUID = 1L;
	
	public DemandePharmacie (){
		super();
	}

	public Integer getIdDemande() {
		return idDemande;
	}

	public void setIdDemande(Integer idDemande) {
		this.idDemande = idDemande;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public byte[] getCin() {
		return cin;
	}

	public void setCin(byte[] cin) {
		this.cin = cin;
	}

	public byte[] getDiplome() {
		return diplome;
	}

	public void setDiplome(byte[] diplome) {
		this.diplome = diplome;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
}
