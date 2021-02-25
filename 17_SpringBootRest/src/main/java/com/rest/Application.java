package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rest.modelo.entidades.Pelicula;
import com.rest.modelo.gestion.GestorPelicula;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
		GestorPelicula gp = context.getBean("gestorPelicula",GestorPelicula.class);
		
		Pelicula p1 = new Pelicula();
		p1.setTitulo("El día de la bestia");
		p1.setDirector("Alex");
		p1.setGenero("Miedo");
		p1.setYear(1990);
		gp.insertar(p1);
		
		p1 = new Pelicula();
		p1.setTitulo("Amanece que no es poco");
		p1.setDirector("Miguel");
		p1.setGenero("Comedia");
		p1.setYear(1980);
		gp.insertar(p1);
		
		p1 = new Pelicula();
		p1.setTitulo("Terminator");
		p1.setDirector("Eduardo");
		p1.setGenero("Accion");
		p1.setYear(1990);
		gp.insertar(p1);
	}

}
