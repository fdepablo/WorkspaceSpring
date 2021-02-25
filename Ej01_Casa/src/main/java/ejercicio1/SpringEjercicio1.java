package ejercicio1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringEjercicio1 {
	
	public static ApplicationContext ap;
	// Inicializar el contexto al inicio del main
	static {
		ap = new ClassPathXmlApplicationContext("beansEj1.xml");
		System.out.println("Contexto cargado.");
	}
		

	public static void main(String[] args) {
		
		Casa c = ap.getBean("casa", Casa.class);
		System.out.println(c);
	
	}
	
}
