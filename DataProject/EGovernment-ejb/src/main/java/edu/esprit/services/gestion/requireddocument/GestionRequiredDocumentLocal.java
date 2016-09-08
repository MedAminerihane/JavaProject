package edu.esprit.services.gestion.requireddocument;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.RequiredDocument;
import edu.esprit.domain.Service;

@Local
public interface GestionRequiredDocumentLocal {

	List<RequiredDocument> findRequiredDocumentByService(Service service);
	List<RequiredDocument> findAllRequiredDocument();
}
