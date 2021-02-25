package ejemplo03;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain3 {
	public static ApplicationContext context = null;
	
	static {
		context = 
				new ClassPathXmlApplicationContext("beans03.xml");
	}
	
	public static void main(String[] args) {		
		Persona paco = context.getBean("paco", Persona.class);
		System.out.println(paco.getNombre());
		
		Persona p1 = context.getBean("personaBean", Persona.class);
		Persona p2 = context.getBean("personaBean", Persona.class);
		Persona p3 = context.getBean("personaBean", Persona.class);
		
		List<Persona> listaPersonas = 
				context.getBean("listaPersonas", List.class);
		
		listaPersonas.add(p1);
		listaPersonas.add(p2);
		listaPersonas.add(p3);
		
		otroMetodo();
	}

	private static void otroMetodo() {
		otroMetodoMas();
		
	}

	private static void otroMetodoMas() {
		List<Persona> listaPersona = 
				context.getBean("listaPersonas",List.class);
		for(Persona p : listaPersona) {
			System.out.println(p);
		}
		
	}
}
