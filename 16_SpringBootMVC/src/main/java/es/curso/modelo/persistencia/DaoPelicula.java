package es.curso.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.curso.modelo.entidades.Pelicula;

@Repository
public interface DaoPelicula extends JpaRepository<Pelicula, Integer>{

}
