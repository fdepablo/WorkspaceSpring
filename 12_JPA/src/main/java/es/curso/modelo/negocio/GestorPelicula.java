package es.curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.curso.modelo.entidad.Pelicula;
import es.curso.modelo.persistencia.PeliculaDaoJPA;

@Service
public class GestorPelicula {
	
	@Autowired
	private PeliculaDaoJPA peliculaDao;
	
	//Con esta anotacion le decimos a spring que todas las acciones que se hagan
	//en bbdd sean transaccionales. Son obligatorias en aquellas acciones
	//que modifiquen la BBDD
	@Transactional
	public int insertar(Pelicula p) {
		return peliculaDao.insertar(p);
	}
	
	@Transactional
	public Pelicula modificar(Pelicula p) {
		return peliculaDao.modificar(p);
	}
	
	@Transactional
	public void borrar(int id) {
		peliculaDao.borrar(id);
	}
	
	//Listar y obtener NO modifican la bbdd, por lo tanto no tiene
	//porque se transaccional 
	public Pelicula buscar(int id) {
		return peliculaDao.buscar(id);
	}
	
	public List<Pelicula> listar(){
		return peliculaDao.listar();
	}
	
}
