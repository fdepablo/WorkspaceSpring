package es.curso.main;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.curso.cfg.ConfiguracionJPA;
import es.curso.modelo.entidad.Pelicula;
import es.curso.modelo.negocio.GestorPelicula;

public class MainJPA {

	private static ApplicationContext context;

	public static void main(String[] args) {
		
		context = new AnnotationConfigApplicationContext(ConfiguracionJPA.class);
		System.out.println("Inicializando BBDD...");
		
		Pelicula p = context.getBean("pelicula",Pelicula.class);
		p.setTitulo("La guerra de las galaxias");
		p.setGenero("Scifi");		
		p.setDirector("George Lucas");
		p.setYear(1975);
		p.setFechaAlta(new Date());
		
		GestorPelicula gp = context.getBean(GestorPelicula.class);
		System.out.println("**** INSERTANDO PELICULA ****");
		int id = gp.insertar(p);
		System.out.println("id insertado: " + id);
		
		System.out.println("**** BUSCAR PELICULA ****");
		
		System.out.println(gp.buscar(id));
		
		System.out.println("**** MODIFICAR PELICULA ****");
		//Esto para modificar solo los campos que queramos
		p = context.getBean("pelicula",Pelicula.class);
		p.setId(1);
		p.setTitulo("El imperio contra ataca");
		p.setGenero("Scifi");
		p.setDirector("George Lucas");
		p.setYear(1979);
		p.setFechaAlta(new Date());
		gp.modificar(p);
		
		System.out.println("**** BUSCAR PELICULA ****");
		System.out.println(gp.buscar(1));
		
		System.out.println("**** INSERTANDO PELICULA ****");
		Pelicula p2 = new Pelicula();
		p2.setGenero("Accion");
		p2.setTitulo("Die Hard");
		p2.setDirector("Bruce Willis");
		p2.setYear(1991);
		p2.setFechaAlta(new Date());
		
		gp.insertar(p2);
		
		System.out.println("**** LISTAR PELICULA ****");
		List<Pelicula> lista = gp.listar();
		//Con una funcion lambda podemos recorrer todas las peliculas
		lista.forEach((v) -> System.out.println(v));
		
		System.out.println("**** BORRAR PELICULA ****");
		gp.borrar(1);
		
		System.out.println("**** LISTAR PELICULA ****");
		lista = gp.listar();
		lista.forEach((v) -> System.out.println(v));
	}
}
