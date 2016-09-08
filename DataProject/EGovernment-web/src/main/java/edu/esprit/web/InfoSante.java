package edu.esprit.web;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.esprit.domain.Cinema;
import edu.esprit.domain.Sante;
import edu.esprit.services.gestion.cinema.GestionCinemaLocal;
import edu.esprit.services.gestion.sante.GestionSanteLocal;

@ManagedBean
@ViewScoped
public class InfoSante {

	
	@EJB
	GestionSanteLocal santeService;

	private Sante santes;

	private Sante sante;
	
	public InfoSante(){
		
	}
	
	@PostConstruct
	public void init() {

		santes = santeService.findAllSante();
		sante = new Sante();
	}


	public Sante getSantes() {
		return santes;
	}
	


}
