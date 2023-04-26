package com.savarino.services;

import java.util.List;

import com.savarino.entities.Biglietto;
import com.savarino.entities.Film;

public interface BiglietteriaService {
	Biglietto addBiglietto (Biglietto b);
	List<Biglietto>getBiglietto();
	List<Film>getfilms();
	
	Biglietto getBigliettoById(int id);
	Film getFilmById(int id);

}
