package es.curso.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import es.curso.config.Configuracion;
import es.curso.modelo.persistencia.DaoPeliculaJdbcTemplate;

//por si necesitamos crear la tabla en base de datos
public class MainCrearTabla {
	
private static ApplicationContext context;
	
	static {
		context = new AnnotationConfigApplicationContext(Configuracion.class);
	}
	
	public static void main(String[] args) {
		DaoPeliculaJdbcTemplate dao = context.getBean("daoPeliculaJdbcTemplate",DaoPeliculaJdbcTemplate.class);
		dao.crearTablaPeliculas();
		System.out.println("Tabla creada :)");
	}
}
