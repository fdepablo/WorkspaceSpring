package es.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import es.curso.modelo.entidad.Pelicula;

/*
 * @SpringBootApplication engloba 3 anotaciones importantes
 * 
 * 1- @Configuration, decimos que esta clase va a tener Beans
 * para dar de alta en el contexto de Spring, es decir, metodos
 * anotados con @Bean 
 * 
 * 2- @ComponentScan, buscar anotaciones de Spring dentro de la aplicacion
 * de manera automatica, va a buscarlas en las clases de este paquete y en 
 * todos los paquetes hijos
 * 
 * 3- @EnableAutoConfiguration, decimos a Spring que cuando arranque la
 * aplicacion instancie todos los beans que necesite para que funcione correctamente
 * Lo beans que creara, irá en funcion de los staters que hemos añadido a 
 * nuestra aplicacion. Por ejemplo, si añadimos un stater web, automaticamente
 * se configurara un Tomcat embebido en el que se desplegara la app. Si por 
 * ejemplo, hemos añadido una base de datos y JPA Data, se nos creara automaticamete
 * el data source y los drives de conexion a la bbdd. Incluso por defecto, si 
 * utilizaramos una bbdd que pueda ser creada en memoria (como H2), spring levataria
 * por defecto dicha base de datos en memoria
 *  
 */

@SpringBootApplication
//Importamos un fichero XML con beans 
@ImportResource({"classpath:applicationContext.xml"})
public class Application implements CommandLineRunner{

	public static ApplicationContext context = null;
		
	@Autowired
	private Pelicula pelicula;
	
	@Autowired
	@Qualifier("peliculaXML")
	public Pelicula peliculaXML;
	
	public static void main(String[] args) {
		//Con esta sentencia estamos ejecutando el contexto de spring
		//y nos devuelve una referencia del mismo.
		context = SpringApplication.run(Application.class, args);
		
		Pelicula p1 = context.getBean("pelicula",Pelicula.class);
		System.out.println("main -> " + p1);
		
		//No podemos acceder a un atributo dinamico desde un contexto estatico
		//System.out.println(pelicula);
		//Para solucionar esto, haremos que nuestra clase implemente
		//"CommandLineRunner" e implementaremos el metodo "run"
		//Este metodo se ejecutara automaticamente cuando acabe de cargar 
		//el contexto de spring, y es un metodo dinamico, por lo que podremos
		//acceder a todos los atributo que hayamos inyectado dependencias
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("run -> Ejecutando");		
		System.out.println("run -> " + pelicula);
		System.out.println("run -> " + peliculaXML);
	}	

}
