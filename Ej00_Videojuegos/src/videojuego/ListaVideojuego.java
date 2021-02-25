package videojuego;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListaVideojuego {
	
	
	private List <Videojuego> videojuegos;
			
			
			
	public  ListaVideojuego ()
	{
		videojuegos = new LinkedList <> ();
	}
	public void altaVideojuego ()
	{
		
	
		Scanner s = new Scanner (System.in);
		
	
		System.out.println("Titulo");
		String titulo = s.next();
		
		
		
		System.out.println("Compañia");
		s = new Scanner (System.in);
		String compania = s.next();
		
		
		int id = videojuegos.size();
		
		
		Videojuego v = new Videojuego (id,titulo, compania);
		
		videojuegos.add(v);
		
		System.out.println("Añadido");
		
	}
	
	
	public void OrdenarTitulo ()
	{
		Collections.sort(videojuegos, new OrdenarVideojuegoTitulo());
		
		System.out.println(videojuegos);
	}
	
	public void OrdenarCompania ()
	{
		Collections.sort(videojuegos, new OrdenarVideojuegoCompania());
		
		System.out.println(videojuegos);
	}
	
	
	public void Listar ()
	
	{
		System.out.println(videojuegos);
	}

}
