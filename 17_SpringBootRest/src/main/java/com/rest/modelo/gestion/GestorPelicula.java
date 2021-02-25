package com.rest.modelo.gestion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rest.modelo.entidades.Pelicula;
import com.rest.modelo.persistencia.PeliculaDAO;

@Service
public class GestorPelicula {
	
	@Autowired
	private PeliculaDAO peliculaDao;
	
	public Pelicula insertar(Pelicula p){
		return peliculaDao.save(p);		
	}
	
	public Pelicula getPelicula(int id) {
		return peliculaDao.findById(id).get();	
	}
	
	public List<Pelicula> listar(Integer year) {		
		if(year != null) {
			return peliculaDao.findByYear(year);
		}		
		return peliculaDao.findAll();		
	}
	
	public Pelicula modificar(Pelicula p) {
		return peliculaDao.save(p);
	}
	
	public void borrar(int id) {
		peliculaDao.deleteById(id);
	}
}
