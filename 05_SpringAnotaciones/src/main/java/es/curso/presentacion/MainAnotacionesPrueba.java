package es.curso.presentacion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.curso.modelo.entidad.Director;
import es.curso.modelo.entidad.Pelicula;

public class MainAnotacionesPrueba {

	public static ApplicationContext context;
	
	public static void main(String[] args) {
		context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println("Arrancado");
		
		Director director1 = context.getBean("directorBean",Director.class);
		System.out.println(director1);
		
		Director director2 = context.getBean("director",Director.class);
		System.out.println(director2);
		
		Pelicula pelicula = context.getBean("pelicula",Pelicula.class);
		System.out.println(pelicula);
	}

}
