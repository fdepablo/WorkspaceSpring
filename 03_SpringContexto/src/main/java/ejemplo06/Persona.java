package ejemplo06;

public class Persona {
	private String nombre;
	private int edad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	//El nombre es arbitrario
	//Este metodo se ejecuta justo despues de construir el objeto
	//y de haber asignado sus propiedades
	//Si es singleton se ejecutara cuando se cree el contexto
	//Si es prototipado se ejecutara cuando se pida el objeto al contexto
	public void inicializar() {
		System.out.println("Inicializando " + this.nombre);
		//Podemos hacer conexion bbdd
	}
	
	//El nombre es arbitrario
	//Este metodo se ejecuta justo despues de destruir el contexto de Spring
	//pero solo funciona para objetos que son de scope Singleton, no funciona
	//para los prototipados
	public void destruir() {
		System.out.println(this.nombre + " Argggggggggggggg muero!");
	}
}
