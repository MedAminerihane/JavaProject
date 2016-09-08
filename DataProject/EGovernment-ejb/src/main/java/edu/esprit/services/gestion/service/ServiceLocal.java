package edu.esprit.services.gestion.service;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.Categorie;
import edu.esprit.domain.Etablishment;
import edu.esprit.domain.RequiredDocument;
import edu.esprit.domain.Service;

@Local
public interface ServiceLocal {

	public List<Service> showAllServices();
	public Service findServiceById(int id);
	public List<Service> findServiceByCategory(Categorie c);
	public List<Service> findServiceByEstablishment(Etablishment e);
	public List<RequiredDocument> getRequiredDocumentsByService(Service s);
	public RequiredDocument findDocumentById(int id);
}
