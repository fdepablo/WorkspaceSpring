package es.curso.modelo.entidad;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Pelicula implements Serializable{
	private int id;
	private String titulo;
	private String genero;

	@Autowired
	@Qualifier(value = "directorBean")
	private Director director;
	
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
	public Director getDirector() {
		return director;
	}
	public void setDirector(Director director) {
		this.director = director;
	}
	
	/*
	 * Esta anotacion funciona en tiempo de compilacion y es una anotacion del tipo "check", es
	 * decir, lo que hace es comprobar en tiempo de ejecuci�n que efectivamente el metodo EXISTE
	 * en la clase padre y que lo vamos a sobrescribir
	 */
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", director=" + director + "]";
	}	
}
