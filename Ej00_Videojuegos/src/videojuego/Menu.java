package videojuego;

import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		
		
		ListaVideojuego lv = new ListaVideojuego ();		
		Scanner s = new Scanner (System.in);
		
		int opcion = 0;
		
		
		
		
		do {
			
			System.out.println("Seleccione opción");
			System.out.println("1-Alta");
			System.out.println("2-Listar");
			System.out.println("3-Ordenar por Titulo");
			System.out.println("4-Ordenar por Compañia");
			System.out.println("0-Salir");
			
			
			 opcion = s.nextInt();
		switch (opcion)
		{
		case 0: 
			System.out.println("Hasta la próxima ejecución");
			break;
		case 1:
			lv.altaVideojuego();
			
			break;
		case 2: 
			lv.Listar();
			break;
		case 3:
			lv.OrdenarTitulo();
			break;
			
		case 4:
			lv.OrdenarCompania();
			break;
			default:
				
				System.out.println("Error. Un número de 0 a 4");
				break;
		
		}
	}while (opcion!=0);
		
		
		
		
	}

}
