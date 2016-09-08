package edu.esprit.services.gestion.requireddocument;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.domain.RequiredDocument;
import edu.esprit.domain.Service;

@Remote
public interface GestionRequiredDocumentRemote {
	Boolean addRequiredDocument(RequiredDocument requiredDocument);
	Boolean deleteRequiredDocument(RequiredDocument requiredDocument);
	Boolean updateRequiredDocument(RequiredDocument requiredDocument);
	List<RequiredDocument> findRequiredDocumentByService(Service service);
	List<RequiredDocument> findAllRequiredDocument();

}
