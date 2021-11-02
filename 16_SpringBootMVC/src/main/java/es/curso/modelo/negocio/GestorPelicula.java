package es.curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.curso.modelo.entidades.Pelicula;
import es.curso.modelo.persistencia.DaoPelicula;

@Service
public class GestorPelicula {
	
	@Autowired
	private DaoPelicula daoPelicula;
	
	@Transactional
	public int insertar(Pelicula p) {
		return daoPelicula.save(p).getId();
	}
	
	@Transactional
	public Pelicula modificar(Pelicula p) {
		return daoPelicula.save(p);
	}
	
	@Transactional
	public void borrar(int id) {
		daoPelicula.deleteById(id);
	}
	
	public Pelicula buscar(int id) {
		return daoPelicula.findById(id).orElse(null);
	}
	
	public List<Pelicula> listar() {
		return daoPelicula.findAll();
	}
}
