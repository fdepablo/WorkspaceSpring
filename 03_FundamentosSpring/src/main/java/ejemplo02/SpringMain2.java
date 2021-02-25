package ejemplo02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain2 {
	public static void main(String[] args) throws Exception, IllegalAccessException, ClassNotFoundException {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans02.xml");
		
		Imprimible f = context.getBean("imprimible",Imprimible.class);
		f.imprimir("ola ke ase");
	}
}
