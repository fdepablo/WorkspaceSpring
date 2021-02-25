package modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.entidades.Pelicula;
import modelo.persistencia.PeliculaDaoJPA;

@Service
public class GestorPelicula {
	
	@Autowired
	private PeliculaDaoJPA peliculaDao;
	
	@Transactional
	public int insertar(Pelicula p) {
		return peliculaDao.insertar(p);
	}
	
	@Transactional
	public Pelicula modificar(Pelicula p) {
		return peliculaDao.modificar(p);
	}
	
	@Transactional
	public void borrar(Pelicula p) {
		peliculaDao.borrar(p);
	}
	
	public Pelicula buscar(int id) {
		return peliculaDao.buscar(id);
	}
	
	public List<Pelicula> listar(){
		return peliculaDao.listar();
	}
	
}
