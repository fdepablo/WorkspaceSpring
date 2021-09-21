package config;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import modelo.entidades.Director;
import modelo.entidades.Pelicula;
import modelo.negocio.GestorPelicula;
import modelo.persistencia.DAOPelicula;

//Esta anotacion decimos que esta clase va a llevar la 
//configuración de nuestro proyecto de spring
//como si fuera un bean.xml
@Configuration
public class Configuracion {
	
	//Con esta anotación damos de alta un bean en el contexto de spring
	@Bean("directorBean")
	@Scope("prototype")
	public Director getDirector() {//por defecto el nombre del bean es el del metodo
		Director director = new Director();
		return director;
	}
	
	//Aqui siempre se intentará hacer una inyección a los argumentos
	//de entrada de algun bean que exista en el contenedor de spring
	//es decir, un autowire de manera automática.
	//Si no pondemos @Qualifer, el autowire sera por tipo, en caso
	//de que haya varios el autowire sera por nombre
	@Bean("pelicula")
	@Scope("prototype")
	public Pelicula pelicula(@Qualifier("directorBean") Director director){
		Pelicula pelicula = new Pelicula();
		pelicula.setDirector(director);
		return pelicula;
	}	

	@Bean("daoPelicula")
	public DAOPelicula getDaoPelicula() {
		DAOPelicula dao = new DAOPelicula();
		dao.setListaPelicula(new ArrayList<Pelicula>());
		dao.setNumeroMaximoPeliculas(2);
		return dao;
	}
	
	@Bean("gestorPeliculas")
	public GestorPelicula getGestorPeliculas(DAOPelicula dao) {
		GestorPelicula gp = new GestorPelicula();
		gp.setDaoPelicula(dao);
		return gp;
	}
}
