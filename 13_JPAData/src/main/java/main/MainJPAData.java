package main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cfg.Configuracion;
import modelo.entidades.Pelicula;
import modelo.negocio.GestorPelicula;

public class MainJPAData {

	private static ApplicationContext context;

	static {
		context = new AnnotationConfigApplicationContext(Configuracion.class);
	}

	public static void main(String[] args) {
		System.out.println("Inicializando BBDD...");
		
		Pelicula p = new Pelicula();
		p.setGenero("Dibujos");
		p.setTitulo("Death Note 2");
		p.setDirector("Akira Toriyama");
		p.setYear(1992);
		
		GestorPelicula gp = context.getBean(GestorPelicula.class);
		gp.insertar(p);
		
		System.out.println("Fin!");
		
		List<Pelicula> lista = gp.listar();
		
		System.out.println(lista.size());
		System.out.println("----------------");
		lista = gp.buscarPorTitulo("Death Note");
		System.out.println(lista);
		
	}
}
