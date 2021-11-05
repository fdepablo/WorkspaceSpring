package es.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.curso.modelo.entidades.Usuario;
import es.curso.modelo.persistencia.DaoUsuario;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private DaoUsuario du;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario u = new Usuario();
		u.setId(1);
		u.setNombre("steve");
		u.setPassword("1234");
		
		du.save(u);
		
		u = new Usuario();
		u.setId(2);
		u.setNombre("tony");
		u.setPassword("4321");
		
		du.save(u);
		
		System.out.println("**************************");
		System.out.println(du.findById(2).orElse(null));
		System.out.println("**************************");
		System.out.println(du.findById(20).orElse(null));
		System.out.println("**************************");
		System.out.println(du.findByNombre("steve").orElse(null));
		System.out.println("**************************");
		System.out.println(du.findAll());
		System.out.println("**************************");
	}

}
