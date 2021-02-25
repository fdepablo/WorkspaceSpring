package ejemplo07;

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
	
	//el nombre es arbitrario
	public void inicializar() {
		System.out.println("Inicializando");
		//podemos hacer conexion bbdd
		this.nombre = "";
		this.edad = 0;
	}
	
	public void destruir() {
		System.out.println("Argggggggggggggg muero!");
	}
}
