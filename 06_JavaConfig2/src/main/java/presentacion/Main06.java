package presentacion;


import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import config.Configuracion;
import modelo.entidades.Director;
import modelo.entidades.Pelicula;
import modelo.negocio.GestorPelicula;

public class Main06 {

	private static ApplicationContext context;
	
	static {
		context = 
				new AnnotationConfigApplicationContext
				(Configuracion.class);
	}
	
	public static void main(String[] args) {
		GestorPelicula gp = 
				context.getBean("gestorPelicula",GestorPelicula.class);
		Scanner sc = new Scanner(System.in);
		String continuar = "s";
		int contador = 0;
		List<Pelicula> listaPeliculas = gp.getDaoPelicula().getListaPelicula();
		
		do {
			System.out.println("Rellene campos(titulo, genero,director");
			Pelicula pelicula = context.getBean("pelicula",Pelicula.class);
			Director director = context.getBean("directorBean",Director.class);
			
			String titulo = sc.nextLine();
			String genero = sc.nextLine();
			String nombreDirector = sc.nextLine();
			
			contador++;
			
			director.setNombre(nombreDirector);
			director.setId(contador);
						
			pelicula.setId(contador);
			pelicula.setDirector(director);
			pelicula.setTitulo(titulo);
			pelicula.setGenero(genero);
			
			
			boolean respuesta = gp.insertar(pelicula);
			System.out.println(respuesta);
			/*List<Pelicula> listaPeliculas = 
					context.getBean("listaPeliculas",List.class);*/
			listaPeliculas = gp.getDaoPelicula().getListaPelicula();
			System.out.println(listaPeliculas);
			continuar = sc.nextLine();
		}while(continuar.equals("s"));
	}

}
