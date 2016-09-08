package edu.esprit.services.gestion.sante;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.Sante;

@Local
public interface GestionSanteLocal {
	Sante findAllSante();
}
