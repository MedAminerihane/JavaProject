package edu.esprit.services.gestion.etablishment;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.Etablishment;

/**
 * Session Bean implementation class GestionEtablishment
 */
@Stateless
public class GestionEtablishment implements GestionEtablishmentRemote, GestionEtablishmentLocal {

@PersistenceContext(unitName="E-Goverment")
	EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public GestionEtablishment() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addEtablishment(Etablishment etablishment) {
		try {
			entityManager.persist(etablishment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteEtablishment(Etablishment etablishment) {
		try {
			entityManager.remove(etablishment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateEtablishment(Etablishment etablishment) {
		try {
			entityManager.merge(etablishment);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Etablishment findEtablishmentByName(String name) {
		Etablishment etablishment=null;
		try {
			Query queryEtablishmentByName = entityManager.createQuery(
				    "SELECT OBJECT(e) FROM Etablishment e WHERE e.name = :name"
				);
				queryEtablishmentByName.setParameter("name", name);
			etablishment=(Etablishment) queryEtablishmentByName.getSingleResult();	
			return etablishment;
		} catch (Exception e) {
			
		}
		return etablishment;
	}

	@Override
	public List<Etablishment> findAllEtablishments() {
		Query query=entityManager.createQuery("select e from Etablishment e");
		return query.getResultList();
	}

	@Override
	public List<Etablishment> findEtablishmentType() {
		Query query=entityManager.createQuery("select e from Etablishment e");

		return query.getResultList();
	}

	@Override
	public List<Etablishment> findAllEtablishmentsByLocationType(String type, String location) {
		Query query=entityManager.createQuery(""
				+ "select e from Etablishment e WHERE e.type = :type and e.location =:location");
		query.setParameter("type", type);
		query.setParameter("location", location);
		System.out.println(query.toString());
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	@Override
	public List<Etablishment> findEtablishmentsByType(String type) {
		Query query=entityManager.createQuery("select e from Etablishment e WHERE e.type = :type");
		query.setParameter("type", type);
		return query.getResultList();
	}
	
	
	
}
