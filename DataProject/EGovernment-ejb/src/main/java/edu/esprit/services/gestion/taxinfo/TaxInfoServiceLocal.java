package edu.esprit.services.gestion.taxinfo;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.TaxInfo;

@Local
public interface TaxInfoServiceLocal {

	TaxInfo findAllTaxInfo();
	
}
