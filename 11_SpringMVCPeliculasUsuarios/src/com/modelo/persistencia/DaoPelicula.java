package com.modelo.persistencia;

import java.util.List;

import com.modelo.entidades.Pelicula;

//Un CRUD
//Create
//Read
//Update
//Delete
public interface DaoPelicula {
	void insertar(Pelicula p);
	void modificar(Pelicula p);
	void borrar(Pelicula p);
	Pelicula buscar(int id);
	List<Pelicula> listar();
}
