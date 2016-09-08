package edu.esprit.services.gestion.eDinarCard;

import java.util.List;

import javax.ejb.Remote;

import edu.esprit.domain.EDinarCard;



@Remote
public interface GestionEDinarCardRemote {

	Boolean addEDinarCard(EDinarCard eDinarCard);
	Boolean deleteEDinarCard(EDinarCard eDinarCard);
	Boolean updateEDinarCard(EDinarCard eDinarCard);
	EDinarCard findEDinarCardByNumeroCard(String numeroCard);
	List<EDinarCard> findAllEDinarCard();
}
