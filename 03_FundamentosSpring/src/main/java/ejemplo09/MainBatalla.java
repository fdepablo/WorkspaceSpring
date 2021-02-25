package ejemplo09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainBatalla {
	
	//arrrancamos nuestrro contenedor de objetos de spring
	private static ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans09.xml");
		
	public static void main(String[] args) {
		Guerrero guerrero = new Guerrero();
		guerrero.setNombre("Aquiles");
		Espada espada = new Espada();
		espada.setTipo("larga");
		
		//inyectar la dependencia
		Arco arco = new Arco();
		arco.setTipo("largo");
		
		guerrero.setArma(arco);
		guerrero.atacar();
		
		//ahora con spring
		Guerrero guerrero2 = context.getBean("guerrero",Guerrero.class);
		guerrero2.atacar();
	}
}
