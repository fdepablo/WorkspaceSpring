package ejemplo08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain8 {
	
	public static ApplicationContext context = null;
		
	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("applicationContext08.xml");
		
		Persona p = context.getBean("persona",Persona.class);
		System.out.println(p);
		System.out.println(p.getNombre());
		System.out.println(p.getDireccion().getNombreVia());
		
		Cliente c = context.getBean("cliente", Cliente.class);
		System.out.println(c);
	}
}
