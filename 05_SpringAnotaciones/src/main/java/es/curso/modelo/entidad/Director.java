package es.curso.modelo.entidad;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Podemos cambiar el id del bean poniendo el atributo "value"
@Component(value = "directorBean")
//<bean id="directorBean" class="modelo.entidad.Director"/>
//Tambien podemos modificar el scope del objeto, por defecto es singleton
@Scope(value="prototype")
//<bean id="director" class="modelo.entidad.Director" scope="prototype"/>
public class Director {
	private int id;
	private String nombre;
	
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
	
	@Override
	public String toString() {
		return "Director [id=" + id + ", nombre=" + nombre + "]";
	}	
}
