package edu.esprit.services.gestion.university;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.Etablishment;
import edu.esprit.domain.University;

/**
 * Session Bean implementation class GestionUniversity
 */
@Stateless
public class GestionUniversity implements GestionUniversityRemote, GestionUniversityLocal {

	@PersistenceContext(unitName="E-Goverment")
	EntityManager entityManager;
    public GestionUniversity() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addUniversity(University university) {
		try {
			entityManager.persist(university);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteUniversity(University university) {
		try {
			entityManager.remove(university);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateUniversity(University university) {
		try {
			entityManager.merge(university);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public University findUniversityByName(String name) {
		University university=null;
		try {
			Query queryUniversityByName = entityManager.createQuery(
				    "SELECT OBJECT(e) FROM University e WHERE e.name = :name"
				);
				queryUniversityByName.setParameter("name", name);
			university=(University) queryUniversityByName.getSingleResult();	
			return university;
		} catch (Exception e) {
			
		}
		return university;
	}

	@Override
	public University findUniversityByMail(String mail) {
		University university=null;
		try {
			Query queryUniversityByMail = entityManager.createQuery(
				    "SELECT OBJECT(e) FROM University e WHERE e.mail = :mail"
				);
				queryUniversityByMail.setParameter("mail", mail);
			university=(University) queryUniversityByMail.getSingleResult();	
			return university;
		} catch (Exception e) {
			
		}
		return university;
	}

	@Override
	public University findUniversityByContact(String contact) {
		University university=null;
		try {
			Query queryUniversityByContact = entityManager.createQuery(
				    "SELECT OBJECT(e) FROM University e WHERE e.contact = :contact"
				);
				queryUniversityByContact.setParameter("contact", contact);
			university=(University) queryUniversityByContact.getSingleResult();	
			return university;
		} catch (Exception e) {
			
		}
		return university;
	}

	@Override
	public List<University> findAllUniversity() {
		Query query=entityManager.createQuery("select e from University e");
		return query.getResultList();
	}

}
