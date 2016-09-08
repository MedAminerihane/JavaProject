package edu.esprit.services.gestion.cinema;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.Cinema;

/**
 * Session Bean implementation class GestionCinema
 */
@Stateless
public class GestionCinema implements GestionCinemaRemote, GestionCinemaLocal {

	@PersistenceContext(unitName="E-Goverment")
	EntityManager entityManager;
	
    public GestionCinema() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public Cinema findAllCinema() {
		  int id=1;
		Query query=entityManager.createQuery("select c from Cinema c WHERE c.idCinema ="+id);
        try {
			return (Cinema)query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
			
		
	}

}
