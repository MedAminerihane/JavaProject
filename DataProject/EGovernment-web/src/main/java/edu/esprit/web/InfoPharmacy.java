package edu.esprit.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import org.primefaces.component.fileupload.FileUploadRenderer;
import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import edu.esprit.domain.Cinema;
import edu.esprit.domain.DemandeCinema;
import edu.esprit.domain.DemandePharmacie;
import edu.esprit.services.gestion.demandePharmacie.GestionDemandePhLocal;

@ManagedBean
@SessionScoped
public class InfoPharmacy extends FileUploadRenderer {

	
	

	private DemandePharmacie demandeph;
	private Part  fileCin; 
	private Part  fileDiplome; 

	@EJB
	GestionDemandePhLocal demandeService;
	
	//MAP
	@EJB
	GestionDemandePhLocal service ; 
	DemandePharmacie d ;
	
	    private MapModel geoModel;
	    private MapModel revGeoModel;
	    private String centerGeoMap = "41.850033, -87.6500523";
	
	public InfoPharmacy(){
		
	}
	@PostConstruct
	public void init() {
		demandeph = new DemandePharmacie();
		//map
		geoModel = new DefaultMapModel();
	    revGeoModel = new DefaultMapModel();
	    d=new DemandePharmacie();

	}
	
	
	  @Override
	public void decode(FacesContext context, UIComponent component) {
	        if (context.getExternalContext().getRequestContentType().toLowerCase().startsWith("multipart/")) {
	            super.decode(context, component);
	        }
	    }
	
	
	public void addDemande() throws IOException {

	 
        
		demandeph.setCin(changeToByte(fileCin));
		demandeph.setDiplome(changeToByte(fileDiplome));
	
		demandeService.addDemandePh(demandeph);
		//demandeph=new DemandePharmacie();
		FacesMessage message = new FacesMessage("Your demand was sent succesfully");
        FacesContext.getCurrentInstance().addMessage(null, message);
	}
	

	public DemandePharmacie getDemande() {
		return demandeph;
	}
    public Part getfileCin(){
		return fileCin ; 
	 }
    public void setfileCin(Part p){
		fileCin =p; 
	 }
    public Part getfileDiplome(){
    	return fileDiplome;
	 }
    public void setfileDiplome(Part p){
    	fileDiplome=p;
	 }
    
    
    public void showMapp() throws IOException{

    	
    	 FacesContext.getCurrentInstance().getExternalContext().redirect("MapPhar.jsf");
    	 FacesContext.getCurrentInstance().responseComplete();
    }
    
    
    
    public byte[] changeToByte(Part file1) throws IOException{
		   InputStream inputStream = null;
	        OutputStream outputStream = null;
	        FacesContext context = FacesContext.getCurrentInstance();
	        ServletContext servletContext = (ServletContext) context
	                .getExternalContext().getContext();
	        String path = servletContext.getRealPath("");
	        boolean file1Success = false;
	        if (file1.getSize() > 0) {
	           // String fileName = Utils.getFileNameFromPart(part)
	           
	           
	            inputStream = file1.getInputStream();
	        }
	            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
               
	            int nRead;
	            byte[] data = new byte[16384];

	            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
	              buffer.write(data, 0, nRead);
	            }

	            buffer.flush();

	            return buffer.toByteArray() ;
	}
	
    //MAP
    
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
        demandeph.setLieu(centerGeoMap);
       
       
        
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
