package com.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modelo.entidades.Pelicula;
import com.modelo.persistencia.DaoPelicula;

@Service
public class GestorPelicula {
	
	@Autowired
	private DaoPelicula daoPelicula;
	
	public void insertar(Pelicula p) {
		daoPelicula.insertar(p);
	}
	
	public void modificar(Pelicula p) {
		daoPelicula.modificar(p);
	}
	
	public void borrar(Pelicula p) {
		daoPelicula.borrar(p);
	}
	
	public Pelicula buscar(int id) {
		return daoPelicula.buscar(id);
	}
	
	public List<Pelicula> listar() {
		return daoPelicula.listar();
	}
}
