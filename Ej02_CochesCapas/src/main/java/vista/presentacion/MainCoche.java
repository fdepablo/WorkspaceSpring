package vista.presentacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modelo.entidades.Coche;
import modelo.negocio.GestorCoche;
import vista.presentacion.casos.Casos;

public class MainCoche {

	public static ApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestorCoche gc = context.getBean("gestorCoche", GestorCoche.class);
		Scanner sc = new Scanner(System.in);
		ArrayList<String> menu = context.getBean("listaMenu", ArrayList.class);
		Map<Integer, Casos> hm = context.getBean("mapaMenu", Map.class);
		Integer opcion = 0;
		
		do {
			
			for (String m: menu) {
				System.out.println(m);
			}
			
			opcion = sc.nextInt();
			sc.nextLine();
			Casos caso = hm.get(opcion);
			//System.out.println(hm.get(opcion));
			//System.out.println(hm);
			//hm.
			caso.ejecutar();
			//caso.ejecutar(gc);
			
			
		}while(opcion != menu.size());

	}

}
