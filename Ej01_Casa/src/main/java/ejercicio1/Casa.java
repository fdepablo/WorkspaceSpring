package ejercicio1;

import java.util.List;

public class Casa {
	private double precio;
	private Direccion direccion;
	private Persona propietario;
	private List<Persona> inquilinos;
	private List<Habitacion> habitaciones;
	
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public Persona getPropietario() {
		return propietario;
	}
	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}
	public List<Persona> getInquilinos() {
		return inquilinos;
	}
	public void setInquilinos(List<Persona> inquilinos) {
		this.inquilinos = inquilinos;
	}
	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	@Override
	public String toString() {
		return "Casa [precio=" + precio + ",\n direccion=" + direccion + ",\n propietario=" + propietario + ",\n inquilinos="
				+ inquilinos + ",\n habitaciones=" + habitaciones + "]";
	}
	
	
	
}
