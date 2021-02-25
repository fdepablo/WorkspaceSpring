package ejemplo10;

public class Persona {
	private String nombre;
	private int edad;
	private double peso;
	private boolean casada;
	private Direccion direccion;
		
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
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public boolean isCasada() {
		return casada;
	}
	public void setCasada(boolean casada) {
		this.casada = casada;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + ", casada=" + casada + ", direccion="
				+ direccion + "]";
	}
	
	
}
