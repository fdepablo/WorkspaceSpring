package presentacion;


import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Configuracion;
import modelo.entidades.Pelicula;
import modelo.negocio.GestorPelicula;

public class MainAnotaciones {

	private static ApplicationContext context;
	
	static {
		context = 
				new AnnotationConfigApplicationContext
				(Configuracion.class);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String continuar = "s";
		int contador = 0;
		do {
			System.out.println("Rellene campos(titulo, genero,director");
			Pelicula pelicula = context.getBean("pelicula",Pelicula.class);
						
			String titulo = sc.nextLine();
			String genero = sc.nextLine();
			String nombreDirector = sc.nextLine();
			
			contador++;
						
			pelicula.setId(contador);
			//ya nos viene la pelicula con su director
			pelicula.getDirector().setId(contador);
			pelicula.getDirector().setNombre(nombreDirector);
			pelicula.setTitulo(titulo);
			pelicula.setGenero(genero);
			
			GestorPelicula gp = 
					context.getBean("gestorPelicula",GestorPelicula.class);
			
			boolean respuesta = gp.insertar(pelicula);
			System.out.println(respuesta);
			List<Pelicula> listaPeliculas = gp.listar();
			System.out.println(listaPeliculas);
			System.out.println("¿Desea continuar?");
			continuar = sc.nextLine();
		}while(continuar.equals("s"));
		
		sc.close();
	}
}
