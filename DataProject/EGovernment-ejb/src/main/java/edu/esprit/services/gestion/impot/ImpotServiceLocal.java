package edu.esprit.services.gestion.impot;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.Impot;

@Local
public interface ImpotServiceLocal {

	List<Impot> findAllImpot() ;
	
}
