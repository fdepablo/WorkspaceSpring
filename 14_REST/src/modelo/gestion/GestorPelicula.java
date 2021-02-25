package modelo.gestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelo.entidades.Pelicula;
import modelo.persistencia.PeliculaDAO;

@Service
public class GestorPelicula {
	
	@Autowired
	private PeliculaDAO peliculaDao;
	
	public void insertar(Pelicula p) throws Exception{
		if("".equals(p.getTitulo())) {
			throw new Exception("titulo requerido");
		}else {
			peliculaDao.insertar(p);
		}
	}
	
	public Pelicula getPelicula(int id) {
		return peliculaDao.buscar(id);	
	}
	
	public List<Pelicula> listar() {
		return peliculaDao.listar();
	}
	
	public void modificar(Pelicula p) {
		peliculaDao.modificar(p);
	}
	
	public void borrar(int id) {
		Pelicula p = new Pelicula();
		p.setId(id);
		peliculaDao.borrar(p);
	}
}
