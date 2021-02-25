package com.modelo.entidades;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Pelicula {
	private int id;
	@NotBlank(message="Ehh! que esta vacio")
	private String titulo;
	@NotBlank
	private String genero;
	@Min(1800)
	@Max(2200)
	private int year;
	
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
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", year=" + year + "]";
	}
	
	
}
