package edu.esprit.web;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.esprit.domain.Cinema;
import edu.esprit.domain.DemandeCinema;
import edu.esprit.domain.DemandePharmacie;
import edu.esprit.services.gestion.cinema.GestionCinemaLocal;
import edu.esprit.services.gestion.demandeCinema.GestionDemandeCinemaLocal;


@ManagedBean
@ViewScoped
public class InfoCinemaBean {

	@EJB
	GestionCinemaLocal cinemaService;
	
	
	private Cinema cinemas;

	private Cinema cinema;

	
	public InfoCinemaBean() {
	}

	@PostConstruct
	public void init() {

		cinemas = cinemaService.findAllCinema();
		cinema = new Cinema();
	}

	public Cinema getCinema() {
		return cinemas;
	}
	
	public String Open() {

		return "/OpenCinema";
	}


	
	

}
