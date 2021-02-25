package modelo.persistencia;

import java.util.List;

import modelo.entidades.Pelicula;

public interface PeliculaDAO {
	
	void insertar(Pelicula p);
	
	void modificar(Pelicula p);
	
	void borrar(Pelicula p);
	
	Pelicula buscar(int id);
	
	List<Pelicula> listar();
}
