package es.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.curso.modelo.entidades.Usuario;
import es.curso.modelo.persistencia.DaoUsuario;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	private DaoUsuario daoUsuario;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario();
		usuario.setNombre("steve");
		usuario.setPassword("1234");
		
		daoUsuario.save(usuario);		
	}

}
