package es.curso;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.curso.modelo.entidad.Pelicula;
import es.curso.modelo.persistencia.DaoPeliculaJPAData;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	public DaoPeliculaJPAData dp;
	
	@Autowired
	public Pelicula p;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		p.setTitulo("La guerra de las galaxias");
		p.setGenero("Scifi");		
		p.setDirector("George Lucas");
		p.setYear(1975);
		p.setFechaAlta(new Date());
		

		System.out.println("**** INSERTANDO PELICULA ****");
		p = dp.save(p);
		System.out.println("id insertado: " + p.getId());
		
		System.out.println("**** BUSCAR PELICULA ****");
		
		System.out.println(dp.findById(p.getId()));			
	}

}
