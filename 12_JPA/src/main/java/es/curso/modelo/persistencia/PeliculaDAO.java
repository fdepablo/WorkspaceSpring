package es.curso.modelo.persistencia;

import java.util.List;

import es.curso.modelo.entidad.Pelicula;

public interface PeliculaDAO {
	
	int insertar(Pelicula p);	
	Pelicula modificar(Pelicula p);	
	int borrar(int id);	
	Pelicula buscar(int id);	
	List<Pelicula> listar();
}
