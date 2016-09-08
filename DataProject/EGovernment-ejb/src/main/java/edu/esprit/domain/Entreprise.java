package edu.esprit.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Enterprise
 *
 */
@Entity

public class Entreprise implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdEntreprise;

	private String Titre;
	private String Description;
	private String Local;
	private String EtudeMarche;
	private String StatJuridique;
	
	private String Nom;
	private String DateNaissance;
	private String Adresse;
	private double CodePostal;
	private double NumTel;
	private String Email;
	
	public Entreprise() {
		super();
	}

	public int getIdEntreprise() {
		return IdEntreprise;
	}

	public void setIdEntreprise(int idEntreprise) {
		IdEntreprise = idEntreprise;
	}

	public String getTitre() {
		return Titre;
	}

	public void setTitre(String titre) {
		Titre = titre;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getLocal() {
		return Local;
	}

	public void setLocal(String local) {
		Local = local;
	}

	public String getEtudeMarche() {
		return EtudeMarche;
	}

	public void setEtudeMarche(String etudeMarche) {
		EtudeMarche = etudeMarche;
	}

	public String getStatJuridique() {
		return StatJuridique;
	}

	public void setStatJuridique(String statJuridique) {
		StatJuridique = statJuridique;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getDateNaissance() {
		return DateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		DateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	public double getCodePostal() {
		return CodePostal;
	}

	public void setCodePostal(double codePostal) {
		CodePostal = codePostal;
	}

	public double getNumTel() {
		return NumTel;
	}

	public void setNumTel(double numTel) {
		NumTel = numTel;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	
}
