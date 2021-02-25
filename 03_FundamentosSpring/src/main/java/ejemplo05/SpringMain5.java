package ejemplo05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain5 {
	public static ApplicationContext context = null;
		
	static {
		context = 
				new ClassPathXmlApplicationContext("beans05.xml");
	}
	public static void main(String[] args) {
		Persona paco = context.getBean("personaInner",Persona.class);
		System.out.println(paco.getNombre());
		System.out.println(paco.getDireccion().getNombreVia());
		
		Persona otroBean = context.getBean("personaInner2",Persona.class);
		System.out.println(otroBean.getNombre());
		System.out.println(otroBean.getDireccion().getNombreVia());
	}
}
