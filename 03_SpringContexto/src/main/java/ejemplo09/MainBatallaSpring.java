package ejemplo09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainBatallaSpring {
	
	private static ApplicationContext context;
		
	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("applicationContext09.xml");
				
		//Ahora con spring no tengo ninguna dependencia fuerte de esta clase con
		//la clase Espada y la clase Arco. 
		//De hecho no tengo ni dependencia debil con la clase abstracta Arma
		Guerrero guerrero = context.getBean("guerrero",Guerrero.class);
		guerrero.atacar();
	}
}
