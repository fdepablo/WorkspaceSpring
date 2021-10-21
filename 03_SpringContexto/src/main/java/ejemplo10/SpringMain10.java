package ejemplo10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//https://docs.spring.io/spring/docs/4.3.10.RELEASE/spring-framework-reference/html/expressions.html
public class SpringMain10 {
	
	public static ApplicationContext context = null;
	
	public static void main(String[] args) {
		context = 
				new ClassPathXmlApplicationContext("applicationContext10.xml");
		
		Persona p = context.getBean("persona",Persona.class);
		System.out.println(p);
		
		Persona p2 = context.getBean("persona2",Persona.class);
		System.out.println(p2);
		
		Persona p3 = context.getBean("persona3",Persona.class);
		System.out.println(p3);
	}
}
