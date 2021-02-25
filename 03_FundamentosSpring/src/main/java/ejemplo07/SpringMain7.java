package ejemplo07;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain7 {
	public static ApplicationContext context = null;
		
	static {
		context = 
				new ClassPathXmlApplicationContext("beans07.xml");
	}
	public static void main(String[] args) {
		List<String> listaNombres = 
				context.getBean("listaNombres",List.class);
		for(String s : listaNombres) {
			System.out.println(s);
		}
		
		Colecciones colecciones = 
				context.getBean("colecciones",Colecciones.class);
		
		for(Persona p : colecciones.getListaPersonas()) {
			System.out.println(p.getNombre());
		}
		
		for(String s : colecciones.getConjuntoStrings()) {
			System.out.println(s);
		}
		
		Map<Integer,Persona> mapaPersonas = 
				colecciones.getMapaPersonas();
		
		System.out.println(mapaPersonas.get(1).getNombre());
		System.out.println(mapaPersonas.get(2).getNombre());
	}
}
