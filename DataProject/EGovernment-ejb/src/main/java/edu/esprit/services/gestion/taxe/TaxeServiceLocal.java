package edu.esprit.services.gestion.taxe;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.Taxe;;

@Local
public interface TaxeServiceLocal {

	Boolean addTaxe(Taxe taxe);
	Boolean updateTaxe(Taxe taxe);
	List<Taxe> findTaxeByCompany(String codeFiscal);
	
}
