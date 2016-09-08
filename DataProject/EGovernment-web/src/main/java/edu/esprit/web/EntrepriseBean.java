package edu.esprit.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.esprit.domain.Entreprise;
import edu.esprit.services.gestion.entreprise.GestionEntrepriseLocal;

@ManagedBean
@ViewScoped
public class EntrepriseBean {

	@EJB
	GestionEntrepriseLocal EntrepriseService;

	private List<Entreprise> entreprises;
	private Entreprise entreprise;

	

	public EntrepriseBean() {
	}

	@PostConstruct
	public void init() {
		entreprise = new Entreprise();
		setEntreprises(EntrepriseService.findAllEntreprise());
	}

	//CreateEntreprise
	public void CreaEntreprise() {
			EntrepriseService.addEntreprise(entreprise);
			entreprise = new Entreprise();
		
			FacesMessage message = new FacesMessage("Your demand was sent succesfully");
			FacesContext.getCurrentInstance().addMessage(null, message);
	}

	//Getters & Setters
	
	public List<Entreprise> getEntreprises() {
		return entreprises;
	}

	public void setEntreprises(List<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}
	
	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	
	

}
