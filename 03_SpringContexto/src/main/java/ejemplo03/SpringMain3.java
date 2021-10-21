package ejemplo03;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain3 {
	public static ApplicationContext context = null;
	
	public static void main(String[] args) {	
		context = new ClassPathXmlApplicationContext("applicationContext03.xml");
		
		Persona paco = context.getBean("paco", Persona.class);
		System.out.println(paco);
		
		Persona ana = context.getBean("ana", Persona.class);
		System.out.println(ana);
		
		//Aqui, al pedir un objeto prototype, cada objeto ser�a diferente
		//y su ciclo de vida depender�a de nosotros
		Persona p1 = context.getBean("personaPrototype", Persona.class);
		p1.setNombre("Steve");
		Persona p2 = context.getBean("personaPrototype", Persona.class);
		p2.setNombre("Peter");
		Persona p3 = context.getBean("personaPrototype", Persona.class);
		p3.setNombre("Tony");
		
		//Podemos guardar los objetos en una lista gestionada por spring
		//para mantener su ciclo de vida
		List<Persona> listaPersonas = 
				context.getBean("listaPersonas", List.class);
		
		listaPersonas.add(p1);
		listaPersonas.add(p2);
		listaPersonas.add(p3);
		
		//Ahora puedo acceder a la lista desde cualquier parte
		//ahora no tengo porque estar pasando la referencia de la
		//lista por todos los metodos. En cualquier momento a traves
		//del contexto de spring puedo acceder a ella.
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
