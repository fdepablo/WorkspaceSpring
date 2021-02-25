package ejemplo04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain4 {
	public static ApplicationContext context = null;
	
	
	
	
	static {
		context = 
				new ClassPathXmlApplicationContext("beans04.xml");
	}
	public static void main(String[] args) {
		Persona paco = context.getBean("paco",Persona.class);
		System.out.println(paco.getNombre());
		System.out.println(paco.getDireccion().getNombreVia());
		
		Persona marta = context.getBean("marta",Persona.class);
		System.out.println(marta.getNombre());
		System.out.println(marta.getDireccion().getNombreVia());
	}
}
