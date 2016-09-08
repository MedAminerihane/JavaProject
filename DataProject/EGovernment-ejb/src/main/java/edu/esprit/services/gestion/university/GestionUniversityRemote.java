package edu.esprit.services.gestion.university;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.domain.University;


@Remote
public interface GestionUniversityRemote {
	Boolean addUniversity(University university);
	Boolean deleteUniversity(University university);
	Boolean updateUniversity(University university);
	University findUniversityByName(String name);
	University findUniversityByMail(String mail);
	University findUniversityByContact(String contact);
	List<University> findAllUniversity();
}
