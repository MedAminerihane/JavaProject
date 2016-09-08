package edu.esprit.services.gestion.sante;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import edu.esprit.domain.Sante;

/**
 * Session Bean implementation class GestionSante
 */
@Stateless
public class GestionSante implements GestionSanteRemote, GestionSanteLocal {

	@PersistenceContext(unitName="E-Goverment")
	EntityManager entityManager;
	
    public GestionSante() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public Sante findAllSante() {
		int id =1;
		
			Query query=entityManager.createQuery("select c from Sante c where idSante="+id);
			
			return (Sante)query.getSingleResult();
			}
		

}
