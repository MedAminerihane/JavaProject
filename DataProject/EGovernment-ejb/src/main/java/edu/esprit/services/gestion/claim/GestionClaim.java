package edu.esprit.services.gestion.claim;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import edu.esprit.domain.Citizen;
import edu.esprit.domain.Claim;
import edu.esprit.domain.Employee;

/**
 * Session Bean implementation class GestionClaim
 */
@Stateless
public class GestionClaim implements GestionClaimLocal , GestionClaimRemote {
	@PersistenceContext(unitName="E-Goverment")
	EntityManager entityManager;
   
    public GestionClaim() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Boolean addClaim(Claim claim) {
		try {
			entityManager.persist(claim);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteClaim(Claim claim) {
		try {
			entityManager.remove(entityManager.merge(claim));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean updateClaim(Claim claim) {
		try {
			entityManager.merge(claim);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public List<Claim> findClaimsBySubject(String subject) {
		Query query=entityManager.createQuery(""
				+ "select e from Claim e WHERE e.subject = :subject");
		query.setParameter("subject", subject);
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Claim> findAllClaim() {
		Query query=entityManager.createQuery("select c from Claim c");
		return query.getResultList();
		
	}

	@Override
	public List<Claim> findClaimsByState(String state) {
		Query query=entityManager.createQuery(""
				+ "select e from Claim e WHERE e.state = :state");
		query.setParameter("state", state);
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Claim> findClaimsByCitizen(Citizen citizen) {
		Query query=entityManager.createQuery(""
				+ "select e from Claim e WHERE e.citizen = :citizen");
		query.setParameter("citizen", citizen);
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Claim> findClaimsByAgent(Employee employee) {
		Query query=entityManager.createQuery(""
				+ "select e from Claim e WHERE e.employee = :employee and e.type = :type");
		query.setParameter("employee", employee).setParameter("type", 0);
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Claim findClaimById(int id) {
		Query query=entityManager.createQuery(""
				+ "select e from Claim e WHERE e.idClaim = :id");
		query.setParameter("id", id);
		try {
			return (Claim)query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Claim> findClaimClient() {
		String type="1";
		Query query=entityManager.createQuery(""
				+ "select e from Claim e WHERE e.type = :type");
		query.setParameter("type", type);
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Claim> findClaimByCitizen(int id) {
		Query query1=entityManager.createQuery(""
				+ "select e from Client e WHERE e.idClient = :id");
		query1.setParameter("id", id);
		Citizen citizen = (Citizen) query1.getSingleResult();
		Query query=entityManager.createQuery(""
				+ "select e from Claim e WHERE e.citizen = :citizen");
		query.setParameter("citizen", citizen);
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void addClaim(String subject, String textclaim, String mail, int idCitizen) {
		Claim claim=new Claim();
		claim.setSubject(subject);
		claim.setTextClaim(textclaim);
		claim.setMail(mail);
		claim.setState("untreated");
		Query query1=entityManager.createQuery(""
				+ "select e from Client e WHERE e.idClient = :id");
		query1.setParameter("id", idCitizen);
		Citizen citizen = (Citizen) query1.getSingleResult();		
		claim.setCitizen(citizen);
		
		try {
			entityManager.persist(claim);
		} catch (Exception e) {
		}		
	}

	@Override
	public List<Claim> findResponseByCitizen(int id) {
		Query query1=entityManager.createQuery(""
				+ "select e from Client e WHERE e.idClient = :id");
		query1.setParameter("id", id);
		Citizen citizen = (Citizen) query1.getSingleResult();
		
		Query query=entityManager.createQuery(""
				+ "select e from Claim e WHERE e.citizen = :id and e.state = :sate");
		query.setParameter("id", citizen).setParameter("sate", "treated");
		try {
			return query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

}
