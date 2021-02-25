package vista.presentacion;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Configuracion;
import modelo.negocio.GestorCoche;
import vista.presentacion.casos.Casos;
import vista.presentacion.casos.Menu;

public class MainCoches {
	public static ApplicationContext context;
	
	static {
		context = new AnnotationConfigApplicationContext(Configuracion.class);
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		GestorCoche gc = context.getBean("gestorCoche", GestorCoche.class); 
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Menu menu = new Menu();
		//Coche c = new Coche();
		
		
		
		Integer opcion = 0;
		Casos caso = null;
		
		do {
			
			menu.printMenu();
			opcion = sc.nextInt();
			sc.nextLine();
			
			switch(opcion) {
				case 1:
					caso = context.getBean("altaCoche", Casos.class); 
					caso.ejecutar();
					break;
				case 2:
					caso = context.getBean("borrarCoche", Casos.class); 
					caso.ejecutar();
					break;
				case 3:
					caso = context.getBean("editarCoche", Casos.class); 
					caso.ejecutar();
					break;
				case 4:
					caso = context.getBean("listarCoches", Casos.class); 
					caso.ejecutar();
					break;
				case 5:
					caso = context.getBean("ordenarModelo", Casos.class); 
					caso.ejecutar();
					break;
				case 6:
					caso = context.getBean("ordenarMarca", Casos.class); 
					caso.ejecutar();
					break;
				case 7:
					caso = context.getBean("salida", Casos.class); 
					caso.ejecutar();
					break;
			}
			
		}while(opcion != 7);
			
		/*
		c.setMatricula("1234uuu");
		c.setMarca("Hyundai");
		c.setModelo("i30");
		c.setKm(60);
		c.setId(1);*/
		
		/*c.setMatricula("5678lll");
		c.setMarca("Renault");
		c.setModelo("clio");
		c.setKm(300.5);*/
		
		/*c.setMatricula("9999zzz");
		c.setMarca("Seat");
		c.setModelo("Cordoba");
		c.setKm(1000.69);*/
		
		/*c.setMatricula("1111aaa");
		c.setMarca("Ford");
		c.setModelo("Focus");
		c.setKm(9000);
		*/
/*
		int insertado = gc.insert(c);
		if(insertado == 1) {
			System.out.println("Mision cumplida! Coche insertado con exito");
		}else if(insertado == 0){
			System.out.println("Matricula incorrecta");
		}else {
			System.out.println("Matricula ya incluida.");
		}
		*/
		//System.out.println(gc.buscar(5));
	//	gc.borrar(c);
		//System.out.println(gc.ordenarModelo());
		
		

	}

}
