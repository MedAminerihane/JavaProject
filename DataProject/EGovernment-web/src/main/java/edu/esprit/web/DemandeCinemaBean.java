package edu.esprit.web;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import edu.esprit.services.gestion.demandeCinema.GestionDemandeCinemaLocal;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.esprit.domain.Cinema;
import edu.esprit.domain.DemandeCinema;
import edu.esprit.domain.DemandePharmacie;
import edu.esprit.services.gestion.cinema.GestionCinemaLocal;
import edu.esprit.services.gestion.demandeCinema.GestionDemandeCinemaLocal;


@ManagedBean
@SessionScoped
public class DemandeCinemaBean {

	private DemandeCinema demandeCinema; 
	@EJB
	GestionDemandeCinemaLocal demandeCinService;
	
	
	// map 
	    private MapModel geoModel;
	    private MapModel revGeoModel;
	    private String centerGeoMap = "41.850033, -87.6500523";
	
	@PostConstruct
	public void init() {
        demandeCinema=new DemandeCinema();
        geoModel = new DefaultMapModel();
        revGeoModel = new DefaultMapModel();
	}
	
	public DemandeCinema getDemandeCinema() {
		return demandeCinema;
	}

	public void setDemandeCinema(DemandeCinema demandeCinema) {
		this.demandeCinema = demandeCinema;
	}

	public void adddemandeCinema() throws IOException {
	   
		      //  DemandeCinema d= demandeCinService.getLastDemandeCinema();
		
			    
				demandeCinService.addDemandeCinema(demandeCinema);
				
				demandeCinema=new DemandeCinema();
				
				FacesMessage message = new FacesMessage("Your demand was sent succesfully");
		        FacesContext.getCurrentInstance().addMessage(null, message);
		
		
	}

//map 
	
	
	public void onGeocode(GeocodeEvent event) {
        List<GeocodeResult> results = event.getResults();
        geoModel= new DefaultMapModel();
        if (results != null && !results.isEmpty()) {
            LatLng center = results.get(0).getLatLng();
            centerGeoMap = center.getLat() + "," + center.getLng();
           
            for (int i = 0; i < results.size(); i++) {
                GeocodeResult result = results.get(i);
                geoModel.addOverlay(new Marker(result.getLatLng(), result.getAddress()));
            }
        }
        demandeCinema.setLieuProjection(centerGeoMap);
       
       
        
    }
    
    public MapModel getGeoModel() {
        return geoModel;
    }
 
    public MapModel getRevGeoModel() {
        return revGeoModel;
    }
 
    public String getCenterGeoMap() {
        return centerGeoMap;
    }
 
}
