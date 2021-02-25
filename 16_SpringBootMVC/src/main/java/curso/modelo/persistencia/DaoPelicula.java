package curso.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.modelo.entidades.Pelicula;

public interface DaoPelicula extends JpaRepository<Pelicula, Integer>{


}
