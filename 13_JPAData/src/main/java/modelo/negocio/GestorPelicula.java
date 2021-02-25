package modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import modelo.entidades.Pelicula;
import modelo.persistencia.PeliculaDaoJPAData;

@Service
public class GestorPelicula {
	
	@Autowired
	private PeliculaDaoJPAData peliculaDao;
	
	@Transactional
	public void insertar(Pelicula p) {
		peliculaDao.save(p);
	}
	
	public List<Pelicula> listar(){
		return peliculaDao.findAll();
	}
	
	public List<Pelicula> buscarPorTitulo(String titulo){
		return peliculaDao.findByTitulo(titulo);
	}
	
}
