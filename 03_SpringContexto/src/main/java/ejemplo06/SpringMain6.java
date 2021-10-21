package ejemplo06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain6 {
	public static ApplicationContext context = null;
		
	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("applicationContext06.xml");
		System.out.println("******* CONTEXTO CREADO **************");
		
		Persona steve = context.getBean("steve",Persona.class);
		System.out.println(steve.getNombre());
		
		Persona persona = context.getBean("persona",Persona.class);
		System.out.println(persona.getNombre());

		//Cuando le pedimos las personas prototipadas es cuando se ejecuta 
		//el metodo de inicializacion
		Persona p1 = context.getBean("personaBean",Persona.class);
		Persona p2 = context.getBean("personaBean",Persona.class);
		p1.setNombre("Asterix");
		System.out.println(p1);
		p2.setNombre("Obelix");
		System.out.println(p2);
		
		System.out.println("******** DESTRUYENDO CONTEXTO ************");		
		AbstractApplicationContext aac = 
				(AbstractApplicationContext)context;
		aac.close();
	}
}
