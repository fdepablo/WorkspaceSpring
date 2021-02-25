package curso.modelo.persistencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import curso.modelo.entidades.Pelicula;

public interface PeliculaDao extends JpaRepository<Pelicula, Integer>{


	//Si empieza por findBy hacemos busquedas por ese campo
	List<Pelicula> findByTitulo(String titulo);
	
	//Adminte operadores logicos And y Or entre atributos
	List<Pelicula> findByTituloAndGenero(String titulo, String genero);
	
	//Si queremos que busque por cosas que contanga el titulo o el genero
	List<Pelicula> findByTituloIgnoreCaseContaining(String titulo);
	List<Pelicula> findByTituloAndGeneroIgnoreCaseContaining(String titulo, String genero);
	
	//Ordenar OrderBy y ademas en Asc o Desc
	//podrimos usar findBy tambien
	public List<Pelicula> findAllByOrderByTituloAsc();
}
