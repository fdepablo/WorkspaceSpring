package modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import modelo.entidades.Pelicula;

@Repository
public class DAOPelicula {
	private List<Pelicula> listaPeliculas = new ArrayList<>();
	private int numeroMaximoPeliculas = 2;
	
	/**
	 * Metodo que inserta una pelicula a la lista
	 * @param p la pelicula a insertar
	 * @return true en caso correcto, false en caso de que el array
	 * este lleno
	 */
	public boolean insertar(Pelicula p) {
		if(listaPeliculas.size() < numeroMaximoPeliculas) {
			listaPeliculas.add(p);
			return true;
		}
		return false;
	}

	public List<Pelicula> listar(){
		return listaPeliculas;
	}
}
