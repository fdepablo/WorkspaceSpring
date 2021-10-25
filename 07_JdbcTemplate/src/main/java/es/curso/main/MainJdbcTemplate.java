package es.curso.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.curso.config.Configuracion;
import es.curso.modelo.entidades.Pelicula;
import es.curso.modelo.negocio.GestorPelicula;

public class MainJdbcTemplate {

	private static ApplicationContext context;
	
	public static void main(String[] args) {		
		context = new AnnotationConfigApplicationContext(Configuracion.class);
		
		GestorPelicula gp = context.getBean("gestorPelicula",GestorPelicula.class);
		Pelicula p = context.getBean("pelicula",Pelicula.class);
		
		p.setTitulo("La guerra de los mundos");
		p.setDirector("Bob el silencioso");
		p.setYear(2001);
		p.setGenero("Sci-Fi");
		
		gp.insertar(p);
		
		p.setId(1);
		p.setTitulo("Mallrats");
		
		gp.modificar(p);
		
		Pelicula p2 = gp.buscar(1);
		System.out.println("Pelicula con id 1: " + p2);
		
		System.out.println("Listado de peliculas");
		System.out.println(gp.listar());
		
		gp.borrar(1);
	}

}
