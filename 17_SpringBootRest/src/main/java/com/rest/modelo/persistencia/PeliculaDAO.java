package com.rest.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.modelo.entidades.Pelicula;

public interface PeliculaDAO extends JpaRepository<Pelicula, Integer>{
	
	public List<Pelicula> findByYear(int year);
}
