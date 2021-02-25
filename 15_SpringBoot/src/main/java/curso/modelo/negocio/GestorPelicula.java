package curso.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import curso.modelo.entidades.Pelicula;
import curso.modelo.persistencia.PeliculaDao;

@Service
public class GestorPelicula {

	@Autowired
	PeliculaDao peliculaDao;
	
	@Transactional
	public Pelicula insertar(Pelicula pelicula) throws RuntimeException{
		if(pelicula.getTitulo() != null) {
			return peliculaDao.save(pelicula);
		}else {
			throw new RuntimeException("peliculaIncorrecta");
		}
	}
	
	public List<Pelicula> listar(String orden){
		if("titulo".equals(orden)) {
			return peliculaDao.findAllByOrderByTituloAsc();
		}else {
			return peliculaDao.findAll();
		}
		
	}
	
	public List<Pelicula> buscarPorTituloAndGenero(String titulo, String genero){
		if(genero != null)
			return peliculaDao.findByTituloAndGeneroIgnoreCaseContaining(titulo, genero);	
		else
			return peliculaDao.findByTituloIgnoreCaseContaining(titulo);
	}
	
}
