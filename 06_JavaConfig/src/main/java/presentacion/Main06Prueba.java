package presentacion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Configuracion;
import modelo.entidades.Director;
import modelo.entidades.Pelicula;

public class Main06Prueba {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext
				(Configuracion.class);
		
		Pelicula p = context.getBean("pelicula",Pelicula.class);
		System.out.println(p);

		Director d = context.getBean("directorBean",Director.class);
		System.out.println(d);
	}

}
