package es.curso.modelo.persistencia;

import java.util.List;

import es.curso.modelo.entidades.Pelicula;

public interface DaoPelicula {
	
	int insertar(Pelicula p);	
	int modificar(Pelicula p);	
	int borrar(int id);	
	Pelicula buscar(int id);	
	List<Pelicula> listar();
}
