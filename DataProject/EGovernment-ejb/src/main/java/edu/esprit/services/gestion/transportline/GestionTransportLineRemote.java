package edu.esprit.services.gestion.transportline;

import java.util.List;

import javax.ejb.Remote;


import edu.esprit.domain.TransportLine;

@Remote
public interface GestionTransportLineRemote {

	Boolean addTransportLine(TransportLine transportLine);
	Boolean deleteTransportLine(TransportLine transportLine);
	Boolean updateTransportLine(TransportLine transportLine);
	TransportLine findTransportLineByNumeroLine(String numeroLine);
	List<TransportLine> findAllTransportLines();
}
