package edu.esprit.services.gestion.client;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.Client;


@Local
public interface GestionClientLocal {
	
	
	
	List<Client> findAllClient();
	Client authentificate(String login,String pwd);
	
}
