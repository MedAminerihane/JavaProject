package edu.esprit.services.gestion.requireddocument;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.RequiredDocument;
import edu.esprit.domain.Service;

/**
 * Session Bean implementation class GestionRequiredDocument
 */
@Stateless
public class GestionRequiredDocument implements GestionRequiredDocumentRemote, GestionRequiredDocumentLocal {

	@PersistenceContext(unitName="E-Goverment")EntityManager entityManager;
    public GestionRequiredDocument() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addRequiredDocument(RequiredDocument requiredDocument) {
		try {
			entityManager.persist(requiredDocument);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteRequiredDocument(RequiredDocument requiredDocument) {
		try {
			entityManager.remove(entityManager.merge(requiredDocument));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateRequiredDocument(RequiredDocument requiredDocument) {
		try {
			entityManager.merge(requiredDocument);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<RequiredDocument> findAllRequiredDocument() {
		try {
			Query query=entityManager.createQuery("select c from RequiredDocument c");
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<RequiredDocument> findRequiredDocumentByService(Service service) {
		try {
			Query query=entityManager.createQuery("select c from RequiredDocument c WHERE c.service = :service");
			query.setParameter("service", service);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

}
