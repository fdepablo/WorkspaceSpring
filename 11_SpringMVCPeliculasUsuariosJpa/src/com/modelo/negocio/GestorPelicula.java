package com.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.modelo.entidades.Pelicula;
import com.modelo.persistencia.DaoPelicula;

@Service
public class GestorPelicula {
	
	@Autowired
	private DaoPelicula daoPelicula;
	
	@Transactional
	public int insertar(Pelicula p) {
		return daoPelicula.insertar(p);
	}
	
	@Transactional
	public Pelicula modificar(Pelicula p) {
		return daoPelicula.modificar(p);
	}
	
	@Transactional
	public int borrar(Pelicula p) {
		return daoPelicula.borrar(p.getId());
	}
	
	public Pelicula buscar(int id) {
		return daoPelicula.buscar(id);
	}
	
	public List<Pelicula> listar() {
		return daoPelicula.listar();
	}
}
