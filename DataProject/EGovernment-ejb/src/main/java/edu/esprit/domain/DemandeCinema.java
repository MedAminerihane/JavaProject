package edu.esprit.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DemandeCinema implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idDemandeCinema;
	private String nameCinema ; 
	private String cinClient ; 
	private String filmName; 
	private String lieuProjection ; 
	private int nbreWatcher ; 
	
	private static final long serialVersionUID = 1L;

	public Integer getIdDemandeCinema() {
		return idDemandeCinema;
	}

	public void setIdDemandeCinema(Integer idDemandeCinema) {
		this.idDemandeCinema = idDemandeCinema;
	}

	public String getNameCinema() {
		return nameCinema;
	}

	public void setNameCinema(String nameCinema) {
		this.nameCinema = nameCinema;
	}

	public String getCinClient() {
		return cinClient;
	}

	public void setCinClient(String cinClient) {
		this.cinClient = cinClient;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getLieuProjection() {
		return lieuProjection;
	}

	public void setLieuProjection(String lieuProjection) {
		this.lieuProjection = lieuProjection;
	}

	public int getNbreWatcher() {
		return nbreWatcher;
	}

	public void setNbreWatcher(int nbreWatcher) {
		this.nbreWatcher = nbreWatcher;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
