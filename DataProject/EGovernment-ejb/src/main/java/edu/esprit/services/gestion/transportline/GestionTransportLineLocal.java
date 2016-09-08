package edu.esprit.services.gestion.transportline;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.TransportLine;

@Local
public interface GestionTransportLineLocal {
	Boolean addTransportLine(TransportLine transportLine);
	Boolean deleteTransportLine(TransportLine transportLine);
	Boolean updateTransportLine(TransportLine transportLine);
	TransportLine findTransportLineByNumeroLine(String numeroLine);
	List<TransportLine> findAllTransportLines();
}
