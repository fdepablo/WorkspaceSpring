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
		
	public static void main(String[] args) {		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Scanner sc = new Scanner(System.in);
		String continuar = "s";
		
		do {
			System.out.println("Rellene campos(titulo, genero, director:");
			String titulo = sc.nextLine();
			String genero = sc.nextLine();
			String nombreDirector = sc.nextLine();
			
			//La pelicula me viene ya inyectada con el director.
			//Una ventaja si tenemos objetos con muchas dependencias
			Pelicula pelicula = context.getBean("pelicula",Pelicula.class);
			pelicula.setId(1);
			pelicula.getDirector().setNombre(nombreDirector);
			pelicula.setTitulo(titulo);
			pelicula.setGenero(genero);
			
			GestorPelicula gp = 
					context.getBean("gestorPelicula",GestorPelicula.class);
			//Insertamos
			int respuesta = gp.insertar(pelicula);
			if(respuesta == 0) {
				System.out.println("Pelicula Insertada");
			}else if(respuesta == 1) {
				System.out.println("El titulo esta vacio");
			}else if(respuesta == 2) {
				System.out.println("La lista esta llena");
			}
			//Listamos
			List<Pelicula> listaPeliculas = gp.listar();
			System.out.println(listaPeliculas);
			
			System.out.println("Desea continuar? s/n:");
			continuar = sc.nextLine();
		}while(continuar.equalsIgnoreCase("s"));
		
		System.out.println("Aplicacion finalizada");
		sc.close();
	}

}

