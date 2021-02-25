import javax.xml.crypto.dsig.CanonicalizationMethod;

public class Prueba {

	static {
		Persona p = new Persona();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getString();
		//aqui morira el objeto String("FElix")
		
		Object obj = new Object();
		Object obj2 = new Object();
		
		//obj = obj2;
		
		System.out.println(obj.equals(obj2));
		
		System.out.println(obj == obj2);
		
		
		String s1 = "Felix";
		String s2 = "Felix";
		
		String s3 = new String("Felix");
		String s4 = new String("Felix");
		
		System.out.println(s1 == s2);
		System.out.println(s3 == s4);
		
		System.out.println(s1.equals(s2));
		System.out.println(s3.equals(s4));
		
		s1 = "ana";
		
		Persona p1 = new Persona();
		p1.setNombre("Felix");
		p1.setEdad(39);
		p1.setPeso(82);
		p1.setApellidos("de Pablo");
		Persona.numeroPersonas++;
		
		Direccion d = new Direccion();
		d.setNombreVia("Gran Via");
		d.setTipoVia("Calle");
		d.setPais("España");
		d.setCp("28034");
		
		p1.setDireccion(d);
		System.out.println(p1);
		
		p1.getDireccion().setPais("Italia");
		//d = new Direccion();
		System.out.println(d.getPais().toLowerCase());
		
		System.out.println(p1.getEdad());
		System.out.println(p1.getNombre());
		
		Persona p2 = new Persona("Felix","de Pablo",39,82);
		System.out.println(p1 == p2);
		System.out.println("Son iguales: " +p1.equals(p2));
		
		p1 = p2;
		p1.setEdad(55);
		
		System.out.println(p1.getEdad() + " " + p2.getEdad());
		System.out.println("==============");
		cambiarEdad(p1);
		System.out.println(p1.getEdad());
		
		int numero = 33;
		cambiarNumero(numero);
		System.out.println(numero);
		
		int cp = 07051;//base octal
		System.out.println(cp);
		
		cp = 0xABC;//hexa
		cp = 0b0101;//binario
		
		numero = 10_000_000;
		
		int n1 = 10;
		int n2 = 3;
		double n3 = (double)n1 / n2;
		System.out.println(n3);
		
		Prueba prueba = new Prueba();
		prueba.hola();
		
		final int n4 = 6;
		final Persona p3 = new Persona("Ana","Gomez",29,67);
		p3.setNombre("Pepa");
		//p3 = new Persona();
	}
	
	public void hola() {
		System.out.println("hola");
	}
	
	public static void cambiarNumero(int numero) {
		numero = 55;
		System.out.println(numero);
	}
	
	public static void cambiarEdad(Persona p) {
		p.setEdad(33);
		System.out.println(p.getEdad());
	}
	
	public static String getString() {
		String s = new String("felix");
		return s;
	}
	/* tiene la misma firma:
	 * 	numero de argumentos
	 * 	tipo de los argumentos
	 * 	nombre del metodo
	 */
	/*
	public static void getString() {
		
	}*/

}
