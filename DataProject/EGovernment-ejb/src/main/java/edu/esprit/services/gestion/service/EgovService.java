package edu.esprit.services.gestion.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.Categorie;
import edu.esprit.domain.Etablishment;
import edu.esprit.domain.RequiredDocument;
import edu.esprit.domain.Service;


/**
 * Session Bean implementation class Service
 */
@Stateless
public class EgovService implements ServiceRemote, ServiceLocal {
	
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public EgovService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addService(Service s) {
		// TODO Auto-generated method stub
		em.persist(s);
		
	}

	@Override
	public void updateService(Service s) {
		// TODO Auto-generated method stub
		em.merge(s);
		
	}

	@Override
	public void deleteService(int idService) {
		// TODO Auto-generated method stub
		em.remove(findServiceById(idService));
		
	}

	@Override
	public List<Service> showAllServices() {
		// TODO Auto-generated method stub
		String queryText = "select s from Service s";
		Query query = em.createQuery(queryText);
		return query.getResultList();
	}

	@Override
	public Service findServiceById(int id) {
		// TODO Auto-generated method stub
		return em.find(Service.class, id);
	}

	@Override
	public List<Service> findServiceByCategory(Categorie c) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select s from Service s where s.categorie=:param1");
		query.setParameter("param1", c);
		List<Service> services = null;
		try {
			services = query.getResultList();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error" + e.getMessage());
		}
		return services;
	}

	@Override
	public List<Service> findServiceByEstablishment(Etablishment e) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("select s from Service s where s.etablishment=:param1");
		query.setParameter("param1", e);
		List<Service> services = null;
		try {
			services = query.getResultList();

		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println("error" + ex.getMessage());
		}
		return services;	}

	@Override
	public void addDocumentToservice(RequiredDocument d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDocument(RequiredDocument d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDocument(int idDocument) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RequiredDocument> getRequiredDocumentsByService(Service s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RequiredDocument findDocumentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
