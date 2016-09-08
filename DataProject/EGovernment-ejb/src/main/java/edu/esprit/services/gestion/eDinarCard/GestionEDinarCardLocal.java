package edu.esprit.services.gestion.eDinarCard;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.EDinarCard;

@Local
public interface GestionEDinarCardLocal {

	EDinarCard findEDinarCardByNumeroCard(String numeroCard);
	List<EDinarCard> findAllEDinarCard();
}
