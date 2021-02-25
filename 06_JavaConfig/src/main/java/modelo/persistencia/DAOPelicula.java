package modelo.persistencia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import modelo.entidades.Pelicula;


public class DAOPelicula {
	
	private List<Pelicula> listaPelicula;
	private int numeroMaximoPeliculas;
	
	/**
	 * Metodo que inserta una pelicula a la lista
	 * @param p la pelicula a insertar
	 * @return true en caso correcto, false en caso de que el array
	 * este lleno
	 */
	public boolean insertar(Pelicula p) {
		if(listaPelicula.size() < numeroMaximoPeliculas) {
			listaPelicula.add(p);
			return true;
		}
		return false;
	}

	public List<Pelicula> getListaPelicula() {
		return listaPelicula;
	}

	public void setListaPelicula(List<Pelicula> listaPelicula) {
		this.listaPelicula = listaPelicula;
	}

	public int getNumeroMaximoPeliculas() {
		return numeroMaximoPeliculas;
	}

	public void setNumeroMaximoPeliculas(int numeroMaximoPeliculas) {
		this.numeroMaximoPeliculas = numeroMaximoPeliculas;
	}
	
	
}
