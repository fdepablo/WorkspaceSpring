package ejemplo02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain2 {
	
	public static ApplicationContext context = null;
	
	public static void main(String[] args){
		
		//Si combinamos Spring con interfaces, nos puede llevar a hacer
		//una programaci�n muy versatil y muy adaptativa, sin necesidad de tocar
		//nuestro codigo.
		context = new ClassPathXmlApplicationContext("applicationContext02.xml");
		
		Imprimible f = context.getBean("imprimible",Imprimible.class);
		f.imprimir("La vida es bella");
	}
}
