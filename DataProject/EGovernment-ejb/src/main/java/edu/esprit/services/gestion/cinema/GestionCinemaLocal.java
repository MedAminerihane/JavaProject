package edu.esprit.services.gestion.cinema;

import java.util.List;

import javax.ejb.Local;

import edu.esprit.domain.Categorie;
import edu.esprit.domain.Cinema;

@Local
public interface GestionCinemaLocal {

	Cinema findAllCinema() ;
}
