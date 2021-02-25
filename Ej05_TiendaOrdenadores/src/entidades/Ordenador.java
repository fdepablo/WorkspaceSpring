package entidades;

public class Ordenador {
	private Procesador procesador;
	private DiscoDuro discoDuro;
	private RAM ram;
	private double precio;
	
	
	public Procesador getProcesador() {
		return procesador;
	}
	public void setProcesador(Procesador procesador) {
		this.procesador = procesador;
	}
	public DiscoDuro getDiscoDuro() {
		return discoDuro;
	}
	public void setDiscoDuro(DiscoDuro discoDuro) {
		this.discoDuro = discoDuro;
	}
	public RAM getRam() {
		return ram;
	}
	public void setRam(RAM ram) {
		this.ram = ram;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	

}
