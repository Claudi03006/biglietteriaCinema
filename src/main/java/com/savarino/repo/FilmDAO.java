package com.savarino.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.savarino.entities.Film;

public interface FilmDAO extends JpaRepository<Film, Integer> {

}
