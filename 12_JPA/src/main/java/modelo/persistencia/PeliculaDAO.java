package modelo.persistencia;

import java.util.List;

import modelo.entidades.Pelicula;

public interface PeliculaDAO {
	
	int insertar(Pelicula p);
	
	Pelicula modificar(Pelicula p);
	
	int borrar(Pelicula p);
	
	Pelicula buscar(int id);
	
	List<Pelicula> listar();
}
