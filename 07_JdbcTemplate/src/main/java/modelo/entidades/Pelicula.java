package modelo.entidades;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//Hay que crear en base de datos la tabla peliculas
// con estos campos
@Component
@Scope("prototype")
public class Pelicula {
	
	private int id;
	//si queremos dar un valor por defecto
	@Value("La guerra de los mundos")
	private String titulo;
	@Value("Kubrik")
	private String director;
	@Value("Sci-Fi")
	private String genero;
	@Value("1992")
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
