package modelo.entidades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class Pelicula {
	private int id;
	private String titulo;
	private String genero;
	
	//por defecto autowired es por tipo
	@Autowired
	//si queremos hacerlo por id o name utilizaremos la
	//etiqueta qualifier
	//@Qualifier("directorBean")
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
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", director=" + director + "]";
	}
	
	
}
