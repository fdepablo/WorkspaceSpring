package curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import curso.modelo.entidades.Pelicula;
import curso.modelo.negocio.GestorPelicula;

/*
 * @SpringBootApplication Engloba 3 anotaciones importantes
 * 
 * 1- @Configuration, decimos que esta clase va a tener Beans
 * de configuracion * 
 * 
 * 2- @ComponentScan, buscar anotaciones de spring concretamente
 * anotaciones @Component, va a buscarlas automaticamente en todos
 * los paquetes que esten dentro de curso
 * 
 * 3- @EnableAutoConfiguration, decimos a spring que ararnque la
 * aplicacion add beans basados en la configuración del classpath,
 * ademas add otros beans y varias propiedades para que se autoconfigure
 * el proyecto
 * 
 */
@SpringBootApplication
@ImportResource({"classpath:beans.xml"})
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = 
				SpringApplication.run(Application.class, args);
		
		Pelicula p1 = new Pelicula();
		p1.setTitulo("El planeta de los simios");
		Pelicula p2 = context.getBean("pelicula",Pelicula.class);
		Pelicula ps = context.getBean("peliculaSingleton",Pelicula.class);
		
		GestorPelicula gp = 
				context.getBean("gestorPelicula",GestorPelicula.class);
		
		ps.setTitulo("Superlopez");
		ps.setDirector("Alejandro");
		ps.setGenero("comedia");
		ps.setYear(2018);
		
		gp.insertar(p2);
		gp.insertar(p1);		
		gp.insertar(ps);
		
		for(Pelicula p :gp.listar(null)) {
			System.out.println(p);
		}
		
		System.out.println("==============================");
		
		for(Pelicula p :gp.listar("titulo")) {
			System.out.println(p);
		}
		
		System.out.println("==============================");
		
		System.out.println(gp.buscarPorTituloAndGenero("El planeta", null));
	}

}
