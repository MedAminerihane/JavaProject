package edu.esprit.services.gestion.eDinarCard;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.Categorie;
import edu.esprit.domain.EDinarCard;

@Stateless
public class GestionEDinarCard implements GestionEDinarCardRemote, GestionEDinarCardLocal {

@PersistenceContext(unitName="E-Goverment")
  EntityManager entityManager;
    public GestionEDinarCard() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addEDinarCard(EDinarCard eDinarCard) {
		try {
			entityManager.persist(eDinarCard);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteEDinarCard(EDinarCard eDinarCard) {
		try {
			entityManager.remove(entityManager.merge(eDinarCard));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateEDinarCard(EDinarCard eDinarCard) {
		try {
			entityManager.merge(eDinarCard);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public EDinarCard findEDinarCardByNumeroCard(String numeroCard) {
		EDinarCard eDinarCard = null;
		try {
			Query queryEDinarCardByNumeroCard = entityManager.createQuery(
				    "SELECT OBJECT(c) FROM EDinarCard c WHERE c.numeroCard = :numeroCard"
				);
			queryEDinarCardByNumeroCard.setParameter("numeroCard", numeroCard);
			eDinarCard = (EDinarCard) queryEDinarCardByNumeroCard.getSingleResult();
			return eDinarCard; 
		} catch (Exception e) {
		}
		return eDinarCard;
	}

	@Override
	public List<EDinarCard> findAllEDinarCard() {
	
		try {
			Query query=entityManager.createQuery("select c from EDinarCard c");
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

}
