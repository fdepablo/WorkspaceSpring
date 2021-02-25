package main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cfg.Configuracion;
import modelo.entidades.Pelicula;
import modelo.negocio.GestorPelicula;

public class MainJPA {

	private static ApplicationContext context;

	static {
		context = new AnnotationConfigApplicationContext(Configuracion.class);
	}

	public static void main(String[] args) {
		System.out.println("Inicializando BBDD...");
		
		Pelicula p = new Pelicula();
		p.setGenero("Dibujos");
		p.setTitulo("Death Note");
		p.setDirector("Akira Toriyama");
		p.setYear(1992);
		
		GestorPelicula gp = context.getBean(GestorPelicula.class);
		int id = gp.insertar(p);
		System.out.println("id insertado: " + id);
		System.out.println(gp.buscar(id));
		
		//Esto del tiron funciona
		//p.setDirector("otro director");
		//Pelicula p2 = gp.modificar(p);
		
		//Esto tambien pero dejaria los otros campos a null
		//p = new Pelicula();
		//p.setId(1);
		//p.setDirector("otro director");
		//Pelicula p2 = gp.modificar(p);
		
		//Esto para modificar solo los campos que queramos
		p = gp.buscar(1);
		p.setDirector("otro director");
		Pelicula p2 = gp.modificar(p);
		
		System.out.println(gp.buscar(1));
		
		Pelicula p3 = new Pelicula();
		p3.setGenero("Accion");
		p3.setTitulo("Hard Day");
		p3.setDirector("Bruce Willis");
		p3.setYear(1991);
		
		gp.insertar(p3);
		
		List<Pelicula> lista = gp.listar();
		System.out.println(lista);
		
		gp.borrar(p);
		
		lista = gp.listar();
		System.out.println(lista);
	}
}
