package edu.esprit.services.gestion.birthregistration;



import java.util.List;

import javax.ejb.Remote;

import edu.esprit.domain.BirthRegistration;


@Remote
public interface GestionBirthRegistrationRemote {
	
	Boolean addBirthRegistration(BirthRegistration birthRegistration);
	Boolean deleteBirthRegistration(BirthRegistration birthRegistration);
	Boolean updateBirthRegistration(BirthRegistration birthRegistration);

	List<BirthRegistration> findAllBirthRegistration();
}
