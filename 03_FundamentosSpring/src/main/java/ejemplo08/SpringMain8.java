package ejemplo08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain8 {
	public static ApplicationContext context = null;
		
	static {
		context = 
				new ClassPathXmlApplicationContext("beans08.xml");
	}
	public static void main(String[] args) {
		Persona p = context.getBean("persona",Persona.class);
		System.out.println(p);
		System.out.println(p.getNombre());
		System.out.println(p.getDireccion().getNombreVia());
	}
}
