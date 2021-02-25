package com.modelo.persistencia;

import java.util.List;

import com.modelo.entidades.Pelicula;

//Un CRUD
//Create
//Read
//Update
//Delete
public interface DaoPelicula {
	int insertar(Pelicula p);
	Pelicula modificar(Pelicula p);
	int borrar(int id);
	Pelicula buscar(int id);
	List<Pelicula> listar();
}
