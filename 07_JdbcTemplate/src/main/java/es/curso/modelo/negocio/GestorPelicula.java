package es.curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.curso.modelo.entidades.Pelicula;
import es.curso.modelo.persistencia.DaoPelicula;

@Service
public class GestorPelicula {
	
	@Autowired
	DaoPelicula daoPelicula;
	
	/**
	 * 
	 * @param p la pelicula que daremos de alta
	 * @return el id en caso de que se haya dado de alta, -1 en caso de que
	 * el titulo sea vacio
	 */
	public int insertar(Pelicula p) {
		if(!"".equals(p.getTitulo())) {
			return daoPelicula.insertar(p);
		}
		return -1;
	}
	
	public int modificar(Pelicula p) {
		if(!"".equals(p.getTitulo())) {
			return daoPelicula.modificar(p);
		}
		return -1;
	}
	
	public int borrar(int id) {
		return daoPelicula.borrar(id);
	}
	
	public Pelicula buscar(int id) {
		return daoPelicula.buscar(id);
	}
	
	public List<Pelicula> listar(){
		return daoPelicula.listar();
	}
}
