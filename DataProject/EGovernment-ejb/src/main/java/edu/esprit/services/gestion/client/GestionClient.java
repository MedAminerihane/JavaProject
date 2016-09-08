package edu.esprit.services.gestion.client;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.Client;
import edu.esprit.domain.Employee;

/**
 * Session Bean implementation class GestionClient
 */
@Stateless
public class GestionClient implements GestionClientRemote, GestionClientLocal {

	@PersistenceContext(unitName="E-Goverment")
	EntityManager entityManager;
	
    public GestionClient() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Client> findAllClient() {
		Query query=entityManager.createQuery("select e from Client e");
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Client authentificate(String login, String pwd) {
        
		Client client=null;
		Query query = entityManager.createQuery("select e from Client e where e.login=:l and e.password=:p");
		System.out.println(login+" "+pwd);
		query.setParameter("l", login).setParameter("p", pwd);
		try {
			client = (Client) query.getSingleResult();
		} catch (Exception e) {
			client = null;
		}
		return client;
	}

}
