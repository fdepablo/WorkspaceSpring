package presentacion;

import java.util.List;
import java.util.Scanner;

import javax.swing.GroupLayout.SequentialGroup;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidades.Director;
import modelo.entidades.Pelicula;
import modelo.negocio.GestorPelicula;

public class Main {

	private static ApplicationContext context;
	
	static {
		context = 
				new ClassPathXmlApplicationContext("bean.xml");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String continuar = "s";
		
		do {
			System.out.println("Rellene campos(titulo, genero,director");
			String titulo = sc.nextLine();
			String genero = sc.nextLine();
			String nombreDirector = sc.nextLine();
			
			Pelicula pelicula = context.getBean("pelicula",Pelicula.class);
			pelicula.setId(1);
			//Esto no da error porque la pelicula ya viene con un director
			//inyectado. Una ventaja si tenemos muchos objetos que dependen
			//de otros
			pelicula.getDirector().setNombre(nombreDirector);
			pelicula.setTitulo(titulo);
			pelicula.setGenero(genero);
			
			GestorPelicula gp = 
					context.getBean("gestorPelicula",GestorPelicula.class);
			
			boolean respuesta = gp.insertar(pelicula);
			System.out.println(respuesta);
			System.out.println("listapeliculas");
			List<Pelicula> listaPeliculas = gp.listar();
			System.out.println(listaPeliculas);
			continuar = sc.nextLine();
		}while(continuar.equals("s"));
	}

}

