package ejemplo01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain1 {
	
	//Para crear el contexto de Spring nos apoyamos en la interfaz
	//"ApplicationContext" que sera el objeto que tenga el contexto de spring
	//El unico new obligatorio va a ser el del contexto.
	//Como para este ejemplo queremos crear el contexto a partir
	//de un XML, usaremos la clase "ClassPathXmlApplicationContext"
	//la cual busca un XML de configuracion dentro del classpath de nuestra
	//aplicacion.
	public static ApplicationContext context = null;

	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("applicationContext01.xml");
		System.out.println("Contexto cargado");
		
		//Mediante el metodo getBean, le pedimos a Spring que nos devuelva
		//un bean del contexto por id
		//Este metodo devuelve referencias de tipo Object, pero nosotros como 
		//programadores sabemos que este objeto es de tipo "Mensaje"
		//por lo que debemos de castear la referencia.
		Mensaje mensaje = (Mensaje)context.getBean("mensajeVacio");
		
		//Aqui el objeto esta vacio
		System.out.println(mensaje.getCuerpo());
		System.out.println(mensaje.getFirma());
		
		mensaje.setCuerpo("Quedamos a las 8 :)");
		mensaje.setFirma("Steve Rogers");
		
		//Si le vuelvo a pedir el bean en cualquier momento, el objeto
		//sera el mismo, ya que el bean es singleton
		//Otra manera de castear la referencia, es pasandole el metodo
		//getBean tambien el tipo de referencia que queremos que nos devuelva
		Mensaje mensaje2 = context.getBean("mensajeVacio",Mensaje.class);
		System.out.println(mensaje2.getCuerpo());
		System.out.println(mensaje2.getFirma());
		
		Mensaje mensajeRelleno = context.getBean("mensajeRelleno", Mensaje.class);
		System.out.println(mensajeRelleno);
		
		//Si te equivocas de id y no existe en el contexto de spring, te arroja
		//una excepcion
		//mensajeRelleno = context.getBean("mensajeNoExiste", Mensaje.class);
		//System.out.println(mensajeRelleno);
		
		metodoImprimirMensaje(mensajeRelleno);
		metodoImprimirMensajeSpring();
		
		//Podemos seguir creando objetos nosotros, pero hay que tener muy claro
		//seran objeto que no ser�n gestionados por Spring, no seran beans y
		//su ciclo de vida dependera el programador, es decir no habra IoC
		Mensaje mensajeNoGestionado = new Mensaje();
	}

	//Una de las ventajas que tenemos con Spring, es que desde cualquier parte
	//de la aplicacion puedo acceder a los beans del contexto, sin preocuparme
	//de estar pasando las referencias al objeto, lo unico que necesito es el 
	//contexto
	public static void metodoImprimirMensaje(Mensaje mensaje) {
		System.out.println(" Imprimiendo objeto");
		System.out.println(mensaje);
	}
	
	public static void metodoImprimirMensajeSpring() {
		System.out.println(" Imprimiendo objeto a traves del contexto");
		Mensaje mensajeRelleno = context.getBean("mensajeRelleno", Mensaje.class);
		System.out.println(mensajeRelleno);
	}
}
