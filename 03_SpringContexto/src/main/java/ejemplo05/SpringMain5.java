package ejemplo05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain5 {
	public static ApplicationContext context = null;
		
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("applicationContext05.xml");
		
		Persona pepe = context.getBean("personaInner",Persona.class);
		System.out.println(pepe.getNombre());
		System.out.println(pepe.getDireccion().getNombreVia());
		
		Persona otroBean = context.getBean("persona",Persona.class);
		System.out.println(otroBean.getNombre());
		System.out.println(otroBean.getDireccion().getNombreVia());
	}
}
