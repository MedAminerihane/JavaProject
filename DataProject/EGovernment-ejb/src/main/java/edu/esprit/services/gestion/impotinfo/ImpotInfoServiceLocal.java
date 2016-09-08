package edu.esprit.services.gestion.impotinfo;

import javax.ejb.Local;

import edu.esprit.domain.ImpotInfo;

@Local
public interface ImpotInfoServiceLocal {

	ImpotInfo findAllImpot();
	
}
