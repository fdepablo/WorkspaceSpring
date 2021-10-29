package com.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modelo.entidades.Pelicula;

public interface DaoPelicula extends JpaRepository<Pelicula, Integer>{

}
