package com.savarino.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savarino.entities.Biglietto;
import com.savarino.entities.Film;
import com.savarino.repo.BigliettoDAO;
import com.savarino.repo.FilmDAO;

@Service
public class BiglietteriaServiceImpl implements BiglietteriaService{

	@Autowired
	private BigliettoDAO bigliettoDAO;
	
	@Autowired
	private FilmDAO filmDAO;

	@Override
	public Biglietto addBiglietto(Biglietto b) {
		// TODO Auto-generated method stub
		return bigliettoDAO.save(b);
	}

	@Override
	public List<Biglietto> getBiglietto() {
		// TODO Auto-generated method stub
		return bigliettoDAO.findAll();
	}

	@Override
	public List<Film> getfilms() {
		// TODO Auto-generated method stub
		return filmDAO.findAll();
	}

	@Override
	public Biglietto getBigliettoById(int id) {
		// TODO Auto-generated method stub
		return bigliettoDAO.getReferenceById(id);
	}

	@Override
	public Film getFilmById(int id) {
		// TODO Auto-generated method stub
		return filmDAO.getReferenceById(id);
	}
	
	
}
	

	
	
	