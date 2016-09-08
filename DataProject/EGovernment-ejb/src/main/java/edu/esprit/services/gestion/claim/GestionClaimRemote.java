package edu.esprit.services.gestion.claim;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.domain.Citizen;
import edu.esprit.domain.Claim;
import edu.esprit.domain.Employee;

@Remote
public interface GestionClaimRemote {
	Boolean addClaim(Claim claim);
	Boolean deleteClaim(Claim claim);
	Boolean updateClaim(Claim claim);
	Claim findClaimById(int id);
	List<Claim> findClaimsBySubject(String subject);
	List<Claim> findClaimsByState(String state);
	List<Claim> findClaimsByCitizen(Citizen citizen);
	List<Claim> findClaimsByAgent(Employee employee);
	List<Claim> findAllClaim();
	List<Claim> findClaimClient();
}
