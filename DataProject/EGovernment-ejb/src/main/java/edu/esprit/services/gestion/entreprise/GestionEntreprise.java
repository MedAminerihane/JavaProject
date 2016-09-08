package edu.esprit.services.gestion.entreprise;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.CareerObjectiveService;
import edu.esprit.domain.Categorie;
import edu.esprit.domain.Entreprise;

/**
 * Session Bean implementation class GestionEntreprise
 */
@Stateless
public class GestionEntreprise implements GestionEntrepriseRemote, GestionEntrepriseLocal {

	@PersistenceContext(unitName = "E-Goverment")
	EntityManager entityManager;

	public GestionEntreprise() {
	}

	@Override
	public Boolean addEntreprise(Entreprise entreprise) {
		try {
			entityManager.persist(entreprise);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Boolean deleteEntreprise(Entreprise entreprise) {
		try {
			entityManager.remove(entreprise);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Boolean updateEntreprise(Entreprise entreprise) {
		try {
			entityManager.merge(entreprise);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Entreprise findEntrepriseById(int idEntreprise) {
		Entreprise entreprise = null;
		try {
			Query query = entityManager
					.createQuery("SELECT OBJECT(e) FROM Entreprise e WHERE e.idEntreprise = :idEntreprise");
			query.setParameter("idEntreprise", idEntreprise);
			entreprise = (Entreprise) query.getSingleResult();
			return entreprise;
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public Entreprise findEntrepriseByTitre(String titre) {
		Entreprise entreprise = null;
		try {
			Query query = entityManager.createQuery("SELECT OBJECT(e) FROM Entreprise e WHERE e.Titre = :Titre");
			query.setParameter("Titre", titre);
			entreprise = (Entreprise) query.getSingleResult();
			return entreprise;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Entreprise findEntrepriseByGerant(String gerant) {
		Entreprise entreprise = null;
		try {
			Query query = entityManager.createQuery("SELECT OBJECT(e) FROM Entreprise e WHERE e.Nom = :Nom");
			query.setParameter("Nom", gerant);
			entreprise = (Entreprise) query.getSingleResult();
			return entreprise;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Entreprise> findEntrepriseBystat(String stat) {
		try {
			Query query = entityManager.createQuery("select e from Entreprise e WHERE e.stat = :stat");
			query.setParameter("stat", stat);
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Entreprise> findAllEntreprise() {
		try {
			Query query = entityManager.createQuery("select e from Entreprise e");
			List<Entreprise> l = query.getResultList();
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

}
