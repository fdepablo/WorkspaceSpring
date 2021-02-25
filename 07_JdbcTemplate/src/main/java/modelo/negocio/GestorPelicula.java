package modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelo.entidades.Pelicula;
import modelo.persistencia.DaoPelicula;

@Service
public class GestorPelicula {
	@Autowired
	DaoPelicula daoPelicula;
	
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
