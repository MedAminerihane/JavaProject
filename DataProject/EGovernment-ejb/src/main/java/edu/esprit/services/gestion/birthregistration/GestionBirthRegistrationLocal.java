package edu.esprit.services.gestion.birthregistration;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.BirthRegistration;

@Local
public interface GestionBirthRegistrationLocal {

	List<BirthRegistration> findAllBirthRegistration();

}
