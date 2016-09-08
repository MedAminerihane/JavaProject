package edu.esprit.services.gestion.claim;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.Claim;

@Local
public interface GestionClaimLocal {
	List<Claim> findAllClaim();
	List<Claim> findClaimByCitizen(int id);
	void addClaim(String subjext , String textclaim, String mail , int idCitizen);
	Boolean addClaim(Claim claim);
	List<Claim> findResponseByCitizen(int id);
	

}
