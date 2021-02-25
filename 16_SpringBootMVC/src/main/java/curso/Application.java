package curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import curso.modelo.entidades.Usuario;
import curso.modelo.negocio.GestorUsuario;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		ApplicationContext context = 
				SpringApplication.run(Application.class, args);
		
		GestorUsuario gu = context.getBean("gestorUsuario",GestorUsuario.class);
		
		Usuario u1 = new Usuario();
		u1.setNombre("Mortadelo");
		u1.setPassword("1234");
		gu.insertar(u1);
	}
	
}
