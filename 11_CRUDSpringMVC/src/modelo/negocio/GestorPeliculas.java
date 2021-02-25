package modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelo.entidades.Pelicula;
import modelo.excepciones.CustomException;
import modelo.persistencia.PeliculaDAO;

@Service
public class GestorPeliculas {

	@Autowired
	private PeliculaDAO peliculaDao;
	
	public void modificarPelicula(Pelicula p) {
		peliculaDao.modificar(p);
	}
	
	public void borrarPelicula(Pelicula p) {
		peliculaDao.borrar(p);
	}
	
	public Pelicula buscarPelicula (Integer id) {
		return peliculaDao.buscar(id);
	}
	
	public void insertar(Pelicula pelicula) throws CustomException {
		//validamos los campos
		if("".equals(pelicula.getDirector())) {
			throw new CustomException("Fallo en el titulo");
		}
		peliculaDao.insertar(pelicula);
	}
	
	public List<Pelicula> getListaPeliculas(){
		return peliculaDao.listar();
	}

	public PeliculaDAO getPeliculaDao() {
		return peliculaDao;
	}

	public void setPeliculaDao(PeliculaDAO peliculaDao) {
		this.peliculaDao = peliculaDao;
	}
	
	
}
