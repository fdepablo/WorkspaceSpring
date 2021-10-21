package ejemplo04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain4 {
	
	public static ApplicationContext context = null;	
	
	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("applicationContext04.xml");
		
		Persona hulk = context.getBean("hulk",Persona.class);
		System.out.println(hulk.getNombre());
		System.out.println(hulk.getDireccion().getNombreVia());
		
		Persona capitanAmerica = context.getBean("capitanAmerica",Persona.class);
		System.out.println(capitanAmerica.getNombre());
		System.out.println(capitanAmerica.getDireccion().getNombreVia());
		
		//De una manera clasica con java, si quiero crear un objeto persona 
		//deberia de crearme el objeto persona y el objeto direccion
		//y a la persona inyectarle la dependencia de direccion
		Persona p1 = new Persona();
		Direccion d1 = new Direccion();
		p1.setDireccion(d1);
		
		//Ahora con Spring, cada vez que le pida un objeto de tipo persona, como
		//tengo configurado que me inyecte una direccion, no tengo porque perdirle
		//a spring ambos objetos y inyectarlos manualmente, simplemente le pido
		//un objeto de tipo personaPrototype y me vendria con todos los objetos
		//asociados
		Persona p2 = context.getBean("personaPrototype", Persona.class);
		p2.setNombre("Peter Parker");
		p2.getDireccion().setPais("America");
		System.out.println(p2);
		
	}
}
