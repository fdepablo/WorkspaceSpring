package es.curso.modelo.entidad;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "directorBean")
@Scope(value="prototype")
public class Director {
	private int id;
	private String nombre;
	
	@Value("#{ T(java.lang.Math).random()  * 50.0 }")
	private int edad;
	
	public Director() {
		this.id = 1;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
		return "Director [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
	}	
}
