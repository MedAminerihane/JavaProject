package edu.esprit.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cinema implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCinema;
	// ouverture
	private String activites; 
	private String autorisationexp ; 
	private String amenagement ;
	private String homologation ; 
	// Autorisation de séances 
	private String projectionCon ; 
	private String delai ; 
	private String demande  ; 
	// Dépôt légal des films
	private String filmConcerne; 
	private String qui ; 
	private String comment ; 
	private String consultation; 
	// Calendrier d'exploitation des film
	private String demandeDerogation ;
	
	
	private static final long serialVersionUID = 1L;
   
	public Cinema (){
		super();
	}

	public Integer getIdCinema() {
		return idCinema;
	}

	public void setIdCinema(Integer idCinema) {
		this.idCinema = idCinema;
	}

	public String getActivites() {
		return activites;
	}

	public void setActivites(String activites) {
		this.activites = activites;
	}

	public String getAutorisationexp() {
		return autorisationexp;
	}

	public void setAutorisationexp(String autorisationexp) {
		this.autorisationexp = autorisationexp;
	}

	public String getAmenagement() {
		return amenagement;
	}

	public void setAmenagement(String amenagement) {
		this.amenagement = amenagement;
	}

	public String getHomologation() {
		return homologation;
	}

	public void setHomologation(String homologation) {
		this.homologation = homologation;
	}

	public String getProjectionCon() {
		return projectionCon;
	}

	public void setProjectionCon(String projectionCon) {
		this.projectionCon = projectionCon;
	}

	public String getDelai() {
		return delai;
	}

	public void setDelai(String delai) {
		this.delai = delai;
	}

	public String getDemande() {
		return demande;
	}

	public void setDemande(String demande) {
		this.demande = demande;
	}

	public String getFilmConcerne() {
		return filmConcerne;
	}

	public void setFilmConcerne(String filmConcerne) {
		this.filmConcerne = filmConcerne;
	}

	public String getQui() {
		return qui;
	}

	public void setQui(String qui) {
		this.qui = qui;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getConsultation() {
		return consultation;
	}

	public void setConsultation(String consultation) {
		this.consultation = consultation;
	}

	public String getDemandeDerogation() {
		return demandeDerogation;
	}

	public void setDemandeDerogation(String demandeDerogation) {
		this.demandeDerogation = demandeDerogation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

