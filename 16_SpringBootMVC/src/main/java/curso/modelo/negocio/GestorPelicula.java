package curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.modelo.entidades.Pelicula;
import curso.modelo.persistencia.DaoPelicula;

@Service
public class GestorPelicula {
	
	@Autowired
	private DaoPelicula daoPelicula;
	
	public void insertar(Pelicula p) {
		daoPelicula.save(p);
	}
	
	public void modificar(Pelicula p) {
		daoPelicula.save(p);
	}
	
	public void borrar(Pelicula p) {
		daoPelicula.delete(p);
	}
	
	public Pelicula buscar(int id) {
		return daoPelicula.findById(id).get();
	}
	
	public List<Pelicula> listar() {
		return daoPelicula.findAll();
	}
}
