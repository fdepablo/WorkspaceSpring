package com.rest.modelo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;

//JAXB, sirve para serializar y deserializar objetos java al
//formato XML
@Entity
@Table(name="peliculas")
@XmlRootElement
public class Pelicula {
	/*
	 * {"id":"1","titulo:"la guerra de las galaxias",director:"Standley kubric","genero":"Amor"}
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotBlank
	private String titulo;
	private String director;
	private String genero;
	private int year;
	
	public Pelicula() {
		super();
	}
	
	public Pelicula(int id, String titulo, String director, String genero, int year) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.director = director;
		this.genero = genero;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", director=" + director + ", genero=" + genero + ", year="
				+ year + "]";
	}
}
