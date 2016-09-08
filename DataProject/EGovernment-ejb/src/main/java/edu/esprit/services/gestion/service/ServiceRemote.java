package edu.esprit.services.gestion.service;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.domain.Categorie;
import edu.esprit.domain.Etablishment;
import edu.esprit.domain.RequiredDocument;
import edu.esprit.domain.Service;



@Remote
public interface ServiceRemote {
	
	public void addService(Service s);
	public void updateService(Service s);
	public void deleteService(int idService);
	public List<Service> showAllServices();
	public Service findServiceById(int id);
	public List<Service> findServiceByCategory(Categorie c);
	public List<Service> findServiceByEstablishment(Etablishment e);
	
	public void addDocumentToservice(RequiredDocument d);
	public void updateDocument(RequiredDocument d);
	public void deleteDocument(int idDocument);
	public List<RequiredDocument> getRequiredDocumentsByService(Service s);
	public RequiredDocument findDocumentById(int id);
	

}
