package edu.esprit.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import edu.esprit.domain.DemandeCinema;
import edu.esprit.services.gestion.demandeCinema.GestionDemandeCinemaLocal;

@ManagedBean
@ViewScoped
public class MapTest {

	
	@EJB
	GestionDemandeCinemaLocal service ; 
	DemandeCinema d ;
	
	    private MapModel geoModel;
	    private MapModel revGeoModel;
	    private String centerGeoMap = "41.850033, -87.6500523";
	     
	    @PostConstruct
	    public void init() {
	        geoModel = new DefaultMapModel();
	        revGeoModel = new DefaultMapModel();
	        d=new DemandeCinema();
	    }
	     
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
	        d.setLieuProjection(centerGeoMap);
	        service.addDemandeCinema(d);
	       
	        
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

