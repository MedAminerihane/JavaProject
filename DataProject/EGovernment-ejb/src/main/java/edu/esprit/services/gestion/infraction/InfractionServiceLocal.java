package edu.esprit.services.gestion.infraction;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.Infraction;



@Local
public interface InfractionServiceLocal {
	public List<Infraction> getAll();

}
