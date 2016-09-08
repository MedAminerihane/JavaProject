package edu.esprit.services.gestion.categorie;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.Categorie;

/**
 * Session Bean implementation class GestionCategorie
 */
@Stateless
public class GestionCategorie implements GestionCategorieRemote, GestionCategorieLocal {

@PersistenceContext(unitName="E-Goverment")
	EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public GestionCategorie() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addCategorie(Categorie categorie) {
		try {
			entityManager.persist(categorie);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteCategorie(Categorie categorie) {
		try {
			entityManager.remove(entityManager.merge(categorie));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateCategorie(Categorie categorie) {
		try {
			entityManager.merge(categorie);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Categorie findCategorieByName(String name) {
		Categorie categorie = null;
		try {
			Query queryCategorieByName = entityManager.createQuery(
				    "SELECT OBJECT(c) FROM Categorie c WHERE c.name = :name"
				);
			queryCategorieByName.setParameter("name", name);
			categorie = (Categorie) queryCategorieByName.getSingleResult();
			return categorie; 
		} catch (Exception e) {
		}
		return categorie;
	}

	@Override
	public List<Categorie> findAllCategorie() {
		
			Query query=entityManager.createQuery("select c from Categorie c");
			List<Categorie> l = query.getResultList();
			System.out.println("hubuh"+l.get(0).getName());
			return query.getResultList();
		
	}

}
