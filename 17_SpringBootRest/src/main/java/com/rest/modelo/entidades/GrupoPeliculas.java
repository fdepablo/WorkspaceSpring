package com.rest.modelo.entidades;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="peliculas")
public class GrupoPeliculas {
		
	private List<Pelicula> listaPeliculas;

	@XmlElement(name = "pelicula")
	public List<Pelicula> getListaPeliculas() {
		return listaPeliculas;
	}

	public void setListaPeliculas(List<Pelicula> listaPeliculas) {
		this.listaPeliculas = listaPeliculas;
	}
	
	
}
