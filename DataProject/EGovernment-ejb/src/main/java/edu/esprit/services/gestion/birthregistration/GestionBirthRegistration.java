package edu.esprit.services.gestion.birthregistration;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.BirthRegistration;

/**
 * Session Bean implementation class GestionBirthRegistration
 */
@Stateless
public class GestionBirthRegistration implements GestionBirthRegistrationRemote, GestionBirthRegistrationLocal {

	@PersistenceContext(unitName="E-Goverment")
	EntityManager entityManager;
    
	public GestionBirthRegistration() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addBirthRegistration(BirthRegistration birthRegistration) {
		try {
			entityManager.persist(birthRegistration);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteBirthRegistration(BirthRegistration birthRegistration) {
		try {
			entityManager.remove(entityManager.merge(birthRegistration));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateBirthRegistration(BirthRegistration birthRegistration) {
		try {
			entityManager.merge(birthRegistration);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<BirthRegistration> findAllBirthRegistration() {
		try {
			Query query=entityManager.createQuery("select c from BirthRegistration c");
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}


}
