package ejemplo01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain1 {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans01.xml");
		System.out.println("Contexto cargado");
		
		Mensaje mensaje = (Mensaje)context.getBean("mensajeBean");
		mensaje = context.getBean("mensajeBean",Mensaje.class);
		
		System.out.println(mensaje.getCuerpo());
		System.out.println(mensaje.getFirma());
		
		mensaje.setCuerpo("Nuevo cuerpo");
		mensaje.setFirma("Felix de pablo");
		
		mensaje = context.getBean("mensajeBean",Mensaje.class);
		System.out.println(mensaje.getCuerpo());
		System.out.println(mensaje.getFirma());
	}

}
